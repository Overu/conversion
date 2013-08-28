package com.overu.conversion.toolutils;

import com.google.inject.Inject;
import com.google.inject.Provider;

import android.content.Context;

public abstract class ConversionType {

  @Inject
  public static Provider<Context> context;

  public abstract double conver(double sourNum, String sourType, String targeType);

  public abstract void init();

}
