package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.Expression;
import com.overu.conversion.expression.NoExpression;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

@Singleton
public class Reactiveheat extends ConversionType {

  private Map<String, Expression> reactiveheat;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    if (sourType.equals(targeType)) {
      return sourNum;
    }
    return sourNum / reactiveheat.get(sourType).operation(0) * reactiveheat.get(targeType).operation(0);
  }

  @Override
  public void init() {
    Context context = ConversionType.context.get();
    String[] reactiveheatMKS0 = context.getResources().getStringArray(R.array.reactiveheat_MKS_0);
    String kcal = reactiveheatMKS0[0];
    String cal = reactiveheatMKS0[1];
    String J = reactiveheatMKS0[2];
    setStandard(J);
    String btu = reactiveheatMKS0[3];
    String erg = reactiveheatMKS0[4];
    String therm = reactiveheatMKS0[5];
    String kWh = reactiveheatMKS0[6];
    String ftlb = reactiveheatMKS0[7];
    String gjs = reactiveheatMKS0[8];
    String mzmls = reactiveheatMKS0[9];
    String yzmls = reactiveheatMKS0[10];

    reactiveheat = new HashMap<String, Expression>();
    reactiveheat.put(kcal, new NoExpression(0.0002390057));
    reactiveheat.put(cal, new NoExpression(0.2390057361));
    reactiveheat.put(J, new NoExpression(1.0));
    reactiveheat.put(btu, new NoExpression(0.0009478171));
    reactiveheat.put(erg, new NoExpression(10000000.0));
    reactiveheat.put(therm, new NoExpression(9.5E-9));
    reactiveheat.put(kWh, new NoExpression(2.778E-7));
    reactiveheat.put(ftlb, new NoExpression(0.7376));
    reactiveheat.put(gjs, new NoExpression(0.102));
    reactiveheat.put(mzmls, new NoExpression(3.777E-7));
    reactiveheat.put(yzmls, new NoExpression(3.725E-7));

  }
}
