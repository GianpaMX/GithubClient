package frogermcs.io.githubclient.ui.activity.component;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import frogermcs.io.githubclient.ui.activity.ActivityScope;
import frogermcs.io.githubclient.ui.activity.RepositoriesListActivity;
import frogermcs.io.githubclient.ui.activity.module.RepositoriesListActivityModule;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
@ActivityScope
@Subcomponent(modules = RepositoriesListActivityModule.class)
public interface RepositoriesListActivityComponent extends AndroidInjector<RepositoriesListActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RepositoriesListActivity> {
    }
}
