package com.example.elasticsearch.config;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * 
 * @author liumeng
 *
 * create at 2018年7月28日, assembly-common
 */

public class DpiDataRecord  {

	private long timestamp;

	public long getTimestamp() {
		return timestamp;
	}

	public DpiDataRecord(String deptId, String deptName, String srcIp, Integer srcPort, String destIp, Integer destPort, String protocol, String highLayerProtocol, Long packetVolume, Long byteVolume, Long transferTime, String outerSrcIp, String outerDestIp, String domainName, Integer internet, Integer tunnel, String destLocation, String hostname, String workgroup, String realMac, String os, String browser, String terminal, String ua, String deviceType, String dnsDomain, String httpDomain, String httpsDomain, String qqNum, String wechatNum, String mailFrom, String mailTo, String mailAttachment, String mailHeader, String applicationProtocol, String applicationPort, String applicationService, String applicationVersion, String serviceProtocol, String servicePort, String serviceName, String serviceVersion, String printerTaskName, String printerUserName, String sql) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.srcIp = srcIp;
		this.srcPort = srcPort;
		this.destIp = destIp;
		this.destPort = destPort;
		this.protocol = protocol;
		this.highLayerProtocol = highLayerProtocol;
		this.packetVolume = packetVolume;
		this.byteVolume = byteVolume;
		this.transferTime = transferTime;
		this.outerSrcIp = outerSrcIp;
		this.outerDestIp = outerDestIp;
		this.domainName = domainName;
		this.internet = internet;
		this.tunnel = tunnel;
		this.destLocation = destLocation;
		this.hostname = hostname;
		this.workgroup = workgroup;
		this.realMac = realMac;
		this.os = os;
		this.browser = browser;
		this.terminal = terminal;
		this.ua = ua;
		this.deviceType = deviceType;
		this.dnsDomain = dnsDomain;
		this.httpDomain = httpDomain;
		this.httpsDomain = httpsDomain;
		this.qqNum = qqNum;
		this.wechatNum = wechatNum;
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
		this.mailAttachment = mailAttachment;
		this.mailHeader = mailHeader;
		this.applicationProtocol = applicationProtocol;
		this.applicationPort = applicationPort;
		this.applicationService = applicationService;
		this.applicationVersion = applicationVersion;
		this.serviceProtocol = serviceProtocol;
		this.servicePort = servicePort;
		this.serviceName = serviceName;
		this.serviceVersion = serviceVersion;
		this.printerTaskName = printerTaskName;
		this.printerUserName = printerUserName;
		this.sql = sql;
	}

	public DpiDataRecord() {
	}

	@Override
	public String toString() {
		return "DpiDataRecord{" +
				"deptId='" + deptId + '\'' +
				", deptName='" + deptName + '\'' +
				", srcIp='" + srcIp + '\'' +
				", srcPort=" + srcPort +
				", destIp='" + destIp + '\'' +
				", destPort=" + destPort +
				", protocol='" + protocol + '\'' +
				", highLayerProtocol='" + highLayerProtocol + '\'' +
				", packetVolume=" + packetVolume +
				", byteVolume=" + byteVolume +
				", transferTime=" + transferTime +
				", outerSrcIp='" + outerSrcIp + '\'' +
				", outerDestIp='" + outerDestIp + '\'' +
				", domainName='" + domainName + '\'' +
				", internet=" + internet +
				", tunnel=" + tunnel +
				", destLocation='" + destLocation + '\'' +
				", hostname='" + hostname + '\'' +
				", workgroup='" + workgroup + '\'' +
				", realMac='" + realMac + '\'' +
				", os='" + os + '\'' +
				", browser='" + browser + '\'' +
				", terminal='" + terminal + '\'' +
				", ua='" + ua + '\'' +
				", deviceType='" + deviceType + '\'' +
				", dnsDomain='" + dnsDomain + '\'' +
				", httpDomain='" + httpDomain + '\'' +
				", httpsDomain='" + httpsDomain + '\'' +
				", qqNum='" + qqNum + '\'' +
				", wechatNum='" + wechatNum + '\'' +
				", mailFrom='" + mailFrom + '\'' +
				", mailTo='" + mailTo + '\'' +
				", mailAttachment='" + mailAttachment + '\'' +
				", mailHeader='" + mailHeader + '\'' +
				", applicationProtocol='" + applicationProtocol + '\'' +
				", applicationPort='" + applicationPort + '\'' +
				", applicationService='" + applicationService + '\'' +
				", applicationVersion='" + applicationVersion + '\'' +
				", serviceProtocol='" + serviceProtocol + '\'' +
				", servicePort='" + servicePort + '\'' +
				", serviceName='" + serviceName + '\'' +
				", serviceVersion='" + serviceVersion + '\'' +
				", printerTaskName='" + printerTaskName + '\'' +
				", printerUserName='" + printerUserName + '\'' +
				", sql='" + sql + '\'' +
				'}';
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSrcIp() {
		return srcIp;
	}

	public void setSrcIp(String srcIp) {
		this.srcIp = srcIp;
	}

	public Integer getSrcPort() {
		return srcPort;
	}

	public void setSrcPort(Integer srcPort) {
		this.srcPort = srcPort;
	}

	public String getDestIp() {
		return destIp;
	}

	public void setDestIp(String destIp) {
		this.destIp = destIp;
	}

	public Integer getDestPort() {
		return destPort;
	}

	public void setDestPort(Integer destPort) {
		this.destPort = destPort;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHighLayerProtocol() {
		return highLayerProtocol;
	}

	public void setHighLayerProtocol(String highLayerProtocol) {
		this.highLayerProtocol = highLayerProtocol;
	}

	public Long getPacketVolume() {
		return packetVolume;
	}

	public void setPacketVolume(Long packetVolume) {
		this.packetVolume = packetVolume;
	}

	public Long getByteVolume() {
		return byteVolume;
	}

	public void setByteVolume(Long byteVolume) {
		this.byteVolume = byteVolume;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(Long transferTime) {
		this.transferTime = transferTime;
	}

	public String getOuterSrcIp() {
		return outerSrcIp;
	}

	public void setOuterSrcIp(String outerSrcIp) {
		this.outerSrcIp = outerSrcIp;
	}

	public String getOuterDestIp() {
		return outerDestIp;
	}

	public void setOuterDestIp(String outerDestIp) {
		this.outerDestIp = outerDestIp;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public Integer getInternet() {
		return internet;
	}

	public void setInternet(Integer internet) {
		this.internet = internet;
	}

	public Integer getTunnel() {
		return tunnel;
	}

	public void setTunnel(Integer tunnel) {
		this.tunnel = tunnel;
	}

	public String getDestLocation() {
		return destLocation;
	}

	public void setDestLocation(String destLocation) {
		this.destLocation = destLocation;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getWorkgroup() {
		return workgroup;
	}

	public void setWorkgroup(String workgroup) {
		this.workgroup = workgroup;
	}

	public String getRealMac() {
		return realMac;
	}

	public void setRealMac(String realMac) {
		this.realMac = realMac;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getUa() {
		return ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDnsDomain() {
		return dnsDomain;
	}

	public void setDnsDomain(String dnsDomain) {
		this.dnsDomain = dnsDomain;
	}

	public String getHttpDomain() {
		return httpDomain;
	}

	public void setHttpDomain(String httpDomain) {
		this.httpDomain = httpDomain;
	}

	public String getHttpsDomain() {
		return httpsDomain;
	}

	public void setHttpsDomain(String httpsDomain) {
		this.httpsDomain = httpsDomain;
	}

	public String getQqNum() {
		return qqNum;
	}

	public void setQqNum(String qqNum) {
		this.qqNum = qqNum;
	}

	public String getWechatNum() {
		return wechatNum;
	}

	public void setWechatNum(String wechatNum) {
		this.wechatNum = wechatNum;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getMailAttachment() {
		return mailAttachment;
	}

	public void setMailAttachment(String mailAttachment) {
		this.mailAttachment = mailAttachment;
	}

	public String getMailHeader() {
		return mailHeader;
	}

	public void setMailHeader(String mailHeader) {
		this.mailHeader = mailHeader;
	}

	public String getApplicationProtocol() {
		return applicationProtocol;
	}

	public void setApplicationProtocol(String applicationProtocol) {
		this.applicationProtocol = applicationProtocol;
	}

	public String getApplicationPort() {
		return applicationPort;
	}

	public void setApplicationPort(String applicationPort) {
		this.applicationPort = applicationPort;
	}

	public String getApplicationService() {
		return applicationService;
	}

	public void setApplicationService(String applicationService) {
		this.applicationService = applicationService;
	}

	public String getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(String applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

	public String getServiceProtocol() {
		return serviceProtocol;
	}

	public void setServiceProtocol(String serviceProtocol) {
		this.serviceProtocol = serviceProtocol;
	}

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getPrinterTaskName() {
		return printerTaskName;
	}

	public void setPrinterTaskName(String printerTaskName) {
		this.printerTaskName = printerTaskName;
	}

	public String getPrinterUserName() {
		return printerUserName;
	}

	public void setPrinterUserName(String printerUserName) {
		this.printerUserName = printerUserName;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	/**
	 * 部门ID
	 */
	@JsonProperty("dept_id")
	private String deptId;

	private String deptName;

	/**
	 * 源IP
	 */
	@JsonProperty("src_ip")
	private String srcIp;

	/**
	 * 源端口
	 */
	@JsonProperty("src_port")
	private Integer srcPort;

	/**
	 * 目的IP
	 */
	@JsonProperty("dest_ip")
	private String destIp;

	/**
	 * 目的端口
	 */
	@JsonProperty("dest_port")
	private Integer destPort;

	/**
	 * 协议
	 */
	private String protocol;

	/**
	 * 高层协议
	 */
	@JsonProperty("high_layer_protocol")
	private String highLayerProtocol;

	/**
	 * 包数量
	 */
	@JsonProperty("packet_volume")
	private Long packetVolume;

	/**
	 * 字节数量
	 */
	@JsonProperty("byte_volume")
	private Long byteVolume;

	/**
	 * 传输时长
	 */
	@JsonProperty("transfer_time")
	private Long transferTime;

	/**
	 * VPN外层源IP
	 */
	@JsonProperty("outer_src_ip")
	private String outerSrcIp;

	/**
	 * VPN外层目的IP
	 */
	@JsonProperty("outer_dest_ip")
	private String outerDestIp;

	/**
	 * 域名(dns/http/https都会填到这个字段上)
	 */
	@JsonProperty("domain_name")
	private String domainName;

	/**
	 * 目的IP是否是外网(0/1)
	 */
	private Integer internet;

	/**
	 * 是否是隧道协议
	 */
	private Integer tunnel;

	/**
	 * 目的IP归属地
	 */
	@JsonProperty("dest_location")
	private String destLocation;

	/**
	 * 主机名
	 */
	private String hostname;

	/**
	 * 工作组
	 */
	private String workgroup;

	/**
	 * 真实mac
	 */
    @JsonProperty("real_mac")
	private String realMac;

	/**
	 * 操作系统
	 */
	private String os;

	/**
	 * 浏览器
	 */
	private String browser;

	/**
	 * 终端信息
	 */
	private String terminal;

	/**
	 * user-agent (传输过程中使用，不入库)
	 */
	private String ua;

	/**
	 * 设备类型
	 */
	@JsonProperty("device_type")
	private String deviceType;

	/**
	 * DNS域名
	 */
	@JsonProperty("dns_domain")
	private String dnsDomain;

	/**
	 * HTTP域名
	 */
	@JsonProperty("http_domain")
	private String httpDomain;

	/**
	 * HTTPS域名
	 */
	@JsonProperty("https_domain")
	private String httpsDomain;

	/**
	 * QQ号
	 */
	@JsonProperty("qq_num")
	private String qqNum;

	/**
	 * 微信号
	 */
	@JsonProperty("wechat_num")
	private String wechatNum;

	/**
	 * 发件人
	 */
	@JsonProperty("mail_from")
	private String mailFrom;

	/**
	 * 收件人
	 */
	@JsonProperty("mail_to")
	private String mailTo;

	/**
	 * 附件名称
	 */
	@JsonProperty("mail_attachment")
	private String mailAttachment;

	/**
	 * 邮件头部
	 */
	@JsonProperty("mail_header")
	private String mailHeader;

	/**
	 * 应用协议
	 */
	@JsonProperty("application_protocol")
	private String applicationProtocol;

	/**
	 * 应用端口
	 */
	@JsonProperty("application_port")
	private String applicationPort;

	/**
	 * 应用服务名称
	 */
	@JsonProperty("application_service")
	private String applicationService;

	/**
	 * 应用版本
	 */
	@JsonProperty("application_version")
	private String applicationVersion;

    /**
     * 服务协议
     */
    @JsonProperty("service_protocol")
    private String serviceProtocol;

    /**
     * 服务端口
     */
    @JsonProperty("service_port")
    private String servicePort;

    /**
     * 服务名称
     */
    @JsonProperty("service_name")
    private String serviceName;

    /**
     * 服务版本
     */
    @JsonProperty("service_version")
    private String serviceVersion;

    /**
     * 打印任务名
     */
    @JsonProperty("printer_task_name")
    private String printerTaskName;

    /**
     * 打印用户名
     */
    @JsonProperty("printer_user_name")
    private String printerUserName;

    /**
     * sql语句
     */
    private String sql;

	public void setTimestamp(long l) {

	}
}
