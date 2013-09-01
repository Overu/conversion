package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.Expression;
import com.overu.conversion.expression.NoExpression;

import java.util.HashMap;
import java.util.Map;

import android.content.res.Resources;

import android.content.Context;

@Singleton
public class Area extends ConversionType {

  private Map<String, Expression> area;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    if (sourType.equals(targeType)) {
      return sourNum;
    }
    return sourNum / area.get(sourType).operation(0) * area.get(targeType).operation(0);
  }

  @Override
  public void init() {
    Context context = ConversionType.context.get();
    Resources resources = context.getResources();
    String[] areaMKS0 = resources.getStringArray(R.array.area_MKS_0);
    String km2 = areaMKS0[0];
    String ha = areaMKS0[1];
    String are = areaMKS0[2];
    String m2 = areaMKS0[3];
    this.setStandard(m2);
    String dm2 = areaMKS0[4];
    String cm2 = areaMKS0[5];
    String mm2 = areaMKS0[6];

    String[] areaMKS1 = resources.getStringArray(R.array.area_MKS_1);
    String mi2 = areaMKS1[0];
    String ac = areaMKS1[1];
    String rd2 = areaMKS1[2];
    String yd2 = areaMKS1[3];
    String ft2 = areaMKS1[4];
    String in2 = areaMKS1[5];

    String[] areaMKS2 = resources.getStringArray(R.array.area_MKS_2);
    String mq = areaMKS2[0];
    String mm = areaMKS2[1];
    String mpfc = areaMKS2[2];
    String mpfcc = areaMKS2[3];

    area = new HashMap<String, Expression>();
    area.put(km2, new NoExpression(0.000001));
    area.put(ha, new NoExpression(0.0001));
    area.put(are, new NoExpression(0.01));
    area.put(m2, new NoExpression(1));
    area.put(dm2, new NoExpression(100));
    area.put(cm2, new NoExpression(10000));
    area.put(mm2, new NoExpression(1000000));

    area.put(mi2, new NoExpression(3.861E-7));
    area.put(ac, new NoExpression(0.0002471054));
    area.put(rd2, new NoExpression(0.039536861));
    area.put(yd2, new NoExpression(1.1959900463));
    area.put(ft2, new NoExpression(10.7639104167));
    area.put(in2, new NoExpression(1550.0031));

    area.put(mq, new NoExpression(0.000015));
    area.put(mm, new NoExpression(0.0015));
    area.put(mpfc, new NoExpression(9));
    area.put(mpfcc, new NoExpression(900));
  }
}
