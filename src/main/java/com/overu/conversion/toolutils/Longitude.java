package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.BaseExpression;
import com.overu.conversion.expression.Expression;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

@Singleton
public class Longitude extends ConversionType {

  private Map<String, Expression> longitude;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    return 0;
  }

  @Override
  public void init() {
    Context context2 = ConversionType.context.get();
    String string = context2.getResources().getString(R.string.longitude);
    longitude = new HashMap<String, Expression>();
    longitude.put("a", new BaseExpression(50));
  }

}
