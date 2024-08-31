package br.com.erudio6.service;

import br.com.erudio6.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MathService {

    public Double calculator(String numberOne, String signalOperation, String numberTwo)
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

    public Double squareRoot(String number)
            throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(convertToDouble(number));
    }

    public Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;

        // BR 10,25 US 10.25
        String number = strNumber.replaceAll(",", ".");

        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
