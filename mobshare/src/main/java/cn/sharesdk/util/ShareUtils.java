package cn.sharesdk.util;

import cn.sharesdk.R;
import cn.sharesdk.data.ShareData;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.OnekeyShareTheme;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ShareUtils {

	// 使用快捷分享完成分享（请务必仔细阅读位于SDK解压目录下Docs文件夹中OnekeyShare类的JavaDoc）
	/**
	 * ShareSDK集成方法有两种</br>
	 * 1、第一种是引用方式，例如引用onekeyshare项目，onekeyshare项目再引用mainlibs库</br>
	 * 2、第二种是把onekeyshare和mainlibs集成到项目中，本例子就是用第二种方式</br> 请看“ShareSDK
	 * 使用说明文档”，SDK下载目录中 </br> 或者看网络集成文档
	 * http://wiki.mob.com/Android_%E5%BF%AB%E9%
	 * 80%9F%E9%9B%86%E6%88%90%E6%8C%87%E5%8D%97
	 * 3、混淆时，把sample或者本例子的混淆代码copy过去，在proguard-project.txt文件中
	 * 
	 * 
	 * 平台配置信息有三种方式： 1、在我们后台配置各个微博平台的key
	 * 2、在代码中配置各个微博平台的key，http://mob.com/androidDoc
	 * /cn/sharesdk/framework/ShareSDK.html
	 * 3、在配置文件中配置，本例子里面的assets/ShareSDK.conf,
	 */
	public static void showShare(final Context context, boolean silent,
			String platform, View captureView, final ShareData data) {
		ShareSDK.initSDK(context);
		// ShareSDK.registerPlatform(LaiwangCustomize.class);
		ShareSDK.setConnTimeout(20000);
		ShareSDK.setReadTimeout(20000);

		final OnekeyShare oks = new OnekeyShare();
		hidePlam(oks);

		oks.setTitle(data.getTitile());
		oks.setTitleUrl(data.getTitileUrl());

		oks.setText(data.getContent());

		if (captureView != null) {
			oks.setViewToShare(captureView);
		} else {
			oks.setImagePath(data.getImagePath());
			oks.setImageUrl(data.getImageUrl());
			// oks.setImageArray(new String[]{MainActivity.TEST_IMAGE,
			// MainActivity.TEST_IMAGE_URL});
		}

		oks.setUrl(data.getUrl());
		oks.setFilePath(data.getFilePath());
		oks.setComment(data.getComment());
		oks.setSite(data.getSite());
		oks.setSiteUrl(data.getSiteUrl());
		oks.setVenueName(data.getVenueName());// 地点名称
		oks.setVenueDescription(data.getVenueDescription());// 地点描述

		oks.setAddress(data.getVenueDescription());
		oks.setLatitude(data.getLat());
		oks.setLongitude(data.getLon());
		oks.setSilent(silent);
		oks.setShareFromQQAuthSupport(false);
		// oks.setShareType(Platform.SHARE_WEBPAGE);
		String theme = "classic";
		if (OnekeyShareTheme.SKYBLUE.toString().toLowerCase().equals(theme)) {
			oks.setTheme(OnekeyShareTheme.SKYBLUE);
		} else {
			oks.setTheme(OnekeyShareTheme.CLASSIC);
		}

		if (platform != null) {
			oks.setPlatform(platform);
		}

		// 令编辑页面显示为Dialog模式
		oks.setDialogMode();

		// 在自动授权时可以禁用SSO方式
		// if(!CustomShareFieldsPage.getBoolean("enableSSO", true))
		oks.disableSSOWhenAuthorize();

		// 去除注释，则快捷分享的操作结果将通过OneKeyShareCallback回调
		// oks.setCallback(new OneKeyShareCallback());

		// 去自定义不同平台的字段内容
		// oks.setShareContentCustomizeCallback(new
		// ShareContentCustomizeDemo());

		// 去除注释，演示在九宫格设置自定义的图标
		Bitmap enableLogo = BitmapFactory.decodeResource(
				context.getResources(), R.drawable.icon_more);
		// Bitmap disableLogo = BitmapFactory.decodeResource(
		// context.getResources(), R.drawable.sharesdk_unchecked);
		// String label =
		// context.getResources().getString(R.string.app_name);
		// OnClickListener listener = new OnClickListener() {
		// public void onClick(View v) {
		// String text = "Customer Logo -- ShareSDK "
		// + ShareSDK.getSDKVersionName();
		// Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
		// }
		// };
		oks.setCustomerLogo(enableLogo, enableLogo, "更多",
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						Intent sendIntent = new Intent();
						sendIntent.setAction(Intent.ACTION_SEND);
						sendIntent.putExtra(Intent.EXTRA_TEXT,
								data.getTitile() + " \n " + data.getContent()
										+ " \n " + data.getUrl());
						sendIntent.setType("text/plain");
						context.startActivity(Intent.createChooser(sendIntent,
								"分享选择"));
					}
				});

		// 去除注释，则快捷分享九宫格中将隐藏新浪微博和腾讯微博
		// oks.addHiddenPlatform(SinaWeibo.NAME);
		// oks.addHiddenPlatform(TencentWeibo.NAME);

		// 为EditPage设置一个背景的View
		oks.setEditPageBackground(new View(context));
		oks.show(context);
	}

	private static void hidePlam(OnekeyShare oks) {
		// oks.addHiddenPlatform("SinaWeibo");
		oks.addHiddenPlatform("WechatFavorite");
		oks.addHiddenPlatform("TencentWeibo");
		// oks.addHiddenPlatform("Twitter");
		// oks.addHiddenPlatform("Renren");
		// oks.addHiddenPlatform("KaiXin");
		// oks.addHiddenPlatform("Douban");
		// oks.addHiddenPlatform("YouDao");
		// oks.addHiddenPlatform("SohuSuishenkan");
		// oks.addHiddenPlatform("Evernote");
		// oks.addHiddenPlatform("LinkedIn");
		// oks.addHiddenPlatform("GooglePlus");
		// oks.addHiddenPlatform("FourSquare");
		// oks.addHiddenPlatform("Pinterest");
		// oks.addHiddenPlatform("Flickr");
		// oks.addHiddenPlatform("Tumblr");
		// oks.addHiddenPlatform("Dropbox");
		// oks.addHiddenPlatform("VKontakte");
		// oks.addHiddenPlatform("Instagram");
		// oks.addHiddenPlatform("Yixin");
		// oks.addHiddenPlatform("YixinMoments");
		// oks.addHiddenPlatform("Mingdao");
		// oks.addHiddenPlatform("Line");
		// oks.addHiddenPlatform("KakaoTalk");
		// oks.addHiddenPlatform("KakaoStory");
		// oks.addHiddenPlatform("WhatsApp");
		// oks.addHiddenPlatform("Pocket");
		// oks.addHiddenPlatform("FacebookMessenger");
		// oks.addHiddenPlatform("BaiduTieba");
		// oks.addHiddenPlatform("Laiwang");
		// oks.addHiddenPlatform("LaiwangMoments");
		oks.addHiddenPlatform("LaiwangCustomize");
		// oks.addHiddenPlatform("Instapaper");
		oks.addHiddenPlatform("Bluetooth");
	}
}
