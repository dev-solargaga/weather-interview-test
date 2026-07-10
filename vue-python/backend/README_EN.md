# Python Backend

## Requirements

- Python 3.11+

## Run in VS Code Terminal

```Powershell
.\.venv\Scripts\Activate.ps1
python -m pip install -r requirements.txt
python -m uvicorn main:app --reload --port 8080
```

API example: `http://localhost:8080/api/weather?city=Singapore`
