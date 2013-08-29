package com.example.gif002;
/**
 * 
 * 补间动画：旋转，平移，缩放，透明度
 * 
 * 添加了一个奔跑的动画
 * 
 * **/
import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button rotateBtn = null;
	private Button translateBtn = null;
	private Button scaleBtn = null;
	private Button alphaBtn = null;
	private ImageView imageView = null;
	/**奔跑**/
	private ImageView imageView2 = null;
	private AnimationDrawable anim = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		rotateBtn = (Button)findViewById(R.id.button1);
		translateBtn = (Button)findViewById(R.id.button2);
		scaleBtn = (Button)findViewById(R.id.button3);
		alphaBtn = (Button)findViewById(R.id.button4);
		imageView = (ImageView)findViewById(R.id.imageView1);
		
		/**奔跑**/
		imageView2 = (ImageView)findViewById(R.id.imageView2);
		
		final Animation rotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
		final Animation translate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
		final Animation scale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
		final Animation alpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
		
		/**奔跑**/
		final Animation runright = AnimationUtils.loadAnimation(this, R.anim.translateright);
		final Animation runleft = AnimationUtils.loadAnimation(this, R.anim.translateleft);
		//获取应用的帧动画
		anim = (AnimationDrawable)imageView2.getBackground();
		//获取线性布局管理器
		LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout2);
		Toast.makeText(this, "触摸屏幕后开始播放。。。", Toast.LENGTH_LONG).show();
		ll.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				anim.start();
				imageView2.startAnimation(runright);
				return false;
			}
		});
		runright.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation a) {
				imageView2.setBackgroundResource(R.anim.motionleft);
				imageView2.startAnimation(runleft);
				anim = (AnimationDrawable)imageView2.getBackground();
				anim.start();
			}
		});
		runleft.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub
				imageView2.setBackgroundResource(R.anim.motionright);
				imageView2.startAnimation(runright);
				anim = (AnimationDrawable)imageView2.getBackground();
				anim.start();
			}
		});
		rotateBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				imageView.startAnimation(rotate);
			}
		});
		translateBtn.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						imageView.startAnimation(translate);
					}
				});
		scaleBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				imageView.startAnimation(scale);
			}
		});
		alphaBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				imageView.startAnimation(alpha);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
