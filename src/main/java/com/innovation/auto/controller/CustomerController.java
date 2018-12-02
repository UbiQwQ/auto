package com.jnsj.nmk.controller.customer.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jnsj.nmk.entity.BaseCustomer;
import com.jnsj.nmk.service.BaseCustomerService;
import com.jnsj.nmk.util.JSON.Contants;
import com.jnsj.nmk.util.JSON.JSONRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Innovation
 * @Date: 2018/9/17 13:52
 * @Description:
 */
@RestController
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    BaseCustomerService baseCustomerService;


    /**
    *
    * @api {get} catering/customer/selectCustomer 查询所有顾客信息：顾客编号、顾客姓名、注册时间、注册手机号、注册餐厅
    * @apiVersion 1.0.0
    * @apiName selectCustomer
    * @apiGroup customer
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *  "msg": "查询顾客成功",
    *  "status": 1,
    *  "res": {
    *    "customerList": [
    *      {
    *        "restaruantName": "青岛麦当劳李沧和谐广场餐厅", //顾客注册餐厅名
    *        "code": null, //客户编号
    *        "createTime": 1539617823000, //注册时间
    *        "phone": "15206349417", //注册手机号
    *        "name": null, //客户名
    *        "id": 28 //顾客ID
    *      },
    *      {
    *        "restaruantName": "青岛麦当劳李沧和谐广场餐厅",
    *        "code": null,
    *        "createTime": 1539699736000,
    *        "phone": "13188968917",
    *        "name": null,
    *        "id": 30
    *      },
    *      {
    *        "restaruantName": "青岛麦当劳李沧和谐广场餐厅",
    *        "code": null,
    *        "createTime": 1539701245000,
    *        "phone": "13573245251",
    *        "name": null,
    *        "id": 45
    *      }
    *    ]
    *  }
    *}
    */
    @GetMapping("customer/selectCustomer")
    public JSONRes selectCustomer(){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        List<Object> list = baseCustomerService.selectCustomer();
        res.put("customerList",list);
        if (null != list) {
            msg = "查询顾客成功";
        } else {
            status = Contants.ERROR2;//失败状态
            msg = "系统异常，查询顾客失败";
        }
        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }
}
