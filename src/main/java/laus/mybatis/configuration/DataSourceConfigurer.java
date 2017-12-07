package laus.mybatis.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfigurer {
	
	@Primary
	@Bean("DemoDB")
	@ConfigurationProperties(prefix = "spring.datasource.demo")
	public DataSource dataSourceDemo() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("EggtraceReader")
	@ConfigurationProperties(prefix = "spring.datasource.eggtracereader")
	public DataSource dataSourceEggtraceReader() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("EggtraceWriter")
	@ConfigurationProperties(prefix = "spring.datasource.eggtracewriter")
	public DataSource dataSourceEggtraceWriter() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean("DynamicDS")
	public DataSource dataSourceDynamic() {
		DynamicDataSource dynamicDS = new DynamicDataSource();
		
		//默认数据源
		dynamicDS.setDefaultTargetDataSource(dataSourceDemo());
		//配置多数据源
		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put("DemoDB", dataSourceDemo());
		targetDataSources.put("EggtraceReader", dataSourceEggtraceReader());
		targetDataSources.put("EggtraceWriter", dataSourceEggtraceWriter());
		dynamicDS.setTargetDataSources(targetDataSources);
		
		return dynamicDS;
	}
	
}
