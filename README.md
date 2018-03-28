# spring_aop
spring aop练习：手动、注解方法进行aop操作

AOP相关名词：

1.切入面

2.切入点

3.织入

4.五种通知Advice：before、after、after-returning、after-throwing、around

5.在before方法中通过org.aspectj.lang.JoinPoint可以获取织入的信息，比如类（接口）、方法、方法参数；可用于保存访问的记录信息

6.在after方法中可以获取方法的返回值；可用于保存访问的记录信息

一、配置文件编写AOP

1.spring-aop.xml配置切面Bean

2.spring-aop.xml配置切面属性

二、注解编写AOP

1.注解的切面类：@Aspect @Component

2.spring-aopAuto.xml设置AOP自动代理
