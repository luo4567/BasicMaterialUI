package com.gis.mongy.basicmaterialdesignui.Presenter.impl;

import android.content.Context;

import com.gis.mongy.basicmaterialdesignui.Presenter.Presenter;
import com.gis.mongy.basicmaterialdesignui.interactor.HomeInteractor;
import com.gis.mongy.basicmaterialdesignui.interactor.impl.HomeInteractorImpl;
import com.gis.mongy.basicmaterialdesignui.view.HomeView;

/**
 * Created by luo on 16-1-5.
 */
public class HomePresenterImpl implements Presenter {

    private Context mContext = null;
    private HomeView mHomeView = null;
    private HomeInteractor mHomeInteractor = null;

    public HomePresenterImpl(Context context, HomeView homeView) {
        if (null == homeView) {
            throw new IllegalArgumentException("Constructor's parameters must not be Null");
        }

        mContext = context;
        mHomeView = homeView;
        mHomeInteractor = new HomeInteractorImpl();
    }

    @Override
    public void initialized() {
        mHomeView.initializeViews(mHomeInteractor.getPagerFragments(), mHomeInteractor.getNavigationListData(mContext));
    }
}
