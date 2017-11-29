package com.example.animation_test.http;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class HttpUtils {

	public HttpUtils() {
		// TODO Auto-generated constructor stub
	}
	public String sendPostMethod(String path,String jsonString,String encoding){
		String result = null;
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost post = new HttpPost(path);
		try {
			post.setEntity(new StringEntity(jsonString));
			HttpResponse response = httpClient.execute(post);
			if(response.getStatusLine().getStatusCode() == 200){
				result = EntityUtils.toString(response.getEntity());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String send(String path,String jsonString){
	      ByteArrayOutputStream bao = new ByteArrayOutputStream();
		  HttpURLConnection httpURLConnection = null;
		  //String lines=null;
			try {
				httpURLConnection = (HttpURLConnection)new URL(path).openConnection();
				httpURLConnection.setRequestMethod("POST");
				httpURLConnection.setRequestProperty("Content-type", "application/json");
				httpURLConnection.setDoOutput(true);
				httpURLConnection.setUseCaches(false);
				httpURLConnection.setConnectTimeout(30000);
				httpURLConnection.connect();
				//获取输出流对象，把请求参数发送到服务器接口
				OutputStream outputStream = httpURLConnection.getOutputStream();
				outputStream.write(jsonString.getBytes("utf-8"));
				outputStream.flush();
				InputStream is = httpURLConnection.getInputStream();
				if(httpURLConnection.getResponseCode() == 200){
					byte [] data = new byte[1024];
					int len = 0;
					while((len = is.read(data)) != -1){
						bao.write(data,0,len);
					}
					is.close();
					//BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			        //lines = reader.readLine();
			} else{
				Log.i("--result-->@@@", "失败");
			}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		return new String(bao.toByteArray());
		
		}	
}

