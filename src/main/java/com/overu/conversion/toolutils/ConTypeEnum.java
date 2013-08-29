package com.overu.conversion.toolutils;

import com.overu.conversion.R;

public enum ConTypeEnum {
  LONGITUDE(R.string.longitude, "长度"), AREA(R.string.area, "面积");

  public static String[] getKeyNames() {
    ConTypeEnum[] values = values();
    String[] keyNames = new String[values.length];
    int i = 0;
    for (ConTypeEnum conType : values) {
      keyNames[i] = conType.getKeyName();
      i++;
    }
    return keyNames;
  }

  public static int[] getKeys() {
    ConTypeEnum[] values = values();
    int[] keys = new int[values.length];
    int i = 0;
    for (ConTypeEnum conType : values()) {
      keys[i] = conType.getKey();
      i++;
    }
    return keys;
  }

  private int key;

  private String keyName;

  private ConTypeEnum(int key, String keyName) {
    this.key = key;
    this.setKeyName(keyName);
  }

  public int getKey() {
    return key;
  }

  public String getKeyName() {
    return keyName;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }
}
