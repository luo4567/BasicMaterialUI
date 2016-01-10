package com.gis.mongy.basicmaterialdesignui.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.gis.mongy.basiclibrary.netstatus.NetUtils;
import com.gis.mongy.basicmaterialdesignui.Presenter.Presenter;
import com.gis.mongy.basicmaterialdesignui.Presenter.impl.SplashPresenterImpl;
import com.gis.mongy.basicmaterialdesignui.R;
import com.gis.mongy.basicmaterialdesignui.ui.activity.base.BaseActivity;
import com.gis.mongy.basicmaterialdesignui.view.SplashView;

import butterknife.InjectView;

/**
 * Created by luo on 16-1-4.
 */
public class SplashActivity extends BaseActivity implements SplashView {

    @InjectView(R.id.splash_image)
    ImageView mSplashImage;

    @InjectView(R.id.splash_version_name)
    TextView mVersionName;

    @InjectView(R.id.splash_copyright)
    TextView mCopyright;

    private Presenter mSplashPresenter = null;

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return false;
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected void initViewsAndEvents() {
        mSplashPresenter = new SplashPresenterImpl(this, this);
        mSplashPresenter.initialized();
    }

    @Override
    public void animateBackgroundImage(Animation animation) {
        mSplashImage.startAnimation(animation);
    }

    @Override
    public void initializeViews(String versionName, String copyright, int backgroundResId) {
        mCopyright.setText(copyright);
        mVersionName.setText(versionName);
        mSplashImage.setImageResource(backgroundResId);
    }

    @Override
    public void navigateToHomePage() {
        readyGoThenKill(HomeActivity.class);
    }
}
