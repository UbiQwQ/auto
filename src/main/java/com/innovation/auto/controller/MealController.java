package com.jnsj.nmk.controller.meal.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jnsj.nmk.entity.*;
import com.jnsj.nmk.service.BaseDishesItemService;
import com.jnsj.nmk.service.BaseDishesMenuService;
import com.jnsj.nmk.util.JSON.Contants;
import com.jnsj.nmk.util.JSON.JSONRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

/**
 * @Auther: Innovation
 * @Date: 2018/9/17 16:05
 * @Description: 餐品查询Controller
 */
@RestController
public class MealController {
    private final static Logger logger = LoggerFactory.getLogger(MealController.class);

    @Autowired
    private BaseDishesMenuService baseDishesMenuService;

    @Autowired
    private BaseDishesItemService baseDishesItemService;


    @PostMapping("/InsertMealForItem")
    public JSONRes insertMealForItem(@RequestParam(value = "ItemId",required = true) String itemId,
                                     @RequestParam(value = "mealType",required = true) String mealType,
                                     @RequestParam(value = "menuId",required = true) Integer menuId) {

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if (null == itemId) {
            //失败状态
            status = Contants.ERROR;
            msg = "ItemId为空";
        } else if (null == mealType) {
            //失败状态
            status = Contants.ERROR;
            msg = "mealType为空";
        } else if (null == menuId) {
            //失败状态
            status = Contants.ERROR;
            msg = "menuId为空";
        } else {

            BaseDishesItem baseDishesItem = baseDishesItemService.selectById(itemId);
            String dishesItemName = baseDishesItem.getDishesItemName();
            Float dishesItemPrice = baseDishesItem.getDishesItemPrice();
            String imageName = baseDishesItem.getImageName();
            String dishesItemCode = baseDishesItem.getDishesItemCode();

            BaseDishesMenu baseDishesMenu = new BaseDishesMenu();
            baseDishesMenu.setDishesMenuCode(dishesItemCode);
            baseDishesMenu.setDishesMenuName(dishesItemName);
            baseDishesMenu.setDishesMenuPrice(dishesItemPrice);
            baseDishesMenu.setDishesMenuType(mealType);
            baseDishesMenu.setImageName(imageName);
            baseDishesMenu.setDishesMenuId(menuId);
            baseDishesMenu.setDelFlg("1");
            baseDishesMenu.setCreateTime(new Date());

            //添加单品
            boolean insert = baseDishesMenuService.insert(baseDishesMenu);

            if (insert) {
                msg = "餐品添加成功";
            } else {
                status = Contants.ERROR2;//失败状态
                msg = "餐品添加失败";
            }
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }

    @Transactional
    @PostMapping("/insertMeal")
    public JSONRes insertMeal(@RequestParam(value = "mealName",required = true) String mealName,
                              @RequestParam(value = "discount",required = true) Float discount,
                              @RequestParam(value = "mealImage",required = true) MultipartFile mealImage,
                              @RequestParam(value = "mainList",required = true) List<BaseDishesItem> mainList,
                              @RequestParam(value = "snackList",required = true) List<BaseDishesItem> snackList,
                              @RequestParam(value = "drinkList",required = true) List<BaseDishesItem> drinkList,
                              @RequestParam(value = "buttonList",required = true) List<Dic> buttonList) throws Exception{

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if (null == mealName) {
            //失败状态
            status = Contants.ERROR;
            msg = "请输入餐品名称";
        } else if (null == mealImage) {
            //失败状态
            status = Contants.ERROR;
            msg = "请上传图片";
        }else if (null == mainList) {
            //失败状态
            status = Contants.ERROR;
            msg = "请选择主餐";
        } else if (null == snackList) {
            //失败状态
            status = Contants.ERROR;
            msg = "请选择配餐";
        } else if (null == drinkList) {
            //失败状态
            status = Contants.ERROR;
            msg = "请选择饮品";
        } else if (null == buttonList) {
            //失败状态
            status = Contants.ERROR;
            msg = "请选择按钮";
        }else {

            //拿到图片原始名称
            String orginFilename = mealImage.getOriginalFilename();
            //图片存储路径
            String imagePath = "D:\\Nginx\\html\\image\\";
            //UUID图片名称
            String imageFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
            //新的图片
            File newFile = new File(imagePath + imageFilename);
            //将内存中数据写入服务器磁盘
            mealImage.transferTo(newFile);

            //计算价格 = 所选单品价格之和 - 优惠价格[discount]
            Float price = -discount;
            for(BaseDishesItem main : mainList) {
                price += main.getDishesItemPrice();
            }
            for(BaseDishesItem snack : snackList) {
                price += snack.getDishesItemPrice();
            }
            for(BaseDishesItem drink : drinkList) {
                price += drink.getDishesItemPrice();
            }

            //完善菜单餐品表
            BaseDishesMenu baseDishesMenu = new BaseDishesMenu();
            baseDishesMenu.setDishesMenuName(mealName);
            baseDishesMenu.setImageName(imageFilename);
            baseDishesMenu.setDishesMenuType("3");
            baseDishesMenu.setDishesMenuPrice(price);
            boolean insert = baseDishesMenuService.insert(baseDishesMenu);

            //完善comb表
            for(BaseDishesItem main : mainList){
                BaseDishesComb baseDishesComb = new BaseDishesComb();
                baseDishesComb.setDishesMenuId(baseDishesMenu.getDishesMenuId());
                baseDishesComb.setDishesItemId(main.getDishesItemId());
                baseDishesComb.setCreateTime(new Date());
            }
            for(BaseDishesItem snack : snackList){
                BaseDishesComb baseDishesComb = new BaseDishesComb();
                baseDishesComb.setDishesMenuId(baseDishesMenu.getDishesMenuId());
                baseDishesComb.setDishesItemId(snack.getDishesItemId());
                baseDishesComb.setCreateTime(new Date());
            }
            for(BaseDishesItem drink : drinkList){
                BaseDishesComb baseDishesComb = new BaseDishesComb();
                baseDishesComb.setDishesMenuId(baseDishesMenu.getDishesMenuId());
                baseDishesComb.setDishesItemId(drink.getDishesItemId());
                baseDishesComb.setCreateTime(new Date());
            }

            //完善菜品按钮表
            for(Dic button : buttonList){
                BaseDishesButton baseDishesButton = new BaseDishesButton();
                baseDishesButton.setButtonName(button.getDicLabel());
                baseDishesButton.setButtonType(button.getDicCode());
                baseDishesButton.setDishesMenuId(baseDishesMenu.getMenuId());
                if(button.getDicCode().equals("1")){
                    baseDishesButton.setCustomFlg("1");
                }else {
                    baseDishesButton.setCustomFlg("0");
                }

            }

            msg = "餐品添加成功";
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {delete} catering/DeleteMeal 删除餐品
    * @apiVersion 1.0.0
    * @apiName DeleteMeal
    * @apiGroup Meal
    * @apiParam mealId
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @DeleteMapping("/DeleteMeal")
    public JSONRes DeleteMeal(@RequestParam(value = "mealId",required = false) Integer mealId){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == mealId){
            status = Contants.ERROR;//失败状态
            msg = "mealId为空";
        }else{
            BaseDishesMenu baseDishesMenu = baseDishesMenuService.selectById(mealId);
            baseDishesMenu.setDelFlg("0");
            boolean delete = baseDishesMenuService.updateById(baseDishesMenu);
            if(delete){
                msg = "餐品删除成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "餐品删除失败";
            }

        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {get} catering/SelectMeal 查询所有餐品
    * @apiVersion 1.0.0
    * @apiName selectMeal
    * @apiGroup Meal
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @GetMapping("/SelectMeal")
    public JSONRes selectMeal(){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        EntityWrapper<BaseDishesMenu> wrapper = new EntityWrapper<>();
        List<BaseDishesMenu> list = baseDishesMenuService.selectList(wrapper);
        res.put("customerList",list);
        if (null != list) {
            msg = "查询餐品成功";
        } else {
            status = Contants.ERROR2;//失败状态
            msg = "系统异常，查询餐品失败";
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }
}
