/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gis.mongy.basicmaterialdesignui.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;

import com.gis.mongy.basiclibrary.eventbus.EventCenter;
import com.gis.mongy.basiclibrary.netstatus.NetUtils;
import com.gis.mongy.basiclibrary.utils.CommonUtils;
import com.gis.mongy.basiclibrary.widgets.XSwipeRefreshLayout;
import com.gis.mongy.basicmaterialdesignui.R;
import com.gis.mongy.basicmaterialdesignui.common.Constants;
import com.gis.mongy.basicmaterialdesignui.common.OnCommonPageSelectedListener;
import com.gis.mongy.basicmaterialdesignui.ui.activity.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class ImagesContainerFragment extends BaseFragment  {

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected void onFirstUserInvisible() {

    }

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected int getContentViewLayoutID() {
        return 0;
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }
}
