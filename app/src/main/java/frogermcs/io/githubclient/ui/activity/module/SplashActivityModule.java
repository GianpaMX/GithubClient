package frogermcs.io.githubclient.ui.activity.module;

import dagger.Module;
import dagger.Provides;
import frogermcs.io.githubclient.HeavyLibraryWrapper;
import frogermcs.io.githubclient.data.api.UserManager;
import frogermcs.io.githubclient.ui.activity.ActivityScope;
import frogermcs.io.githubclient.ui.activity.SplashActivity;
import frogermcs.io.githubclient.ui.activity.presenter.SplashActivityPresenter;
import frogermcs.io.githubclient.utils.Validator;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@Module
public class SplashActivityModule {

    @Provides
    @ActivityScope
    public SplashActivityPresenter provideSplashActivityPresenter(SplashActivity splashActivity, Validator validator, UserManager userManager, HeavyLibraryWrapper heavyLibraryWrapper) {
        SplashActivityPresenter presenter = new SplashActivityPresenter(validator, userManager, heavyLibraryWrapper);
        presenter.setView(splashActivity);
        return presenter;
    }
}
