package com.innovation.auto.module.country.controller;

import com.innovation.auto.module.country.service.CountryService;
import com.innovation.auto.entity.Country;
import com.innovation.auto.model.APIResult;
import com.innovation.auto.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: carver
 * @Date: 2018/12/24 21:55
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description:
 */
@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    /**
     * 查询车厂国家名及其代码
     * @return json
     */
    @GetMapping("/queryCountry")
    public APIResult queryCountry() {
        APIResult apiResult = new APIResult();
        apiResult.setMsg("ok");
        apiResult.setStatus(Constants.SUCCESS);

        List<Country> countries = countryService.selectCountry();


        apiResult.setRes(countries);
        apiResult.setStatus(Constants.SUCCESS);
        apiResult.setMsg("query success");
        return apiResult;
    }
}
