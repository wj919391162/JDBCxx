# JDBC实现

JDBC模拟实现：

```java
package com.jdbcmy;

/**
 *实现类
 **/

public class TestJDBC {
    public static void main(String[] args){

        Jdbcinterface jdbcinterface = new OracleJdbclmpl();
        jdbcinterface.getConnection(); //通过接口来调用实现类【动态绑定】
        jdbcinterface.crud();
        jdbcinterface.close();
    }
}
```



![未命名图片](H:\系统缓存\工具人\笔记\photo\未命名图片.png)



## Java Properties 类

Properties 继承于 Hashtable。表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。

Properties 类被许多 Java 类使用。例如，在获取环境变量时它就作为 System.getProperties() 方法的返回值。

Properties 定义如下实例变量.这个变量持有一个 Properties 对象相关的默认属性列表。



## Jdbc简单实现案例

```java
package com.JDBC;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *jdbc程序完成简单操作
 * * @version 1.8
 **/

public class Jdbc {
    public static void main(String[] args) throws SQLException {
        //再项目下创建一个文件夹把jar包导入
        //1：注册驱动
        Driver driver = new Driver();

        //2.得到连接(可以是host也可以是ip地址)
        //mysql的连接本质就是socket连接
        String url ="jdbc:mysql://localhost:3306/ppx_db01";
        //讲用户名和密码放入到properties对象中
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","ppx");

        Connection connect = driver.connect(url, properties);

        //3.执行sql;
        String sql ="delete from  users where id = 12";
        //statement-用于执行静态sql语句并返回其生成结果的对象
        Statement statement = connect.createStatement();
        int rows = statement.executeUpdate(sql); //如果是dml语句，返回的就是影响行数

        // 4.关闭资源
        System.out.println(rows>0?"success":"false");
        statement.close();
        connect.close();
    }
}
```

![2](H:\系统缓存\工具人\笔记\photo\2.png)

![3](H:\系统缓存\工具人\笔记\photo\3.png)

## 读取方式x5

1.通过将密码账户配置写进配置文件通过反射机制读取

2.可以不用写Class.forName-----底层的Driver类是个静态的代码块(在类加载阶段已经加载过一次并且自动注册了)

```properties
user=root
password =*******
url=jdbc:mysql://localhost:3306/ppx_db01
driver=com.mysql.jdbc.Driver
```

```java
public class Jdbc02 {
    
    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        //通过properties对象获取相关配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String psw = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName("com.mysql.jdbc.Driver");  //可以不写
        Connection connection = DriverManager.getConnection(url, user, psw);

        System.out.println("方式5="+connection);
    }
}
```



## ResultSet结果集

```java
ResultSet resultset = statment.executeQuery(sql);
```

```java
//用while来接受结果
while (resultset.next()){  
    int id =resultset.getInt(1);
    String name = resultset.getString(2);
    
    System.out.println(id+name);
}
```

