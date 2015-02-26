#include <com_zaoqibu_hellojni_HelloJNI.h>
#include <string.h>

JNIEXPORT jstring JNICALL Java_com_zaoqibu_hellojni_HelloJNI_stringFromJNI(JNIEnv *env, jobject thiz)
{
    return (*env)->NewStringUTF(env, "Hello from JNI!");
}