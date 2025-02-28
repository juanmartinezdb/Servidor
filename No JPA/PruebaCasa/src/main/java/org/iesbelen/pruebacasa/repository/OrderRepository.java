package org.iesbelen.pruebacasa.repository;

import org.iesbelen.pruebacasa.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> finByUserId(Long id);
}
