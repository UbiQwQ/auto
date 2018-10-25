package com.innovation.auto.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Auther: carver
 * @Date: 2018/10/25 08:55
 * @email lt1550919167@163.com
 * @QQ 1550919167
 * @Description: Mybatis PageHelper 分页插件配置Class
 */
@Configuration
public class PageHelperConfig {

    private static final Logger log = LoggerFactory.getLogger(PageHelperConfig.class);

    @Bean
    public PageHelper pageHelper() {
        log.info("------Register MyBatis PageHelper------");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("helperDialect", "mysql");
//        p.setProperty("offsetAsPageNum", "true");
//        p.setProperty("rowBoundsWithCount", "true");
        //默认false禁用 ||启用合理化时，如果pageNum<1会查询第一页，如果pageNum>pages会查询最后一页 禁用合理化时，如果pageNum<1或pageNum>pages会返回空数据
        p.setProperty("reasonable", "true");
        //通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
//        p.setProperty("pageSizeZero", "true");

        p.setProperty("supportMethodsArguments", "true");
        p.setProperty("returnPageInfo", "check");
        p.setProperty("params", "count=countSql");

        pageHelper.setProperties(p);

        //添加插件
        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
        return pageHelper;
    }
}
