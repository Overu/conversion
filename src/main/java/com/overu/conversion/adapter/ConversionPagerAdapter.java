package com.overu.conversion.adapter;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

import com.overu.conversion.fragment.PubFragment;
import com.overu.conversion.toolutils.ConTypeEnum;

import android.support.v4.app.FragmentStatePagerAdapter;

import android.support.v4.app.FragmentManager;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentPagerAdapter;

public class ConversionPagerAdapter extends FragmentStatePagerAdapter {

  private int[] mConTypes;

  private String[] mConString;

  @Inject
  Injector injector;

  @Inject
  public ConversionPagerAdapter(FragmentManager fm) {
    super(fm);
    mConTypes = ConTypeEnum.getKeys();
    mConString = ConTypeEnum.getKeyNames();
  }

  @Override
  public int getCount() {
    return mConTypes.length;
  }

  @Override
  public Fragment getItem(int position) {
    return injector.getInstance(Key.get(PubFragment.class, Names.named(mConTypes[position] + "")));
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return mConString[position];
  }

}
