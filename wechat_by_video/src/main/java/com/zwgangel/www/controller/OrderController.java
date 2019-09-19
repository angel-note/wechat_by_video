package com.zwgangel.www.controller;

import com.zwgangel.www.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: OrderController
 * @Package: com.zwgangel.www.controller.OrderController
 * @Description:  定单的Controller
 * @Auther: Angel.zhou
 * @Version: 1.0
 * @create 2019-09-20 01:17
 */
@RestController
@RequestMapping("/user/api/v1/order")
public class OrderController {

    @RequestMapping("add")
    public JsonData saveOrder(){
        return JsonData.buildSuccess("下单成功");
    }
}
