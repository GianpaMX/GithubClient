package frogermcs.io.githubclient;

import android.app.Activity;

import dagger.android.AndroidInjector;
import frogermcs.io.githubclient.ui.activity.SplashActivity;
import frogermcs.io.githubclient.ui.activity.presenter.SplashActivityPresenter;
import frogermcs.io.githubclient.utils.AnalyticsManager;

/**
 * Created by Miroslaw Stanek on 19.09.15.
 */
public class TestGithubClientApplication
        extends GithubClientApplication {

    public SplashActivityPresenter splashActivityPresenter;
    public AnalyticsManager analyticsManager;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return new AndroidInjector<Activity>() {
            @Override
            public void inject(Activity instance) {
                SplashActivity activity = (SplashActivity) instance;
                activity.presenter = splashActivityPresenter;
                activity.analyticsManager = analyticsManager;
            }
        };
    }
}
