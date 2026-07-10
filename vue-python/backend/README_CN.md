# Python 后端

## 环境要求

- Python 3.11+

## 使用 VS Code Terminal 运行

```Powershell
.\.venv\Scripts\Activate.ps1
python -m pip install -r requirements.txt
python -m uvicorn main:app --reload --port 8080
```

API 示例：`http://localhost:8080/api/weather?city=Singapore`
