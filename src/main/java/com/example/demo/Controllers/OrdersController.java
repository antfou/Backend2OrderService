package com.example.demo.Controllers;

import com.example.demo.Models.Orders;
import com.example.demo.Repositories.OrdersRepository;
import com.example.demo.Service.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/order")
public class OrdersController {

    private final OrdersService service;

    OrdersController(OrdersService service) {
        this.service = service;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return service.getOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public String addOrderWithCurl(@RequestBody Orders order) {
        return service.addNewOrder(order);

    }
}