package laus.mybatis.pay.core;

public interface IPaygate {
	
	/*
	 * 推送订单到支付网关进行结算
	 */
	IPaygateResult PayOrder(IPayOrder payOrder);
	
	/*
	 * 查询订单结算状态
	 */
	IPaygateResult QueryOrder(IPayOrder payOrder);
	
	/*
	 * 取消订单支付
	 */
	IPaygateResult CancelOrder(IPayOrder payOrder);
	
}
