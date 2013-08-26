package com.overu.conversion;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ConversionActivity extends Activity {

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.conversion, menu);
    return true;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_conversion);

  }

}
