package frogermcs.io.githubclient;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import frogermcs.io.githubclient.data.UserComponent;
import frogermcs.io.githubclient.data.api.GithubApiModule;
import frogermcs.io.githubclient.data.api.UserModule;
import frogermcs.io.githubclient.ui.activity.module.ActivityBuilder;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                AppModule.class,
                GithubApiModule.class,
                ActivityBuilder.class
        }
)
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    UserComponent plus(UserModule userModule);

    void inject(GithubClientApplication githubClientApplication);
}
