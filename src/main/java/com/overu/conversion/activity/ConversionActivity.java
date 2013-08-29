package com.overu.conversion.activity;

import com.google.inject.Inject;

import com.overu.conversion.R;
import com.overu.conversion.fragment.LongitudeFragment;
import com.overu.conversion.toolutils.TypeFactory;

import roboguice.inject.InjectFragment;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.app.ActionBar;
import android.widget.ArrayAdapter;
import roboguice.inject.InjectResource;
import android.view.MenuItem;
import android.view.View;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;

@SuppressLint("NewApi")
@ContentView(R.layout.activity_conversion)
public class ConversionActivity extends RoboActivity {

  private class ConversionSpinnerSelectedItem implements OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      String s = "";
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

  }

  @Inject
  TypeFactory mTypeFactory;

  @InjectResource(R.array.conTypeNames)
  String[] mContypeNames;

  @Inject
  LongitudeFragment longitudeFragmentl;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.conversion, menu);
    MenuItem menuItem = menu.findItem(R.id.spinner);
    Spinner spinner = (Spinner) menuItem.getActionView();
    SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.conTypeNames, android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(new ConversionSpinnerSelectedItem());
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
