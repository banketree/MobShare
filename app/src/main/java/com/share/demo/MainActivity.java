package com.share.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.sharesdk.data.ShareData;
import cn.sharesdk.demo.R;
import cn.sharesdk.util.ShareUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.Button_share).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ShareData data = new ShareData();
        data.setComment("test");
        data.setContent("test");
        data.setImageUrl("http://imgnews.gmw.cn/attachement/jpg/site2/20160728/eca86ba050091903a4b202.jpg");
        data.setTitile("test");
        data.setTitileUrl("http://www.baidu.com");
        ShareUtils.showShare(getApplicationContext(), false, null, null, data);
    }
}
