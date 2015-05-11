package com.fedorvlasov.lazylist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.wyj.gestureimageview.GestureImageView;

public class ImageShowActivity extends Activity {

	private String url;// 图片的链接
	private GestureImageView gestureImageView;
	private Bitmap bp;
	private ImageLoader imageLoader = ImageLoader.getInstance();

	public static void startImageShowActivity(Context context, String imageLink) {
		Intent intent = new Intent(context, ImageShowActivity.class);
		intent.putExtra("url", imageLink);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image_show_activity);
		initView();
		initData();
	}

	private void initData() {
		url = getIntent().getExtras().getString("url");// 图片的链接
		/*ds=(DataofSeri)getIntent().getSerializableExtra("data");
		//ds=getIntent().getBundleExtra("data").getSerializable("");
		if(ds!=null){
		gestureImageView.setImageBitmap(ds.getBp());
		Log.v("lazy","da not empty!");
		}*/
	    /*ds=(DataofSeri)getIntent().getSerializableExtra("data");
	    if(ds!=null) Log.v("lazy","da not empty!");*/
			imageLoader.displayImage(url, gestureImageView, ImageLoaderControl.options);
			//Log.v("lazy","da is empty!");
		
	}

	private void initView() {
		gestureImageView = (GestureImageView) findViewById(R.id.gestureImageView);
		findViewById(R.id.back).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
