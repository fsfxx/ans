package com.p.ans.repository;

import com.p.ans.domain.User;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<User> findById(Integer id);
}
