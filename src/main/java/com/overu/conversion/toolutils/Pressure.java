package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.Expression;
import com.overu.conversion.expression.NoExpression;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

@Singleton
public class Pressure extends ConversionType {

  private Map<String, Expression> pressure;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    if (sourType.equals(targeType)) {
      return sourNum;
    }
    return sourNum / pressure.get(sourType).operation(0) * pressure.get(targeType).operation(0);
  }

  @Override
  public void init() {
    Context context = ConversionType.context.get();
    String[] pressureMKS0 = context.getResources().getStringArray(R.array.pressure_MKS_0);
    String kPa = pressureMKS0[0];
    String Pa = pressureMKS0[1];
    setStandard(Pa);
    String B = pressureMKS0[2];
    String mB = pressureMKS0[3];
    String torr = pressureMKS0[4];

    String[] pressureMKS1 = context.getResources().getStringArray(R.array.pressure_MKS_1);
    String ATM = pressureMKS1[0];
    String mmHg = pressureMKS1[1];
    String inHg = pressureMKS1[2];
    String mmH2O = pressureMKS1[3];
    String inH2O = pressureMKS1[4];
    String psi = pressureMKS1[5];
    String psf = pressureMKS1[6];
    String pfll = pressureMKS1[7];
    String pfml = pressureMKS1[8];

    pressure = new HashMap<String, Expression>();
    pressure.put(kPa, new NoExpression(0.001));
    pressure.put(Pa, new NoExpression(1.0));
    pressure.put(B, new NoExpression(0.00001));
    pressure.put(mB, new NoExpression(0.01));
    pressure.put(torr, new NoExpression(0.0075006168));

    pressure.put(ATM, new NoExpression(0.0000098692));
    pressure.put(mmHg, new NoExpression(0.0075006168));
    pressure.put(inHg, new NoExpression(0.0002952999));
    pressure.put(mmH2O, new NoExpression(0.101972));
    pressure.put(inH2O, new NoExpression(0.0040146457));
    pressure.put(psi, new NoExpression(0.0001450377));
    pressure.put(psf, new NoExpression(0.0208854342));
    pressure.put(pfll, new NoExpression(0.0000101972));
    pressure.put(pfml, new NoExpression(0.1019716213));

  }
}
