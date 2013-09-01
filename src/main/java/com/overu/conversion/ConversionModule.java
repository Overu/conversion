package com.overu.conversion;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import com.overu.conversion.fragment.AreaFragment;
import com.overu.conversion.fragment.LongitudeFragment;
import com.overu.conversion.fragment.PubFragment;
import com.overu.conversion.toolutils.Area;
import com.overu.conversion.toolutils.ConversionType;
import com.overu.conversion.toolutils.Longitude;
import com.overu.conversion.toolutils.TypeFactory;

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

    bind(new TypeLiteral<Set<Class<? extends ConversionType>>>() {
    }).toInstance(new HashSet<Class<? extends ConversionType>>() {
      {
        add(Longitude.class);
        add(Area.class);
      }
    });

    bindKey(PubFragment.class, R.string.longitude, LongitudeFragment.class);
    bindKey(PubFragment.class, R.string.area, AreaFragment.class);
  }
}
