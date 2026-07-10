# Vue + Java Spring Boot 版本

后端要求：Java 21 和 Maven 3.9+

打开两个 Windows CMD 窗口。

后端：

```cmd
cd /d <项目目录>\vue-java\backend
mvn spring-boot:run
```

前端：

```cmd
cd /d <项目目录>\vue-java\frontend
npm install
npm run dev
```

前端：`http://localhost:5173`  
后端：`http://localhost:8080`  
API 示例：`http://localhost:8080/api/weather?city=Singapore`
