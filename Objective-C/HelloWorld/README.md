## Hello World

### 源代码
```objective-c
#import <Foundation/Foundation.h>

int main(int argc, const char * argv[]) {
@autoreleasepool {
NSLog(@"Hello, World!");
}
return 0;
}
```

### 输出
```
2015-04-14 12:50:35.896 HelloWorld[1300:116063] Hello, World!
```

import  相同的头文件只加载一次

Foundation.h    目录：/Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX10.10.sdk/System/Library/Frameworks/Foundation.framework/Versions/C/Headers

NS  NextSTEP 的缩写

@   NString

NSLog   输出时间戳、自动增加换行符\n

