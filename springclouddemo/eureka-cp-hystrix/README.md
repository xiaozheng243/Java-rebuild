## 服务相互调用--熔断器Hystrix

[原文](http://www.ityouknow.com/springcloud/2017/05/16/springcloud-hystrix.html)

注意点：
1. 文中添加的注释：`feign.hystrix.enabled=true` 可能在idea中不会被识别，但其确实可用。
2. 创建RemoteServer的实现类时，在调用时，idea可能会提示错误，这个错误可忽略，不影响运行，或者在RemoteServer上添加`@Primary`即可！