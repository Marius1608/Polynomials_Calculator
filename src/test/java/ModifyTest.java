import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import Calculator.Logic.PolynomialOperations;
import Calculator.Models.*;
import org.junit.Test;
import java.util.*;

public class ModifyTest {

    @Test
    public void modifyTest1() {

        String polynomialString = "3x^2-2x^3+5x^4-6x+2";
        HashMap<Integer, Monomial> result = Polynomial.modify(polynomialString);

        assertEquals(3, result.get(2).getCoefficient());
        assertEquals(-2, result.get(3).getCoefficient());
        assertEquals(5, result.get(4).getCoefficient());
        assertEquals(-6, result.get(1).getCoefficient());
        assertEquals(2, result.get(0).getCoefficient());
    }

    @Test
    public void modifyTest2() {

        String polynomialString = "-3x^2-2x^3+5x^4-6x-2";
        HashMap<Integer, Monomial> result = Polynomial.modify(polynomialString);

        assertEquals(-3, result.get(2).getCoefficient());
        assertEquals(-2, result.get(3).getCoefficient());
        assertEquals(5, result.get(4).getCoefficient());
        assertEquals(-6, result.get(1).getCoefficient());
        assertEquals(-2, result.get(0).getCoefficient());
    }

    @Test
    public void modifyTest3() {

        String polynomialString = "5";
        HashMap<Integer, Monomial> result = Polynomial.modify(polynomialString);
        assertEquals(5, result.get(0).getCoefficient());

    }

}

