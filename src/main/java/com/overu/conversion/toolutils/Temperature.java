package com.overu.conversion.toolutils;

import com.google.inject.Singleton;

import com.overu.conversion.R;
import com.overu.conversion.expression.Expression;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;

@Singleton
public class Temperature extends ConversionType {

  private Map<String, Expression> temperature;

  @Override
  public double conver(double sourNum, String sourType, String targeType) {
    if (sourType.equals(targeType)) {
      return sourNum;
    }
    double operation = temperature.get(sourType + "-" + getStandard()).operation(sourNum);
    double operation2 = temperature.get(getStandard() + "-" + targeType).operation(operation);
    return operation2;
  }

  @Override
  public void init() {
    Context context = ConversionType.context.get();
    String[] temperatureMKS0 = context.getResources().getStringArray(R.array.temperature_MKS_0);
    String C = temperatureMKS0[0];
    String F = temperatureMKS0[1];
    String K = temperatureMKS0[2];
    setStandard(K);
    String Ra = temperatureMKS0[3];
    String Re = temperatureMKS0[4];

    temperature = new HashMap<String, Expression>();
    temperature.put(C + "-" + K, new Expression() {

      @Override
      public double operation(double num) {
        return num + 273.15;
      }
    });
    temperature.put(K + "-" + C, new Expression() {

      @Override
      public double operation(double num) {
        return num - 273.15;
      }
    });

    temperature.put(F + "-" + K, new Expression() {

      @Override
      public double operation(double num) {
        return (num + 459.67) / 1.8;
      }
    });
    temperature.put(K + "-" + F, new Expression() {

      @Override
      public double operation(double num) {
        return num * 1.8 - 459.67;
      }
    });

    temperature.put(K + "-" + K, new Expression() {

      @Override
      public double operation(double num) {
        return num * 1;
      }
    });

    temperature.put(K + "-" + Ra, new Expression() {

      @Override
      public double operation(double num) {
        return num * 1.8;
      }
    });
    temperature.put(Ra + "-" + K, new Expression() {

      @Override
      public double operation(double num) {
        return num / 1.8;
      }
    });

    temperature.put(K + "-" + Re, new Expression() {

      @Override
      public double operation(double num) {
        return (num - 273.15) * 0.8;
      }
    });
    temperature.put(Re + "-" + K, new Expression() {

      @Override
      public double operation(double num) {
        return num * 1.25 + 273.15;
      }
    });

  }
}
