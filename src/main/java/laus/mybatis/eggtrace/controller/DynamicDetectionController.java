package laus.mybatis.eggtrace.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import laus.mybatis.eggtrace.model.DrugResidueDetection;
import laus.mybatis.eggtrace.model.InsertDrugResidueDetectionParameter;
import laus.mybatis.eggtrace.repository.DrugResidueDetectionRepository;

/**
 * 使用动态数据源进行处理
 * All rights Reserved, Code By LiuHan
 * @Title:     DynamicDetectionController.java   
 * @Package    laus.mybatis.eggtrace.controller   
 * @author:    LiuHan   
 * @date:      2017年12月21日 下午1:41:03   
 * @version    V1.0.0
 * @Copyright: 2017 www.eggworld.cn Inc. All rights reserved.
 */
@RequestMapping(value = "/eggtrace/dynamic/detection")
@RestController
public class DynamicDetectionController {
	
	private static Logger log = LoggerFactory.getLogger(DynamicDetectionController.class);

	@Autowired
	DrugResidueDetectionRepository repository;
	
	@RequestMapping(value = "/detail/{traceid}", method = {RequestMethod.GET, RequestMethod.POST})
	public ArrayList<DrugResidueDetection> GetListByTraceID(@PathVariable("traceid")String traceid){
		log.info("使用动态数据源获取检测结果列表");
		return repository.GetListByTraceID(traceid);
	}
	
	@RequestMapping(value = "/new", method = {RequestMethod.POST})
	@ResponseBody
	public int InsertNewDetection(InsertDrugResidueDetectionParameter parameters) {
		DrugResidueDetection model = new DrugResidueDetection();
		model.setDrugResDeteID(UUID.randomUUID().toString());
		model.setTraceID(parameters.getTraceID());
		model.setDetectionTypeID(parameters.getDetectionTypeID());
		model.setDetectionTypeName(parameters.getDetectionTypeName());
		model.setDetectionPic(parameters.getDetectionPic());
		model.setDetectionID(parameters.getDetectionID());
		model.setDetectionResult(parameters.getDetectionResult());
		model.setCreateTime(new Timestamp(System.currentTimeMillis()));
		model.setIsValid((short) 1);
		int result = repository.Insert(model);
		return result;
	}
	
}
