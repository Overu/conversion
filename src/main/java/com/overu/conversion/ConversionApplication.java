package com.overu.conversion;

import roboguice.RoboGuice;

import android.app.Application;

public class ConversionApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE);
  }

}
