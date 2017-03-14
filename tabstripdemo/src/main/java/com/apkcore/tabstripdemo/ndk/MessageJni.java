package com.apkcore.tabstripdemo.ndk;

public class MessageJni {

    public static native String getString();

    static {
        System.loadLibrary("NdkTest");
    }

}
