package Calculator.Models;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private Map<Integer, Monomial> monomials;

    public Polynomial(Map<Integer, Monomial> monomials) {
        this.monomials = monomials;
    }

    public Map<Integer, Monomial> getMonomials() { return monomials; }

    public void addMonomial(Monomial m) {
        int degree = m.getDegree();
        if (monomials.containsKey(degree)) {
            Monomial existingMonomial = monomials.get(degree);
            existingMonomial.setCoefficient(existingMonomial.getCoefficient() + m.getCoefficient());
        } else {
            monomials.put(degree, m);
        }
    }

    @Override
    public String toString() {
        Map<Integer, Monomial> sortedMonomials = new TreeMap<>(monomials).descendingMap();
        String result = "";
        for (Map.Entry<Integer, Monomial> entry : sortedMonomials.entrySet()) {
                Monomial monomial = entry.getValue();
                String monomialString = monomial.toString();
                if (!monomialString.isEmpty()) {
                    if (monomial.getCoefficient() < 0) {
                        result += "";
                    } else if (!result.isEmpty()) {
                        result += "+";
                    }
                    result += monomialString;
                }
            }
        if(result.equals(""))result+="0";
        return result;
    }

        public static HashMap<Integer, Monomial> modify(String polynomial) {

        HashMap<Integer, Monomial> coefficients = new HashMap<>();
        String pattern = "(\\+|-)?([0-9]+\\.?[0-9]*)(x(\\^([0-9]+))?)?";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(polynomial);

        while (matcher.find()) {

            String sign = matcher.group(1);
            String coefficientSrs = matcher.group(2);
            String variable = matcher.group(3);
            String exponentSrs = matcher.group(5);

            double coefficient;
            if (coefficientSrs != null && !coefficientSrs.isEmpty()) { coefficient = Double.parseDouble(coefficientSrs); }
                else { coefficient = 1; }

            int exponent;
            if (exponentSrs != null && !exponentSrs.isEmpty()) { exponent = Integer.parseInt(exponentSrs); }
            else {
                if (variable != null) { exponent = 1; }
                    else { exponent = 0; }
            }

            if (sign != null && sign.equals("-")) { coefficient *= -1;  }
            coefficients.put(exponent, new Monomial(exponent, coefficient));
        }
        return coefficients;
    }
}

