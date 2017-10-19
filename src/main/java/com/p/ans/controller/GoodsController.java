package com.p.ans.controller;

import com.p.ans.domain.Goods;
import com.p.ans.repository.GoodsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    private GoodsRepository goodsRepository;

    public GoodsController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @GetMapping
    Iterable<Goods> all() {
        return goodsRepository.findAll();
    }
}
