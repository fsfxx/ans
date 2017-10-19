package com.p.ans.controller;

import com.p.ans.domain.*;
import com.p.ans.repository.GoodsRepository;
import com.p.ans.repository.OrderRepository;
import com.p.ans.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    public OrderController(UserRepository userRepository, GoodsRepository goodsRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.goodsRepository = goodsRepository;
        this.orderRepository = orderRepository;
    }

    private UserRepository userRepository;
    private GoodsRepository goodsRepository;
    private OrderRepository orderRepository;

    @Transactional
    @PostMapping
    OrderResult order(@RequestBody OrderRequest orderRequest) {

        User user = userRepository.findOne(orderRequest.getUid());
        if (user == null) {
            return new OrderResult(false, "用户不存在");
        }

        Goods goods = goodsRepository.findOne(orderRequest.getItemid());
        if (goods == null) {
            return new OrderResult(false, "商品不存在");
        }

        System.out.println(user);
        System.out.println(goods);
        System.out.println(orderRequest);

        int totalPrice = orderRequest.getNum() * goods.getPrice();

        if (totalPrice > user.getMoney()) {
            return new OrderResult(false, "用户余额不足");
        } else {
            user.setMoney(user.getMoney() - totalPrice);
            goods.setQuantity(goods.getQuantity() - orderRequest.getNum());
            Order order = new Order(user, goods, orderRequest.getNum());
            orderRepository.save(order);

            return new OrderResult(true, "成功");
        }
    }

    // 返回所有订单
    @GetMapping
    Iterable<Order> all() {
        return orderRepository.findAll();
    }
}
