package com.devsuperior.valortotal.service;

import com.devsuperior.valortotal.entities.Order;
import org.springframework.stereotype.Service;


@Service
public class ShippingService {

    public Double Shipment(Order order) {
        var frete = 0.0;
        if (order.getBasic() < 100) {
            frete = 20.0;
        } else if (order.getBasic() < 200) {
            frete = 12.0;
        } else { frete = 0;}
        return frete;
    }
}
