package com.example.animation_test;

import java.util.List;

import com.example.animation_test.http.HttpUtils;
import com.example.animation_test.json.JsonTools;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.os.Build;

public class MainActivity extends Activity {
	private Button btn;
	private VideoView video;
	private TextView text;
	private MyHandler handler;
	private List<String> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnOnclick();
      
       
        new Thread(new MyThread()).start();

       
    }
    private void initView(){
    	 video = (VideoView)this.findViewById(R.id.video);
         btn = (Button)this.findViewById(R.id.btn);
         text = (TextView)this.findViewById(R.id.text);
         handler = new MyHandler();
         String path = "android.resource://"+getPackageName()+"/"+R.raw.two;
         MediaController controller = new MediaController(this);
         video.setVideoPath(path);
         video.setMediaController(controller);
    }
    private void btnOnclick(){
    	 btn.setOnClickListener(new View.OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				Intent intent = new Intent(MainActivity.this,Animation_test.class);
 				startActivity(intent);
 				//overridePendingTransition(enterAnim, exitAnim);
 				
 			}
 		});
    }
    class MyHandler extends Handler{
    	@Override
    	public void handleMessage(Message msg) {
    		// TODO Auto-generated method stub
    		super.handleMessage(msg);
    		if(msg.what == 0x123){
    		if(Integer.valueOf(list.get(1))>5000){
    			video.seekTo(0);
    			video.requestFocus();
    			video.start();
    			text.setText("CO2"+list.get(1)+"严重超标！！");
    				
    		}else{
    			video.pause();
    			video.seekTo(0);
    			text.setText("CO2"+list.get(1)+"正常");
    		}
    		}
    	}
    }
    class MyThread implements Runnable{
    	@Override
    	public void run() {
    		while(!Thread.currentThread().isInterrupted()){
    				try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			String result = new HttpUtils().sendPostMethod("http://192.168.1.231:8080/transportservice/type/jason/action/%20GetAllSense.do","","utf-8");
    			list = new JsonTools().parseList(result);
    			 
    			Message message = Message.obtain();
    			Bundle bundle = new Bundle();
    			message.what = 0x123;
    			bundle.putString("text", list.get(0));
    			message.setData(bundle);
    			handler.sendMessage(message);
    			
    		}
    		
    		
    	}
    }


  

}
