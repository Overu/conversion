package com.overu.conversion.toolutils;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.BaseExpression;
import com.overu.conversion.expression.Expression;

import java.util.HashMap;
import java.util.Map;

import roboguice.inject.InjectResource;

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
    Context context = ConversionType.context.get();
    String[] longitudeMKS0 = context.getResources().getStringArray(R.array.longitude_MKS_0);
    String ly = longitudeMKS0[0];
    String AU = longitudeMKS0[1];
    String km = longitudeMKS0[2];
    String m = longitudeMKS0[3];
    // String dm = longitudeMKS0[4];
    // String cm = longitudeMKS0[5];
    // String mm = longitudeMKS0[6];
    // String µm = longitudeMKS0[7];
    // String nm = longitudeMKS0[8];
    // String Å = longitudeMKS0[9];

    String[] longitudeMKSby0 = context.getResources().getStringArray(R.array.longitude_MKS_1);
    String nmi = longitudeMKSby0[0];
    String mi = longitudeMKSby0[1];
    String fg = longitudeMKSby0[2];
    String fm = longitudeMKSby0[3];
    // String yd = longitudeMKSby0[4];
    // String ft = longitudeMKSby0[5];
    // String in = longitudeMKSby0[6];

    // ly
    longitude = new HashMap<String, Expression>();
    longitude.put(ly + "-" + ly, new BaseExpression(1));
    longitude.put(ly + "-" + AU, new BaseExpression(63239.6716738));
    longitude.put(ly + "-" + km, new BaseExpression(300000 * 365 * 24 * 3600));
  }
}
