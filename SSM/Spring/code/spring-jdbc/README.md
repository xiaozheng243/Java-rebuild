## Spring下JDBC模板的使用

Spring自带了一个数据库连接池及数据库模板
其使用方式为
1. 注册一个`DriverManagerDataSource`类并传递其参数
2. 注册一个`JdbcTemplate`类并将`DriverManagerDataSource`传给给它当参数

```xml
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
    <property name="url" value="jdbc:mysql:///school"/>
    <property name="username" value="root"/>
    <property name="password" value="suiyu"/>
</bean>
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <property name="dataSource" ref="dataSource"/>
</bean>
```
然后，就能在测试类中使用了。
```java
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
String sql = "insert into stu values(?,?)";
jdbcTemplate.update(sql, 4, "Lisa");
```