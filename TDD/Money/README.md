﻿## 测试驱动开发 货币（Money）例子

### 测试驱动开发的节奏
1. 迅速地添加一个测试用例。
2. 执行所有的测试，查看新添加的测试用例的错误结果。
3. 少量修改代码。
4. 执行所有的测试，查看所有测试用例正确执行。
5. 对代码进行重构，消除重复。

### 快速消除测试用例错误的策略
1. 伪实现。使用一个常量代替。
2. 显示的实现。直接编写功能的实现代码。
3. 三角测量。有多个选择出现时。

### 值对象的模式
* 通过构造函数传入值，其它方法只有返回新的对象，不能够修改对象的值。