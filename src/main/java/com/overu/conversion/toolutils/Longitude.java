package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.NoExpression;
import com.overu.conversion.expression.Expression;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

@Singleton
public class Longitude extends ConversionType {

  private Map<String, Expression> longitude;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    if (sourType.equals(targeType)) {
      return sourNum;
    }
    return sourNum / longitude.get(sourType).operation(0) * longitude.get(targeType).operation(0);
  }

  @Override
  public void init() {
    Context context = ConversionType.context.get();
    String[] longitudeMKS0 = context.getResources().getStringArray(R.array.longitude_MKS_0);
    String ly = longitudeMKS0[0];
    String AU = longitudeMKS0[1];
    String km = longitudeMKS0[2];
    String m = longitudeMKS0[3];
    this.setStandard(m);
    String dm = longitudeMKS0[4];
    String cm = longitudeMKS0[5];
    String mm = longitudeMKS0[6];
    String µm = longitudeMKS0[7];
    String nm = longitudeMKS0[8];
    String Å = longitudeMKS0[9];

    String[] longitudeMKS1 = context.getResources().getStringArray(R.array.longitude_MKS_1);
    String nmi = longitudeMKS1[0];
    String mi = longitudeMKS1[1];
    String fg = longitudeMKS1[2];
    String fm = longitudeMKS1[3];
    String yd = longitudeMKS1[4];
    String ft = longitudeMKS1[5];
    String in = longitudeMKS1[6];

    String[] longitudeMKS2 = context.getResources().getStringArray(R.array.longitude_MKS_2);
    String ml = longitudeMKS2[0];
    String mz = longitudeMKS2[1];
    String mc = longitudeMKS2[2];
    String mcc = longitudeMKS2[3];
    String mf = longitudeMKS2[4];
    String mll = longitudeMKS2[5];
    String mh = longitudeMKS2[6];

    longitude = new HashMap<String, Expression>();
    longitude.put(ly, new NoExpression(1.0570234E-16));
    longitude.put(AU, new NoExpression(6.6845813E-12));
    longitude.put(km, new NoExpression(0.001));
    longitude.put(m, new NoExpression(1.0));
    longitude.put(dm, new NoExpression(10.0));
    longitude.put(cm, new NoExpression(100.0));
    longitude.put(mm, new NoExpression(1000.0));
    longitude.put(µm, new NoExpression(1000000.0));
    longitude.put(nm, new NoExpression(1000000000.0));
    longitude.put(Å, new NoExpression(10000000000.0));

    longitude.put(nmi, new NoExpression(0.0005399568));
    longitude.put(mi, new NoExpression(0.0006213712));
    longitude.put(fg, new NoExpression(0.0049709695));
    longitude.put(fm, new NoExpression(0.5468066492));
    longitude.put(yd, new NoExpression(1.0936132983));
    longitude.put(ft, new NoExpression(3.280839895));
    longitude.put(in, new NoExpression(39.3700787402));

    longitude.put(ml, new NoExpression(0.002));
    longitude.put(mz, new NoExpression(0.3));
    longitude.put(mc, new NoExpression(3.0));
    longitude.put(mcc, new NoExpression(30.0));
    longitude.put(mf, new NoExpression(300.0));
    longitude.put(mll, new NoExpression(3000.0));
    longitude.put(mh, new NoExpression(30000.0));
  }
}
