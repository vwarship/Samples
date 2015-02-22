## 在代码中指定度量单位

### 使用函数 TypedValue.applyDimension
```java
TypedValue.applyDimension(unit, value, getResources().getDisplayMetrics());

// 可以指定的度量单位
TypedValue.COMPLEX_UNIT_PX	//complex unit: Value is raw pixels.
TypedValue.COMPLEX_UNIT_DIP	//complex unit: Value is Device Independent Pixels.
TypedValue.COMPLEX_UNIT_SP	//complex unit: Value is a scaled pixel.
TypedValue.COMPLEX_UNIT_PT	//complex unit: Value is in points.
TypedValue.COMPLEX_UNIT_IN	//complex unit: Value is in inches.
TypedValue.COMPLEX_UNIT_MM	//complex unit: Value is in millimeters.
```

### 例子：创建 TextView 的代码
```java
TextView textView = new TextView(this);
textView.setText(R.string.hello_world);
int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
        40, getResources().getDisplayMetrics());
textView.setPadding(padding, padding, padding, padding);
textView.setTextSize(40);
```
* setTextSize 不需要进行单位转换，40的位置是 sp。因为内部指定了单位 TypedValue.COMPLEX_UNIT_SP。

和下面的代码对等
```xml
<TextView android:text="@string/hello_world"
		android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:padding="40dp"
    android:textSize="40sp"/>
```