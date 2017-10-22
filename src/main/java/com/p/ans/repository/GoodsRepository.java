package com.p.ans.repository;

import com.p.ans.domain.Goods;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import java.util.Optional;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public interface GoodsRepository extends CrudRepository<Goods, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Goods> findById(Long id);
}
