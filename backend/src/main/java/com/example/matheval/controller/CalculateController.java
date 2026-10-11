package com.example.matheval.controller;

import com.example.matheval.api.CalculateApi;
import com.example.matheval.model.CalculateRequest;
import com.example.matheval.model.CalculateResponse;
import com.example.matheval.service.CalculateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculateController implements CalculateApi {

    private final CalculateService calculateService;

    @Override
    public CalculateResponse calculate(CalculateRequest calculateRequest) {
        return calculateService.calculate(calculateRequest.getExpression());
    }
}
