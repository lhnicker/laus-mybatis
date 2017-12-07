package laus.mybatis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import laus.mybatis.annotation.Authentication;
import laus.mybatis.demo.mapper.DemoMapper;
import laus.mybatis.demo.model.Demo;

@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	DemoMapper demoMapper;
	
	@RequestMapping(value = "/query", method = {RequestMethod.POST})
	public Demo GetDemoByName(String name) {
		Demo demo = demoMapper.findByName(name);
		return demo;
	}
	
	@Authentication(login = true, allow_roles = {"administrator"})
	@RequestMapping(value = "/insert", method = {RequestMethod.POST})
	public int InsertNewDemo(String name) {
		Demo demo = new Demo();
		demo.setName(name);
		int result = demoMapper.insertNewDemo(demo);
		return result;
	}
	
}
