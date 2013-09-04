package com.overu.conversion.fragment;

import com.overu.conversion.R;

import javax.inject.Singleton;

import android.os.Bundle;

@Singleton
public class ReactiveheatFragment extends PubFragment {

  @Override
  public String getBaseMSK() {
    return "reactiveheat_MKS";
  }

  @Override
  public String getConverType() {
    return resources.getString(R.string.reactiveheat);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onResume() {
    super.onResume();
    showView(0);
  }
}
