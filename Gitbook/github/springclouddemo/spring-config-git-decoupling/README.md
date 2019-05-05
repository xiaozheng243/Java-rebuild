# spring cloud config decoupling

上个项目中使用的远程配置中，client直接从server中获取远程配置，这种方式耦合性太强，如果server出现问题，client也将无法正常使用。