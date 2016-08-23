package cn.sharesdk.data;

import cn.sharesdk.framework.Platform;

public class ShareData {
	public static final String Field_Title = "title";
	public static final String Field_TitleUrl = "titleurl";
	public static final String Field_Content = "content";

	protected String mTitile = ""; // 主题
	protected String mTitileUrl = ""; // 链接
	protected String mContent = ""; // 内容
	protected String mImagePath = ""; // 本地图片地址
	protected String mImageUrl = ""; // 网络图片地址
	protected String mUrl = ""; // 连接地址
	protected String mFilePath = ""; // 本地文件
	protected String mComment = ""; // 评论
	protected String mSite = ""; // 主题
	protected String mSiteUrl = ""; // 地址
	protected String mVenueName = ""; // 地点
	protected String mVenueDescription = ""; // 地点描述
	protected float mLat = 0f;
	protected float mLon = 0f;
	protected int mShareType = Platform.SHARE_WEBPAGE;

	public String getTitile() {
		return mTitile;
	}

	public void setTitile(String mTitile) {
		this.mTitile = mTitile;
	}

	public String getTitileUrl() {
		return mTitileUrl;
	}

	public void setTitileUrl(String titileUrl) {
		this.mTitileUrl = titileUrl;
	}

	public String getContent() {
		return mContent;
	}

	public void setContent(String content) {
		this.mContent = content;
	}

	public String getImagePath() {
		return mImagePath;
	}

	public void setImagePath(String imagePath) {
		this.mImagePath = imagePath;
	}

	public String getImageUrl() {
		return mImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.mImageUrl = imageUrl;
	}

	public String getUrl() {
		return mUrl;
	}

	public void setUrl(String url) {
		this.mUrl = url;
	}

	public String getFilePath() {
		return mFilePath;
	}

	public void setFilePath(String filePath) {
		this.mFilePath = filePath;
	}

	public String getComment() {
		return mComment;
	}

	public void setComment(String comment) {
		this.mComment = comment;
	}

	public String getSite() {
		return mSite;
	}

	public void setSite(String site) {
		this.mSite = site;
	}

	public String getSiteUrl() {
		return mSiteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.mSiteUrl = siteUrl;
	}

	public String getVenueName() {
		return mVenueName;
	}

	public void setVenueName(String venueName) {
		this.mVenueName = venueName;
	}

	public String getVenueDescription() {
		return mVenueDescription;
	}

	public void setVenueDescription(String venueDescription) {
		this.mVenueDescription = venueDescription;
	}

	public float getLat() {
		return mLat;
	}

	public void setLat(float lat) {
		this.mLat = lat;
	}

	public float getLon() {
		return mLon;
	}

	public void setLon(float lon) {
		this.mLon = lon;
	}

}
