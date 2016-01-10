package com.gis.mongy.basicmaterialdesignui.Presenter.impl;

import android.content.Context;
import android.view.animation.Animation;

import com.gis.mongy.basicmaterialdesignui.Presenter.Presenter;
import com.gis.mongy.basicmaterialdesignui.interactor.SplashInteractor;
import com.gis.mongy.basicmaterialdesignui.interactor.impl.SplashInteractorImpl;
import com.gis.mongy.basicmaterialdesignui.view.SplashView;

/**
 * Created by luo on 16-1-4.
 */
public class SplashPresenterImpl implements Presenter {

    private Context mContext = null;
    private SplashView mSplashView = null;
    private SplashInteractor mSplashInteractor = null;

    public SplashPresenterImpl(Context context,SplashView splashView) {
        if (null == splashView) {
            throw new IllegalArgumentException("构造参数不能为空！");
        }

        mContext = context;
        mSplashView = splashView;
        mSplashInteractor = new SplashInteractorImpl();
    }

    @Override
    public void initialized() {
        mSplashView.initializeViews(mSplashInteractor.getVersionName(mContext),
                mSplashInteractor.getCopyright(mContext),
                mSplashInteractor.getBackgroundImageResID());

        Animation animation = mSplashInteractor.getBackgroundImageAnimation(mContext);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mSplashView.navigateToHomePage();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mSplashView.animateBackgroundImage(animation);
    }
}
