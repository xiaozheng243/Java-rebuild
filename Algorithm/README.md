## 算法

[TOC]

### 二分查找（BinarySearch）

1. 给数组取开始和结束标识位
2. 通过开始和结束位生成中间位
3. 如果目标数字与中间位数字相等，返回
4. 如果目标数字小于中间位数字，那么目标数字处于开始位和中间位之间，所以，给结束位赋值中间位-1
5. 如果目标数字大于中间位数字，那么目标数字处于结束位和中间位之间，所以，给开始位赋值中间位+1
6. 重复2-5，直到开始位与结束位相同，返回



### 冒泡排序（BubbleSort）

[可视化排序](https://visualgo.net/en/sorting)

