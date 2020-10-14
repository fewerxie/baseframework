# project name  
基础框架项目

# project introduce
后台框架    Spring + SpringMVC + Mybatis（通用mapper）

前台框架    react

数据库      oracle + druid + redis

运行前提    

    * 安装lombok插件
    * 安装oracle
    * 在本机maven库中安装oracle驱动
        * D:\app\Lenovo\product\11.1.0\db_1\jdbc\lib（我本地的安装路径）选择合适的jar包：
        * mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.1.0 -Dpackaging=jar -Dfile=D:\app\Lenovo\product\11.1.0\db_1\jdbc\lib\ojdbc6.jar 
        * 将本地D:\Program Files (x86)\apache-maven-3.2.1\repository\com\oracle\ojdbc6\11.2.0.1.0中ojdbc6-11.2.0.1.0.jar和ojdbc6-11.2.0.1.0.pom两个文件复制到
          C:\Users\Lenovo\.m2\repository\com\oracle\ojdbc6\11.2.0.1.0
        * 简单来说，先去本地oracle安装目录中找oracle驱动，通过maven把驱动安装到本地maven库，如果idea使用的是idea默认maven仓库位置，需要把本地maven里的jar文件和pom文件复制到idea默认仓库相同位置
    * 数据库需要执行项目根目录/doc/sql文件夹下的sql