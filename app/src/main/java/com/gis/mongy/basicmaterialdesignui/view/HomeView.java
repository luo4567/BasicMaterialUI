package com.gis.mongy.basicmaterialdesignui.view;


import com.gis.mongy.basiclibrary.base.BaseLazyFragment;
import com.gis.mongy.basicmaterialdesignui.bean.NavigationEntity;

import java.util.List;

public interface HomeView {

    void initializeViews(List<BaseLazyFragment> fragments, List<NavigationEntity> navigationList);

}
