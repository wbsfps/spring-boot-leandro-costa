package br.com.erudio6.controller;

import br.com.erudio6.exceptions.UnsupportedMathOperationException;
import br.com.erudio6.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class MathController {
    @Autowired
    private MathService mathService;
    private final AtomicLong count = new AtomicLong();

    @RequestMapping(value = "/operation/{numberOne}/{signalOperation}/{numberTwo}", method = RequestMethod.GET)
    public Double calculator(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "signalOperation") String signalOperation,
            @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {

            return mathService.calculator(numberOne, signalOperation, numberTwo);
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number)
            throws Exception {
            return mathService.squareRoot(number);
    }
}
