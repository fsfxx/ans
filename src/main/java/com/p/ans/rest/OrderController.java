package com.p.ans.rest;

import com.p.ans.domain.Order;
import com.p.ans.domain.OrderRequest;
import com.p.ans.domain.OrderResult;
import com.p.ans.exception.GoodsNotFoundException;
import com.p.ans.exception.InsufficientBalanceException;
import com.p.ans.exception.UserNotFoundException;
import com.p.ans.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Xunxiao Ren on 2017/10/19.
 */
@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json")
    public OrderResult order(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.makeOrder(orderRequest);
    }

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public OrderResult order(@RequestParam("uid") @Min(0) @NotNull(message = "用户编号未指定") Integer uid,
                             @RequestParam("itemid") @Min(0) @NotNull(message = "商品编号未指定") Long itemid,
                             @RequestParam("num") @Min(value = 1, message = "购买数量必须大于0") @NotNull Integer num) {

        OrderRequest orderRequest = new OrderRequest(uid, itemid, num);

        return order(orderRequest);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public OrderResult httpMessageNotReadable() {
        return new OrderResult(false, "请求错误");
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public OrderResult noValid() {
        return new OrderResult(false, "参数错误");
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public OrderResult userNotFound(UserNotFoundException e) {
        return new OrderResult(false, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public OrderResult goodsNotFound(GoodsNotFoundException e) {
        return new OrderResult(false, e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public OrderResult insufficientBalance(InsufficientBalanceException e) {
        return new OrderResult(false, e.getMessage());
    }

    // 返回所有订单
    @GetMapping
    Iterable<Order> all() {
        return orderService.findAll();
    }


}
