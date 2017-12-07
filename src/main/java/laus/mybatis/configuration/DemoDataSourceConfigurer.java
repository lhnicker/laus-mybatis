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
@MapperScan(basePackages = {"laus.mybatis.demo.mapper"}, sqlSessionFactoryRef = "demoSqlSessionFactory")
public class DemoDataSourceConfigurer {
	
	@Autowired
	@Qualifier("DemoDB")
	DataSource demoDS;
	
	@Bean
	public SqlSessionFactory demoSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean demoFactoryBean = new SqlSessionFactoryBean();
		demoFactoryBean.setDataSource(demoDS);
		return demoFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate demoSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(demoSqlSessionFactory());
		return template;
	}
	
}
