# Java basic

[TOC]

## Exception

*为Optional*做准备

```java
throw new ArithmeticException("除数为零");//其他方法抛出此异常，再打印
System.err.println("1:" + e);
System.out.println("------------");
System.err.println("2:" + e.getMessage());
System.out.println("------------");
System.err.println("3:" + e.getStackTrace());
```

```shell
1:java.lang.ArithmeticException: 除数为零
------------
2:除数为零
------------
3:[Ljava.lang.StackTraceElement;@f6f4d33
```



## Optional

```java
return Optional.ofNullable(user)
                .map(UserVO::getAge)
                .filter(age -> age > 0)
                .orElseThrow(() -> new NullPointerException("年龄为空"));
```

