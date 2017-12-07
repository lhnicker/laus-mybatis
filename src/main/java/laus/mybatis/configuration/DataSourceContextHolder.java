package laus.mybatis.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 保存当前线程使用的数据源名
 * 
 * @author LiuHan
 * @create 2017/12/01
 */
public class DataSourceContextHolder {
	
	private static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
	
	/*
	 * 默认数据源名
	 */
	public static final String DEFAULT_DS = "demo";
	
	/*
	 * 当前线程
	 */
	private static final ThreadLocal<String> contextDsHolder = new ThreadLocal<String>();
	
	public static void SetDataSource(String dataSourceName) {
		log.info("设置前的当前数据源为{}", GetCurrentDataSource());
		contextDsHolder.set(dataSourceName);
		log.info("设置后的当前数据源为{}", GetCurrentDataSource());
	}
	
	public static String GetCurrentDataSource() {
		return contextDsHolder.get();
	}
	
	public static void ClearDataSource() {
		contextDsHolder.remove();
	}
	
}
