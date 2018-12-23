package com.jnsj.nmk.controller.menu.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jnsj.nmk.entity.BaseDishesMenu;
import com.jnsj.nmk.entity.BaseMaterial;
import com.jnsj.nmk.entity.BaseMenu;
import com.jnsj.nmk.service.BaseDishesMenuService;
import com.jnsj.nmk.service.BaseMenuService;
import com.jnsj.nmk.util.JSON.Contants;
import com.jnsj.nmk.util.JSON.JSONRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Auther: Innovation
 * @Date: 2018/9/12 16:52
 * @Description:
 */
@RestController
public class MenuController {

    private final static Logger logger = LoggerFactory.getLogger(MenuController.class);

    //ImagePath
    @Value("${IMAGEHTTP}")
    private String imageHttp;

    @Autowired
    private BaseMenuService menuService;
    @Autowired
    private BaseDishesMenuService baseDishesMenuService;


    /**
    *
    * @api {post} catering/InsertMenu 添加菜单
    * @apiVersion 1.0.0
    * @apiName insertMenu
    * @apiGroup Menu
    * @apiParam menuName 菜单名称
    * @apiParam menuIcon 菜单图片
    * @apiParam enable 删除标志：0-删除1-未删除
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @PostMapping("/InsertMenu")
    public JSONRes insertMenu(@RequestParam(value = "menuName",required = false) String menuName,
                              @RequestParam(value = "menuIcon",required = false) MultipartFile menuIcon,
                              @RequestParam(value = "enable",required = false) String enable){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == menuName){
            status = Contants.ERROR;//失败状态
            msg = "menuName为空";
        }else if(null == menuIcon){
            status = Contants.ERROR;//失败状态
            msg = "menuIcon为空";
        }else if(null == enable){
            status = Contants.ERROR;//失败状态
            msg = "enable为空";
        }else{

            //拿到图片原始名称
            String orginFilename = menuIcon.getOriginalFilename();
            //图片存储路径
            String iconPath = "D:\\Nginx\\html\\image\\";
            //UUID图片名称
            String iconFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
            try {
                //新的图片
                File newFile = new File(iconPath + iconFilename);
                //将内存中数据写入服务器磁盘
                menuIcon.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            BaseMenu baseMenu = new BaseMenu();
            baseMenu.setMenuName(menuName);
            baseMenu.setMenuImage(iconFilename);
            baseMenu.setDelFlg(enable);
            baseMenu.setCreateTime(new Date());

            boolean insert = menuService.insert(baseMenu);
            if(insert){
                msg = "添加菜单成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "添加菜单失败";
            }
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {delete} catering/DeleteMenu 菜单软删除
    * @apiVersion 1.0.0
    * @apiName deleteMenu
    * @apiGroup Menu
    * @apiParam menuId 菜单ID
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @DeleteMapping("/DeleteMenu")
    public JSONRes deleteMenu(@RequestParam(value = "menuId",required = true) Integer menuId){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == menuId){
            status = Contants.ERROR;//失败状态
            msg = "menuId为空";
        }else{
            BaseMenu baseMenu = menuService.selectById(menuId);
            baseMenu.setDelFlg("0");
            boolean delete = menuService.updateById(baseMenu);

            BaseDishesMenu baseDishesMenu = new BaseDishesMenu();
            baseDishesMenu.setDelFlg("0");
            EntityWrapper<BaseDishesMenu> wrapper = new EntityWrapper<>();
            wrapper.where("menu_id={0}",menuId);
            boolean deleteMeal = baseDishesMenuService.update(baseDishesMenu,wrapper);

            if(delete && deleteMeal){
                msg = "删除菜单成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "删除菜单失败";
            }

        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {put} catering/UpdateMenu 更新菜单
    * @apiVersion 1.0.0
    * @apiName updateMenu
    * @apiGroup UpdateMenu
    * @apiParam menuId 菜单ID
    * @apiParam menuName 菜单名称
    * @apiParam menuIcon 菜单图片
    * @apiParam enable 删除标志：0-删除1-未删除
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @PutMapping("/UpdateMenu")
    public JSONRes updateMenu(@RequestParam(value = "menuId",required = false) Integer menuId,
                              @RequestParam(value = "menuName",required = false) String menuName,
                              @RequestParam(value = "menuIcon",required = false) MultipartFile menuIcon,
                              @RequestParam(value = "enable",required = false) String enable){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == menuId){
            status = Contants.ERROR;//失败状态
            msg = "menuId为空";
            jsonRes.setStatus(status);
            jsonRes.setMsg(msg);
            jsonRes.setRes(res);
            return jsonRes;
        }else{
            BaseMenu baseMenu = menuService.selectById(menuId);
            if(menuName != null){
                baseMenu.setMenuName(menuName);
            }
            if(menuIcon != null){

                //拿到图片原始名称
                String orginFilename = menuIcon.getOriginalFilename();
                //图片存储路径
                String iconPath = "D:\\Nginx\\html\\image\\";
                //UUID图片名称
                String iconFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
                try {
                    //新的图片
                    File newFile = new File(iconPath + iconFilename);
                    //将内存中数据写入服务器磁盘
                    menuIcon.transferTo(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                baseMenu.setMenuImage(iconFilename);
            }else{
                logger.error("image cannt Obtain...");
            }
            if(enable != null){
                baseMenu.setDelFlg(enable);
            }

            boolean update = menuService.updateById(baseMenu);

            if(update){
                msg = "更新菜单成功";
            }else {
                //失败状态
                status = Contants.ERROR2;
                msg = "更新菜单失败";
            }
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }

    /**
    *
    * @api {get} catering/SelectMenu 查询所有菜单
    * @apiVersion 1.0.0
    * @apiName selectMenu
    * @apiGroup Menu
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *  "msg": "查询菜单成功",
    *  "status": 1,
    *  "res": {
    *    "menuList": [
    *      {
    *        "menuId": 2, //菜单ID
    *        "menuName": "精美小食", //菜单名称
    *        "createTime": "2018-09-13 09:15:34", //创建时间
    *        "menuImage": "M1004.png", //菜单图片
    *        "delFlg": "1" //删除标志：0-删除1-未删除
    *      },
    *      {
    *        "menuId": 3,
    *        "menuName": "经典套餐",
    *        "createTime": "2018-09-13 09:15:34",
    *        "menuImage": "M1003.png",
    *        "delFlg": "1"
    *      },
    *      {
    *        "menuId": 4,
    *        "menuName": "主食",
    *        "createTime": "2018-09-13 09:15:34",
    *        "menuImage": "M1006.png",
    *        "delFlg": "1"
    *      },
    *      {
    *        "menuId": 5,
    *        "menuName": "冰激凌",
    *        "createTime": "2018-09-13 09:15:34",
    *        "menuImage": "M1001.png",
    *        "delFlg": "1"
    *      },
    *      {
    *        "menuId": 6,
    *        "menuName": "咖啡饮品",
    *        "createTime": "2018-09-13 09:15:34",
    *        "menuImage": "M1005.png",
    *        "delFlg": "1"
    *      },
    *      {
    *        "menuId": 7,
    *        "menuName": "披萨",
    *        "createTime": "2018-09-13 09:15:34",
    *        "menuImage": "M1002.png",
    *        "delFlg": "1"
    *      }
    *    ]
    *  }
    *}
    */
    @GetMapping("/SelectMenu")
    public JSONRes selectMenu(){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        EntityWrapper<BaseMenu> wrapper = new EntityWrapper<>();
        wrapper.where("del_flg={0}","1");
        List<BaseMenu> list = menuService.selectList(wrapper);
        res.put("menuList",list);
        if (null != list) {
            msg = "查询菜单成功";
        } else {
            status = Contants.ERROR2;//失败状态
            msg = "系统异常，查询菜单失败";
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }
}