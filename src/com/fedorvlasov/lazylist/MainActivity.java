package com.fedorvlasov.lazylist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends Activity {
    
    ListView list;
    LazyAdapter adapter;
      
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      //Initialize ImageLoader with configuration.  
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this)); 
        list=(ListView)findViewById(R.id.list);
        adapter=new LazyAdapter(this, mStrings);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//ImageShowActivity.startImageShowActivity(MainActivity.this,mStrings[position]);
				/*Intent intent = new Intent(MainActivity.this, ImageShowActivity.class);
				intent.putExtra("url", mStrings[position]);
				startActivity(intent);*/
				
			}
        	
        });
        Button b=(Button)findViewById(R.id.button1);
        b.setOnClickListener(listener);
    }
    
    @Override
    public void onDestroy()
    {
        list.setAdapter(null);
        super.onDestroy();
    }
    
    public OnClickListener listener=new OnClickListener(){
        @Override
        public void onClick(View arg0) {
        	
            adapter.imageLoader.clearMemoryCache();
            adapter.imageLoader.clearDiscCache();
            adapter.notifyDataSetChanged();
        }
    };
    
    private String[] mStrings={
    		 "http://img.my.csdns.net/uploads/201309/01/1378037235_3453.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037235_9280.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037234_3539.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037234_6318.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037194_2965.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037193_1687.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037193_1286.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037192_8379.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037178_9374.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037177_1254.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037177_6203.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037152_6352.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037151_9565.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037151_7904.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037148_7104.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037129_8825.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037128_5291.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037128_3531.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037127_1085.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037095_7515.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037094_8001.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037093_7168.jpg",  
             "http://img.my.csdn.net/uploads/201309/01/1378037091_4950.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949643_6410.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949642_6939.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949630_4505.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949630_4593.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949629_7309.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949629_8247.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949615_1986.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949614_8482.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949614_3743.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949614_4199.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949599_3416.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949599_5269.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949598_7858.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949598_9982.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949578_2770.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949578_8744.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949577_5210.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949577_1998.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949482_8813.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949481_6577.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949480_4490.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949455_6792.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949455_6345.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949442_4553.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949441_8987.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949441_5454.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949454_6367.jpg",  
             "http://img.my.csdn.net/uploads/201308/31/1377949442_4562.jpg"
    };
}