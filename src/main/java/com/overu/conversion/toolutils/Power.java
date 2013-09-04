package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.Expression;
import com.overu.conversion.expression.NoExpression;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

@Singleton
public class Power extends ConversionType {

  private Map<String, Expression> power;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    if (sourType.equals(targeType)) {
      return sourNum;
    }
    return sourNum / power.get(sourType).operation(0) * power.get(targeType).operation(0);
  }

  @Override
  public void init() {
    Context context = ConversionType.context.get();
    String[] prowerMKS0 = context.getResources().getStringArray(R.array.power_MKS_0);
    String MW = prowerMKS0[0];
    String kW = prowerMKS0[1];
    String W = prowerMKS0[2];
    setStandard(W);
    String mW = prowerMKS0[3];
    String BHP = prowerMKS0[4];
    String MHP = prowerMKS0[5];
    String gls = prowerMKS0[6];
    String qks = prowerMKS0[7];
    String yrs = prowerMKS0[8];
    String ycbs = prowerMKS0[9];

    power = new HashMap<String, Expression>();
    power.put(MW, new NoExpression(0.000001));
    power.put(kW, new NoExpression(0.001));
    power.put(W, new NoExpression(1.0));
    power.put(mW, new NoExpression(1000.0));
    power.put(BHP, new NoExpression(0.0013410221));
    power.put(MHP, new NoExpression(0.0013596216));
    power.put(gls, new NoExpression(0.1019716213));
    power.put(qks, new NoExpression(0.000239));
    power.put(yrs, new NoExpression(0.0009478171));
    power.put(ycbs, new NoExpression(0.7375621489));

  }
}
