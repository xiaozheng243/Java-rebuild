# spring cloud config decoupling auto refresh

## 设置rabbitmq用户及权限
```jshelllanguage
yuluo@DESKTOP-65PLVD0 MINGW64 /c/Program Files/RabbitMQ Server/rabbitmq_server-3.7.14/sbin
$ ./rabbitmqctl.bat add_user yuluo yuluo123
Adding user "yuluo" ...

yuluo@DESKTOP-65PLVD0 MINGW64 /c/Program Files/RabbitMQ Server/rabbitmq_server-3.7.14/sbin
$ ./rabbitmqctl.bat set_user_tags yuluo administrator
Setting tags for user "yuluo" to [administrator] ...

```

## 启动浏览器客户端页面
``` jshelllanguage
yuluo@DESKTOP-65PLVD0 MINGW64 /c/Program Files/RabbitMQ Server/rabbitmq_server-3.7.14/sbin
$ ./rabbitmq-plugins.bat enable rabbitmq_management

```