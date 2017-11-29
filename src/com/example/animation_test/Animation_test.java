package com.example.animation_test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Animation_test extends Activity{
	private ImageView img;
	private Button btn1,btn2,btn3,btn4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animation_test);
		img= (ImageView)this.findViewById(R.id.img);
		btn1 = (Button)this.findViewById(R.id.btn1);
		btn2 = (Button)this.findViewById(R.id.btn2);
		btn3 = (Button)this.findViewById(R.id.btn3);
		btn4 = (Button)this.findViewById(R.id.btn4);
		btn1.setOnClickListener(new MyButton());
		btn2.setOnClickListener(new MyButton());
		btn3.setOnClickListener(new MyButton());
		btn4.setOnClickListener(new MyButton());
		
	}
	
	class MyButton implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn1:
		      Alpha();
		      break;
			case R.id.btn2:
				Scale();
				break;
			case R.id.btn3:
				Rotata();
				break;
			case R.id.btn4:
				Translate();
				break;
			}
			
		}
		
	}
	public void Alpha(){
		AnimationSet animationSet = new AnimationSet(true);
		AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0.1f);
		alphaAnimation.setDuration(2000);
		animationSet.addAnimation(alphaAnimation);
		img.startAnimation(animationSet);
	}
	public void Scale(){
	 	AnimationSet animationSet = new AnimationSet(true);
	    ScaleAnimation scaleAnimation = new ScaleAnimation(1f, 0.1f, 1f, 0.1f);
	    scaleAnimation.setDuration(2000);
	    animationSet.addAnimation(scaleAnimation);
		img.startAnimation(animationSet);
	}
	public void Rotata(){
		AnimationSet animationSet = new AnimationSet(true);
		RotateAnimation rotateAnimation = new RotateAnimation(0, 270,Animation.RELATIVE_TO_PARENT,1f,Animation.RELATIVE_TO_PARENT,0f
				
				);
		rotateAnimation.setDuration(2000);
		animationSet.addAnimation(rotateAnimation);
		img.startAnimation(rotateAnimation);
	}

	public void Translate(){
		AnimationSet animationSet = new AnimationSet(true);
		TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF
				,0.5f, Animation.RELATIVE_TO_SELF,0f, Animation.RELATIVE_TO_SELF,1.0f);
		translateAnimation.setDuration(2000);
		animationSet.addAnimation(translateAnimation);
		img.startAnimation(animationSet);
	}
	
}
