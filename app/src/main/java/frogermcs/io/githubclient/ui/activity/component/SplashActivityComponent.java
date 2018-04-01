package frogermcs.io.githubclient.ui.activity.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import frogermcs.io.githubclient.ui.activity.ActivityScope;
import frogermcs.io.githubclient.ui.activity.SplashActivity;
import frogermcs.io.githubclient.ui.activity.module.SplashActivityModule;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivityComponent extends AndroidInjector<SplashActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SplashActivity> {
    }
}
