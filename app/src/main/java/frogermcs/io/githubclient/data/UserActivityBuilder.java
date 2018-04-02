package frogermcs.io.githubclient.data;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import frogermcs.io.githubclient.ui.activity.RepositoriesListActivity;
import frogermcs.io.githubclient.ui.activity.RepositoryDetailsActivity;
import frogermcs.io.githubclient.ui.activity.component.RepositoriesListActivityComponent;
import frogermcs.io.githubclient.ui.activity.component.RepositoryDetailsActivityComponent;

@Module
public abstract class UserActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(RepositoriesListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindRepositoriesListActivity(RepositoriesListActivityComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(RepositoryDetailsActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindRepositoryDetailsActivity(RepositoryDetailsActivityComponent.Builder builder);

}
