package com.p.ans.repository;

import com.p.ans.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {

}
