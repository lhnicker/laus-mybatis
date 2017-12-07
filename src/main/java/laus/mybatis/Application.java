package laus.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//禁用自动配置，转而配置多数据源
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) 
@MapperScan(basePackages = {"laus.mybatis.eggtrace.*.mapper", "laus.mybatis.demo.mapper", "laus.mybatis.eggtrace.dynamicds.mappers"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
