package com.montefiore.incidents.dto;

/**
 * This Class is mainly to store the Incidents Details
 */
public class Resources {
	private boolean verified;
	private int type;
	private String start;
	private int severity;
	private boolean roadClosed;
	private String lastModified;
	private String lane;
	private String incidentId;
	private String end;
	private String detour;
	private String description;
	private String congestion;
	private String __type;
	private Point point;
	private int source;
	private Point toPoint;
	private int avgMax;
	private int avgMin;

	/**
	 * Default Constructor
	 */
	public Resources() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the avgMax
	 */
	public int getAvgMax() {
		return avgMax;
	}

	/**
	 * @param avgMax
	 *            the avgMax to set
	 */
	public void setAvgMax(int avgMax) {
		this.avgMax = avgMax;
	}

	/**
	 * @return the avgMin
	 */
	public int getAvgMin() {
		return avgMin;
	}

	/**
	 * @param avgMin
	 *            the avgMin to set
	 */
	public void setAvgMin(int avgMin) {
		this.avgMin = avgMin;
	}

	/**
	 * @return the source
	 */
	public int getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(int source) {
		this.source = source;
	}

	/**
	 * @return the toPoint
	 */
	public Point getToPoint() {
		return toPoint;
	}

	/**
	 * @param toPoint
	 *            the toPoint to set
	 */
	public void setToPoint(Point toPoint) {
		this.toPoint = toPoint;
	}

	/**
	 * @return the verified
	 */
	public boolean isVerified() {
		return verified;
	}

	/**
	 * @param verified
	 *            the verified to set
	 */
	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the start
	 */
	public String getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}

	/**
	 * @return the severity
	 */
	public int getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(int severity) {
		this.severity = severity;
	}

	/**
	 * @return the roadClosed
	 */
	public boolean isRoadClosed() {
		return roadClosed;
	}

	/**
	 * @param roadClosed
	 *            the roadClosed to set
	 */
	public void setRoadClosed(boolean roadClosed) {
		this.roadClosed = roadClosed;
	}

	/**
	 * @return the lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the lane
	 */
	public String getLane() {
		return lane;
	}

	/**
	 * @param lane
	 *            the lane to set
	 */
	public void setLane(String lane) {
		this.lane = lane;
	}

	/**
	 * @return the incidentId
	 */
	public String getIncidentId() {
		return incidentId;
	}

	/**
	 * @param incidentId
	 *            the incidentId to set
	 */
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}

	/**
	 * @param end
	 *            the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	/**
	 * @return the detour
	 */
	public String getDetour() {
		return detour;
	}

	/**
	 * @param detour
	 *            the detour to set
	 */
	public void setDetour(String detour) {
		this.detour = detour;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the congestion
	 */
	public String getCongestion() {
		return congestion;
	}

	/**
	 * @param congestion
	 *            the congestion to set
	 */
	public void setCongestion(String congestion) {
		this.congestion = congestion;
	}

	/**
	 * @return the __type
	 */
	public String get__type() {
		return __type;
	}

	/**
	 * @param __type
	 *            the __type to set
	 */
	public void set__type(String __type) {
		this.__type = __type;
	}

	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/*
	 * Resources toString
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resources [verified=" + verified + ", type=" + type + ", start=" + start + ", severity=" + severity
				+ ", roadClosed=" + roadClosed + ", lastModified=" + lastModified + ", lane=" + lane + ", incidentId="
				+ incidentId + ", end=" + end + ", detour=" + detour + ", description=" + description + ", congestion="
				+ congestion + ", __type=" + __type + ", point=" + point + ", source=" + source + ", toPoint=" + toPoint
				+ ", avgMax=" + avgMax + ", avgMin=" + avgMin + "]";
	}


}
