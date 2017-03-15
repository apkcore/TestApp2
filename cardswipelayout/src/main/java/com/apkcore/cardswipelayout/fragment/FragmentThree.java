package com.apkcore.cardswipelayout.fragment;

import android.os.Bundle;


/**
 * Created by Kevin on 2016/11/20.
 * Blog:http://blog.csdn.net/student9128
 * Describe：the third fragment
 */

public class FragmentThree extends BaseFragment {

    public static FragmentThree newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(bundle);
        return fragment;
    }
}
