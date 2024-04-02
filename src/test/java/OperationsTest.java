import Calculator.Logic.PolynomialOperations;
import Calculator.Models.*;
import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void addTest1() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        polynomial1.addMonomial(new Monomial(2, 3));
        polynomial1.addMonomial(new Monomial(1, 2));

        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        polynomial2.addMonomial(new Monomial(2, 1));
        polynomial2.addMonomial(new Monomial(0, 5));

        Polynomial result = PolynomialOperations.addPolynomials(polynomial1, polynomial2);
        assertEquals("4x^2+2x+5", result.toString());

    }

    @Test
    public void addTest2() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        polynomial1.addMonomial(new Monomial(2, 3));
        polynomial1.addMonomial(new Monomial(1, 2));
        polynomial1.addMonomial(new Monomial(0, 1));

        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        polynomial2.addMonomial(new Monomial(2, 1));
        polynomial2.addMonomial(new Monomial(1, 3));
        polynomial2.addMonomial(new Monomial(0, 5));

        Polynomial result = PolynomialOperations.addPolynomials(polynomial1, polynomial2);
        Polynomial expected = new Polynomial(new HashMap<>());
        expected.addMonomial(new Monomial(2, 4));
        expected.addMonomial(new Monomial(1, 5));
        expected.addMonomial(new Monomial(0, 6));

        assertEquals(expected.toString(), result.toString());

    }

    @Test
    public void addTest3() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        Polynomial result = PolynomialOperations.addPolynomials(polynomial1, polynomial2);
        assertEquals("0", result.toString());
    }

    @Test
    public void multiplyTest1() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        polynomial1.addMonomial(new Monomial(2, 3));
        polynomial1.addMonomial(new Monomial(1, 2));

        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        polynomial2.addMonomial(new Monomial(1, 4));
        polynomial2.addMonomial(new Monomial(0, 1));

        Polynomial result = PolynomialOperations.multiplyPolynomials(polynomial1, polynomial2);
        assertEquals("12x^3+11x^2+2x", result.toString());
    }

    @Test
    public void multiplyTest2() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        polynomial1.addMonomial(new Monomial(2, 3));
        polynomial1.addMonomial(new Monomial(1, 2));
        polynomial1.addMonomial(new Monomial(0, 1));

        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        polynomial2.addMonomial(new Monomial(1, 4));
        polynomial2.addMonomial(new Monomial(0, 1));

        Polynomial result = PolynomialOperations.multiplyPolynomials(polynomial1, polynomial2);
        Polynomial expected = new Polynomial(new HashMap<>());
        expected.addMonomial(new Monomial(3, 12));
        expected.addMonomial(new Monomial(2, 11));
        expected.addMonomial(new Monomial(1, 6));
        expected.addMonomial(new Monomial(0,1));
        assertEquals(expected.toString(), result.toString());

    }

    @Test
    public void multiplyTest3() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        Polynomial result = PolynomialOperations.multiplyPolynomials(polynomial1, polynomial2);
        assertEquals("0", result.toString());
    }

    @Test
    public void subtractTest1() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        polynomial1.addMonomial(new Monomial(2, 3));
        polynomial1.addMonomial(new Monomial(1, 2));

        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        polynomial2.addMonomial(new Monomial(2, 1));
        polynomial2.addMonomial(new Monomial(0, 5));

        Polynomial result = PolynomialOperations.subtractPolynomials(polynomial1, polynomial2);
        assertEquals("2x^2+2x-5", result.toString());
    }

    @Test
    public void subtractTest2() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        polynomial1.addMonomial(new Monomial(2, 3));
        polynomial1.addMonomial(new Monomial(1, 2));
        polynomial1.addMonomial(new Monomial(0, 1));

        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        polynomial2.addMonomial(new Monomial(2, 1));
        polynomial2.addMonomial(new Monomial(1, 1));
        polynomial2.addMonomial(new Monomial(0, 5));

        Polynomial result = PolynomialOperations.subtractPolynomials(polynomial1, polynomial2);
        Polynomial expected = new Polynomial(new HashMap<>());
        expected.addMonomial(new Monomial(2, 2));
        expected.addMonomial(new Monomial(1, 1));
        expected.addMonomial(new Monomial(0, -4));

        assertEquals(expected.toString(), result.toString());

    }

    @Test
    public void subtractTest3() {

        Polynomial polynomial1 = new Polynomial(new HashMap<>());
        Polynomial polynomial2 = new Polynomial(new HashMap<>());
        Polynomial result = PolynomialOperations.subtractPolynomials(polynomial1, polynomial2);
        assertEquals("0", result.toString());
    }

    @Test
    public void integrateTest1() {

        Polynomial polynomial = new Polynomial(new HashMap<>());
        polynomial.addMonomial(new Monomial(2, 6));
        polynomial.addMonomial(new Monomial(1, 4));
        polynomial.addMonomial(new Monomial(0, 2));
        Polynomial result = PolynomialOperations.integratePolynomial(polynomial);
        assertEquals("2x^3+2x^2+2x", result.toString());
    }
    @Test
    public void integrateTest2() {

        Polynomial polynomial = new Polynomial(new HashMap<>());
        polynomial.addMonomial(new Monomial(3, 6));
        polynomial.addMonomial(new Monomial(2, 4));
        polynomial.addMonomial(new Monomial(1, 2));
        polynomial.addMonomial(new Monomial(0, 5));

        Polynomial result = PolynomialOperations.integratePolynomial(polynomial);
        Polynomial expected = new Polynomial(new HashMap<>());
        expected.addMonomial(new Monomial(4, 1.5));
        expected.addMonomial(new Monomial(3, 1.33));
        expected.addMonomial(new Monomial(2, 1));
        expected.addMonomial(new Monomial(1, 5));

        assertEquals(expected.toString(), result.toString());

    }
    @Test
    public void integrateTest3() {

        Polynomial polynomial = new Polynomial(new HashMap<>());
        Polynomial result = PolynomialOperations.integratePolynomial(polynomial);
        assertEquals("0", result.toString());

    }

    @Test
    public void deriveTest1() {

        Polynomial polynomial = new Polynomial(new HashMap<>());
        polynomial.addMonomial(new Monomial(3, 6));
        polynomial.addMonomial(new Monomial(2, 4));
        polynomial.addMonomial(new Monomial(1, 2));
        Polynomial result = PolynomialOperations.derivePolynomial(polynomial);
        assertEquals("18x^2+8x+2", result.toString());
    }
    @Test
    public void deriveTest2() {

        Polynomial polynomial = new Polynomial(new HashMap<>());
        polynomial.addMonomial(new Monomial(3, 6));
        polynomial.addMonomial(new Monomial(2, 4));
        polynomial.addMonomial(new Monomial(1, 2));
        polynomial.addMonomial(new Monomial(0, 5));

        Polynomial result = PolynomialOperations.derivePolynomial(polynomial);
        Polynomial expected = new Polynomial(new HashMap<>());
        expected.addMonomial(new Monomial(2, 18));
        expected.addMonomial(new Monomial(1, 8));
        expected.addMonomial(new Monomial(0, 2));

        assertEquals(expected.toString(), result.toString());

    }
    @Test
    public void deriveTest3() {

        Polynomial polynomial = new Polynomial(new HashMap<>());
        Polynomial result = PolynomialOperations.derivePolynomial(polynomial);
        assertEquals("0", result.toString());
    }

    @Test
    public void divisionTest1() {

        Polynomial numerator = new Polynomial(new HashMap<>());
        numerator.addMonomial(new Monomial(2, 6));
        numerator.addMonomial(new Monomial(1, 4));
        numerator.addMonomial(new Monomial(0, 2));

        Polynomial denominator = new Polynomial(new HashMap<>());
        denominator.addMonomial(new Monomial(1, 2));


        Polynomial result = PolynomialOperations.divisionPolynomials(numerator, denominator);
        assertEquals("3x+2", result.toString());
    }
    @Test
    public void divisionTest2() {

        Polynomial numerator = new Polynomial(new HashMap<>());
        numerator.addMonomial(new Monomial(3, 8));
        numerator.addMonomial(new Monomial(2, 4));
        numerator.addMonomial(new Monomial(1, 4));
        numerator.addMonomial(new Monomial(0, 16));

        Polynomial denominator = new Polynomial(new HashMap<>());
        denominator.addMonomial(new Monomial(1, 4));
        denominator.addMonomial(new Monomial(0, 2));

        Polynomial result = PolynomialOperations.divisionPolynomials(numerator, denominator);
        Polynomial expected = new Polynomial(new HashMap<>());
        expected.addMonomial(new Monomial(2, 2));
        expected.addMonomial(new Monomial(0, 1));

        assertEquals(expected.toString(), result.toString());

    }
}
