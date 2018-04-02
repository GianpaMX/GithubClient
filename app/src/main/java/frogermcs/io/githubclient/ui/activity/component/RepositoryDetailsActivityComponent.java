package frogermcs.io.githubclient.ui.activity.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import frogermcs.io.githubclient.ui.activity.ActivityScope;
import frogermcs.io.githubclient.ui.activity.RepositoryDetailsActivity;
import frogermcs.io.githubclient.ui.activity.module.RepositoryDetailsActivityModule;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(modules = RepositoryDetailsActivityModule.class)
public interface RepositoryDetailsActivityComponent extends AndroidInjector<RepositoryDetailsActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RepositoryDetailsActivity> {
    }
}
