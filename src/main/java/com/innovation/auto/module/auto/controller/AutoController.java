package com.innovation.auto.module.auto.controller;

import com.innovation.auto.entity.MotorInfo;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.auto.service.AutoService;
import com.innovation.auto.util.Constants;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: carver
 * @Date: 2018/12/24 22:42
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@RestController
public class AutoController {

    @Autowired
    private AutoService autoService;


    /**
     * 查询汽车信息/all/byCountry
     * @return
     */
    @GetMapping("/queryAuto")
    public APIResult queryAuto(@RequestParam(value = "countryId",required = false) Integer countryId,
                               @RequestParam(value = "name",required = false) String name) {
        APIResult apiResult = new APIResult();
        apiResult.setMsg("ok");
        apiResult.setStatus(Constants.SUCCESS);

        Map<String,Object> map = new HashMap<>();
        map.put("countryId",countryId);
        map.put("name",name);
        List<LinkedHashMap<String,String>> motorInfos = autoService.selectAuto(map);


        apiResult.setRes(motorInfos);
        apiResult.setStatus(Constants.SUCCESS);
        apiResult.setMsg("query success");
        return apiResult;
    }


    /**
     * 查询motor详细信息
     * @return
     */
    @GetMapping("/motor")
    public APIResult queryMotor(@RequestParam(value = "motorId") Integer motorId) {
        APIResult apiResult = new APIResult();
        apiResult.setMsg("ok");
        apiResult.setStatus(Constants.SUCCESS);
        LinkedHashMap<String, String> motorInfo = autoService.selectByMotorId(motorId);
        apiResult.setRes(motorInfo);
        apiResult.setStatus(Constants.SUCCESS);
        apiResult.setMsg("query success");
        return apiResult;
    }

    /**
     * 删除汽车
     * @param id
     * @return
     */
    @DeleteMapping("/motor")
    public APIResult deleteAuto(@RequestParam(value = "id") Integer id) {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("delete successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        int result = autoService.deleteByPrimaryKey(id);

        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("delete failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }

    @PostMapping("/motor")
    public APIResult insertAuto(@RequestParam(value = "motorName") String motorName,
                                @RequestParam(value = "country") String country,
                                @RequestParam(value = "retailPrice") Long retailPrice,
                                @RequestParam(value = "weight") String weight,
                                @RequestParam(value = "maxTorque") String maxTorque,
                                @RequestParam(value = "maxPower") String maxPower,
                                @RequestParam(value = "maxSpeed") String maxSpeed) {
        MotorInfo motorInfo = new MotorInfo();
        motorInfo.setName(motorName);
        motorInfo.setMadeCountry(country);
        motorInfo.setRetailPrice(retailPrice);
        motorInfo.setWeight(weight);
        motorInfo.setMaximumTorque(maxTorque);
        motorInfo.setMaximumPower(maxPower);
        motorInfo.setmaximumSpeed(maxSpeed);

        APIResult apiResult = new APIResult();
        apiResult.setMsg("insert successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        int result = autoService.insert(motorInfo);
        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("insert failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }

    @PutMapping("/motor")
    public APIResult updateAuto(@RequestBody MotorInfo motorInfo) {
        APIResult apiResult = new APIResult();
        apiResult.setMsg("update successfully...");
        apiResult.setStatus(Constants.SUCCESS);
        int result = autoService.updateByPrimaryKeySelective(motorInfo);

        if (result == 1) {
            apiResult.setStatus(Constants.SUCCESS);
            return apiResult;
        }else {
            apiResult.setMsg("update failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }



}
