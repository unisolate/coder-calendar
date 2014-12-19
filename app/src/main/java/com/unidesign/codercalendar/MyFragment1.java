package com.unidesign.codercalendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyFragment1 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	    Bundle savedInstanceState) {
	    View v = inflater.inflate(R.layout.my_fragment1, null);
	    
	    TextView date=(TextView) v.findViewById(R.id.showdate);
	    String text=Uni.getTodayString();
	    date.setText(text);
	    date.getPaint().setFakeBoldText(true);
	    
	    TextView good=(TextView) v.findViewById(R.id.good);
	    good.setBackgroundResource(R.color.DeepYellow);
	    good.getPaint().setFakeBoldText(true);
	    
	    LinearLayout goodevt=(LinearLayout) v.findViewById(R.id.lucktext);
	    String[][] event=Uni.pickTodaysLuck();
	    int numGood= Uni.random(Uni.iday, 98) % 3 + 2;
	    for(int i=0;i<numGood;i++)
	    {
	    	TextView luck = new TextView(getActivity());
	    	luck.setText(event[0][2*i]);
	    	luck.getPaint().setFakeBoldText(true);
	    	luck.setBackgroundResource(R.color.LightYellow);
	    	luck.setTextSize(20);
	    	luck.setGravity(Gravity.CENTER);
	    	goodevt.addView(luck);
	    	
	    	TextView luckword = new TextView(getActivity());
	    	luckword.setText(event[0][2*i+1]);
	    	luckword.setBackgroundResource(R.color.LightYellow);
	    	luckword.setTextSize(17);
	    	luckword.setTextColor(getResources().getColor(R.color.MyGray));
	    	luckword.setGravity(Gravity.CENTER);
	    	goodevt.addView(luckword);
	    }
	    
	    TextView bad=(TextView) v.findViewById(R.id.bad);
	    bad.setBackgroundResource(R.color.DeepRed);
	    bad.getPaint().setFakeBoldText(true);
	    
	    LinearLayout badevt=(LinearLayout) v.findViewById(R.id.unlucktext);
	    int numBad= Uni.random(Uni.iday, 87) % 3 + 2;
	    for(int i=0;i<numBad;i++)
	    {
	    	TextView unluck = new TextView(getActivity());
	    	unluck.setText(event[1][2*i]);
	    	unluck.getPaint().setFakeBoldText(true);
	    	unluck.setBackgroundResource(R.color.LightRed);
	    	unluck.setTextSize(20);
	    	unluck.setGravity(Gravity.CENTER);
	    	badevt.addView(unluck);
	    	
	    	TextView unluckword = new TextView(getActivity());
	    	unluckword.setText(event[1][2*i+1]);
	    	unluckword.setBackgroundResource(R.color.LightRed);
	    	unluckword.setTextSize(17);
	    	unluckword.setTextColor(getResources().getColor(R.color.MyGray));
	    	unluckword.setGravity(Gravity.CENTER);
	    	badevt.addView(unluckword);
	    }
	    
	    TextView seats=(TextView) v.findViewById(R.id.seat3);
	    seats.setText(Uni.directions[Uni.random(Uni.iday, 2) % Uni.directions.length]);
	    
	    TextView drinks=(TextView) v.findViewById(R.id.drink2);
	    drinks.setText(Uni.printRandom());
	    
	    TextView godness=(TextView) v.findViewById(R.id.godness2);
	    godness.setText(Uni.star(Uni.random(Uni.iday, 6) % 5 + 1));
	    
	    return v;
	}
	
	
}
