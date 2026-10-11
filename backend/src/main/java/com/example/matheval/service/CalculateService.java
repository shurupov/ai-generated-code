package com.example.matheval.service;

import com.example.matheval.exception.InvalidExpressionException;
import com.example.matheval.model.CalculateResponse;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculateService {

    public CalculateResponse calculate(String expression) {
        try {
            Expression e = new ExpressionBuilder(expression).build();
            double result = e.evaluate();
            
            CalculateResponse response = new CalculateResponse();
            response.setResult(BigDecimal.valueOf(result));
            return response;
        } catch (Exception e) {
            throw new InvalidExpressionException("Invalid mathematical expression: " + expression);
        }
    }
}
