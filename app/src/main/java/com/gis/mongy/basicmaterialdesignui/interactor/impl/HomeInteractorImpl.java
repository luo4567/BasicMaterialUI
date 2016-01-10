package com.gis.mongy.basicmaterialdesignui.interactor.impl;

import android.content.Context;

import com.gis.mongy.basiclibrary.base.BaseLazyFragment;
import com.gis.mongy.basicmaterialdesignui.R;
import com.gis.mongy.basicmaterialdesignui.bean.NavigationEntity;
import com.gis.mongy.basicmaterialdesignui.interactor.HomeInteractor;
import com.gis.mongy.basicmaterialdesignui.ui.fragment.ImagesContainerFragment;
import com.gis.mongy.basicmaterialdesignui.ui.fragment.MusicsFragment;
import com.gis.mongy.basicmaterialdesignui.ui.fragment.VideosContainerFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeInteractorImpl implements HomeInteractor {

    @Override
    public List<BaseLazyFragment> getPagerFragments() {
        List<BaseLazyFragment> fragments = new ArrayList<>();
        fragments.add(new ImagesContainerFragment());
        fragments.add(new VideosContainerFragment());
        fragments.add(new MusicsFragment());

        return fragments;
    }

    @Override
    public List<NavigationEntity> getNavigationListData(Context context) {
        List<NavigationEntity> navigationEntities = new ArrayList<>();
        String[] navigationArrays = context.getResources().getStringArray(R.array.navigation_list);
        navigationEntities.add(new NavigationEntity("", navigationArrays[0], R.mipmap.ic_picture));
        navigationEntities.add(new NavigationEntity("", navigationArrays[1], R.mipmap.ic_video));
        navigationEntities.add(new NavigationEntity("", navigationArrays[2], R.mipmap.ic_music));
        return navigationEntities;
    }
}
