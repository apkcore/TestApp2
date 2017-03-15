package com.apkcore.cardswipelayout.fragment;

import android.os.Bundle;

/**
 * Created by Kevin on 2016/11/20.
 * Blog:http://blog.csdn.net/student9128
 * Describe：the second fragment
 */

public class FragmentTwo extends BaseFragment {

    public static FragmentTwo newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(bundle);
        return fragment;
    }

}
