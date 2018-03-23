package com.security.bean;

public class NetFlowDO {
    private Integer id;

    private String date;

    private String protocolType;

    private String duration;

    private String sourceIp;

    private String sourcePort;

    private String destIp;

    private String destPort;

    private String sourceSendByte;

    private String destSendByte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(String protocolType) {
        this.protocolType = protocolType == null ? null : protocolType.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp == null ? null : sourceIp.trim();
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort == null ? null : sourcePort.trim();
    }

    public String getDestIp() {
        return destIp;
    }

    public void setDestIp(String destIp) {
        this.destIp = destIp == null ? null : destIp.trim();
    }

    public String getDestPort() {
        return destPort;
    }

    public void setDestPort(String destPort) {
        this.destPort = destPort == null ? null : destPort.trim();
    }

    public String getSourceSendByte() {
        return sourceSendByte;
    }

    public void setSourceSendByte(String sourceSendByte) {
        this.sourceSendByte = sourceSendByte == null ? null : sourceSendByte.trim();
    }

    public String getDestSendByte() {
        return destSendByte;
    }

    public void setDestSendByte(String destSendByte) {
        this.destSendByte = destSendByte == null ? null : destSendByte.trim();
    }
}