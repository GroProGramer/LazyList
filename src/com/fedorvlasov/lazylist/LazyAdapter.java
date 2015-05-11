package com.fedorvlasov.lazylist;

import java.math.BigInteger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

public class LazyAdapter extends BaseAdapter {
    
    private Activity activity;
    private String[] data;
    private static LayoutInflater inflater=null;
   // public ImageLoader imageLoader; 
   ImageLoader imageLoader = ImageLoader.getInstance();
    
    public LazyAdapter(Activity a, String[] d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //imageLoader=new ImageLoader(activity.getApplicationContext());
        
    }

    public int getCount() {
        return data.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.item, null);

        TextView text=(TextView)vi.findViewById(R.id.text);
        final ImageView image=(ImageView)vi.findViewById(R.id.image);
        image.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(activity, ImageShowActivity.class);
				intent.putExtra("url", data[position]);
				activity.startActivity(intent);
			
				//image.getDrawingCache();
			}
        	
        });
        final ProgressBar pb=(ProgressBar)vi.findViewById(R.id.progressBar);
        final ImageView tv=(ImageView)vi.findViewById(R.id.reget);
        final ProgressBar dataprobar=(ProgressBar)vi.findViewById(R.id.dataprobar);
        
        
        text.setText("item "+position);
        //imageLoader.DisplayImage(data[position], image,pb);
        tv.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imageLoader.displayImage(data[position], image, ImageLoaderControl.options,new ImageLoadingListener(){

					@Override
					public void onLoadingStarted(String imageUri, View view) {
						// TODO Auto-generated method stub
						pb.setVisibility(View.VISIBLE);
						tv.setVisibility(View.INVISIBLE);
						dataprobar.setVisibility(View.VISIBLE);
					}

					@Override
					public void onLoadingFailed(String imageUri, View view,
							FailReason failReason) {
						// TODO Auto-generated method stub
						pb.setVisibility(View.INVISIBLE);
						tv.setVisibility(View.VISIBLE);
						dataprobar.setVisibility(View.INVISIBLE);
					}

					@Override
					public void onLoadingComplete(String imageUri, View view,
							Bitmap loadedImage) {
						// TODO Auto-generated method stub
						pb.setVisibility(View.INVISIBLE);
						tv.setVisibility(View.INVISIBLE);
						dataprobar.setVisibility(View.INVISIBLE);
					}

					@Override
					public void onLoadingCancelled(String imageUri, View view) {
						// TODO Auto-generated method stub
						
					}
		        	
		        },new ImageLoadingProgressListener(){

					@Override
					public void onProgressUpdate(String imageUri, View view,
							int current, int total) {
						// TODO Auto-generated method stub
						dataprobar.setProgress(current*100/total);
						//dataprobar.setProgress(Integer.parseInt(BigInteger.valueOf(current).divide(BigInteger.valueOf(total)).toString())*100);
						//Log.v("LazyAdapter","第"+position+"个：current="+current+",total="+total);
						//Log.v("LazyAdapter","进度为"+Integer.parseInt(BigInteger.valueOf(current).divide(BigInteger.valueOf(total)).toString())*100);
					}
		        	
		        });
			}
        	
        });
        imageLoader.displayImage(data[position], image, ImageLoaderControl.options,new ImageLoadingListener(){

			@Override
			public void onLoadingStarted(String imageUri, View view) {
				// TODO Auto-generated method stub
				pb.setVisibility(View.VISIBLE);
				tv.setVisibility(View.INVISIBLE);
				dataprobar.setVisibility(View.VISIBLE);
			}

			@Override
			public void onLoadingFailed(String imageUri, View view,
					FailReason failReason) {
				// TODO Auto-generated method stub
				pb.setVisibility(View.INVISIBLE);
				tv.setVisibility(View.VISIBLE);
				dataprobar.setVisibility(View.INVISIBLE);
			}

			@Override
			public void onLoadingComplete(String imageUri, View view,
					Bitmap loadedImage) {
				// TODO Auto-generated method stub
				pb.setVisibility(View.INVISIBLE);
				tv.setVisibility(View.INVISIBLE);
				dataprobar.setVisibility(View.INVISIBLE);
			}

			@Override
			public void onLoadingCancelled(String imageUri, View view) {
				// TODO Auto-generated method stub
				
			}
        	
        },new ImageLoadingProgressListener(){

			@Override
			public void onProgressUpdate(String imageUri, View view,
					int current, int total) {
				// TODO Auto-generated method stub
				dataprobar.setProgress(current*100/total);
				//Log.v("LazyAdapter","第"+position+"个：current="+current+",total="+total);
				//Log.v("LazyAdapter","进度为"+Integer.parseInt(BigInteger.valueOf(current).divide(BigInteger.valueOf(total)).toString())*100);
			}
        	
        });
        
        return vi;
    }
    
  
    
}