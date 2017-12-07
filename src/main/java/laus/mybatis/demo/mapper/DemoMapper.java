package laus.mybatis.demo.mapper;

import org.apache.ibatis.annotations.*;

import laus.mybatis.demo.model.Demo;

public interface DemoMapper {
	
	@Select("select * from names where name=#{name}")
	public Demo findByName(@Param("name")String name);
	
	@Insert("insert into names (name) values (#{name})")
	public int insertNewDemo(Demo demo);
	
}
