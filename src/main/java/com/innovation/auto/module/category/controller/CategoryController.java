package com.innovation.auto.module.category.controller;

import com.innovation.auto.model.APIResult;
import com.innovation.auto.module.category.service.CategoryService;
import com.innovation.auto.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.*;

/**
 * @ClassName CategoryController
 * @Description
 * @Date 2019/5/15 20:05
 **/
@RestController
public class CategoryController {
    @Autowired
    private  CategoryService categoryService;

    /**
     * 查询热门机型
     * @return
     * @throws ParseException
     */
    @GetMapping("/category_motor/query")
    public APIResult queryByCategory() throws ParseException {

        APIResult apiResult = new APIResult();
        apiResult.setMsg("query successfully...");
        apiResult.setStatus(Constants.SUCCESS);

        List<HashMap<String, Object>> list = categoryService.selectByCategory();
        HashSet<String> set = new HashSet<>();
        HashMap<String,List<HashMap<String,Object>>> map = new HashMap<>();
        // 获得热门机型类型
        list.forEach(x -> set.add((String)x.get("value")));
        // 初始化结果集map("机型类型",List)
        set.forEach(x -> map.put(x, new ArrayList<>()));
        // 填充结果集
        list.forEach(x -> {
            if (set.contains(x.get("value"))) {
                HashMap<String, Object> temp = new HashMap<>();
                temp.put("name",x.get("name"));
                temp.put("id",x.get("id"));
                temp.put("type",x.get("type"));
                map.get(x.get("value")).add(temp);
            }
        });

        if (null != map){
            apiResult.setStatus(Constants.SUCCESS);
            apiResult.setRes(map);
            return apiResult;
        }else {
            apiResult.setMsg("query failed...");
            apiResult.setStatus(Constants.ERROR);
            return apiResult;
        }
    }
}
