package laus.mybatis.eggtrace.writer.mapper;

import org.apache.ibatis.annotations.Insert;

import laus.mybatis.eggtrace.model.DrugResidueDetection;

public interface DrugResidueDetectionWriterMapper {
	
	@Insert("insert into `drugresiduedetection` (DrugResDeteID, TraceID, DetectionTypeID, DetectionTypeName, DetectionPic, DetectionID, DetectionResult) values (#{DrugResDeteID}, #{TraceID}, #{DetectionTypeID}, #{DetectionTypeName}, #{DetectionPic}, #{DetectionID}, #{DetectionResult})")
	public int InsertNewRecord(DrugResidueDetection model);
	
}
