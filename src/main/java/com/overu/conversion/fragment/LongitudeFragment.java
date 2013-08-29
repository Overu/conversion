package com.overu.conversion.fragment;

import com.google.inject.Singleton;

import com.overu.conversion.R;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import android.view.View;

import android.os.Bundle;

import roboguice.fragment.RoboFragment;

@Singleton
public class LongitudeFragment extends RoboFragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_longitude, container, false);
  }
}
