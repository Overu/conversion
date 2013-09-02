package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.Expression;
import com.overu.conversion.expression.NoExpression;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

@Singleton
public class Volume extends ConversionType {

  private Map<String, Expression> volume;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    if (sourType.equals(targeType)) {
      return sourNum;
    }
    return sourNum / volume.get(sourType).operation(0) * volume.get(targeType).operation(0);
  }

  @Override
  public void init() {
    Context context = ConversionType.context.get();
    String[] volumeMKS0 = context.getResources().getStringArray(R.array.volume_MKS_0);
    String m3 = volumeMKS0[0];
    setStandard(m3);
    String hL = volumeMKS0[1];
    String L = volumeMKS0[2];
    String dm3 = volumeMKS0[3];
    String dL = volumeMKS0[4];
    String cL = volumeMKS0[5];
    String mL = volumeMKS0[6];
    String cm3 = volumeMKS0[7];
    String mm3 = volumeMKS0[8];

    String[] volumeMKS1 = context.getResources().getStringArray(R.array.volume_MKS_1);
    String yd3 = volumeMKS1[0];
    String ft3 = volumeMKS1[1];
    String in3 = volumeMKS1[2];
    String UKgal = volumeMKS1[3];
    String USgal = volumeMKS1[4];
    String myc = volumeMKS1[5];
    String bbl = volumeMKS1[6];
    String c = volumeMKS1[7];
    String floz = volumeMKS1[8];
    String tsp = volumeMKS1[9];

    volume = new HashMap<String, Expression>();
    volume.put(m3, new NoExpression(1));
    volume.put(hL, new NoExpression(10.0));
    volume.put(L, new NoExpression(1000.0));
    volume.put(dm3, new NoExpression(1000.0));
    volume.put(dL, new NoExpression(10000.0));
    volume.put(cL, new NoExpression(100000.0));
    volume.put(mL, new NoExpression(1000000.0));
    volume.put(cm3, new NoExpression(1000000.0));
    volume.put(mm3, new NoExpression(1000000000.0));

    volume.put(yd3, new NoExpression(1.3079527714));
    volume.put(ft3, new NoExpression(35.3147248277));
    volume.put(in3, new NoExpression(61023.8445022));
    volume.put(UKgal, new NoExpression(219.969157332));
    volume.put(USgal, new NoExpression(264.172052358));
    volume.put(myc, new NoExpression(0.0008107132));
    volume.put(bbl, new NoExpression(6.2893081761));
    volume.put(c, new NoExpression(4226.7527752));
    volume.put(floz, new NoExpression(33814.0222016));
    volume.put(tsp, new NoExpression(67628.0444032));

  }
}
