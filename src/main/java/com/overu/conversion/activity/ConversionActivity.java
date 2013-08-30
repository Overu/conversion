package com.overu.conversion.activity;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.overu.conversion.R;
import com.overu.conversion.fragment.PubFragment;
import com.overu.conversion.toolutils.ConTypeEnum;
import com.overu.conversion.toolutils.TypeFactory;
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
      PubFragment fragment = injector.getInstance(Key.get(PubFragment.class, Names.named(mConTypes[position] + "")));
      FragmentTransaction beginTransaction = mFragmentManager.beginTransaction();
      beginTransaction.replace(R.id.covmain, fragment);
      beginTransaction.commitAllowingStateLoss();
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

  private int[] mConTypes;

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.conversion, menu);
    MenuItem menuItem = menu.findItem(R.id.spinner);
    Spinner spinner = (Spinner) menuItem.getActionView();
    SpinnerAdapter adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_dropdown_item, ConTypeEnum.getKeyNames());
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

    mConTypes = ConTypeEnum.getKeys();

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
