package com.jnsj.nmk.controller.material.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jnsj.nmk.entity.BaseMaterial;
import com.jnsj.nmk.service.BaseMaterialService;
import com.jnsj.nmk.util.JSON.Contants;
import com.jnsj.nmk.util.JSON.JSONRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Innovation
 * @Date: 2018/9/13 10:15
 * @Description: 物料管理相关Controller
 */
@RestController
public class MaterialController {


    @Autowired
    BaseMaterialService baseMaterialService;

    /**
    *
    * @api {post} catering/InsertMaterial 添加物料
    * @apiVersion 1.0.0
    * @apiName insertMaterial
    * @apiGroup Material
    * @apiParam materialName 物料名称
    * @apiParam materialType 物料分类（字典项）
    * @apiParam formulaUnit 配方单位
    * @apiParam stockUnit 库存单位
    * @apiParam stockUnitRate 库存单位换算率
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @PostMapping("/InsertMaterial")
    public JSONRes insertMaterial(@RequestParam(value = "materialName",required = false) String materialName,
                                  @RequestParam(value = "materialType",required = false) String materialType,
                                  @RequestParam(value = "formulaUnit",required = false) String formulaUnit,
                                  @RequestParam(value = "stockUnit",required = false) String stockUnit,
                                  @RequestParam(value = "stockUnitRate",required = false) Integer stockUnitRate){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == materialName){
            status = Contants.ERROR;//失败状态
            msg = "materialName为空";
        }else if(null == materialType){
            status = Contants.ERROR;//失败状态
            msg = "materialType为空";
        }else if(null == formulaUnit){
            status = Contants.ERROR;//失败状态
            msg = "formulaUnit为空";
        }else if(null == stockUnit){
            status = Contants.ERROR;//失败状态
            msg = "stockUnit为空";
        }else if(null == stockUnitRate){
            status = Contants.ERROR;//失败状态
            msg = "stockUnitRate为空";
        }else{

            BaseMaterial baseMaterial = new BaseMaterial();
            baseMaterial.setMaterialName(materialName);
            baseMaterial.setFormulaUnit(formulaUnit);
            baseMaterial.setMaterialType(materialType);
            baseMaterial.setStockUnit(stockUnit);
            baseMaterial.setStockUnitRate(stockUnitRate);
            baseMaterial.setCreateTime(new Date());
            baseMaterial.setDelFlg("1");

            boolean insert = baseMaterialService.insert(baseMaterial);
            if(insert){
                msg = "添加物料成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "添加物料失败";
            }
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }

    /**
    *
    * @api {delete} catering/DeleteMaterial 删除物料
    * @apiVersion 1.0.0
    * @apiName deleteMaterial
    * @apiGroup Material
    * @apiParam materialId 物料ID
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @DeleteMapping("/DeleteMaterial")
    public JSONRes deleteMaterial(@RequestParam(value = "materialId",required = false) Integer materialId){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == materialId){
            status = Contants.ERROR;//失败状态
            msg = "materialId为空";
        }else{
            BaseMaterial baseMaterial = new BaseMaterial();
            baseMaterial.setMaterialId(materialId);
            baseMaterial.setDelFlg("0");
            boolean delete = baseMaterialService.updateById(baseMaterial);
            if(delete){
                msg = "删除物料成功";
            }else {
                status = Contants.ERROR2;//失败状态
                msg = "删除物料失败";
            }

        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {put} catering/UpdateMaterial 修改物料信息
    * @apiVersion 1.0.0
    * @apiName updateMaterial
    * @apiGroup Material
    * @apiParam materialId 物料ID
    * @apiParam materialName 物料名称
    * @apiParam materialType 物料分类（字典项）
    * @apiParam formulaUnit 配方单位
    * @apiParam stockUnit 库存单位
    * @apiParam stockUnitRate 库存单位换算率
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *     {
    *       "status": "",
    *       "msg": "",
    *       "res": {}
    *     }
    */
    @PutMapping("/UpdateMaterial")
    public JSONRes updateMaterial(@RequestParam(value = "materialId",required = false) Integer materialId,
                                  @RequestParam(value = "materialName",required = false) String materialName,
                                  @RequestParam(value = "materialType",required = false) String materialType,
                                  @RequestParam(value = "formulaUnit",required = false) String formulaUnit,
                                  @RequestParam(value = "stockUnit",required = false) String stockUnit,
                                  @RequestParam(value = "stockUnitRate",required = false) Integer stockUnitRate){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == materialId){
            status = Contants.ERROR;//失败状态
            msg = "materialId为空";
        }else{
            BaseMaterial baseMaterial = baseMaterialService.selectById(materialId);
            if(null != materialName){
                baseMaterial.setMaterialName(materialName);
            }
            if (null != formulaUnit) {
                baseMaterial.setFormulaUnit(formulaUnit);
            }
            if(null != materialType){
                baseMaterial.setMaterialType(materialType);
            }
            if (null != stockUnit) {
                baseMaterial.setStockUnit(stockUnit);
            }
            if (null != stockUnitRate) {
                baseMaterial.setStockUnitRate(stockUnitRate);
            }
//            baseMaterial.setCreateTime(new Date());

            boolean update = baseMaterialService.updateById(baseMaterial);
            if (update) {
                msg = "更新物料成功";
            } else {
                status = Contants.ERROR2;//失败状态
                msg = "更新物料失败";
            }
        }
        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {get} catering/SelectMaterial 查询所有物料
    * @apiVersion 1.0.0
    * @apiName selectMaterial
    * @apiGroup Material
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *    "msg": "查询物料成功",
    *    "status": 1,
    *    "res": {
    *        "materialList": [
    *            {
    *                "materialId": 1, //物料ID
    *                "materialName": "牛肉", //物料名称
    *                "materialType": "肉类", //物料分类（字典项）
    *                "formulaUnit": "块", //配方单位
    *                "stockUnit": "箱", //库存单位
    *                "stockUnitRate": 12, //库存单位换算率
    *                "createTime": "2018-09-13 11:03:18", //创建时间
    *                "delFlg": "1"
    *            }
    *        ]
    *    }
    *}
    */
    @GetMapping("/SelectMaterial")
    public JSONRes selectMaterial(){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        EntityWrapper<BaseMaterial> wrapper = new EntityWrapper<>();
        wrapper.where("del_flg={0}","1");

        List<BaseMaterial> list = baseMaterialService.selectList(wrapper);
        res.put("materialList",list);
        if (null != list) {
            msg = "查询物料成功";
        } else {
            status = Contants.ERROR2;//失败状态
            msg = "系统异常，查询物料失败";
        }

        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }


    /**
    *
    * @api {get} catering/SelectMaterialByName 根据物料名称查询[模糊查询]
    * @apiVersion 1.0.0
    * @apiName selectMaterialByName
    * @apiGroup Material
    * @apiParam materialName 物料名称
    * @apiSuccess result 返回值描述
    * @apiSuccessExample Success-Response:
    *{
    *    "msg": "根据物料名查询物料成功",
    *    "status": 1,
    *    "res": {
    *        "materialList": [
    *            {
    *                "materialId": 1, //物料ID
    *                "materialName": "牛肉", //物料名称
    *                "materialType": "肉类", //物料分类（字典项）
    *                "formulaUnit": "块", //配方单位
    *                "stockUnit": "箱", //库存单位
    *                "stockUnitRate": 12, //库存单位换算率
    *                "createTime": "2018-09-13 11:03:18", //创建时间
    *                "delFlg": "1"
    *            }
    *        ]
    *    }
    *}
    */
    @GetMapping("/SelectMaterialByName")
    public JSONRes SelectMaterialByName(@RequestParam(value = "materialName",required = true) String materialName){

        JSONRes jsonRes = new JSONRes();
        Map<String, Object> res = new HashMap<String, Object>();
        int status = Contants.SUCCESS;
        String msg = "ok";

        if(null == materialName){
            status = Contants.ERROR;//失败状态
            msg = "materialName为空";
        }else{
            EntityWrapper<BaseMaterial> wrapper = new EntityWrapper<>();
            wrapper.like("material_name",materialName).and("del_flg={0}","1");

            List<BaseMaterial> list = baseMaterialService.selectList(wrapper);
            res.put("materialList",list);
            if (null != list) {
                msg = "根据物料名查询物料成功";
            } else {
                status = Contants.ERROR2;//失败状态
                msg = "系统异常，查询物料失败";
            }
        }
        jsonRes.setStatus(status);
        jsonRes.setMsg(msg);
        jsonRes.setRes(res);
        return jsonRes;
    }




}
