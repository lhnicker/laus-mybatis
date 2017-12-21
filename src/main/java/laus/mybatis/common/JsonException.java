package laus.mybatis.common;

/**
 * 自定义返回JSON的异常
 * All rights Reserved, Code By LiuHan
 * @Title:     JsonException.java   
 * @Package    laus.mybatis.common   
 * @author:    LiuHan   
 * @date:      2017年12月21日 上午10:33:21   
 * @version    V1.0.0
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
public class JsonException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public JsonException(String message) {
		super(message);
	}

}
