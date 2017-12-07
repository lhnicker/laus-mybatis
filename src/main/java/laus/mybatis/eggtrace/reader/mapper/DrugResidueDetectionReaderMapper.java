package laus.mybatis.eggtrace.reader.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import laus.mybatis.eggtrace.model.DrugResidueDetection;

public interface DrugResidueDetectionReaderMapper {
	
	@Select("select * from `drugresiduedetection` where TraceID=#{TraceID} and IsValid in (1)")
	public ArrayList<DrugResidueDetection> GetByTraceID(@Param("TraceID")String traceID);
	
}
