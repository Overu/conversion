package com.overu.conversion.adapter;

import java.util.List;

import android.content.res.Resources;

import android.view.ViewGroup;

import android.view.View;

import android.content.Context;

import android.widget.ArrayAdapter;

public class ConversionArrayAdapter<T> extends ArrayAdapter<T> {

  public static ConversionArrayAdapter<CharSequence> createFromResource(Context context, int textArrayResId, int textViewResId) {
    Resources resources = context.getResources();
    CharSequence[] strings = resources.getTextArray(textArrayResId);
    return new ConversionArrayAdapter<CharSequence>(context, textViewResId, strings);
  }

  private View[] mItems;

  public ConversionArrayAdapter(Context context, int textViewResourceId) {
    super(context, textViewResourceId);
  }

  public ConversionArrayAdapter(Context context, int resource, int textViewResourceId) {
    super(context, resource, textViewResourceId);
  }

  public ConversionArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
    super(context, resource, textViewResourceId, objects);
  }

  public ConversionArrayAdapter(Context context, int resource, int textViewResourceId, T[] objects) {
    super(context, resource, textViewResourceId, objects);
  }

  public ConversionArrayAdapter(Context context, int textViewResourceId, List<T> objects) {
    super(context, textViewResourceId, objects);
  }

  public ConversionArrayAdapter(Context context, int textViewResourceId, T[] objects) {
    super(context, textViewResourceId, objects);
  }

  public View[] getItems() {
    return mItems;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View view = super.getView(position, convertView, parent);
    if (mItems == null) {
      mItems = new View[3];
    }
    mItems[position] = view;
    return view;
  }

}
