package laus.mybatis.eggtrace.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import laus.mybatis.annotation.EggtraceAround;
import laus.mybatis.eggtrace.model.DrugResidueDetection;
import laus.mybatis.eggtrace.reader.mapper.*;

@RequestMapping(value = "/eggtrace/detection")
@RestController
public class DetectionController {
	
	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(DetectionController.class);
	
	@Autowired
	private DrugResidueDetectionReaderMapper service;

	@EggtraceAround
	@RequestMapping(value = "/detail", method = {RequestMethod.GET, RequestMethod.POST})
	public ArrayList<DrugResidueDetection> GetByTraceID(String traceid) {
		return service.GetByTraceID(traceid);
	}
	
}
