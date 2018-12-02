package com.jnsj.nmk.controller.carousel.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jnsj.nmk.entity.BaseCyclePicture;
import com.jnsj.nmk.service.BaseCyclePictureService;
import com.jnsj.nmk.util.JSON.Contants;
import com.jnsj.nmk.util.JSON.JSONRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * @Auther: Innovation
 * @Date: 2018/9/13 16:39
 * @Description: 轮播图增删改查Controller
 */
@RestController
public class CarouselController {

    public final static Logger logger = LoggerFactory.getLogger(CarouselController.class);
    //ImagePath
    @Value("${IMAGEHTTP}")
    private String imageHttp;

    @Autowired
    BaseCyclePictureService cyclePictureService;

    /**
    *
    * @api {post} catering/InsertCarousel 添加轮播图
    * @apiVersion 1.0.0
    * @apiName insertCarousel
    * @apiGroup Carousel
    * @apiParam imageTitle 图片标题
    * @apiParam image 图片文件
    * @apiParam enable 显示标志（字典项）：0-不在前端显示，1-在前端显示
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @Transactional
    @PostMapping("/carousel/insertCarousel")
    public JSONRes insertCarousel(@RequestParam(value = "imageTitle",required = false) String imageTitle,
                                  @RequestParam(value = "image",required = false) MultipartFile image,
                                  @RequestParam(value = "enable",required = false) String enable) throws Exception{

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == imageTitle){
            //失败状态
            status = Contants.ERROR;
            msg = "imageTitle为空";
        }else if(null == image){
            //失败状态
            status = Contants.ERROR;
            msg = "image为空";
        }else if(null == enable){
            //失败状态
            status = Contants.ERROR;
            msg = "enable为空";
        }else{

            //拿到图片原始名称
            String orginFilename = image.getOriginalFilename();
            //图片存储路径
            String imagePath = "D:\\Nginx\\html\\image\\";
            //UUID图片名称
            String imageFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
//            try {
                //新的图片
                File newFile = new File(imagePath + imageFilename);
                //将内存中数据写入服务器磁盘
                image.transferTo(newFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            BaseCyclePicture baseCyclePicture = new BaseCyclePicture();
            baseCyclePicture.setImageTitle(imageTitle);
            baseCyclePicture.setImageName(imageFilename);
            baseCyclePicture.setImageRef(imageHttp + imageFilename);
            baseCyclePicture.setShowFlg(enable);
            baseCyclePicture.setCreateTime(new Date());

            boolean insert = cyclePictureService.insert(baseCyclePicture);
            if(insert){
                msg = "轮播图添加成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "轮播图添加失败";
            }
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {post} catering/DeleteCarousel 删除轮播图
    * @apiVersion 1.0.0
    * @apiName deleteCarousel
    * @apiGroup Carousel
    * @apiParam carouselId 轮播图ID
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *  "msg": "图片删除成功",
    *  "status": 1,
    *  "res": {}
    *}
    */
    @DeleteMapping("/carousel/deleteCarousel")
    public JSONRes deleteCarousel(@RequestParam(value = "carouselId",required = false) Integer carouselId){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == carouselId){
            status = Contants.ERROR;//失败状态
            msg = "carouselId为空";
        }else{
            BaseCyclePicture baseCyclePicture = cyclePictureService.selectById(carouselId);
            baseCyclePicture.setShowFlg("0");
            baseCyclePicture.setDelFlg("0");
            boolean delete = cyclePictureService.updateById(baseCyclePicture);
            if(delete){
                msg = "图片删除成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "图片删除失败";
            }

        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {put} catering/UpdateCarousel 修改轮播图信息
    * @apiVersion 1.0.0
    * @apiName updateCarousel
    * @apiGroup Carousel
    * @apiParam carouselId 轮播图ID
    * @apiParam imageTitle 图片标题
    * @apiParam image 上传图片文件
    * @apiParam enable 显示标志（字典项）：0-不在前端显示，1-在前端显示
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @PutMapping("/UpdateCarousel")
    public JSONRes updateCarousel(@RequestParam(value = "carouselId",required = true) Integer carouselId,
                                  @RequestParam(value = "imageTitle",required = false) String imageTitle,
                                  @RequestParam(value = "image",required = false) MultipartFile image,
                                  @RequestParam(value = "enable",required = false) String enable){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == carouselId){
            status = Contants.ERROR;//失败状态
            msg = "carouselId为空";
        }else{

            BaseCyclePicture baseCyclePicture = cyclePictureService.selectById(carouselId);

            if(null != imageTitle){
                baseCyclePicture.setImageTitle(imageTitle);
            }
            if(null != image){
                //拿到图片原始名称
                String orginFilename = image.getOriginalFilename();
                //图片存储路径
                String imagePath = "D:\\Nginx\\html\\image\\";
                //UUID图片名称
                String imageFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
                try {
                    //新的图片
                    File newFile = new File(imagePath + imageFilename);
                    //将内存中数据写入服务器磁盘
                    image.transferTo(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                baseCyclePicture.setImageName(imageFilename);
                baseCyclePicture.setImageRef(imageHttp + imageFilename);
            }
            if(null != enable){
               baseCyclePicture.setShowFlg(enable);
            }else {

                //拿到图片原始名称
                String orginFilename = image.getOriginalFilename();
                //图片存储路径
                String imagePath = "D:\\Nginx\\html\\image\\";
                //UUID图片名称
                String imageFilename = UUID.randomUUID() + orginFilename.substring(orginFilename.lastIndexOf("."));
                try {
                    //新的图片
                    File newFile = new File(imagePath + imageFilename);
                    //将内存中数据写入服务器磁盘
                    image.transferTo(newFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                baseCyclePicture.setImageTitle(imageTitle);
                baseCyclePicture.setImageName(imageFilename);
                baseCyclePicture.setImageRef(imageHttp + imageFilename);
                baseCyclePicture.setShowFlg(enable);
                baseCyclePicture.setCreateTime(new Date());
            }

            boolean update = cyclePictureService.updateById(baseCyclePicture);
            if(update){
                msg = "轮播图更新成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "轮播图更新失败";
            }
        }
        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {get} catering/SelectCarousel 查询所有轮播图片
    * @apiVersion 1.0.0
    * @apiName selectCarousel
    * @apiGroup Carousel
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *  "msg": "查询轮播图成功",
    *  "status": 1,
    *  "res": {
    *    "carouselList": [
    *      {
    *        "cyclePictureId": 1, //轮播图ID
    *        "imageTitle": "轮播图片", //轮播图标题
    *        "imageName": "L1001.jpg", //图片名称,用来检索服务器对应的名称
    *        "imageRef": "http://47.104.240.143:8082/image/L1001.jpg", //图片链接地址
    *        "imageButton": null, //图片按钮
    *        "showFlg": "1", //显示标志（字典项）：0-不在前端显示，1-在前端显示
    *        "createTime": "2018-08-31 18:18:14", //创建时间
    *        "delFlg": "1" //删除标志：0-删除1-未删除
    *      }
    *    ]
    *  }
    *}
    */
    @GetMapping("/SelectCarousel")
    public JSONRes selectCarousel(){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        EntityWrapper<BaseCyclePicture> wrapper = new EntityWrapper<>();
        wrapper.where("show_flg={0}","1").and("del_flg={0}","1");
        List<BaseCyclePicture> list = cyclePictureService.selectList(wrapper);
        res.put("carouselList",list);
        if (null != list) {
            msg = "查询轮播图成功";
        } else {
            status = Contants.ERROR2;//失败状态
            msg = "系统异常，查询轮播图失败";
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {get} catering/SelectCarouselByTitle 根据imageTitle查询轮播图
    * @apiVersion 1.0.0
    * @apiName selectCarouselByName
    * @apiGroup Carousel
    * @apiParam imageTitle 图片Title
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *    "msg": "根据Title查询轮播图成功",
    *    "status": 1,
    *    "res": {
    *        "carouselList": [
    *            {
    *                "cyclePictureId": 1, //轮播图ID
    *                "imageTitle": "轮播图片", //轮播图标题
    *                "imageName": "L1001.jpg", //图片名称,用来检索服务器对应的名称
    *                "imageRef": "http://47.104.240.143:8082/image/L1001.jpg", //图片链接地址
    *                "imageButton": null, //图片按钮
    *                "showFlg": "1", //显示标志（字典项）：0-不在前端显示，1-在前端显示
    *                "createTime": "2018-08-31 18:18:14", //创建时间
    *                "delFlg": "1" //删除标志：0-删除1-未删除
    *            }
    *        ]
    *    }
    *}
    */
    @GetMapping("/SelectCarouselByTitle")
    public JSONRes selectCarouselByName(@RequestParam(value = "imageTitle",required = true) String imageTitle){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        EntityWrapper<BaseCyclePicture> wrapper = new EntityWrapper<>();
        wrapper.where("show_flg={0}","1").and("del_flg={0}","1").like("image_title",imageTitle);
        List<BaseCyclePicture> list = cyclePictureService.selectList(wrapper);
        res.put("carouselList",list);
        if (null != list) {
            msg = "根据Title查询轮播图成功";
        } else {
            status = Contants.ERROR2;//失败状态
            msg = "系统异常，根据Title查询轮播图失败";
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }



}
