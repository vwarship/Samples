#include <string.h>
#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_zaoqibu_hellojni_HelloJNIActivity_stringFromJNI(JNIEnv *env, jobject thiz)
{
    return (*env)->NewStringUTF(env, "Hello from JNI!");
}