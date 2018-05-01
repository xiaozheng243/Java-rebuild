# 通过XML实现Spring的IOC

## 简介

此项目是复习Spring的第一个项目，主要是使用XML实现对Spring IOC的控制。

实现Spring项目的步骤为：
1. 下载并加载Spring的JAR包
2. 创建包、接口及接口实现类
3. 将实现类加载到配置文件spring-config.xml或者applicationContext.xml中 `    <bean id="userService" class="UserServiceImpl"/>`
4. 编写测试文件

```java
public class Test{
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService =applicatonContext.getBean("userService");
        userService.sayHello();
    }
}

```

Spring框架的IOC控制主要引用了如下几个jar包
* Beans
* Core
* Context
* Expression Language

## 配置文件

``` xml
<bean id="userService" class="UserServiceImpl" name="/userService" init-method="init" destroy-method="destroy/>

```
* bean标签可以拥有id、class、name属性，name与id的作用相同（标识当前类），name可以存在特殊符号，id不可以
* class为Bean属性的全路径名
* scope属性：Bean的作用范围
    * singleton：单例模式
    * prototype：多例模式
    * request：每次HTTP请求会创建新的Bean
    * session：同一个HTTP Session共享一个session
    * globalsession：多个服务器之间共享同一个session

初始化与销毁操作可以在userService中自定义

## 在配置文件中注入属性
### setter方式注入
常规的调用属性是在类中创建一个属性然后使用getter与setter获取或者添加属性，在spring中可以使用配置文件中的property的方式给属性复制。前提是你已经在class类中添加了属性与其setter方法。
类引用的方式与之相同，唯一的区别在于引用类使用的是ref

### 构造器方式注入
构造器注入可以使用索引和name的方式。

```xml
<bean id="userDao" class="UserDaoImple">
    <constructor-arg index="0" value="小红"/>
    <constructor-arg name="password" value="xiaohong123"/>
</bean>
```

### 注入数组与集合
数组的注入与list相同，如果想要注入集合的元素是对象，可以使用`value-ref`引用对象。

```xml
<property name="array">
    <list>
        <value>呵呵</value>
        <value>嘿嘿</value>
        <value>哈哈</value>
    </list>
</property>
<property name="list">
    <list>
        <value>list0</value>
        <value>list1</value>
        <value>list2</value>
    </list>
</property>
<property name="set">
    <set>
        <value>set0</value>
        <value>set1</value>
        <value>set2</value>
    </set>
</property>
<property name="map">
    <map>
        <entry key="1" value="map0"/>
        <entry key="2" value="map1"/>
        <entry key="3" value="map2"/>
    </map>
</property>
```