package com.gis.mongy.basicmaterialdesignui.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gis.mongy.basiclibrary.adapter.ListViewDataAdapter;
import com.gis.mongy.basiclibrary.adapter.ViewHolderBase;
import com.gis.mongy.basiclibrary.adapter.ViewHolderCreator;
import com.gis.mongy.basiclibrary.base.BaseLazyFragment;
import com.gis.mongy.basiclibrary.netstatus.NetUtils;
import com.gis.mongy.basiclibrary.widgets.XViewPager;
import com.gis.mongy.basicmaterialdesignui.Presenter.Presenter;
import com.gis.mongy.basicmaterialdesignui.Presenter.impl.HomePresenterImpl;
import com.gis.mongy.basicmaterialdesignui.R;
import com.gis.mongy.basicmaterialdesignui.bean.NavigationEntity;
import com.gis.mongy.basicmaterialdesignui.ui.activity.base.BaseActivity;
import com.gis.mongy.basicmaterialdesignui.ui.adpter.VPFragmentAdapter;
import com.gis.mongy.basicmaterialdesignui.view.HomeView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by luo on 16-1-4.
 */
public class HomeActivity extends BaseActivity implements HomeView {

    private static long DOUBLE_CLICK_TIME = 0L;

    @InjectView(R.id.home_container)
    XViewPager mViewPager;

    @InjectView(R.id.home_navigation_list)
    ListView mNavListView;

    @InjectView(R.id.home_drawer)
    DrawerLayout mDrawerLayout;

    private int mCheckedListItemColorResIds[] = {
            R.color.navigation_checked_picture_text_color,
            R.color.navigation_checked_video_text_color,
            R.color.navigation_checked_music_text_color,
    };

    private int mCurrentMenuCheckedPos = 0;
    private ActionBarDrawerToggle mActionBarDrawerToggle = null;
    private ListViewDataAdapter<NavigationEntity> mNavListAdapter = null;

    private Presenter mHomePresenter = null;

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return true;
    }

    @Override
    protected View getLoadingTargetView() {
        return ButterKnife.findById(this, R.id.home_container);
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_home;
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
        return true;
    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected void initViewsAndEvents() {
        mHomePresenter = new HomePresenterImpl(this, this);
        mHomePresenter.initialized();
    }

    @Override
    public void initializeViews(List<BaseLazyFragment> fragments, List<NavigationEntity> navigationList) {
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                setTitle(getString(R.string.app_name));
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (null != mNavListAdapter) {
                    setTitle(mNavListAdapter.getItem(mCurrentMenuCheckedPos).getName());
                }
            }
        };

        mActionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);

        if (null != fragments && !fragments.isEmpty()) {
            mViewPager.setEnableScroll(false);
            mViewPager.setOffscreenPageLimit(fragments.size());
            mViewPager.setAdapter(new VPFragmentAdapter(getSupportFragmentManager(), fragments));
        }

        mNavListAdapter = new ListViewDataAdapter<NavigationEntity>(new ViewHolderCreator<NavigationEntity>() {

            @Override
            public ViewHolderBase<NavigationEntity> createViewHolder(int position) {

                return new ViewHolderBase<NavigationEntity>() {

                    ImageView itemIcon;
                    TextView itemName;

                    @Override
                    public View createView(LayoutInflater layoutInflater) {
                        View convertView = layoutInflater.inflate(R.layout.list_item_navigation, null);
                        itemIcon = ButterKnife.findById(convertView, R.id.list_item_navigation_icon);
                        itemName = ButterKnife.findById(convertView, R.id.list_item_navigation_name);

                        return convertView;
                    }

                    @Override
                    public void showData(int i, NavigationEntity navigationEntity) {
                        itemIcon.setImageResource(navigationEntity.getIconResId());
                        itemName.setText(navigationEntity.getName());

                        if (mCurrentMenuCheckedPos == i) {
                            // checked
                            itemName.setTextColor(getResources().getColor(mCheckedListItemColorResIds[i]));
                        } else {
                            // unchecked
                            itemName.setTextColor(getResources().getColor(android.R.color.black));
                        }
                    }
                };
            }
        });

        mNavListView.setAdapter(mNavListAdapter);
        mNavListAdapter.getDataList().addAll(navigationList);
        mNavListAdapter.notifyDataSetChanged();
        setTitle(mNavListAdapter.getItem(mCurrentMenuCheckedPos).getName());

        mNavListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentMenuCheckedPos = position;
                mNavListAdapter.notifyDataSetChanged();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                mViewPager.setCurrentItem(mCurrentMenuCheckedPos, false);
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (mActionBarDrawerToggle != null) {
            mActionBarDrawerToggle.syncState();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mActionBarDrawerToggle != null) {
            mActionBarDrawerToggle.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle != null && mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
/*            case R.id.action_capture:
                readyGo(CaptureActivity.class);
                break;
            case R.id.action_about_us:
                readyGo(AboutUsActivity.class);
                break;
            case R.id.action_feedback:
                Bundle extras = new Bundle();
                extras.putString(FeedbackFragment.BUNDLE_KEY_CONVERSATION_ID, mFeedbackAgent.getDefaultConversation().getId());
                readyGo(FeedBackActivity.class, extras);
                break;*/
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
            return true;
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                if ((System.currentTimeMillis() - DOUBLE_CLICK_TIME) > 2000) {
                    showToast(getString(R.string.double_click_exit));
                    DOUBLE_CLICK_TIME = System.currentTimeMillis();
                } else {
                    //getBaseApplication().exitApp();
                }
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
