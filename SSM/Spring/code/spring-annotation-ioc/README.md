## Spring的注解IOC实现

### Component注解
1. 想要实现IOC的注解，需要在配置文件中开启注解扫描，代码会扫描到指定包下的类注解
    ```xml
    <context:component-scan base-package="online.suiyu.annioc"/>
    ```
2. 在类上加上`@Component(value = "userService")`注解

3.在测试类中测试即可

### Component衍生注解
衍生注解，增强版本

1. `@Controller` :作用在WEB层
2. `@Service` :作用在业务层
3. `@Repository` :作用在持久层

### 属性注入

在类中可以直接使用注解注入属性
```java
@Value(value = "小明")
private String name;
```
此种方式可以省略属性的setter方法。

### 类的注入

需要在定义类时按照Component的衍生注解添加注解，然后就可以使用了。
在userDaoImpl中添加注解：
```java
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDao执行了！");
    }
}
```
使用时在类属性前加上`@Autowired`注解就可以实现自动按类型匹配：
```java
@Autowired
private UserDao userDao;
```
上方代码中没有明确写出要使用的Component，`@Autowired`表示自动匹配实现了UserDao的类，在出现多个实现了userDao的类后，这种方式将不在好用。
可以使用按name匹配的注解`@Qualifier`。
```java
@Autowired
@Qualifier(value = "userDao")
private UserDao userDao;
```
这样就可以完成按名称引入指定的类了。

**Java原生注解注入**

Spring支持使用`@Resource(name="userDao")`注入类，这个过程相当于`@Autowired
                                                 @Qualifier(value = "userDao")`的联合使用。

### 多例模式

通过`@Scope(value="")`注解可以修改类的单例与多例模式

```java
@Service(value = "userService")
@Scope(value = "prototype")
```
其中`singleton`为单例模式

### 初始化与销毁

```java
@PostConstruct
public void init() {
    System.out.println("初始化操作。。。");
}

@PreDestroy
public void destroy() {
    System.out.println("销毁操作。。。");
}
```
