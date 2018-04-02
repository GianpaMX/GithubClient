package frogermcs.io.githubclient.data.api;

import dagger.Module;
import dagger.Provides;
import frogermcs.io.githubclient.data.UserScope;
import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.ui.activity.component.RepositoriesListActivityComponent;
import frogermcs.io.githubclient.ui.activity.component.RepositoryDetailsActivityComponent;

/**
 * Created by Miroslaw Stanek on 23.06.15.
 */
@Module(subcomponents = {
        RepositoriesListActivityComponent.class,
        RepositoryDetailsActivityComponent.class})
public class UserModule {
    @Provides
    @UserScope
    RepositoriesManager provideRepositoriesManager(User user, GithubApiService githubApiService) {
        return new RepositoriesManager(user, githubApiService);
    }
}
