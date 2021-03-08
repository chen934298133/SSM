# &#127800; Spring IOC &#127800;

## &#127800; 1 由原来的方式引入(dao、pojo、service)

### &#127800; 1.1 初始工程
1. 先写一个UserDao接口
```java
public interface UserDao {
   public void getUser();
}
```
2. 再去写Dao的实现类
```java
public class UserDaoImpl implements UserDao {
   @Override
   public void getUser() {
       System.out.println("获取用户数据");
  }
}
```
3. 然后去写UserService的接口
```java
public interface UserService {
   public void getUser();
}
```
4. 最后写Service的实现类
```java
public class UserServiceImpl implements UserService {
   private UserDao userDao = new UserDaoImpl();

   @Override
   public void getUser() {
       userDao.getUser();
  }
}
```
5. 测试一下
```java
@Test
public void test(){
   UserService service = new UserServiceImpl();
   service.getUser();
}
```

### &#127800; 1.2 原有工程进展

1. 把Userdao的实现类增加一个
```java
public class UserDaoMySqlImpl implements UserDao {
   @Override
   public void getUser() {
       System.out.println("MySql获取用户数据");
  }
}
```
2. 紧接着我们要去使用MySql的话 , 我们就需要去service实现类里面修改对应的实现
```java
public class UserServiceImpl implements UserService {
   private UserDao userDao = new UserDaoMySqlImpl();

   @Override
   public void getUser() {
       userDao.getUser();
  }
}
```
3. 在假设, 我们再增加一个Userdao的实现类
```java
public class UserDaoOracleImpl implements UserDao {
   @Override
   public void getUser() {
       System.out.println("Oracle获取用户数据");
  }
}
```
4. 那么我们要使用 `Oracle` , 又需要去 `service实现类` 里面修改对应的实现 . 假设我们的这种需求非常大 , 这种方式就根本不适用了, 每次变动 , 都需要修改大量代码。
    - 这种设计的**耦合性太高**, 牵一发而动全身

### &#127800; 1.3 耦合性太高解决方式 ：留出一个接口 , 利用set

1. 在需要用到他的地方 , 不去实现它 , 而是留出一个接口 , 利用set 
```java
public class UserServiceImpl implements UserService {
   private UserDao userDao;
// 利用set实现
   public void setUserDao(UserDao userDao) {
       this.userDao = userDao;
  }

   @Override
   public void getUser() {
       userDao.getUser();
  }
}
```
2. 测试类里 , 进行测试 
```java
@Test
public void test(){
   UserServiceImpl service = new UserServiceImpl();
   service.setUserDao( new UserDaoMySqlImpl() );
   service.getUser();
   //那我们现在又想用Oracle去实现呢
   service.setUserDao( new UserDaoOracleImpl() );
   service.getUser();
}
```

- 以前所有东西都是**由程序去进行控制创建** , 而现在是**由程序员自行控制创建对象** ,
  - 把主动权交给了调用者
  - 程序不用去管怎么创建, 怎么实现了, 它只负责提供一个接口

### &#127800; 1.4 IOC的原型 : 

- 这种思想 , 从本质上解决了问题 , 程序员不再去管理对象的创建了 , 更多的去关注业务的实现 . 耦合性大大降低 . 这也就是IOC的原型 !

## &#127800; 2 IOC本质

- 控制反转 `IoC`(Inversion of Control)，是一种设计思想，`DI`(依赖注入)是实现 `IoC` 的一种方法，也有人认为 `DI` 只是 `IoC` 的另一种说法。
- 没有 `IoC` 的程序中 , 我们使用**面向对象编程** , 对象的创建与对象间的依赖关系完全**硬编码在程序中**，对象的创建**由程序自己控制**，控制反转后将对象的创建转移给第三方
- 个人认为所谓**控制反转**就是：
  - **获得依赖对象的方式反转了。**
  
![](http://lc-dDwI9S44.cn-n1.lcfile.com/672c60f511f23bbeb1b2.png/%E8%A7%A3%E8%80%A6%E8%BF%87%E7%A8%8B.png)

- `IoC` 是 `Spring` 框架的核心内容，使用多种方式完美的实现了 `IoC` ，可以使用 **XML配置**，也可以使用 **注解**，新版本的 `Spring` 也可以**零配置实现`IoC`**。

- Spring容器在初始化时先读取配置文件，根据配置文件或元数据创建与组织对象存入容器中，程序使用时再从Ioc容器中取出需要的对象。

![Spring初始化过程](http://lc-dDwI9S44.cn-n1.lcfile.com/e3c7b7fa1f039af35fae.png/spring%E5%88%9D%E5%A7%8B%E5%8C%96%E8%BF%87%E7%A8%8B.png)
- 采用 `XML` 方式 配置 `Bean` 的时候，`Bean` 的定义信息是和实现分离的，而采用**注解**的方式可以把两者合为一体，`Bean` 的定义信息直接以注解的形式定义在实现类中，从而达到了**零配置**的目的。

- **控制反转** 是一种通过描述（**`XML`或注解**）并通过第三方去生产或获取特定对象的方式。在 `Spring` 中实现控制反转的是`IoC容器`，其实现方法是**依赖注入**（Dependency Injection,`DI`）。
