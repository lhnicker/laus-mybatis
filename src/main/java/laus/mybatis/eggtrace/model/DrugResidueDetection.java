package laus.mybatis.eggtrace.model;

import java.sql.Timestamp;

public class DrugResidueDetection {
	private String DrugResDeteID;
	private String TraceID;
	private short DetectionTypeID;
	private String DetectionTypeName;
	private String DetectionPic;
	private short DetectionID;
	private String DetectionResult;
	private short IsValid;
	private Timestamp CreateTime;
	
	public String getDrugResDeteID() {
		return DrugResDeteID;
	}
	public void setDrugResDeteID(String drugResDeteID) {
		DrugResDeteID = drugResDeteID;
	}
	public String getTraceID() {
		return TraceID;
	}
	public void setTraceID(String traceID) {
		TraceID = traceID;
	}
	public short getDetectionTypeID() {
		return DetectionTypeID;
	}
	public void setDetectionTypeID(short detectionTypeID) {
		DetectionTypeID = detectionTypeID;
	}
	public String getDetectionTypeName() {
		return DetectionTypeName;
	}
	public void setDetectionTypeName(String detectionTypeName) {
		DetectionTypeName = detectionTypeName;
	}
	public String getDetectionPic() {
		return DetectionPic;
	}
	public void setDetectionPic(String detectionPic) {
		DetectionPic = detectionPic;
	}
	public short getDetectionID() {
		return DetectionID;
	}
	public void setDetectionID(short detectionID) {
		DetectionID = detectionID;
	}
	public String getDetectionResult() {
		return DetectionResult;
	}
	public void setDetectionResult(String detectionResult) {
		DetectionResult = detectionResult;
	}
	public short getIsValid() {
		return IsValid;
	}
	public void setIsValid(short isValid) {
		IsValid = isValid;
	}
	public Timestamp getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Timestamp createTime) {
		CreateTime = createTime;
	}
}
