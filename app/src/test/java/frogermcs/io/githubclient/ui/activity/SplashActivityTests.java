package frogermcs.io.githubclient.ui.activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import frogermcs.io.githubclient.BuildConfig;
import frogermcs.io.githubclient.TestGithubClientApplication;
import frogermcs.io.githubclient.ui.activity.presenter.SplashActivityPresenter;
import frogermcs.io.githubclient.utils.AnalyticsManager;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

/**
 * Created by Miroslaw Stanek on 19.09.15.
 */
@RunWith(RobolectricTestRunner.class)
@Config(
        sdk = 18,
        constants = BuildConfig.class,
        application = TestGithubClientApplication.class
)
public class SplashActivityTests {

    @Mock
    SplashActivityPresenter splashActivityPresenter;

    @Mock
    AnalyticsManager analyticsManagerMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        TestGithubClientApplication app = (TestGithubClientApplication) RuntimeEnvironment.application;
        app.analyticsManager = analyticsManagerMock;
        app.splashActivityPresenter = splashActivityPresenter;
    }

    @Test
    public void testName() throws Exception {
        SplashActivity activity = Robolectric.setupActivity(SplashActivity.class);
        verify(activity.analyticsManager).logScreenView(anyString());
    }
}
