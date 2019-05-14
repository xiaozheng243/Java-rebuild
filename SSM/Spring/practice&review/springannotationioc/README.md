## 使用注解形式的AOP

- **引入注解约束，配置组件扫描**
- **类上的注解： @Conponent  @Controller @Service @Repository**
- **普通属性的注解   @value**
- **对象属性的注解    @Resource   @Autowired  @Qualifier**
- **Bean生命周期，初始化与销毁: @PostConstruct @PreDestroy**
- **Bean作用范围：@Scope("prototype")  ， 默认是singleton**

获取Bean时需要在Spring核心配置文件中加入包扫描

```xml
<context:component-scan base-package="online.yuluo"/>
```

然后调用Bean时需要使用引入ApplicationContext配置文件。