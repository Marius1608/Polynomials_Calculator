package Calculator;
import java.awt.event.*;
import java.util.*;
import Calculator.Gui.PolynomialView;
import Calculator.Logic.PolynomialOperations;
import Calculator.Models.*;

public class PolynomialController {

    private PolynomialView view;

    public void addView(PolynomialView view) {
        this.view = view;
        this.view.addButtonListener(new AddButtonListener());
        this.view.subtractButtonListener(new SubtractButtonListener());
        this.view.multiplyButtonListener(new MultiplyButtonListener());
        this.view.derivateButtonListener(new DerivateButtonListener());
        this.view.integrateButtonListener(new IntegrateButtonListener());
        this.view.divisionButtonListener(new DivisionButtonListener());
    }

    class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            HashMap<Integer, Monomial> polynomialMap1 = Polynomial.modify(view.getPolynomial1());
            Polynomial polynomial1 = new Polynomial(polynomialMap1);

            HashMap<Integer, Monomial> polynomialMap2 = Polynomial.modify(view.getPolynomial2());
            Polynomial polynomial2 = new Polynomial(polynomialMap2);

            Polynomial result = PolynomialOperations.addPolynomials(polynomial1, polynomial2);
            view.setResult(result.toString());
        }
    }
    class SubtractButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            HashMap<Integer, Monomial> polynomialMap1 = Polynomial.modify(view.getPolynomial1());
            Polynomial polynomial1 = new Polynomial(polynomialMap1);

            HashMap<Integer, Monomial> polynomialMap2 = Polynomial.modify(view.getPolynomial2());
            Polynomial polynomial2 = new Polynomial(polynomialMap2);

            Polynomial result = PolynomialOperations.subtractPolynomials(polynomial1, polynomial2);
            view.setResult(result.toString());
        }
    }

    class MultiplyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            HashMap<Integer, Monomial> polynomialMap1 = Polynomial.modify(view.getPolynomial1());
            Polynomial polynomial1 = new Polynomial(polynomialMap1);

            HashMap<Integer, Monomial> polynomialMap2 = Polynomial.modify(view.getPolynomial2());
            Polynomial polynomial2 = new Polynomial(polynomialMap2);

            Polynomial result = PolynomialOperations.multiplyPolynomials(polynomial1, polynomial2);
            view.setResult(result.toString());
        }
    }

    class DivisionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            HashMap<Integer, Monomial> polynomialMap1 = Polynomial.modify(view.getPolynomial1());
            Polynomial polynomial1 = new Polynomial(polynomialMap1);

            HashMap<Integer, Monomial> polynomialMap2 = Polynomial.modify(view.getPolynomial2());
            Polynomial polynomial2 = new Polynomial(polynomialMap2);

            Polynomial result = PolynomialOperations.divisionPolynomials(polynomial1, polynomial2);
            view.setResult(result.toString());

        }
    }

    class DerivateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            HashMap<Integer, Monomial> polynomialMap1 = Polynomial.modify(view.getPolynomial1());
            Polynomial polynomial1 = new Polynomial(polynomialMap1);

            Polynomial result = PolynomialOperations.derivePolynomial(polynomial1);
            view.setResult(result.toString());
        }
    }

    class IntegrateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            HashMap<Integer, Monomial> polynomialMap1 = Polynomial.modify(view.getPolynomial1());
            Polynomial polynomial1 = new Polynomial(polynomialMap1);

            Polynomial result = PolynomialOperations.integratePolynomial(polynomial1);
            view.setResult(result.toString());
        }
    }
}
