package com.ramitax.service;

import com.ramitax.model.entity.Usuario;
import com.ramitax.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(username)
        );

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        usuario.getRoles()
                .forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role)));

        usuario.getRoles().stream()
                .flatMap(role -> role.getPermisos().stream())
                .forEach(permission -> grantedAuthorities.add(new SimpleGrantedAuthority(permission.getNombrePermiso())));

        return new User(usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEnabled(),
                usuario.getAccountNonExpired(),
                usuario.getCredentialsNonExpired(),
                usuario.getAccountNonLocked(),
                grantedAuthorities);
    }
}
