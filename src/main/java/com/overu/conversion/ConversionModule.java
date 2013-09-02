package com.overu.conversion;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import com.overu.conversion.fragment.AreaFragment;
import com.overu.conversion.fragment.LongitudeFragment;
import com.overu.conversion.fragment.PubFragment;
import com.overu.conversion.fragment.QualityFragment;
import com.overu.conversion.fragment.TemperatureFragment;
import com.overu.conversion.fragment.VolumeFragment;
import com.overu.conversion.toolutils.Area;
import com.overu.conversion.toolutils.ConversionType;
import com.overu.conversion.toolutils.Longitude;
import com.overu.conversion.toolutils.Temperature;
import com.overu.conversion.toolutils.TypeFactory;
import com.overu.conversion.toolutils.Quality;
import com.overu.conversion.toolutils.Volume;

import java.util.HashSet;
import java.util.Set;

public class ConversionModule extends AbstractModule {

  public <T> void bindKey(Class<T> bind, int id, Class<? extends T> to) {
    bind(bind).annotatedWith(Names.named(id + "")).to(to).in(Singleton.class);
  }

  @Override
  protected void configure() {
    requestStaticInjection(ConversionType.class);
    bind(TypeFactory.class).asEagerSingleton();

    bindKey(ConversionType.class, R.string.longitude, Longitude.class);
    bindKey(ConversionType.class, R.string.area, Area.class);
    bindKey(ConversionType.class, R.string.quality, Quality.class);
    bindKey(ConversionType.class, R.string.volume, Volume.class);
    bindKey(ConversionType.class, R.string.temperature, Temperature.class);

    bind(new TypeLiteral<Set<Class<? extends ConversionType>>>() {
    }).toInstance(new HashSet<Class<? extends ConversionType>>() {
      {
        add(Longitude.class);
        add(Area.class);
        add(Volume.class);
        add(Quality.class);
        add(Temperature.class);
      }
    });

    bindKey(PubFragment.class, R.string.longitude, LongitudeFragment.class);
    bindKey(PubFragment.class, R.string.area, AreaFragment.class);
    bindKey(PubFragment.class, R.string.volume, VolumeFragment.class);
    bindKey(PubFragment.class, R.string.quality, QualityFragment.class);
    bindKey(PubFragment.class, R.string.temperature, TemperatureFragment.class);
  }
}
