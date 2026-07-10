# Java 后端

## 环境要求

- Java 17 or newer
- 首次下载 Maven 和项目依赖时需要网络连接

不需要另外安装 Maven。本后端已包含 `mvnw.cmd`，首次使用时会自动下载 Maven。

## 使用 VS Code PowerShell 终端运行

在此 `backend` 目录中打开终端，然后运行：

```powershell
.\mvnw.cmd spring-boot:run
```

首次运行可能需要几分钟，以下载 Maven 和项目依赖。

API 示例：`http://localhost:8080/api/weather?city=Singapore`
