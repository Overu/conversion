package com.overu.conversion.fragment;

import com.google.inject.Singleton;

import com.overu.conversion.R;

import android.os.Bundle;

@Singleton
public class AreaFragment extends PubFragment {

  @Override
  public String getBaseMSK() {
    return "area_MKS";
  }

  @Override
  public String getConverType() {
    return resources.getString(R.string.area);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.showSinnper();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

}
