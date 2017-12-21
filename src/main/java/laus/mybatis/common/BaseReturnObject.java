package laus.mybatis.common;

/**
 * 基本的JSON返回架构类
 * All rights Reserved, Code By LiuHan
 * @Title:     BaseReturnObject.java   
 * @Package    laus.mybatis.common   
 * @author:    LiuHan   
 * @date:      2017年12月21日 上午9:56:14   
 * @version    V1.0.0
 * @param <T>
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
public class BaseReturnObject<T> {

	private short Code;
	
	private String Msg;
	
	private T Data;

	public short getCode() {
		return Code;
	}

	public void setCode(short code) {
		Code = code;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public Object getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}
	
}
