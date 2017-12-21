package laus.mybatis.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 保存当前线程使用的数据源名
 * All rights Reserved, Code By LiuHan
 * @Title:     DataSourceContextHolder.java   
 * @Package    laus.mybatis.configuration   
 * @author:    LiuHan   
 * @date:      2017年12月21日 下午2:27:28   
 * @version    V1.0.0
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
public class DataSourceContextHolder {
	
	private static final Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
	
	/*
	 * 默认数据源名
	 */
	public static final String DEFAULT_DS = "DemoDB";
	
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
