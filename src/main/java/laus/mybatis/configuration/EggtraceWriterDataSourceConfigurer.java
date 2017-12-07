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
@MapperScan(basePackages = {"laus.mybatis.eggtrace.writer.mapper"}, sqlSessionFactoryRef = "eggtraceWriterSqlSessionFactory")
public class EggtraceWriterDataSourceConfigurer {

	@Autowired
	@Qualifier("EggtraceWriter")
	DataSource eggtraceWriterDS;
	
	@Bean
	public SqlSessionFactory eggtraceWriterSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(eggtraceWriterDS);
		return bean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate eggtraceWriterSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(eggtraceWriterSqlSessionFactory());
		return template;
	}
	
}
