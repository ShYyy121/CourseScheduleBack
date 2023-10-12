![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/6545295e-f490-445e-ae77-70dca5954a94)# CourseScheduleBack-学校排课系统--Spring+Vue3+SQL Server
## 项目技术栈:
后端:

Spring Boot: Spring Boot是一个用于快速构建Spring应用程序的框架，提供了自动化配置和快速开发特性。
JPA (Java Persistence API): JPA是一种用于管理Java应用程序中的关系型数据的API，它可以与SQL Server等数据库进行集成，简化了数据访问。
RESTful风格: REST（Representational State Transfer）是一种设计风格，用于构建可伸缩、轻量级的Web服务，它通常使用HTTP协议来实现。
前端:

Vue 3: Vue.js是一个流行的JavaScript框架，用于构建现代、交互式的用户界面。
Vuetify 3: Vuetify是一个基于Vue的Material Design组件库，用于创建美观的前端界面。
Node.js: Node.js是一个JavaScript运行时环境，用于在服务器端运行JavaScript代码。
Yarn: Yarn是一个包管理工具，用于管理前端项目的依赖。

数据库:
SQL Server: SQL Server是Microsoft提供的关系型数据库管理系统（RDBMS），用于存储和管理数据。

开发工具:
Spring REST and HAL Browser: Spring的REST和HAL Browser是一个工具，用于浏览和测试RESTful API，特别是针对基于HAL（Hypertext Application Language）的API。

集成开发环境：
IntelliJ IDEA 2023.2：
用途：IntelliJ IDEA是一款广泛用于Java和其他编程语言开发的IDE。它提供了丰富的功能，包括代码编辑、调试、版本控制集成、构建工具支持等等。
特点：智能代码完成、静态代码分析、强大的调试工具、集成的版本控制支持（如Git）、内置构建工具支持（Maven、Gradle）、插件生态系统等。
适用领域：Java开发、Web应用程序开发、移动应用程序开发（Android等）、数据科学、机器学习等。

## 界面展示
### 登陆界面：根据不同角色，进入不同界面，采用spring security，对于没有权限的请求重定向至登陆界面
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/cca6ae67-7a3d-434a-bf76-e3253b7e1cae)
### 排课管理界面：可以进行单次/批量排课
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/d7a09c12-f52b-407c-8740-fa51b196ec32)
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/a5dd3851-ccd4-485f-86a7-e3d0c1be2395)
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/f2c8e438-d5ba-4088-bf79-4974e1eb0abc)
### 用户管理界面：对用户的信息进行维护，增删改查
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/285c0794-a89a-483e-812b-62bc18db1790)
### 课程查询：可以根据教师/教学班/每周进行查询，在每周查询中，可以点击（+）号直接进行课程的排课添加（已更新）
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/2696f49d-549c-41f6-abb9-60cec9396d04)
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/01ef8dd7-aa03-4388-a20a-f5a30be3d3f4)
### 机房信息管理：对机房进行维护，增删改查
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/fc72996b-cb40-41dc-ae74-0a9b4eb3e51a)
### 课程转换到正式课表中，老师和管理员可以对课表进行预先操作，最后由管理员统一转换到正式课表中，同时带有时间/教室冲突的检测
![image](https://github.com/ShYyy121/CourseScheduleBack/assets/145829122/e27507f3-5c5c-4d9c-8fc2-b78c2b116134)
# 具体需求详情见项目中的 机房排课软件功能需求.txt文件（https://github.com/ShYyy121/CourseScheduleBack/blob/master/%E6%9C%BA%E6%88%BF%E6%8E%92%E8%AF%BE%E8%BD%AF%E4%BB%B6%E5%8A%9F%E8%83%BD%E9%9C%80%E6%B1%82.txt）
