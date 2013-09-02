package com.overu.conversion.fragment;

import com.overu.conversion.R;

import javax.inject.Singleton;

import android.os.Bundle;

@Singleton
public class QualityFragment extends PubFragment {

  @Override
  public String getBaseMSK() {
    return "quality_MKS";
  }

  @Override
  public String getConverType() {
    return resources.getString(R.string.quality);
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
