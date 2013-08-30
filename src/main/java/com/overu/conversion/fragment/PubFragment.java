package com.overu.conversion.fragment;

import com.google.inject.Inject;

import com.overu.conversion.R;
import com.overu.conversion.view.ConversionSpinner;

import java.util.ArrayList;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class PubFragment extends RoboFragment {

  private class ConversionSpinnerSelectedItemHandle implements OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      PubFragment.this.switchSpinnerItem(parent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

  }

  @InjectView(R.id.spinner_MKS)
  ConversionSpinner mSpinnerMKS;
  @InjectView(R.id.spinner_MKSEn)
  ConversionSpinner mSpinnerMKSEn;

  @Inject
  Application context;

  private SpinnerAdapter mSpinnerAdapterMKS;
  private SpinnerAdapter mSpinnerAdapterMKSEn;

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ConversionSpinnerSelectedItemHandle spinnerSelectedItemHandle = new ConversionSpinnerSelectedItemHandle();
    mSpinnerAdapterMKS = ArrayAdapter.createFromResource(context, R.array.MKS, android.R.layout.simple_spinner_dropdown_item);
    mSpinnerMKS.setAdapter(mSpinnerAdapterMKS);
    mSpinnerAdapterMKSEn = ArrayAdapter.createFromResource(context, R.array.MKS, android.R.layout.simple_spinner_dropdown_item);
    mSpinnerMKSEn.setAdapter(mSpinnerAdapterMKSEn);
    mSpinnerMKS.setOnItemSelectedListener(spinnerSelectedItemHandle);
    mSpinnerMKSEn.setOnItemSelectedListener(spinnerSelectedItemHandle);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_longitude, container, false);
  }

  @Override
  public void onResume() {
    super.onResume();
    // this.switchSpinnerItem(mSpinnerMKS);
  }

  protected void switchSpinnerItem(AdapterView<?> spinner) {
    // mSpinnerMKS.refreshDrawableState();
    // mSpinnerMKSEn.refreshDrawableState();
    // for (int i = 0; i < spinner.getCount(); i++) {
    // mSpinnerMKS.getChildAt(i).setVisibility(View.VISIBLE);
    // mSpinnerMKSEn.getChildAt(i).setVisibility(View.VISIBLE);
    // }
    View view = mSpinnerAdapterMKS.getView(0, null, null);
    View dropDownView = mSpinnerAdapterMKS.getDropDownView(0, null, null);
    ArrayList<View> touchables = mSpinnerMKS.getTouchables();
    if (mSpinnerMKS == spinner) {
      mSpinnerMKS.getSelectedView().setVisibility(View.INVISIBLE);
    } else {
      mSpinnerMKS.getSelectedView().setVisibility(View.INVISIBLE);
    }
  }
}
