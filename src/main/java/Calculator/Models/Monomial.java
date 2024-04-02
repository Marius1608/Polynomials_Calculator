package Calculator.Models;

public class Monomial {
    private int degree;
    private double coefficient;

    public Monomial(int degree, double coefficient) {
        this.degree = degree;
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        if (coefficient == 0) {
            return "";
        }
        if (degree == 0) {
            int intCoefficient = (int) coefficient;
            if (coefficient == intCoefficient) {
                return Integer.toString(intCoefficient);
            } else {
                return Double.toString(coefficient);
            }
        } else if (degree == 1) {
            if (coefficient == 1) {
                return "x";
            } else if (coefficient == -1) {
                return "-x";
            } else {
                return formatCoefficient(coefficient) + "x";
            }
        } else {
            if (coefficient == 1) {
                return "x^" + degree;
            } else if (coefficient == -1) {
                return "-x^" + degree;
            } else {
                return formatCoefficient(coefficient) + "x^" + degree;
            }
        }
    }

    private String formatCoefficient(double coefficient) {
        int intCoefficient = (int) coefficient;
        if (coefficient == intCoefficient) {
            return Integer.toString(intCoefficient);
        } else {
            return Double.toString(coefficient);
        }
    }
}
