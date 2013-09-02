package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.Expression;
import com.overu.conversion.expression.NoExpression;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

@Singleton
public class Quality extends ConversionType {

  private Map<String, Expression> quality;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    if (sourType.equals(targeType)) {
      return sourNum;
    }
    return sourNum / quality.get(sourType).operation(0) * quality.get(targeType).operation(0);
  }

  @Override
  public void init() {
    Context context = ConversionType.context.get();
    String[] volumeMKS0 = context.getResources().getStringArray(R.array.quality_MKS_0);
    String ton = volumeMKS0[0];
    String q = volumeMKS0[1];
    String kg = volumeMKS0[2];
    setStandard(kg);
    String g = volumeMKS0[3];
    String mg = volumeMKS0[4];
    String µg = volumeMKS0[5];

    String[] volumeMKS1 = context.getResources().getStringArray(R.array.quality_MKS_1);
    String lb = volumeMKS1[0];
    String oz = volumeMKS1[1];
    String ct = volumeMKS1[2];
    String gr = volumeMKS1[3];
    String lt = volumeMKS1[4];
    String st = volumeMKS1[5];
    String lh = volumeMKS1[6];
    String sh = volumeMKS1[7];
    String yg = volumeMKS1[8];
    String dr = volumeMKS1[9];

    String[] volumeMKS2 = context.getResources().getStringArray(R.array.quality_MKS_2);
    String md = volumeMKS2[0];
    String mj = volumeMKS2[1];
    String mm = volumeMKS2[2];
    String mq = volumeMKS2[3];

    quality = new HashMap<String, Expression>();
    quality.put(ton, new NoExpression(0.001));
    quality.put(q, new NoExpression(0.01));
    quality.put(kg, new NoExpression(1));
    quality.put(g, new NoExpression(1000.0));
    quality.put(mg, new NoExpression(1000000.0));
    quality.put(µg, new NoExpression(1000000000.0));

    quality.put(lb, new NoExpression(2.2046226218));
    quality.put(oz, new NoExpression(35.2739619496));
    quality.put(ct, new NoExpression(5000.0));
    quality.put(gr, new NoExpression(15432.3583529));
    quality.put(lt, new NoExpression(0.0009842065));
    quality.put(st, new NoExpression(0.0011023113));
    quality.put(lh, new NoExpression(0.0196841306));
    quality.put(sh, new NoExpression(0.0220462262));
    quality.put(yg, new NoExpression(0.1574730444));
    quality.put(dr, new NoExpression(564.383391193));

    quality.put(md, new NoExpression(0.02));
    quality.put(mj, new NoExpression(2.0));
    quality.put(mm, new NoExpression(20));
    quality.put(mq, new NoExpression(200));
  }
}
