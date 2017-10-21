package com.p.ans.service;

import com.p.ans.domain.User;
import com.p.ans.exception.InsufficientBalanceException;
import com.p.ans.exception.UserNotFoundException;
import com.p.ans.repository.GoodsRepository;
import com.p.ans.repository.OrderRepository;
import com.p.ans.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Xunxiao Ren on 2017/10/21.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceTest {
    private OrderService orderService;
    private UserRepository userRepository;
    private GoodsRepository goodsRepository;
    private OrderRepository orderRepository;
    private long notExistUserId = -1;
    private long notExistGoods = -1;
    private long insufficientStockGoodsId = 1;
    private long insufficientBalanceUserId = 1;

    @After
    public void tearDown() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
        orderRepository = mock(OrderRepository.class);
        when(orderRepository.findOne(notExistUserId))
                .thenThrow(UserNotFoundException.class);
        when(goodsRepository.findOne(notExistGoods))
                .thenThrow(UserNotFoundException.class);
        when(goodsRepository.findOne(insufficientBalanceUserId))
                .thenThrow(InsufficientBalanceException.class);
    }

    @Test
    public void makeOrder() throws Exception {

    }

    @Test
    public void findAll() throws Exception {
    }

}