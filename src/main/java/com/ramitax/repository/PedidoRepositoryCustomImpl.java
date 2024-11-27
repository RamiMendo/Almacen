package com.ramitax.repository;

import com.ramitax.model.entity.Pedido;
import com.ramitax.model.entity.PedidoDetalle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepositoryCustomImpl implements PedidoRepositoryCustom  {

    @PersistenceContext
    EntityManager em;

    @Override
    public Page<Pedido> pedidosFiltrados(Integer idCliente, LocalDate desde, LocalDate hasta, Integer estado, Pageable pageable) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Pedido> query = criteriaBuilder.createQuery(Pedido.class);
        Root<Pedido> root = query.from(Pedido.class);
        List<Predicate> predicates = new ArrayList<>();

        if(idCliente!=0) predicates.add(criteriaBuilder.equal(root.get("cliente").get("id"), idCliente));
        predicates.add(criteriaBuilder.between(root.get("fechaEntrega"), desde, hasta));
        if(estado!=0) predicates.add(criteriaBuilder.equal(root.get("estado"), estado));

        query.select(root).where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));

        List<Pedido> listaPedidos = em.createQuery(query).setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();

        return new PageImpl<>(listaPedidos, pageable, listaPedidos.size());
    }
}
