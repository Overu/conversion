package com.overu.conversion;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import com.overu.conversion.toolutils.Area;
import com.overu.conversion.toolutils.ConversionType;
import com.overu.conversion.toolutils.Longitude;
import com.overu.conversion.toolutils.TypeFactory;

import java.util.HashSet;
import java.util.Set;

public class ConversionModule extends AbstractModule {

  @Override
  protected void configure() {
    requestStaticInjection(ConversionType.class);
    bind(TypeFactory.class).asEagerSingleton();

    bind(ConversionType.class).annotatedWith(Names.named(R.string.longitude + "")).to(Longitude.class).in(Singleton.class);
    bind(ConversionType.class).annotatedWith(Names.named(R.string.area + "")).to(Area.class).in(Singleton.class);

    bind(new TypeLiteral<Set<Class<? extends ConversionType>>>() {
    }).toInstance(new HashSet<Class<? extends ConversionType>>() {
      {
        add(Longitude.class);
        add(Area.class);
      }
    });
  }
}
