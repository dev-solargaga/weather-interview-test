# Vue + Python FastAPI 版本

后端要求：Python 3.11+

打开两个 Windows CMD 窗口。

后端：

```cmd
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

前端：`http://localhost:5173`  
后端：`http://localhost:8080`  
API 示例：`http://localhost:8080/api/weather?city=Singapore`
