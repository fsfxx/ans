package com.p.ans.repository;

import com.p.ans.domain.Goods;
import com.p.ans.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public interface GoodsRepository extends CrudRepository<Goods, Long> {
}
