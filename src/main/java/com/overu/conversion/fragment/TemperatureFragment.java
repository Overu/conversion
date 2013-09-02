package com.overu.conversion.fragment;

import com.overu.conversion.R;

import javax.inject.Singleton;

import android.os.Bundle;

@Singleton
public class TemperatureFragment extends PubFragment {

  @Override
  public String getBaseMSK() {
    return "temperature_MKS";
  }

  @Override
  public String getConverType() {
    return resources.getString(R.string.temperature);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    showView(0);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
