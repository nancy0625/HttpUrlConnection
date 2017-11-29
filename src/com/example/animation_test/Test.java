package com.example.animation_test;

import com.example.animation_test.http.HttpUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Test extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		new Thread(new MyThread()).start();
	}
	class MyThread implements Runnable{
		@Override
		public void run() {
			int i = 1;
			while(i<=2){
		
			  String strJson = "{\"BusStationId\":" + 2 + "}";
           String result = new HttpUtils().send(
        		   "http://192.168.1.231:8080/transportservice/type/jason/action/GetBusStationInfo.do", strJson);
			  Log.i("--json-->", result);
			i++;
		}
		}
	}

}
