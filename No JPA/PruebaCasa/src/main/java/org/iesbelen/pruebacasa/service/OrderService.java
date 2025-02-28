package org.iesbelen.pruebacasa.service;

import org.iesbelen.pruebacasa.domain.Order;
import org.iesbelen.pruebacasa.exceptions.OrderNotFoundException;
import org.iesbelen.pruebacasa.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }
public List<Order> allOrders() {
        return orderRepository.findAll();
}
public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException(id));
}
public Order save(Order order) {
        return orderRepository.save(order);
}
public Order replace(Long id, Order order) {
       return orderRepository.findById(id).map
               (o -> (id.equals(order.getId()) ?
                       orderRepository.save(order): null))
               .orElseThrow(()-> new OrderNotFoundException(id));
}
public void delete(Long id) {
        orderRepository.findById(id).map( p -> {
            this.orderRepository.delete(p);
            return p;
        }).orElseThrow(()-> new OrderNotFoundException(id));
}
//
public List<Order> byUserId(Long userId) {
        this.orderRepository.finByUserId(userId);
}

}
