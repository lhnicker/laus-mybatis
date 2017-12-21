package laus.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 应用程序入口
 * All rights Reserved, Code By LiuHan
 * @Title:     Application.java   
 * @Package    laus.mybatis   
 * @author:    LiuHan   
 * @date:      2017年12月21日 上午10:29:13   
 * @version    V1.0.0
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
@EnableAspectJAutoProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) 
@MapperScan(basePackages = {"laus.mybatis.eggtrace.*.mapper", "laus.mybatis.demo.mapper", "laus.mybatis.eggtrace.dynamicds.mappers"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
