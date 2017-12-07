package laus.mybatis.pay.core;

import java.math.BigDecimal;

/*
 * 定义支付单接口
 */
public interface IPayOrder {

	/*
	 * 订单号
	 */
	String OrderID = "";
	
	/*
	 * 订单应支付金额
	 */
	BigDecimal PaySum = new BigDecimal("0.00");
	
	/*
	 * 用户ID
	 */
	long UserID = 0;
	
	/*
	 * 用户名
	 */
	String UserName = "";
	
	/*
	 * 订单描述
	 */
	String OrderDesc = "";
	
}
