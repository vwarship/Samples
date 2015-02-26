## HelloJNI

1. 创建 HelloJNI 类
```java
package com.zaoqibu.hellojni;

public class HelloJNI {
    public native String  stringFromJNI();

    static {
        System.loadLibrary("hello-jni");
    }
}
```

* 原生方法的声明 public native String  stringFromJNI();
* 静态加载共享库，System.loadLibrary("hello-jni");。库的名字在 jni/Android.mk 文件中定义的 LOCAL_MODULE 变量。

2. javah

通过 Java 类生成头文件。

```
D:\Samples\Android\NDK\HelloJNI\app\src\main\java>javah com.zaoqibu.hellojni.HelloJNI
```

通过 class 生成头文件。（使用前得编译出 class 才能用）

```
D:\Samples\Android\NDK\HelloJNI\app>javah -classpath build/intermediates/classes/debug com.zaoqibu.hellojni.HelloJNI
```

3. 增加 jni 目录及文件
```
src
jni\
    Android.mk
    Application.mk
    com_zaoqibu_hellojni_HelloJNI.h
    com_zaoqibu_hellojni_HelloJNI.c
```

4. 原生方法的实现 com_zaoqibu_hellojni_HelloJNI.c
```c
#include <com_zaoqibu_hellojni_HelloJNI.h>
#include <string.h>

JNIEXPORT jstring JNICALL Java_com_zaoqibu_hellojni_HelloJNI_stringFromJNI(JNIEnv *env, jobject thiz)
{
    return (*env)->NewStringUTF(env, "Hello from JNI!");
}
```

5. 构建共享库的描述 Android.mk
```
LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := hello-jni
LOCAL_SRC_FILES := com_zaoqibu_hellojni_HelloJNI.c

include $(BUILD_SHARED_LIBRARY)
```

6. 生成所有支持的CPU体系结构的共享库 Application.mk
```
APP_ABI := all
```

7. 编译共享库 ndk_build
```
D:\Samples\Android\NDK\HelloJNI\app\jni>ndk_build
```
* 生成共享库到 libs 目录。

8. 修改 app 构建文件 build.gradle，打包 APK 时，增加共享库。
在 android 中增加
```json
    sourceSets {
        main {
            jniLibs.srcDirs = ['libs']
        }
    }
```

修改后
```json
apply plugin: 'com.android.application'

android {
    compileSdkVersion 21
    buildToolsVersion "21.1.1"

    defaultConfig {
        applicationId "com.zaoqibu.hellojni"
        minSdkVersion 14
        targetSdkVersion 21
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    sourceSets {
        main {
            jniLibs.srcDirs = ['libs']
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    compile 'com.android.support:appcompat-v7:21.0.3'
}
```

9. 调用原生方法。
```java
public class HelloJNIActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellojni);

        HelloJNI helloJNI = new HelloJNI();
        String hello = helloJNI.stringFromJNI();

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(hello);
    }

}
```

10. 运行。

![](hello-jni.png)
