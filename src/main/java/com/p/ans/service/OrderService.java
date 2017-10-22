package com.p.ans.service;

import com.p.ans.domain.*;
import com.p.ans.exception.GoodsNotFoundException;
import com.p.ans.exception.InsufficientBalanceException;
import com.p.ans.exception.InsufficientStockException;
import com.p.ans.exception.UserNotFoundException;
import com.p.ans.repository.GoodsRepository;
import com.p.ans.repository.OrderRepository;
import com.p.ans.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
@Service
public class OrderService {

    private UserRepository userRepository;
    private GoodsRepository goodsRepository;
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(UserRepository userRepository, GoodsRepository goodsRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.goodsRepository = goodsRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderResult makeOrder(OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUid())
                .orElseThrow(() -> new UserNotFoundException("用户不存在"));

        Goods goods = goodsRepository.findById(orderRequest.getItemid())
                .orElseThrow(() -> new GoodsNotFoundException("商品不存在"));

        if (orderRequest.getNum() > goods.getQuantity()) {
            throw new InsufficientStockException("库存不足");
        }

        int totalPrice = orderRequest.getNum() * goods.getPrice();

        if (totalPrice > user.getMoney()) {
            throw new InsufficientBalanceException("用户余额不足");
        }

        user.setMoney(user.getMoney() - totalPrice);
        goods.setQuantity(goods.getQuantity() - orderRequest.getNum());
        Order order = new Order(user, goods, orderRequest.getNum());
        order = orderRepository.save(order);

        return new OrderResult(true, "成功");
    }

    /**
     * @return 包含所有Order的Iterable对象
     */
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }
}
