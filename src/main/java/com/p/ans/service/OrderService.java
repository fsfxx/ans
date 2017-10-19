package com.p.ans.service;

import com.p.ans.domain.Goods;
import com.p.ans.domain.Order;
import com.p.ans.domain.User;
import com.p.ans.repository.GoodsRepository;
import com.p.ans.repository.OrderRepository;
import com.p.ans.repository.UserRepository;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */

@Service
public class OrderService {

    private UserRepository userRepository;
    private GoodsRepository goodsRepository;
    private OrderRepository orderRepository;

    public OrderService(UserRepository userRepository, GoodsRepository goodsRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.goodsRepository = goodsRepository;
        this.orderRepository = orderRepository;
    }

    Order order(User user, Goods goods) {
        // TODO
        throw new NotImplementedException();
    }
}
