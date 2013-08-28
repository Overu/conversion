package com.overu.conversion.activity;

import com.google.inject.Inject;

import com.overu.conversion.R;
import com.overu.conversion.toolutils.ConversionType;
import com.overu.conversion.toolutils.TypeFactory;

import android.view.MenuItem;

import android.view.View;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.widget.Button;
import roboguice.inject.InjectView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;

@SuppressLint("NewApi")
@ContentView(R.layout.activity_conversion)
public class ConversionActivity extends RoboActivity {

  @Inject
  TypeFactory typeFactory;
  @InjectView(R.id.btn1)
  Button btn1;
  @InjectView(R.id.btn2)
  Button btn2;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.conversion, menu);
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

    getActionBar().setDisplayHomeAsUpEnabled(true);

    btn1.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        ConversionType type = typeFactory.getType("longitude");
        type.conver(50, "", "");
      }
    });
    btn2.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        ConversionType type = typeFactory.getType("area");
        type.conver(50, "", "");
      }
    });
  }

}
