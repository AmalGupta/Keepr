package com.keepr.app.di;

import android.content.Context;
import com.keepr.app.util.ImageManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class UtilModule_ProvideImageManagerFactory implements Factory<ImageManager> {
  private final Provider<Context> contextProvider;

  public UtilModule_ProvideImageManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ImageManager get() {
    return provideImageManager(contextProvider.get());
  }

  public static UtilModule_ProvideImageManagerFactory create(Provider<Context> contextProvider) {
    return new UtilModule_ProvideImageManagerFactory(contextProvider);
  }

  public static ImageManager provideImageManager(Context context) {
    return Preconditions.checkNotNullFromProvides(UtilModule.INSTANCE.provideImageManager(context));
  }
}
