package laus.mybatis.eggtrace.dynamicds.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import laus.mybatis.annotation.DataSource;
import laus.mybatis.eggtrace.controller.DetectionController;
import laus.mybatis.eggtrace.dynamicds.mappers.DynamicDataSourceDetectionMapper;
import laus.mybatis.eggtrace.model.DrugResidueDetection;

@RestController
@RequestMapping(value = "/eggtrace/detection/dynamicds")
public class DynamicDatasourceDetectionController {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(DetectionController.class);
	
	@Autowired
	private DynamicDataSourceDetectionMapper service;

	@DataSource("EggtraceReader")
	@RequestMapping(value = "/detail", method = {RequestMethod.GET, RequestMethod.POST})
	public ArrayList<DrugResidueDetection> GetByTraceID(String traceid) {
		return service.GetByTraceID(traceid);
	}
	
}
