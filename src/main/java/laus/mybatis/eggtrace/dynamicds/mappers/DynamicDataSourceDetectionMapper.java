package laus.mybatis.eggtrace.dynamicds.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.*;

import laus.mybatis.eggtrace.model.DrugResidueDetection;

public interface DynamicDataSourceDetectionMapper {

	@Select("select * from `drugresiduedetection` where TraceID=#{TraceID} and IsValid in (1)")
	public ArrayList<DrugResidueDetection> GetByTraceID(@Param("TraceID")String traceID);
	
	@Insert("call DrupResDetection_Insert(#{DrugResDeteID}, #{TraceID}, #{DetectionTypeID}, #{DetectionTypeName}, #{DetectionPic}, #{DetectionID}, #{DetectionResult}, 10032)")
	public int Insert(DrugResidueDetection model);
	
}
