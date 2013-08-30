package com.overu.conversion.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.View;

import android.content.Context;

import android.widget.ArrayAdapter;

public class ConversionArrayAdapter<T> extends ArrayAdapter<T> {

  private List<View> items;

  public ConversionArrayAdapter(Context context, int textViewResourceId) {
    super(context, textViewResourceId);
  }

  public ConversionArrayAdapter(Context context, int resource, int textViewResourceId) {
    super(context, resource, textViewResourceId);
    // TODO Auto-generated constructor stub
  }

  public ConversionArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
    super(context, resource, textViewResourceId, objects);
    // TODO Auto-generated constructor stub
  }

  public ConversionArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
    super(context, resource, textViewResourceId, objects);
    // TODO Auto-generated constructor stub
  }

  public ConversionArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
    super(context, textViewResourceId, objects);
  }

  public ConversionArrayAdapter(Context context, int textViewResourceId, T[] objects) {
    super(context, textViewResourceId, objects);
  }

}
