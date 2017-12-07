package laus.mybatis.pay.core;

public class PaygateFactory {
	
	IPaygate CreatePaygate(PaygateType paygateType) {
		IPaygate paygate = null;
		switch (paygateType) {
		case Alipay:
			paygate = new AlipayPaygate();
			break;
		case Allinpay:
			paygate = new AllinpayPaygate();
			break;
		case Chinapay:
			paygate = new ChinapayPaygate();
			break;
		case JDpay:
			paygate = new JDpayPaygate();
			break;
		case Psbc:
			paygate = new PsbcPaygate();
			break;
		case Tenpay:
			paygate = new TenpayPaygate();
			break;
		default:
			break;
		}
		return paygate;
	}
	
}
