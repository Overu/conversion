package com.overu.conversion.activity;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.overu.conversion.R;
import com.overu.conversion.adapter.ConversionPagerAdapter;
import com.overu.conversion.fragment.PubFragment;
import com.overu.conversion.toolutils.ConTypeEnum;
import com.overu.conversion.toolutils.TypeFactory;
import com.overu.conversion.view.ConversionTabStrip;

import android.view.MotionEvent;

import android.view.MotionEvent;

import android.util.TypedValue;

import android.support.v4.view.ViewPager;

import roboguice.inject.InjectView;

import roboguice.activity.RoboFragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.app.ActionBar;
import android.widget.ArrayAdapter;
import android.view.MenuItem;
import android.view.View;
import roboguice.inject.ContentView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;

@SuppressLint("NewApi")
@ContentView(R.layout.activity_conversion)
public class ConversionActivity extends RoboFragmentActivity {

  private class ConversionSpinnerSelectedItem implements OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      if (isSpinnerCallback) {
        isSpinnerCallback = true;
        pager.setCurrentItem(position);
      }
      // PubFragment fragment = injector.getInstance(Key.get(PubFragment.class, Names.named(mConTypes[position] + "")));
      // FragmentTransaction beginTransaction = mFragmentManager.beginTransaction();
      // beginTransaction.replace(R.id.covmain, fragment);
      // beginTransaction.commitAllowingStateLoss();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

  }

  @Inject
  TypeFactory mTypeFactory;
  @Inject
  Injector injector;
  @Inject
  FragmentManager mFragmentManager;
  @Inject
  ConversionPagerAdapter pagerAdapter;
  @InjectView(R.id.tap)
  ConversionTabStrip tap;
  @InjectView(R.id.pager)
  ViewPager pager;

  private boolean isSpinnerCallback = true;
  private Spinner actionBarSpinner;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.conversion, menu);
    MenuItem menuItem = menu.findItem(R.id.spinner);
    actionBarSpinner = (Spinner) menuItem.getActionView();
    SpinnerAdapter adapter = new ArrayAdapter<CharSequence>(this, R.layout.conversion_actionbar_cell, ConTypeEnum.getKeyNames());
    actionBarSpinner.setAdapter(adapter);
    actionBarSpinner.setOnItemSelectedListener(new ConversionSpinnerSelectedItem());
    actionBarSpinner.setOnTouchListener(new View.OnTouchListener() {

      @Override
      public boolean onTouch(View v, MotionEvent event) {
        isSpinnerCallback = true;
        return false;
      }
    });
    // MenuItem item = menu.add(Menu.NONE, 0, 0, "aa");
    // item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActionBar actionBar = getActionBar();
    actionBar.setDisplayHomeAsUpEnabled(true);

    pager.setAdapter(pagerAdapter);

    final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
    pager.setPageMargin(pageMargin);
    tap.setViewPager(pager);

    tap.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
      }

      @Override
      public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE) {
          isSpinnerCallback = false;
        }
      }

      @Override
      public void onPageSelected(int position) {
        String s = "";
        actionBarSpinner.setSelection(position);
      }
    });

    // mBtn1.setOnClickListener(new View.OnClickListener() {
    //
    // @Override
    // public void onClick(View v) {
    // ConversionType type = mTypeFactory.getType("longitude");
    // type.conver(50, "", "");
    // }
    // });
    // mBtn2.setOnClickListener(new View.OnClickListener() {
    //
    // @Override
    // public void onClick(View v) {
    // ConversionType type = mTypeFactory.getType("area");
    // type.conver(50, "", "");
    // }
    // });
  }
}
