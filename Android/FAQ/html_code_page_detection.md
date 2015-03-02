## HTML 代码页探测

### 代码

```java
private String getCharsetName(String url) {
    CodepageDetectorProxy codepageDetectorProxy = CodepageDetectorProxy.getInstance();

    codepageDetectorProxy.add(JChardetFacade.getInstance());
    codepageDetectorProxy.add(ASCIIDetector.getInstance());
    codepageDetectorProxy.add(UnicodeDetector.getInstance());

    Charset charset = Charset.forName("iso-8859-1");
    try {
        charset = codepageDetectorProxy.detectCodepage(new URL(url));
    } catch (IOException e) {
        e.printStackTrace();
    }

    Log.i("TEST", charset.name());
    return charset.name();
}
```

### 参考

* [cpdetector](http://cpdetector.sourceforge.net/usage.shtml)

