package com.apkcore.cardswipelayout;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.apkcore.cardswipelayout.fragment.FragmentFour;
import com.apkcore.cardswipelayout.fragment.FragmentOne;
import com.apkcore.cardswipelayout.fragment.FragmentThree;
import com.apkcore.cardswipelayout.fragment.FragmentTwo;
import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;
    private FragmentFour mFragmentFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        /*** the setting for BadgeItem ***/

        BadgeItem badgeItem = new BadgeItem();
        badgeItem.setHideOnSelect(false)
                .setText("10")
                .setBackgroundColorResource(R.color.colorAccent)
                .setBorderWidth(0);

        /*** the setting for BottomNavigationBar ***/
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
//        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
//        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBarBackgroundColor(R.color.white);//set background color for navigation bar
        mBottomNavigationBar.setInActiveColor(R.color.blue);//unSelected icon color
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.tab_one).setActiveColorResource(R.color.green).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.tab_two).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.tab_three).setActiveColorResource(R.color.lime))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, R.string.tab_four))
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * set the default fragment
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mFragmentOne = FragmentOne.newInstance("First Fragment");
        transaction.replace(R.id.ll_content, mFragmentOne).commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mFragmentOne == null) {
                    mFragmentOne = FragmentOne.newInstance("First Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentOne);
                break;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo = FragmentTwo.newInstance("Second Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentTwo);
                break;
            case 2:
                if (mFragmentThree == null) {
                    mFragmentThree = FragmentThree.newInstance("Third Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentThree);
                break;
            case 3:
                if (mFragmentFour == null) {
                    mFragmentFour = FragmentFour.newInstance("Forth Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentFour);
                break;
            default:
                if (mFragmentOne == null) {
                    mFragmentOne = FragmentOne.newInstance("First Fragment");
                }
                transaction.replace(R.id.ll_content, mFragmentOne);
                break;
        }
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}