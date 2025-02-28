package org.iesbelen.pruebacasa.service;

import org.iesbelen.pruebacasa.repository.ProductRepository;
import org.iesbelen.pruebacasa.repository.TuplasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final TuplasRepository tuplasRepository;

    public ProductService (ProductRepository productRepository, TuplasRepository tuplasRepository) {
        this.productRepository = productRepository;
        this.tuplasRepository = tuplasRepository;

    }
    
}
