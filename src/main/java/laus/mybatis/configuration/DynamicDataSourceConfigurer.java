package laus.mybatis.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"laus.mybatis.eggtrace.dynamicds.mappers"}, sqlSessionFactoryRef = "dynamicSqlSessionFactory")
public class DynamicDataSourceConfigurer {
	
	@Autowired
	@Qualifier("DynamicDS")
	DataSource dynamicDataSource;

	@Bean
	public SqlSessionFactory dynamicSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dynamicDataSource);
		return bean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate eggtraceWriterSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(dynamicSqlSessionFactory());
		return template;
	}
	
}
