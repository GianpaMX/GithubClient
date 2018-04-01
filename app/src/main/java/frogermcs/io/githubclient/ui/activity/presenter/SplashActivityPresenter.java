package frogermcs.io.githubclient.ui.activity.presenter;

import frogermcs.io.githubclient.HeavyLibraryWrapper;
import frogermcs.io.githubclient.data.api.UserManager;
import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.utils.SimpleObserver;
import frogermcs.io.githubclient.utils.Validator;

/**
 * Created by Miroslaw Stanek on 23.04.15.
 */
public class SplashActivityPresenter {
    public String username;

    private View view;
    private Validator validator;
    private UserManager userManager;
    private HeavyLibraryWrapper heavyLibraryWrapper;

    public SplashActivityPresenter(Validator validator,
                                   UserManager userManager, HeavyLibraryWrapper heavyLibraryWrapper) {
        this.validator = validator;
        this.userManager = userManager;
        this.heavyLibraryWrapper = heavyLibraryWrapper;

        //This calls should be delivered to ExternalLibrary right after it will be initialized
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
    }

    public void onShowRepositoriesClick() {
        if (validator.validUsername(username)) {
            if (view != null) view.showLoading(true);
            userManager.getUser(username).subscribe(new SimpleObserver<User>() {
                @Override
                public void onNext(User user) {
                    if (view != null) view.showLoading(false);
                    if (view != null) view.showRepositoriesListForUser(user);
                }

                @Override
                public void onError(Throwable e) {
                    if (view != null) view.showLoading(false);
                    if (view != null) view.showValidationError();
                }
            });
        } else {
            if (view != null) view.showValidationError();
        }
    }

    public void setView(View view) {
        this.view = view;
    }


    public interface View {
        void showRepositoriesListForUser(User user);

        void showValidationError();

        void showLoading(boolean loading);
    }
}
