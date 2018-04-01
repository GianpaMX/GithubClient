package frogermcs.io.githubclient.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewTextChangeEvent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import frogermcs.io.githubclient.GithubClientApplication;
import frogermcs.io.githubclient.R;
import frogermcs.io.githubclient.data.model.User;
import frogermcs.io.githubclient.ui.activity.presenter.SplashActivityPresenter;
import frogermcs.io.githubclient.utils.AnalyticsManager;
import rx.Subscription;
import rx.functions.Action1;


public class SplashActivity extends AppCompatActivity implements SplashActivityPresenter.View {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    @BindView(R.id.btnShowRepositories)
    Button btnShowRepositories;

    //These references will be satisfied by 'SplashActivityComponent.inject(this)' method
    @Inject
    public
    SplashActivityPresenter presenter;
    @Inject
    public
    AnalyticsManager analyticsManager;

    private Subscription textChangeSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        analyticsManager.logScreenView(getClass().getName());

        textChangeSubscription = RxTextView.textChangeEvents(etUsername).subscribe(new Action1<TextViewTextChangeEvent>() {
            @Override
            public void call(TextViewTextChangeEvent textViewTextChangeEvent) {
                presenter.username = textViewTextChangeEvent.text().toString();
                etUsername.setError(null);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.setView(null);
        textChangeSubscription.unsubscribe();
    }

    @OnClick(R.id.btnShowRepositories)
    public void onShowRepositoriesClick() {
        presenter.onShowRepositoriesClick();
    }

    @Override
    public void showRepositoriesListForUser(User user) {
        GithubClientApplication.get(this).createUserComponent(user);
        startActivity(new Intent(this, RepositoriesListActivity.class));
    }

    @Override
    public void showValidationError() {
        etUsername.setError("Validation error");
    }

    @Override
    public void showLoading(boolean loading) {
        btnShowRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}
