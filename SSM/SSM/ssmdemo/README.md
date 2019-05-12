## 踩坑记

1. jdbc驱动和mysql版本号要一致
2. mysql8.0之后的驱动名为com.mysql.cj.jdbc.Driver
3. 链接url必须显式设置no ssl和时区

```properties
druid.driver=com.mysql.cj.jdbc.Driver
druid.url=jdbc:mysql://localhost:3306/school?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true
druid.username=root
druid.password=yuluo
```



