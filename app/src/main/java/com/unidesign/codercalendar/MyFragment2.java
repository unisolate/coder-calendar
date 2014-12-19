package com.unidesign.codercalendar;

import java.util.Timer;
import java.util.TimerTask;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyFragment2 extends Fragment implements OnClickListener{
	private static TextView tv;
	private static Button b1;
	private static Button b2;
	private static Button b3;
	private static Button b4;
	private static Button b5;
	private static View v;
	int count=0;
	
	Timer timer1 = new Timer(true);
	Timer timer2 = new Timer(true);
	Timer timer3 = new Timer(true);
	Timer timer4 = new Timer(true);
	Timer timer5 = new Timer(true);
	
	@SuppressLint("HandlerLeak")
	Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case 1:
					setRandom();
					tv.setOnClickListener(null);
					b1.setOnClickListener(null);
					b2.setOnClickListener(null);
					b3.setOnClickListener(null);
					b4.setOnClickListener(null);
					b5.setOnClickListener(null);
					count++;
					if(count>15){
		        		task1.cancel();
						timer2.schedule(task2,150,150);
					}
					break; 
				case 2:
					setRandom();
					count++;
					if(count>20){
						task2.cancel();
						timer3.schedule(task3,200,200);
					}
					break;
				case 3:
					setRandom();
					count++;
					if(count>25){
						task3.cancel();
						timer4.schedule(task4,400,400);
					}
					break;
				case 4:
					setRandom();
					count++;
					if(count>32){
						task4.cancel();
						timer5.schedule(task5,800,800);
					}
					break;
				case 5:
					setRandom();
					count++;
					if(count>35){
						task5.cancel();
					}
					break;
			}
			super.handleMessage(msg);
		}
	};
	
	TimerTask task1 = new TimerTask(){ 
		public void run() { 
			Message message = new Message();
			message.what = 1;
			handler.sendMessage(message);
		}
	};
	
	TimerTask task2 = new TimerTask(){ 
		public void run() { 
			Message message = new Message();
			message.what = 2;
			handler.sendMessage(message);
		}
	};
	
	TimerTask task3 = new TimerTask(){ 
		public void run() { 
			Message message = new Message();
			message.what = 3;
			handler.sendMessage(message);
		}
	};
	
	TimerTask task4 = new TimerTask(){ 
		public void run() { 
			Message message = new Message();
			message.what = 4;
			handler.sendMessage(message);
		}
	};
	
	TimerTask task5 = new TimerTask(){ 
		public void run() { 
			Message message = new Message();
			message.what = 5;
			handler.sendMessage(message);
		}
	};
	
	public void setRandom(){
		String[] results = {"超大吉", "大吉", "吉", "小吉", "未知", "小胸", "胸", "大胸", "超大胸"};
		String show=Predict.pickRandomWithRate(count);
		if(tv.getText()!=show)
			tv.setText(show);else
			for(int i=2;i<9;i++)
				if(tv.getText()!=results[i])
				{
					tv.setText(results[i]);
					break;
				}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {
	    v = inflater.inflate(R.layout.my_fragment2, null);
	    
	    tv = (TextView) v.findViewById(R.id.bless);
	    
	    b1 = (Button) v.findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button) v.findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) v.findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) v.findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = (Button) v.findViewById(R.id.button5);
        b5.setOnClickListener(this);
	    return v;
	}
	
	@Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.bless:
        	timer1.schedule(task1,100,100);
            break;
        case R.id.button1:
        	tv.setText("求");
        	tv.setTextColor(getResources().getColor(R.color.white));
        	tv.setBackgroundColor(getResources().getColor(R.color.red));
        	tv.setTextSize(70);
        	tv.setOnClickListener(this);
            break;
        case R.id.button2:
        	tv.setText("求");
        	tv.setTextColor(getResources().getColor(R.color.white));
        	tv.setBackgroundColor(getResources().getColor(R.color.red));
        	tv.setTextSize(70);
        	tv.setOnClickListener(this);
            break;
        case R.id.button3:
        	tv.setText("求");
        	tv.setTextColor(getResources().getColor(R.color.white));
        	tv.setBackgroundColor(getResources().getColor(R.color.red));
        	tv.setTextSize(70);
        	tv.setOnClickListener(this);
            break;
        case R.id.button4:
        	tv.setText("求");
        	tv.setTextColor(getResources().getColor(R.color.white));
        	tv.setBackgroundColor(getResources().getColor(R.color.red));
        	tv.setTextSize(70);
        	tv.setOnClickListener(this);
            break;
        case R.id.button5:
        	tv.setText("求");
        	tv.setTextColor(getResources().getColor(R.color.white));
        	tv.setBackgroundColor(getResources().getColor(R.color.red));
        	tv.setTextSize(70);
        	tv.setOnClickListener(this);
            break;
        }
    }
}