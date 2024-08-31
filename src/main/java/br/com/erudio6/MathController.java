package br.com.erudio6;

import br.com.erudio6.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class MathController {

    private final AtomicLong count = new AtomicLong();

    @RequestMapping(value = "/operation/{numberOne}/{signalOperation}/{numberTwo}", method = RequestMethod.GET)
    public Double calculator(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "signalOperation") String signalOperation,
            @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {

            if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Please set a numeric value!");
            }

            switch (signalOperation) {
                case "sum": return convertToDouble(numberOne) + convertToDouble(numberTwo);
                case "sub" : return convertToDouble(numberOne) - convertToDouble(numberTwo);
                case "div": return convertToDouble(numberOne) / convertToDouble(numberTwo);
                case "avg": return (convertToDouble(numberOne) + convertToDouble(numberTwo) / 2);
                default: return 0D;
            }

    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number)
            throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;

        // BR 10,25 US 10.25
        String number = strNumber.replaceAll(",", ".");

        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
