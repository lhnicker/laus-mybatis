package laus.mybatis.common;

/**
 * 自定义返回视图异常
 * All rights Reserved, Code By LiuHan
 * @Title:     ViewException.java   
 * @Package    laus.mybatis.common   
 * @author:    LiuHan   
 * @date:      2017年12月21日 上午10:32:59   
 * @version    V1.0.0
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
public class ViewException extends Exception {

	private static final long serialVersionUID = 1L;

	public ViewException(String message, String toView) {
		super(message);
		this.setView(toView);
	}
	
	public String getView() {
		return View;
	}

	public void setView(String view) {
		View = view;
	}

	private String View;

}
