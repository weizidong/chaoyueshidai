package xin.chaoyueshidai.param;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 来自Wechat端的消息(所有字段)
 * 
 * @author WeiZiDong
 *
 */
@SuppressWarnings("serial")
public class WechatMsg implements Serializable {
	private String ToUserName; // 开发者微信号
	private String FromUserName; // 发送方帐号（一个OpenID）
	private Long CreateTime; // 消息创建时间 （整型）
	private String MsgType; // 消息类型
	private Long MsgId; // 消息id，64位整型
	private String MediaId; // 消息媒体id，可以调用多媒体文件下载接口拉取数据。
	/** ==========text **/
	private String Content; // 文本消息内容
	/** ==========image **/
	private String PicUrl; // 图片链接（由系统生成）
	/** ==========voice **/
	private String Format; // 语音格式，如amr，speex等
	private String Recognition; // 语音识别结果，UTF8编码
	/** ==========video/shortvideo **/
	private String ThumbMediaId; // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	/** ==========location **/
	private Double Location_X; // 地理位置维度
	private Double Location_Y; // 地理位置经度
	private Integer Scale; // 地图缩放大小
	private String Label; // 地理位置信息
	/** ==========link **/
	private String Title; // 消息标题
	private String Description; // 消息描述
	private String Url; // 消息链接
	/** ==========事件类型 **/
	private String Event; // 事件类型
	private String EventKey; // 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	/** ==========SCAN/subscribe **/
	private String Ticket; // 二维码的ticket，可用来换取二维码图片
	/** ==========LOCATION **/
	private Double Latitude; // 地理位置纬度
	private Double Longitude; // 地理位置经度
	private Double Precision; // 地理位置精度

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public Double getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(Double location_X) {
		Location_X = location_X;
	}

	public Double getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(Double location_Y) {
		Location_Y = location_Y;
	}

	public Integer getScale() {
		return Scale;
	}

	public void setScale(Integer scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

	public Double getLatitude() {
		return Latitude;
	}

	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}

	public Double getLongitude() {
		return Longitude;
	}

	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}

	public Double getPrecision() {
		return Precision;
	}

	public void setPrecision(Double precision) {
		Precision = precision;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
