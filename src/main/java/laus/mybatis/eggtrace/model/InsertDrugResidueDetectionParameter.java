package laus.mybatis.eggtrace.model;

public class InsertDrugResidueDetectionParameter {

	private String TraceID;
	private short DetectionTypeID;
	private String DetectionTypeName;
	private String DetectionPic;
	private short DetectionID;
	private String DetectionResult;
	
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
	
}
