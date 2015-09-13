package com.echo.qqslidemenu;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.echo.qqslidemenu.SlideMenu.OnDragStateChangeListener;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SlideMenu slideMenu = (SlideMenu) findViewById(R.id.slideMenu);
		final ImageView iv_head = (ImageView) findViewById(R.id.iv_head);
		final ListView menu_listview = (ListView) findViewById(R.id.menu_listview);
		ListView main_listview = (ListView) findViewById(R.id.main_listview);
		MyLinearLayout myLinearLayout = (MyLinearLayout) findViewById(R.id.my_layout);
		
		myLinearLayout.setSlideMenu(slideMenu);
		
		menu_listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Constant.ITEM){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView textView = (TextView) super.getView(position, convertView, parent);
				textView.setTextColor(Color.WHITE);
				return textView;
			}
		});
		
		main_listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Constant.ITEM));
		
		slideMenu.setOnDragStateChangeListener(new OnDragStateChangeListener() {
			@Override
			public void onOpen() {
//				Random random = new Random();
//				menu_listview.smoothScrollToPosition(random.nextInt(Constant.ITEM.length));
			}
			@Override
			public void onDragging(float dragFraction) {
				ViewHelper.setAlpha(iv_head, 1-dragFraction);
			}
			@Override
			public void onClose() {
				//ViewPropertyAnimator.animate(iv_head).translationXBy(12).setDuration(600).setInterpolator(new CycleInterpolator(4)).start();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
