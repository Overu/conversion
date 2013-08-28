package com.overu.conversion.toolutils;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import java.util.Set;
import android.app.Application;
import android.content.res.Resources;

@Singleton
public class TypeFactory {

  private Injector injector;
  @Inject
  Application context;
  @Inject
  Resources res;

  private Set<Class<? extends ConversionType>> typeCls;

  @Inject
  public TypeFactory(Set<Class<? extends ConversionType>> typeCls, Injector injector) {
    this.typeCls = typeCls;
    this.injector = injector;
    for (Class<? extends ConversionType> typeCl : this.typeCls) {
      ConversionType conType = this.injector.getInstance(typeCl);
      conType.init();
    }
  }

  @SuppressWarnings("cast")
  public ConversionType getType(String type) {
    ConversionType conType = null;
    int identifier = res.getIdentifier(type, "string", context.getPackageName());
    conType = (ConversionType) injector.getInstance(Key.get(ConversionType.class, Names.named(identifier + "")));
    return conType;
  }
}
