#include "com_apkcore_tabstripdemo_ndk_MessageJni.h"

JNIEXPORT jstring JNICALL Java_com_apkcore_tabstripdemo_ndk_MessageJni_getString
        (JNIEnv *env, jclass jc)
{
    return env->NewStringUTF("Hello word !!!");
}