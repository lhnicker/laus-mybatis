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
@MapperScan(basePackages = {"laus.mybatis.eggtrace.reader.mapper"}, sqlSessionFactoryRef = "eggtraceReaderSqlSessionFactory")
public class EggtraceReaderDataSourceConfigurer {
	
	@Autowired
	@Qualifier("EggtraceReader")
	DataSource eggtraceReaderDS;
	
	@Bean
	public SqlSessionFactory eggtraceReaderSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(eggtraceReaderDS);
		return bean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate eggtraceReaderSqlSessionTemplate() throws Exception {
		SqlSessionTemplate template = new SqlSessionTemplate(eggtraceReaderSqlSessionFactory());
		return template;
	}

}
