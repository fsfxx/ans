package com.p.ans;

import com.p.ans.domain.Goods;
import com.p.ans.domain.Order;
import com.p.ans.domain.User;
import com.p.ans.repository.GoodsRepository;
import com.p.ans.repository.OrderRepository;
import com.p.ans.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnsApplicationTests {

    private UserRepository userRepository;
    private GoodsRepository goodsRepository;
    private OrderRepository orderRepository;
    private User testUser = new User("测试用户", 300000);
    private Goods testGoods = new Goods("测试商品", 3000, 20);

    @Test
    public void contextLoads() {

    }

    @Before
    public void setUp() {
        testUser = userRepository.save(testUser);
        testGoods = goodsRepository.save(testGoods);
    }

    @After
    public void tearDown() {
        userRepository.delete(testUser);
        goodsRepository.delete(testGoods);
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setGoodsRepository(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Test
    public void readUser() throws Exception {
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void readGoods() {
        goodsRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void saveOrder() {
        Order order = new Order(testUser, testGoods, 30);
        Order savedOrder = orderRepository.save(order);
        Order foundOrder = orderRepository.findOne(savedOrder.getId());
        System.out.println(savedOrder);
        System.out.println(foundOrder);
        orderRepository.delete(savedOrder);
    }
}
