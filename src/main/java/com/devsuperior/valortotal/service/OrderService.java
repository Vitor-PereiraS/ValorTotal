package com.devsuperior.valortotal.service;

import com.devsuperior.valortotal.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public Double Total(Order order) {
        return order.getBasic() * (1 - (order.getDiscount()/ 100)) + shippingService.Shipment(order);
    }
}
