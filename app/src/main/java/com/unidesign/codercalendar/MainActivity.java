package com.unidesign.codercalendar;

import java.util.Locale;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());
		
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    	case R.id.action_refresh:
	    		refresh();
	    		return true;
	        case R.id.action_about:
	            showAbout(mViewPager);
	            return true;
	        case R.id.action_share:
	        	share();
	            return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void refresh(){
		finish();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);  
        startActivity(intent);
	}
	
	public void showAbout(View view){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("About")
		.setMessage("\nCoder Calendar V1.2\n\nA work by UNI.\n\nSource code thanks to Yiding He.\n\nCopyright 2013\n")
		.setCancelable(true);
		builder.show();
	}
	
	public void share(){
		Intent shareIntent = new Intent();
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		String good=addGood();
		String bad=addBad();
		shareIntent.putExtra(Intent.EXTRA_TEXT, "程序员老黄历\n\n"+Uni.getTodayString()+
				"\n\n宜\n"+good+"\n不宜\n"+bad+"\n座位朝向：面向"+Uni.directions[Uni.random(Uni.iday, 2) % Uni.directions.length]+
				"写程序，BUG 最少。\n"+"今日宜饮："+Uni.printRandom()+"\n女神亲近指数："+
				Uni.star(Uni.random(Uni.iday, 6) % 5 + 1));
		startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.action_share)));
	}
	
	public String addGood(){
		String good="";
		String[][] event=Uni.pickTodaysLuck();
		int numGood= Uni.random(Uni.iday, 98) % 3 + 2;
		for(int i=0;i<numGood;i++){
			good+=(i+1)+"."+event[0][2*i]+"\n"+event[0][2*i+1]+"\n";
		}
		return good;
	}
	
	public String addBad(){
		String bad="";
		String[][] event=Uni.pickTodaysLuck();
		int numBad= Uni.random(Uni.iday, 87) % 3 + 2;
		for(int i=0;i<numBad;i++){
			bad+=(i+1)+"."+event[1][2*i]+"\n"+event[1][2*i+1]+"\n";
		}
		return bad;
	}
	
	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
		    Fragment fragment; 
		    switch(i){
		    case 0:
		         fragment = new MyFragment1();
		         break;
		    case 1:
		         fragment = new MyFragment2();
		         break;
		    default:
		         throw new IllegalArgumentException("Invalid section number");
		    }

		    Bundle args = new Bundle();
		    args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, i + 1);
		    fragment.setArguments(args);

		    return fragment;
		}

		@Override
		public int getCount() {
			// Show 2 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
