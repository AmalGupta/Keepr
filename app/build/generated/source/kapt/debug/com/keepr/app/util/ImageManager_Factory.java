package com.keepr.app.util;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ImageManager_Factory implements Factory<ImageManager> {
  private final Provider<Context> contextProvider;

  public ImageManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ImageManager get() {
    return newInstance(contextProvider.get());
  }

  public static ImageManager_Factory create(Provider<Context> contextProvider) {
    return new ImageManager_Factory(contextProvider);
  }

  public static ImageManager newInstance(Context context) {
    return new ImageManager(context);
  }
}
