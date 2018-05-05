## Spring下使用Druid数据库连接池

### 额外添加的JAR包

1. mysql connection包
2. Druid包

### 配置`DruidDataSource`
```xml
<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql://localhost:3306/school?useSSL=true"/>
    <property name="username" value="root"/>
    <property name="password" value="suiyu"/>
    <property name="initialSize" value="5"/>
    <property name="minIdle" value="1"/>
    <property name="maxActive" value="1000"/>
    <property name="poolPreparedStatements" value="false"/>
</bean>
```

### `JdbcTemplate`调用`DruidDataSource`

```xml
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <property name="dataSource" ref="dataSource"/>
</bean>
```

### 测试类

```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
String sql = "insert into stu values(?,?)";
jdbcTemplate.update(sql, 8, "Lisi");
System.out.println("执行完成！");
```