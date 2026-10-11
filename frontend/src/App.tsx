import React, { useState } from 'react';
import { CalculateApi, Configuration, CalculateRequest } from './api-client';

const config = new Configuration({
  basePath: 'http://localhost:8080/api'
});
const api = new CalculateApi(config);

function App() {
  const [expression, setExpression] = useState('');
  const [result, setResult] = useState<string | null>(null);
  const [error, setError] = useState<string | null>(null);

  const handleCalculate = async (e?: React.FormEvent) => {
    if (e) e.preventDefault();
    
    setResult(null);
    setError(null);
    try {
      const request: CalculateRequest = { expression };
      const response = await api.calculate(request);
      
      const resValue = response.data?.result;
      if (resValue !== undefined && resValue !== null) {
        setResult(resValue.toString());
      } else {
        setError('Empty result');
      }
    } catch (e: any) {
      setError(e.response?.data?.message || 'Error');
    }
  };

  return (
    <div className="container">
      <h1>Math Evaluator</h1>
      <form onSubmit={handleCalculate} className="calc-row">
        <input 
          type="text" 
          value={expression} 
          onChange={(e) => setExpression(e.target.value)} 
          placeholder="2 + 2 * 5"
        />
        <button type="submit" className="equal-btn">=</button>
        <div className="result-display">
          {result && <span className="result">{result}</span>}
          {error && <span className="error">{error}</span>}
          {!result && !error && <span className="placeholder">?</span>}
        </div>
      </form>
      <footer className="footer">
        <a href="http://localhost:8081" target="_blank" rel="noopener noreferrer">
          API Documentation (Swagger)
        </a>
      </footer>
    </div>
  );
}

export default App;
