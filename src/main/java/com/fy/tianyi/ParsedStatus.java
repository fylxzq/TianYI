package com.fy.tianyi;


public class ParsedStatus {
	
	private String value;
	private String timestamp;
	private String datasetId;
	
	public ParsedStatus() {}
	public ParsedStatus(String value, String timestamp, String datasetId) {
		this.value = value;
		this.timestamp = timestamp;
		this.datasetId = datasetId;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getDatasetId() {
		return datasetId;
	}
	
	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}
	
	@Override
	public String toString() {
		return "ParsedStatus\n"
				+ "[value=" + value + ",\n"
					+ "timestamp=" + timestamp +",\n"
					+ "datasetId=" + datasetId + "]";
	}
}
