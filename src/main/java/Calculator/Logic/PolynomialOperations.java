package Calculator.Logic;
import Calculator.Models.*;
import java.util.*;

public class PolynomialOperations {

    public static Polynomial addPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Map<Integer, Monomial> resultMonomials = new HashMap<>(polynomial1.getMonomials());
        for (Map.Entry<Integer, Monomial> monomialEntry : polynomial2.getMonomials().entrySet()) {
            int degree = monomialEntry.getKey();
            Monomial monomial = monomialEntry.getValue();
            if (resultMonomials.containsKey(degree)) {
                double coefficient = resultMonomials.get(degree).getCoefficient() + monomial.getCoefficient();
                resultMonomials.put(degree, new Monomial(degree, coefficient));
            } else {
                resultMonomials.put(degree, monomial);
            }
        }
        return new Polynomial(resultMonomials);
    }

    public static Polynomial subtractPolynomials(Polynomial polynomial1, Polynomial polynomial2) {
        Map<Integer, Monomial> resultMonomials = new HashMap<>(polynomial1.getMonomials());
        for (Map.Entry<Integer, Monomial> monomialEntry : polynomial2.getMonomials().entrySet()) {
            int degree = monomialEntry.getKey();
            Monomial monomial = monomialEntry.getValue();
            if (resultMonomials.containsKey(degree)) {
                double coefficient = resultMonomials.get(degree).getCoefficient() - monomial.getCoefficient();
                resultMonomials.put(degree, new Monomial(degree, coefficient));
            } else {
                resultMonomials.put(degree, new Monomial(degree, -monomial.getCoefficient()));
            }
        }
        if (resultMonomials.isEmpty()) {
            resultMonomials.put(0, new Monomial(0, 0));
        }
        return new Polynomial(resultMonomials);
    }

    public static Polynomial multiplyPolynomials(Polynomial polynomial1, Polynomial polynomial2) {

        Map<Integer, Monomial> resultMonomials = new HashMap<>();
        for (Map.Entry<Integer, Monomial> monomialEntry1 : polynomial1.getMonomials().entrySet()) {

            Monomial monomial1 = monomialEntry1.getValue();
            int degree1 = monomialEntry1.getKey();

            for (Map.Entry<Integer, Monomial> monomialEntry2 : polynomial2.getMonomials().entrySet()) {

                Monomial monomial2 = monomialEntry2.getValue();
                int degree2 = monomialEntry2.getKey();
                int productDegree = degree1 + degree2;
                double productCoefficient = monomial1.getCoefficient() * monomial2.getCoefficient();

                if (resultMonomials.containsKey(productDegree)) {
                    double coefficient = resultMonomials.get(productDegree).getCoefficient() + productCoefficient;
                    resultMonomials.put(productDegree, new Monomial(productDegree, coefficient));

                } else {
                    resultMonomials.put(productDegree, new Monomial(productDegree, productCoefficient));
                }
            }
        }
        return new Polynomial(resultMonomials);
    }

    public static Polynomial divisionPolynomials(Polynomial numerator, Polynomial denominator) {

        if (denominator.getMonomials().isEmpty()) {
            throw new IllegalArgumentException("Division by zero polynomial is not allowed.");
        }

        Map<Integer, Monomial> quotientMonomials = new HashMap<>();
        Map<Integer, Monomial> remainderMonomials = new HashMap<>(numerator.getMonomials());

        while (!remainderMonomials.isEmpty() && !denominator.getMonomials().isEmpty()) {
            int leadDegreeRemainder = Collections.max(remainderMonomials.keySet());
            int leadDegreeDenominator = Collections.max(denominator.getMonomials().keySet());

            if (leadDegreeRemainder < leadDegreeDenominator) {
                break;
            }

            double quotientCoefficient = remainderMonomials.get(leadDegreeRemainder).getCoefficient() / denominator.getMonomials().get(leadDegreeDenominator).getCoefficient();
            int quotientDegree = leadDegreeRemainder - leadDegreeDenominator;
            quotientMonomials.put(quotientDegree, new Monomial(quotientDegree, quotientCoefficient));

            for (Map.Entry<Integer, Monomial> entry : denominator.getMonomials().entrySet()) {
                int remainderExponent = entry.getKey() + quotientDegree;
                double remainderCoefficient = entry.getValue().getCoefficient() * -quotientCoefficient;

                if (remainderMonomials.containsKey(remainderExponent)) {
                    double updatedCoefficient = remainderMonomials.get(remainderExponent).getCoefficient() + remainderCoefficient;
                    remainderMonomials.put(remainderExponent, new Monomial(remainderExponent, updatedCoefficient));
                } else {
                    remainderMonomials.put(remainderExponent, new Monomial(remainderExponent, remainderCoefficient));
                }
            }

            Iterator<Map.Entry<Integer, Monomial>> iterator = remainderMonomials.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Monomial> entry = iterator.next();
                if (entry.getValue().getCoefficient() == 0) {
                    iterator.remove();
                }
            }
        }
        Polynomial quotient = new Polynomial(quotientMonomials);
        Polynomial rest = new Polynomial(remainderMonomials);
        System.out.println(rest.toString());
        return quotient;
    }

    public static Polynomial derivePolynomial(Polynomial polynomial) {
        Map<Integer, Monomial> resultMonomials = new HashMap<>();
        for (Map.Entry<Integer, Monomial> entry : polynomial.getMonomials().entrySet()) {
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();
            if (degree > 0) {
                int newDegree = degree - 1;
                double newCoefficient = monomial.getCoefficient() * degree;
                resultMonomials.put(newDegree, new Monomial(newDegree, newCoefficient));
            }
        }
        return new Polynomial(resultMonomials);
    }

    public static Polynomial integratePolynomial(Polynomial polynomial) {

        Map<Integer, Monomial> resultMonomials = new HashMap<>();
        for (Map.Entry<Integer, Monomial> entry : polynomial.getMonomials().entrySet()) {
            int degree = entry.getKey();
            Monomial monomial = entry.getValue();
            int newDegree = degree + 1;
            double newCoefficient = monomial.getCoefficient()/ newDegree;

            double nr=newCoefficient*100;
            double nr1=Math.round(nr);
            double nr2=nr1/100;
            newCoefficient=nr2;

            resultMonomials.put(newDegree, new Monomial(newDegree, newCoefficient));
        }
        return new Polynomial(resultMonomials);
    }
}


