package com.overu.conversion.fragment;

import com.google.inject.Inject;

import com.overu.conversion.R;
import com.overu.conversion.adapter.ConversionArrayAdapter;
import com.overu.conversion.view.ConversionSpinner;
import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import roboguice.fragment.RoboFragment;
import roboguice.inject.InjectView;

public class PubFragment extends RoboFragment {

  private class ConversionSpinnerSelectedItemHandle implements OnItemSelectedListener {

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      PubFragment.this.switchSpinnerItem(parent, position);
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

  private int mLeftCurResId = 0;
  private int mRightCurResId = 0;
  private boolean mLazySelect = false;

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_longitude, container, false);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
  }

  @Override
  public void onResume() {
    super.onResume();
    // this.switchSpinnerItem(mSpinnerMKS);
  }

  public void showSinnper() {
    mSpinnerMKS.setVisibility(View.VISIBLE);
    mSpinnerMKSEn.setVisibility(View.VISIBLE);
    ConversionSpinnerSelectedItemHandle spinnerSelectedItemHandle = new ConversionSpinnerSelectedItemHandle();
    mLeftCurResId = mLeftCurResId == 0 ? R.array.MKS_0 : mLeftCurResId;
    ConversionArrayAdapter<CharSequence> adapterMKS =
        ConversionArrayAdapter.createFromResource(context, mLeftCurResId, android.R.layout.simple_spinner_dropdown_item);
    mSpinnerMKS.setAdapter(adapterMKS);
    mRightCurResId = mRightCurResId == 0 ? R.array.MKS_1 : mRightCurResId;
    ConversionArrayAdapter<CharSequence> adapterMKSEn =
        ConversionArrayAdapter.createFromResource(context, mRightCurResId, android.R.layout.simple_spinner_dropdown_item);
    mSpinnerMKSEn.setAdapter(adapterMKSEn);
    mSpinnerMKS.setOnItemSelectedListener(spinnerSelectedItemHandle);
    mSpinnerMKSEn.setOnItemSelectedListener(spinnerSelectedItemHandle);
  }

  protected void switchSpinnerItem(AdapterView<?> spinner, int position) {
    if (mSpinnerMKS == spinner) {
      if (mLazySelect) {
        mLazySelect = false;
        return;
      }
      int mksSelectId = this.getMKSSelectId(mLeftCurResId, position);
      mRightCurResId = this.getMKSResId(mLeftCurResId, position);
      ConversionArrayAdapter<CharSequence> adapterMKS =
          ConversionArrayAdapter.createFromResource(context, mRightCurResId, android.R.layout.simple_spinner_dropdown_item);
      mSpinnerMKSEn.setAdapter(adapterMKS);
      mSpinnerMKSEn.setSelection(mksSelectId);
      mLazySelect = true;
    } else {
      if (mLazySelect) {
        mLazySelect = false;
        return;
      }
      int mksSelectId = this.getMKSSelectId(mRightCurResId, position);
      mLeftCurResId = this.getMKSResId(mRightCurResId, position);
      ConversionArrayAdapter<CharSequence> adapterMKSEn =
          ConversionArrayAdapter.createFromResource(context, mLeftCurResId, android.R.layout.simple_spinner_dropdown_item);
      mSpinnerMKS.setAdapter(adapterMKSEn);
      mSpinnerMKS.setSelection(mksSelectId);
      mLazySelect = true;
    }
  }

  private int getMKSResId(int curResId, int position) {
    if (curResId == R.array.MKS_0) {
      return position == 0 ? R.array.MKS_1 : R.array.MKS_2;
    } else if (curResId == R.array.MKS_1) {
      return position == 0 ? R.array.MKS_0 : R.array.MKS_2;
    } else {
      return position == 0 ? R.array.MKS_1 : R.array.MKS_0;
    }
  }

  private int getMKSSelectId(int curResId, int position) {
    if (curResId == R.array.MKS_0) {
      return position == 0 ? 0 : 1;
    } else if (curResId == R.array.MKS_1) {
      return position == 0 ? 0 : 0;
    } else {
      return position == 0 ? 1 : 1;
    }
  }
}
