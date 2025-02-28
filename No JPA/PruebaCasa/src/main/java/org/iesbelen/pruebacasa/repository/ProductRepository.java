package org.iesbelen.pruebacasa.repository;

import org.iesbelen.pruebacasa.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
