package laus.mybatis.eggtrace.reader.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.*;

import laus.mybatis.eggtrace.model.DrugResidueDetection;

public interface DrugResidueDetectionReaderMapper {
	
	@Select("SELECT * FROM `drugresiduedetection` WHERE TraceID=#{TraceID} AND IsValid IN (1)")
	@Results({
		@Result(column="DrugResDeteID", property="DrugResDeteID"),
		@Result(column="TraceID", property="TraceID")
	})
	public ArrayList<DrugResidueDetection> GetByTraceID(@Param("TraceID")String traceID);
	
}
