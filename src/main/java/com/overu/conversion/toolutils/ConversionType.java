package com.overu.conversion.toolutils;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.content.Context;

public abstract class ConversionType {

  @Inject
  public static Provider<Context> context;

  private String mStandard;

  public abstract double conver(double sourNum, String sourType, String targeType);

  public String getStandard() {
    return mStandard;
  }

  public abstract void init();

  public void setStandard(String standard) {
    this.mStandard = standard;
  }

}
