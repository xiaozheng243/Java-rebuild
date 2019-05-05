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

## 执行查询操作

### 查询一条信息
查询一条信息使用的是`JabcTemplate`类的`queryForObject`方法操作，因为该方法接收一个`RowMapper`接口，所以使用时需要一个实现RowMapper接口的类。

类`BeanMapper`：
```java
class BeanMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        return user;
    }
}
```
使用：
```java
String sql = "select * from stu where id=?";
User user = jdbcTemplate.queryForObject(sql, new BeanMapper(), 2);
System.out.println(user);
```

### 查询多条信息

使用query操作

```java
String sql = "select * from stu where name like ?";
List<User> list = jdbcTemplate.query(sql, new BeanMapper(),"%s%");
for (User user : list) {
    System.out.println(user);
}
```
也会接收一个RowMapper操作，因此，同样可以使用BeanMapper。