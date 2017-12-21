package laus.mybatis.common;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 返回XML格式数据
 * All rights Reserved, Code By LiuHan
 * @Title:     BaseXmlReturnObj.java   
 * @Package    laus.mybatis.common   
 * @author:    LiuHan   
 * @date:      2017年12月21日 上午10:41:49   
 * @version    V1.0.0
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
@XmlRootElement
public class BaseXmlReturnObj<T> extends BaseReturnObject<T> {
	
	public BaseXmlReturnObj(){
		super();
	}

}
