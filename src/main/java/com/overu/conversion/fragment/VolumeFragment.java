package com.overu.conversion.fragment;

import com.overu.conversion.R;

import javax.inject.Singleton;

import android.os.Bundle;

@Singleton
public class VolumeFragment extends PubFragment {

  @Override
  public String getBaseMSK() {
    return "volume_MKS";
  }

  @Override
  public String getConverType() {
    return resources.getString(R.string.volume);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    this.showSinnper();
    this.mSpinnerMKS.setEnabled(false);
    this.mSpinnerMKSEn.setEnabled(false);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }
}
