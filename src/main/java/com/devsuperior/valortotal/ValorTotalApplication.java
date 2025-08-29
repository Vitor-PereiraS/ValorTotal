package com.devsuperior.valortotal;

import com.devsuperior.valortotal.entities.Order;
import com.devsuperior.valortotal.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ValorTotalApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(ValorTotalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite os dados do pedido:");
        System.out.print("Código: ");
        var codigo = leitura.nextInt();
        System.out.print("Valor Basico: ");
        var valorBasico = leitura.nextDouble();
        System.out.print("porcentagem de desconto: ");
        var desconto = leitura.nextDouble();

        Order order = new Order(codigo, valorBasico, desconto);
        orderService.Total(order);

        System.out.println();
        System.out.print("""
                código: %d
                valor total: R$ %.2f""".formatted(codigo, orderService.Total(order)));


    }
}
