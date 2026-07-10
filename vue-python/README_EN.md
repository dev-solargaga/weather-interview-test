# Vue + Python FastAPI Variant

Backend requirements: Python 3.11+

Open two Windows CMD windows.

Backend:

```cmd
python -m venv .venv
call .venv\Scripts\activate.bat
python -m pip install -r requirements.txt
python -m uvicorn main:app --reload --port 8080
```

Frontend:

```cmd
cd /d <project-folder>\vue-python\frontend
npm install
npm run dev
```

Frontend: `http://localhost:5173`  
Backend: `http://localhost:8080`  
API example: `http://localhost:8080/api/weather?city=Singapore`
