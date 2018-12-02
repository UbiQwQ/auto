package com.jnsj.nmk.controller.item.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jnsj.nmk.entity.*;
import com.jnsj.nmk.service.BaseDishesItemService;
import com.jnsj.nmk.service.DicService;
import com.jnsj.nmk.service.RelDishesMaterialService;
import com.jnsj.nmk.util.JSON.Contants;
import com.jnsj.nmk.util.JSON.JSONRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Auther: Innovation
 * @Date: 2018/9/17 08:56
 * @Description: 餐品单品Controller
 */
@RestController
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private BaseDishesItemService baseDishesItemService;
    @Autowired
    private RelDishesMaterialService relDishesMaterialService;
    @Autowired
    private DicService dicService;


    /**
    *
    * @api {post} catering/InsertItem 添加餐品单品
    * @apiVersion 1.0.0
    * @apiName insertItem
    * @apiGroup Item
    * @apiParam itemName 单品名称
    * @apiParam itemPrice 单品价格
    * @apiParam itemType 单品类型
    * @apiParam itemImage 单品图片上传
    * @apiParam rel 单品物料信息
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @PostMapping("/InsertItem")
    public JSONRes insertItem(@RequestParam(value = "itemName",required = false) String itemName,
                              @RequestParam(value = "itemPrice",required = false) Float itemPrice,
                              @RequestParam(value = "itemType",required = false) String itemType,
                              @RequestParam(value = "itemImage",required = false) MultipartFile itemImage,
                              @RequestParam(value = "rel",required = false) Map<Integer,Integer> rel){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == itemName){
            status = Contants.ERROR;//失败状态
            msg = "itemName为空";
        }else if(null == itemPrice){
            status = Contants.ERROR;//失败状态
            msg = "itemPrice为空";
        }else if(null == itemType){
            status = Contants.ERROR;//失败状态
            msg = "itemType为空";
        }else if(null == itemImage) {
            status = Contants.ERROR;//失败状态
            msg = "itemImage为空";
        }else if(null == rel) {
            status = Contants.ERROR;//失败状态
            msg = "rel为空";
        }else {

            //拿到图片原始名称
            String orginFilename = itemImage.getOriginalFilename();
            //图片存储路径
            String imagePath = "D:\\Nginx\\html\\image\\";
            //UUID图片名称
            String imageFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
            try {
                //新的图片
                File newFile = new File(imagePath + imageFilename);
                //将内存中数据写入服务器磁盘
                itemImage.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            BaseDishesItem baseDishesItem = new BaseDishesItem();
            baseDishesItem.setDishesItemName(itemName);
            baseDishesItem.setDishesItemType(itemType);
            baseDishesItem.setDishesItemPrice(itemPrice);
            baseDishesItem.setImageName(imageFilename);
            baseDishesItem.setCreateTime(new Date());
            //添加单品
            boolean insert = baseDishesItemService.insert(baseDishesItem);

            //Lambda遍历map
            rel.forEach((key, value) -> {
                //添加单品物料关系
                RelDishesMaterial relDishesMaterial = new RelDishesMaterial();
                relDishesMaterial.setDishesItemId(baseDishesItem.getDishesItemId());
                relDishesMaterial.setDishesMaterialId(key);
                relDishesMaterial.setMaterialDosage(value);
                boolean insertRel = relDishesMaterialService.insert(relDishesMaterial) ;
            });


            if(insert){
                msg = "单品添加成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "单品添加失败";
            }
        }


        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }

    /**
    *
    * @api {delete} catering/DeleteItem 单品删除
    * @apiVersion 1.0.0
    * @apiName deleteItem
    * @apiGroup Item
    * @apiParam itemId 单品ID
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @DeleteMapping("/DeleteItem")
    public JSONRes deleteItem(@RequestParam(value = "itemId",required = false) Integer itemId){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == itemId){
            status = Contants.ERROR;//失败状态
            msg = "itemId为空";
        }else{
            BaseDishesItem baseDishesItem = new BaseDishesItem();
            baseDishesItem.setDishesItemId(itemId);
            baseDishesItem.setDelFlg("0");
            boolean delete = baseDishesItemService.updateById(baseDishesItem);

            EntityWrapper<RelDishesMaterial> wrapper = new EntityWrapper<>();
            wrapper.where("dishes_item_id={0}",itemId);
//            boolean deleteRel = relDishesMaterialService.delete(wrapper);
            List<RelDishesMaterial> list = relDishesMaterialService.selectList(wrapper);
            //遍历List 实现物料软删除
            list.forEach(x->x.setDelFlg("0"));
            boolean deleteRel = relDishesMaterialService.updateAllColumnBatchById(list);
            if(delete && deleteRel){
                msg = "单品删除成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "单品删除失败";
            }

        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }



    /**
    *
    * @api {put} catering/UpdateItem 修改单品
    * @apiVersion 1.0.0
    * @apiName updateItem
    * @apiGroup Item
    * @apiParam itemId 单品ID
    * @apiParam itemName 单品名称
    * @apiParam itemPrice 单品价格
    * @apiParam itemType 单品类型
    * @apiParam itemImage 单品图片上传
    * @apiParam rel 单品物料信息
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @PutMapping("/UpdateItem")
    public JSONRes updateItem(@RequestParam(value = "itemId",required = false) String itemId,
                              @RequestParam(value = "itemName",required = false) String itemName,
                              @RequestParam(value = "itemPrice",required = false) Float itemPrice,
                              @RequestParam(value = "itemType",required = false) String itemType,
                              @RequestParam(value = "itemImage",required = false) MultipartFile itemImage,
                              @RequestParam(value = "rel",required = false) Map<Integer,Integer> rel){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == itemId){
            status = Contants.ERROR;//失败状态
            msg = "itemid为空";
        }else{
            BaseDishesItem baseDishesItem = baseDishesItemService.selectById(itemId);

            if(itemName != null){
                baseDishesItem.setImageName(itemName);
            }
            if(itemPrice != null){
                baseDishesItem.setDishesItemPrice(itemPrice);
            }
            if(itemType != null){
                baseDishesItem.setDishesItemType(itemType);
            }
            if(itemImage != null){

                //拿到图片原始名称
                String orginFilename = itemImage.getOriginalFilename();
                //图片存储路径
                String iconPath = "D:\\Nginx\\html\\image\\";
                //UUID图片名称
                String iconFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
                try {
                    //新的图片
                    File newFile = new File(iconPath + iconFilename);
                    //将内存中数据写入服务器磁盘
                    itemImage.transferTo(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                baseDishesItem.setImageName(iconFilename);
            }else{
                logger.error("image cannt Obtain...");
            }

            if(rel != null){
                //Lambda遍历map
                rel.forEach((key, value) -> {
                    //添加单品物料关系
                    RelDishesMaterial relDishesMaterial = new RelDishesMaterial();
                    relDishesMaterial.setDishesItemId(baseDishesItem.getDishesItemId());
                    relDishesMaterial.setDishesMaterialId(key);
                    relDishesMaterial.setMaterialDosage(value);
                    //更新单品物料
                    boolean insertRel = relDishesMaterialService.insert(relDishesMaterial) ;
                });
            }
            //更新单品基本信息
            boolean update = baseDishesItemService.updateById(baseDishesItem);
            if(update){
                msg = "更新单品成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "更新单品失败";
            }
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


//    @GetMapping("/SelectItem")
//    public JSONRes selectItem(){
//
//        JSONRes jsonRes = new JSONRes();
//        Map<String, Object> res = new HashMap<String, Object>();
//        int status = Contants.SUCCESS;
//        String msg = "ok";
//
//        EntityWrapper<BaseDishesItem> wrapper = new EntityWrapper<>();
//        List<BaseDishesItem> itemList = baseDishesItemService.selectList(wrapper);
//
//        res.put("itemList",itemList);
//        if (null != itemList) {
//            msg = "查询单品成功";
//        } else {
//            status = Contants.ERROR2;//失败状态
//            msg = "系统异常，查询单品失败";
//        }
//
//        jsonRes.setStatus(status);
//        jsonRes.setMsg(msg);
//        jsonRes.setRes(res);
//        return jsonRes;
//    }


    /**
    *
    * @api {get} catering/SelectItem 查询所有单品
    * @apiVersion 1.0.0
    * @apiName selectItem
    * @apiGroup Item
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *  "msg": "查询单品成功",
    *  "status": 1,
    *  "res": {
    *    "itemList": [
    *      {
    *        "image": "I1001.png", //单品图片
    *        "code": "B1001", //单品编号
    *        "material": [], //单品物料
    *        "name": "霸王薯", //单品名称
    *        "id": 3, //单品ID
    *        "time": "2018-09-12 18:59:46", //单品创建时间
    *        "type": "1", //单品类型
    *        "pice": 10 //单品价格
    *      },
    *      {
    *        "image": null, //单品图片
    *        "code": null, //单品编号
    *        "material": [
    *          {
    *            "materialName": "牛肉", //物料名称
    *            "dosage": 50, //原料用量
    *            "unit": "g" //物料单位
    *          },
    *          {
    *            "materialName": "鸡肉",
    *            "dosage": 50,
    *            "unit": "g"
    *          }
    *        ], //单品物料信息
    *        "name": "单品测试啊", //单品名称
    *        "id": 65, //单品ID
    *        "time": "2018-09-20 18:32:29", //单品创建时间
    *        "type": null, //单品类型
    *        "pice": null //单品价格
    *      }
    *    ]
    *  }
    *}
    */
    @GetMapping("/SelectItem")
    public JSONRes selectItem(){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        List<Map<String,Object>> itemList = baseDishesItemService.selectItemAndMaterial();

        res.put("itemList",itemList);
        if (null != itemList) {
            msg = "查询单品成功";
        } else {
            status = Contants.ERROR2;//失败状态
            msg = "系统异常，查询单品失败";
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }

    /**
    *
    * @api {get} catering/SelectItemByName 根据单品名查询单品
    * @apiVersion 1.0.0
    * @apiName SelectItemByName
    * @apiGroup Item
    * @apiParam itemName 单品名
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
     *{
     *  "msg": "查询单品成功",
     *  "status": 1,
     *  "res": {
     *    "itemList": [
     *      {
     *        "image": "I1001.png", //单品图片
     *        "code": "B1001", //单品编号
     *        "material": [], //单品物料信息
     *        "name": "霸王薯", //单品名称
     *        "id": 3, //单品ID
     *        "time": "2018-09-12 18:59:46", //单品创建时间
     *        "type": "1", //单品类型
     *        "pice": 10 //单品价格
     *      }
     *    ]
     *  }
     *}
    */
    @GetMapping("/SelectItemByName")
    public JSONRes SelectItemByName(@RequestParam(value = "itemName",required = true) String itemName){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        Map<String,Object> map = new HashMap<>();
        map.put("itemName",itemName);
        List<Map<String,Object>> itemList = baseDishesItemService.selectItemAndMaterialByName(map);

        res.put("itemList",itemList);
        if (null != itemList) {
            msg = "查询单品成功";
        } else {
            status = Contants.ERROR2;//失败状态
            msg = "系统异常，查询单品失败";
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }



    /**
    *
    * @api {get} catering/selectItemByType 添加餐品页面，选项显示
    * @apiVersion 1.0.0
    * @apiName selectItemByType
    * @apiGroup Meal
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *  "msg": "ok",
    *  "status": 1,
    *  "res": {
    *    "drinkList": [
    *      {
    *        "dishesItemId": 33, //单品Id
    *        "dishesItemCode": "B1031", //单品编码
    *        "dishesItemName": "香草华夫甜筒", //单品名称
    *        "dishesItemType": "2", //单品类型
    *        "createTime": "2018-09-12 18:59:47", //创建时间
    *        "imageName": "I1004.png", //单品图片
    *        "dishesItemPrice": 6, //单品价格
    *        "delFlg": "1" //删除标志：0-删除1-未删除
    *      },
    *      {
    *        "dishesItemId": 34,
    *        "dishesItemCode": "B1032",
    *        "dishesItemName": "草莓华夫甜筒",
    *        "dishesItemType": "2",
    *        "createTime": "2018-09-12 18:59:47",
    *        "imageName": "I1004.png",
    *        "dishesItemPrice": 7,
    *        "delFlg": "1"
    *      },
    *      {
    *        "dishesItemId": 35,
    *        "dishesItemCode": "B1033",
    *        "dishesItemName": "草莓双旋华夫甜筒",
    *        "dishesItemType": "2",
    *        "createTime": "2018-09-12 18:59:47",
    *        "imageName": "I1004.png",
    *        "dishesItemPrice": 6.5,
    *        "delFlg": "1"
    *      }
    *    ], //饮品list
    *    "buttonList": [
    *      {
    *        "dicId": 7, //dicId
    *        "partitionId": "BUTTONTYPE", //分区代码
    *        "partitionDesc": "按钮类型", //分区描述
    *        "dicCode": "add", //枚举项代码
    *        "dicLabel": "立即购买", //枚举项名称
    *        "delFlg": "1" //删除标志：0-删除1-未删除
    *      },
    *      {
    *        "dicId": 10,
    *        "partitionId": "BUTTONTYPE",
    *        "partitionDesc": "按钮类型",
    *        "dicCode": "1",
    *        "dicLabel": "去定制",
    *        "delFlg": "1"
    *      },
    *      {
    *        "dicId": 12,
    *        "partitionId": "BUTTONTYPE",
    *        "partitionDesc": "按钮类型",
    *        "dicCode": "half",
    *        "dicLabel": "第二份半价",
    *        "delFlg": "1"
    *      }
    *    ],//按钮list
    *    "mainList": [
    *      {
    *        "dishesItemId": 23, //单品Id
    *        "dishesItemCode": "B1021", //单品编码
    *        "dishesItemName": "特惠狭鳕鱼双层堡", //单品名称
    *        "dishesItemType": "0", //单品类型
    *        "createTime": "2018-09-12 18:59:46", //创建时间
    *        "imageName": "I1003.png", //单品图片
    *        "dishesItemPrice": 10, //单品价格
    *        "delFlg": "1" //删除标志：0-删除1-未删除
    *      },
    *      {
    *        "dishesItemId": 24,
    *        "dishesItemCode": "B1022",
    *        "dishesItemName": "劲脆鸡腿堡",
    *        "dishesItemType": "0",
    *        "createTime": "2018-09-12 18:59:46",
    *        "imageName": "I1003.png",
    *        "dishesItemPrice": 16,
    *        "delFlg": "1"
    *      }
    *    ], //主餐list
    *    "snackList": [
    *      {
    *        "dishesItemId": 3, //单品Id
    *        "dishesItemCode": "B1001", //单品编码
    *        "dishesItemName": "霸王薯", //单品名称
    *        "dishesItemType": "1", //单品类型
    *        "createTime": "2018-09-12 18:59:46", //创建时间
    *        "imageName": "I1001.png", //单品图片
    *        "dishesItemPrice": 10, //单品价格
    *        "delFlg": "1" //删除标志：0-删除1-未删除
    *      },
    *      {
    *        "dishesItemId": 4,
    *        "dishesItemCode": "B1002",
    *        "dishesItemName": "小食拼盘",
    *        "dishesItemType": "1",
    *        "createTime": "2018-09-12 18:59:46",
    *        "imageName": "I1001.png",
    *        "dishesItemPrice": 26,
    *        "delFlg": "1"
    *      }
    *    ] //配餐list
    *  }
    *}
    */
    @GetMapping("/selectItemByType")
    public JSONRes selectItemByType(){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        EntityWrapper<BaseDishesItem> wrapperMain = new EntityWrapper<>();
        wrapperMain.where("dishes_item_type={0}","0");
        List<BaseDishesItem> mainList = baseDishesItemService.selectList(wrapperMain);

        EntityWrapper<BaseDishesItem> wrapperSnack = new EntityWrapper<>();
        wrapperSnack.where("dishes_item_type={0}","1");
        List<BaseDishesItem> snackList = baseDishesItemService.selectList(wrapperSnack);

        EntityWrapper<BaseDishesItem> wrapperDrink = new EntityWrapper<>();
        wrapperDrink.where("dishes_item_type={0}","2");
        List<BaseDishesItem> drinkList = baseDishesItemService.selectList(wrapperDrink);

        EntityWrapper<Dic> wrapperButton = new EntityWrapper<>();
        wrapperButton.where("partition_id={0}","BUTTONTYPE");
        List<Dic> buttonList = dicService.selectList(wrapperButton);

        res.put("mainList",mainList);
        res.put("snackList",snackList);
        res.put("drinkList",drinkList);
        res.put("buttonList",buttonList);


        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }

}
