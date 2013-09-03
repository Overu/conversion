package com.overu.conversion.fragment;

import com.google.inject.Inject;

import com.overu.conversion.R;
import com.overu.conversion.adapter.ConversionArrayAdapter;
import com.overu.conversion.toolutils.ConversionType;
import com.overu.conversion.toolutils.TypeFactory;
import com.overu.conversion.view.ConversionSpinner;

import java.text.DecimalFormat;

import android.view.View.OnTouchListener;

import android.view.MotionEvent;

import roboguice.inject.InjectResource;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.content.res.Resources;
import android.view.View.OnFocusChangeListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
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

  private OnTouchListener mConTouchHandle = new OnTouchListener() {

    @Override
    public boolean onTouch(View v, MotionEvent event) {
      // if (v instanceof EditText) {
      // EditText editText = (EditText) v;
      // editText.requestFocus();
      // editText.selectAll();
      // }
      return false;
    }
  };

  private OnFocusChangeListener mConTextFocusChangeHandle = new OnFocusChangeListener() {

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
      mCurTextEdit = (EditText) v;
      mCurTextView = (TextView) ((LinearLayout) mCurTextEdit.getParent()).getChildAt(1);
      if (hasFocus) {
        mCurTextEdit.addTextChangedListener(mConTextChangeHandle);
      } else {
        mCurTextEdit.removeTextChangedListener(mConTextChangeHandle);
      }
    }

  };

  private TextWatcher mConTextChangeHandle = new TextWatcher() {

    @Override
    public void afterTextChanged(Editable s) {
      try {
        if (s.toString().length() == 0) {
          mCurConverNum = 0.0;
        } else {
          mCurConverNum = Double.parseDouble(s.toString());
        }
        mCurConverType = (String) mCurTextView.getTag();
        PubFragment.this.conversionAll();
      } catch (NumberFormatException e) {
        mCurConverNum = 0.0;
      }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
  };

  @InjectView(R.id.spinner_MKS)
  ConversionSpinner mSpinnerMKS;

  @InjectView(R.id.spinner_MKSEn)
  ConversionSpinner mSpinnerMKSEn;

  @InjectView(R.id.left_container)
  LinearLayout mLeftContainer;
  @InjectView(R.id.right_container)
  LinearLayout mRightContainer;
  @InjectResource(R.array.MKS_all)
  String[] mMSKAll;
  @Inject
  Application context;

  @Inject
  Resources resources;
  @Inject
  LayoutInflater layoutInflater;
  @Inject
  TypeFactory mTypeFactory;

  public static DecimalFormat moreThan0 = new DecimalFormat("0.####E0");
  public static DecimalFormat lessThan0 = new DecimalFormat("0.0000E0");
  public static DecimalFormat baseFormat = new DecimalFormat("0.###");

  private int mLeftCurResId = 0;
  private int mRightCurResId = 0;

  private int mLeftCurContainerId = -1;
  private int mRightCurContainerId = -1;
  private EditText mCurTextEdit;
  private TextView mCurTextView;
  private double mCurConverNum;
  private String mCurConverType;
  private ConversionType mConverType;

  public void clearText() {
  }

  public void conversionAll() {
    this.conversionLeft();
    this.conversionRight();
  }

  public void conversionLeft() {
    if (mLeftCurContainerId != -1) {
      this.conversion(true);
    }
  }

  public void conversionRight() {
    if (mRightCurContainerId != -1) {
      this.conversion(false);
    }
  }

  public String formatDouble(double source) {
    String target = null;
    do {
      if (source > 0) {
        if (source > 999999) {
          target = moreThan0.format(source);
          break;
        }
        if (source < 1) {
          target = lessThan0.format(source);
          break;
        }
        if (source < 999999 && source > 1) {
          target = baseFormat.format(source);
          break;
        }
      } else {
        if (source < -999999) {
          target = moreThan0.format(source);
          break;
        }
        if (source > -1) {
          target = lessThan0.format(source);
          break;
        }
        if (source > -999999 && source < -1) {
          target = baseFormat.format(source);
          break;
        }
      }
    } while (false);
    return target;
  }

  public String getBaseMSK() {
    return "";
  }

  public String getConverType() {
    return "";
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mConverType = mTypeFactory.getType(PubFragment.this.getConverType());
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_longitude, container, false);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    mLeftCurContainerId = -1;
    mRightCurContainerId = -1;
    mCurConverNum = 0;
    mCurConverType = "";
  }

  @Override
  public void onResume() {
    super.onResume();
  }

  public void showSinnper() {
    mSpinnerMKS.setVisibility(View.VISIBLE);
    mSpinnerMKSEn.setVisibility(View.VISIBLE);
    ConversionSpinnerSelectedItemHandle spinnerSelectedItemHandle = new ConversionSpinnerSelectedItemHandle();
    mLeftCurResId = mLeftCurResId == 0 ? R.array.MKS_0 : mLeftCurResId;
    ConversionArrayAdapter<CharSequence> adapterMKS =
        ConversionArrayAdapter.createFromResource(context, mLeftCurResId, R.layout.conversion_spinner_cell);
    mSpinnerMKS.setAdapter(adapterMKS);
    mRightCurResId = mRightCurResId == 0 ? R.array.MKS_1 : mRightCurResId;
    ConversionArrayAdapter<CharSequence> adapterMKSEn =
        ConversionArrayAdapter.createFromResource(context, mRightCurResId, R.layout.conversion_spinner_cell);
    mSpinnerMKSEn.setAdapter(adapterMKSEn);
    mSpinnerMKS.setOnItemSelectedListener(spinnerSelectedItemHandle);
    mSpinnerMKSEn.setOnItemSelectedListener(spinnerSelectedItemHandle);
  }

  public void showView() {
    showView(0, true);
    showView(1, true);
  }

  public void showView(int id) {
    showView(id, true);
  }

  protected void switchSpinnerItem(AdapterView<?> spinner, int position) {
    if (mSpinnerMKS == spinner) {
      int rightCurResId = this.getMKSResId(mLeftCurResId, position);
      if (rightCurResId != mRightCurResId) {
        mRightCurResId = rightCurResId;
        int mksSelectId = this.getMKSSelectId(mLeftCurResId, position);
        ConversionArrayAdapter<CharSequence> adapterMKS =
            ConversionArrayAdapter.createFromResource(context, mRightCurResId, R.layout.conversion_spinner_cell);
        mSpinnerMKSEn.setAdapter(adapterMKS);
        mSpinnerMKSEn.setSelection(mksSelectId);
      }
      CheckedTextView selectItem = (CheckedTextView) mSpinnerMKS.getSelectedView();
      if (selectItem == null) {
        showView(0, true);
        return;
      }
      showView(this.getMSKPositionByName((String) selectItem.getText(), true), true);
    } else {
      int leftCurResId = this.getMKSResId(mRightCurResId, position);
      if (leftCurResId != mLeftCurResId) {
        mLeftCurResId = leftCurResId;
        int mksSelectId = this.getMKSSelectId(mRightCurResId, position);
        ConversionArrayAdapter<CharSequence> adapterMKSEn =
            ConversionArrayAdapter.createFromResource(context, mLeftCurResId, R.layout.conversion_spinner_cell);
        mSpinnerMKS.setAdapter(adapterMKSEn);
        mSpinnerMKS.setSelection(mksSelectId);
      }
      CheckedTextView selectItem = (CheckedTextView) mSpinnerMKSEn.getSelectedView();
      if (selectItem == null) {
        showView(1, false);
        return;
      }
      showView(this.getMSKPositionByName((String) selectItem.getText(), false), false);
    }
  }

  private void conversion(boolean isLeft) {
    if (mConverType == null) {
      return;
    }
    if (mCurConverType == null || mCurConverType.equals("")) {
      mCurConverType = mConverType.getStandard();
    }
    LinearLayout lOrRcontaier = isLeft ? mLeftContainer : mRightContainer;
    LinearLayout container = (LinearLayout) lOrRcontaier.getChildAt(0);
    for (int i = 0; i < container.getChildCount(); i++) {
      LinearLayout editTextContainer = (LinearLayout) container.getChildAt(i);
      EditText converEditText = (EditText) editTextContainer.getChildAt(0);
      TextView converTextView = (TextView) editTextContainer.getChildAt(1);
      String targetConverType = (String) converTextView.getTag();
      if (mCurConverType.equals(targetConverType)) {
        continue;
      }
      if (mCurConverNum == 0.0) {
        converEditText.setText("");
        continue;
      }
      double conver = mConverType.conver(mCurConverNum, mCurConverType, targetConverType);
      converEditText.setText(this.formatDouble(conver));
    }
  }

  private ViewGroup getConverView(int i) {
    int keyId = resources.getIdentifier(getBaseMSK() + "_" + i, "array", context.getPackageName());
    int nameId = resources.getIdentifier(getBaseMSK() + "_cn_" + i, "array", context.getPackageName());
    if (keyId == 0 || nameId == 0) {
      return null;
    }
    String keys[] = resources.getStringArray(keyId);
    String names[] = resources.getStringArray(nameId);
    int j = 0;
    LinearLayout container = (LinearLayout) layoutInflater.inflate(R.layout.conversion_edittext_container, null);
    for (String key : keys) {
      LinearLayout conTextContainer = (LinearLayout) layoutInflater.inflate(R.layout.conversion_edittext_cell, null);
      EditText converEditText = (EditText) conTextContainer.findViewById(R.id.conver_input);
      converEditText.setOnFocusChangeListener(mConTextFocusChangeHandle);
      converEditText.setOnTouchListener(mConTouchHandle);
      TextView converText = (TextView) conTextContainer.findViewById(R.id.conver_text);
      converText.setTag(key);
      converText.setText(names[j]);
      container.addView(conTextContainer);
      j++;
    }
    return container;
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

  private int getMSKPositionByName(String text, boolean isLeft) {
    int i = 0;
    for (String MSKname : mMSKAll) {
      if (MSKname.equals(text)) {
        if (isLeft) {
          return i == mLeftCurContainerId ? -1 : i;
        } else {
          return i == mRightCurContainerId ? -1 : i;
        }
      }
      i++;
    }
    return -1;
  }

  private void showView(int id, boolean isLeft) {
    if (id == -1) {
      return;
    }
    if (isLeft) {
      if (mLeftCurContainerId == id) {
        return;
      }
      ViewGroup converView = this.getConverView(id);
      if (converView == null) {
        return;
      }
      View last = mLeftContainer.findViewById(R.id.conver_edittext_container);
      if (last != null) {
        mLeftContainer.removeAllViewsInLayout();
      }
      mLeftCurContainerId = id;
      mLeftContainer.addView(converView);
      if (mCurConverNum != 0.0) {
        this.conversionLeft();
      }
    } else {
      if (mRightCurContainerId == id) {
        return;
      }
      ViewGroup converView = this.getConverView(id);
      if (converView == null) {
        return;
      }
      View last = mRightContainer.findViewById(R.id.conver_edittext_container);
      if (last != null) {
        mRightContainer.removeAllViewsInLayout();
      }
      mRightCurContainerId = id;
      mRightContainer.addView(converView);
      if (mCurConverNum != 0.0) {
        this.conversionRight();
      }
    }
  }
}
