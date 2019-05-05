# spring cloud config decoupling auto refresh

因为上个项目中，如果远程修改了配置文件，那么我们需要重启项目来刷新配置，这显然不合理！
因此，可以设置成当git仓库发生变动时，项目自动刷新配置。
webhook在项目下的setting可以设置，一般只用于线上项目，毕竟需要出发链接。