package laus.mybatis.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import laus.mybatis.common.BaseReturnObject;
import laus.mybatis.common.BaseXmlReturnObj;
import laus.mybatis.common.JsonException;
import laus.mybatis.common.ViewException;
import laus.mybatis.common.XmlException;

/**
 * 自定义全局异常处理类
 * All rights Reserved, Code By LiuHan
 * @Title:     GlobalExceptionHandler.java   
 * @Package    laus.mybatis.common   
 * @author:    LiuHan   
 * @date:      2017年12月21日 上午9:57:18   
 * @version    V1.0.0
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = JsonException.class)
	@ResponseBody
	public BaseReturnObject<Object> jsonExceptionHandler(HttpServletRequest req, HttpServletResponse rep, JsonException e) throws Exception {
		BaseReturnObject<Object> obj = new BaseReturnObject<Object>();
		obj.setCode((short) -1);
		obj.setMsg(e.getMessage());
		obj.setData(null);
		return obj;
	}
	
	@ExceptionHandler(value = XmlException.class)
	@ResponseBody
	public BaseXmlReturnObj<Object> xmlExceptionHandler(HttpServletRequest req, HttpServletResponse rep, XmlException e) throws Exception {
		BaseXmlReturnObj<Object> obj = new BaseXmlReturnObj<Object>();
		obj.setCode((short) -1);
		obj.setMsg(e.getMessage());
		obj.setData(null);
		return obj;
	}
	
	@ExceptionHandler(value = ViewException.class)
	public ModelAndView viewExceptionHandler(HttpServletRequest req, HttpServletResponse rep, ViewException e) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception", e);
		mv.setViewName(e.getView());
		return mv;
	}

}
