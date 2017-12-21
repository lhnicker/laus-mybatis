package laus.mybatis.eggtrace.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import laus.mybatis.annotation.SwitchDataSource;
import laus.mybatis.eggtrace.dynamicds.mappers.DynamicDataSourceDetectionMapper;
import laus.mybatis.eggtrace.model.DrugResidueDetection;

@Repository
public class DrugResidueDetectionRepository {

	@Autowired
	DynamicDataSourceDetectionMapper mapper;
	
	@SwitchDataSource("EggtraceReader")
	public ArrayList<DrugResidueDetection> GetListByTraceID(String traceid){
		return mapper.GetByTraceID(traceid);
	}
	
	@SwitchDataSource("EggtraceWriter")
	public int Insert(DrugResidueDetection model) {
		return mapper.Insert(model);
	}
	
}
