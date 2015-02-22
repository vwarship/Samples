## Using Code Create Layout

### 一般使用 XML 在资源中定义布局
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView android:text="名字"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <EditText
        android:text="军舰"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

</LinearLayout>
```

### 使用代码创建同样的布局
```java
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        
        TextView textView = new TextView(this);
        textView.setText("名字");
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);

        EditText editText = new EditText(this);
        editText.setText("军舰");
        editText.setLayoutParams(layoutParams);
        linearLayout.addView(editText);

        setContentView(linearLayout);
    }
    
}
```