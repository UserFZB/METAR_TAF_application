package com.example.adapters;

import androidx.viewpager.widget.ViewPager;

import com.example.metar_taf.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CircularViewPageHandler implements ViewPager.OnPageChangeListener {

    private static final String TAG = "CircularViewPageHandler";

    ViewPager mViewPager;
    private int         mCurrentPosition;
    private int         mScrollState;
    BottomNavigationView bottomNav;

    public CircularViewPageHandler(final ViewPager viewPager, BottomNavigationView bottom) {
        mViewPager = viewPager;
        bottomNav = bottom;
    }

    @Override
    public void onPageSelected(final int position) {
        mCurrentPosition = position;
    }

    @Override
    public void onPageScrollStateChanged(final int state) {
        handleScrollState(state);
        mScrollState = state;
    }

    private void handleScrollState(final int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE && mScrollState == ViewPager.SCROLL_STATE_DRAGGING) {
            setNextItemIfNeeded();
        }
    }

    private void setNextItemIfNeeded() {
        if (!isScrollStateSettling()) {
            handleSetNextItem();
        }
    }

    private boolean isScrollStateSettling() {
        return mScrollState == ViewPager.SCROLL_STATE_SETTLING;
    }

    private void handleSetNextItem() {
        final int lastPosition = mViewPager.getAdapter().getCount() - 1;
        if(mCurrentPosition == 0) {
            mViewPager.setCurrentItem(lastPosition, true);
        } else if(mCurrentPosition == lastPosition) {
            mViewPager.setCurrentItem(0, true);
        }
    }

    @Override
    public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {
        bottomNav.setSelectedItemId(R.id.nav_station);
    }
}
