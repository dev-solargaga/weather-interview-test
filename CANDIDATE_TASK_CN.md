# 天气应用——第二轮面试技术测试

本压缩包包含同一个天气应用的两种全栈实现：

1. `vue-java` — Vue 3 + Vite 前端，Java Spring Boot 后端
2. `vue-python` — Vue 3 + Vite 前端，Python FastAPI 后端

一般只需分配其中一个版本给候选人。只有在面试需要比较 Java 与 Python 实现时，才同时使用两个版本。

应用通过 Open-Meteo 获取天气数据，不需要 API Key。

## 文档

- `CANDIDATE_TASK_EN.md` — 英文候选人任务说明
- `CANDIDATE_TASK_CN.md` — 中文候选人任务说明
- `INTERVIEWER_GUIDE_EN.md` — 英文面试官内部指南
- `INTERVIEWER_GUIDE_CN.md` — 中文面试官内部指南

进行盲测时，不要把面试官指南发给候选人。

## 建议面试流程

- 20–30 分钟：检查并运行项目
- 45–60 分钟：修复、改进或扩展功能
- 15–20 分钟：说明技术决定与取舍

## Windows CMD 运行方式

打开两个独立的 CMD 窗口。一个运行后端，另一个运行前端。

请将 `<项目目录>` 替换为解压后的 `weather-interview-test` 文件夹完整路径。

### Vue + Python

后端：

```cmd
cd /d <项目目录>\vue-python\backend
python -m venv .venv
call .venv\Scripts\activate.bat
python -m pip install -r requirements.txt
python -m uvicorn main:app --reload --port 8080
```

前端：

```cmd
cd /d <项目目录>\vue-python\frontend
npm install
npm run dev
```

### Vue + Java

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

前端地址：`http://localhost:5173`  
后端地址：`http://localhost:8080`  
后端 API 示例：`http://localhost:8080/api/weather?city=Singapore`

### 允许使用 AI 工具。但是，在要求 AI 修改代码之前，你必须先说明自己对问题的理解，并解释你认为可行的解决方案。使用 AI 后，你也必须自行检查、测试并验证修改后的代码，以便在后续讨论中清楚说明所做的改动。

### 我们会根据候选人使用 AI 的方式进行公平且综合的评估。候选人不会仅仅因为使用 AI 而被扣分；我们更关注的是 AI 是否被合理使用、候选人是否真正理解所提出的解决方案，以及是否能够自行检查、测试、验证并解释最终代码。