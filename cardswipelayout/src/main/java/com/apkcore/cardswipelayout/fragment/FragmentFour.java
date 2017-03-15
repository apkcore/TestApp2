package com.apkcore.cardswipelayout.fragment;

import android.os.Bundle;

/**
 * Created by Kevin on 2016/11/20.
 * Blog:http://blog.csdn.net/student9128
 * Describe：the forth fragment
 */

public class FragmentFour extends BaseFragment {

    public static FragmentFour newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentFour fragment = new FragmentFour();
        fragment.setArguments(bundle);
        return fragment;
    }

}
