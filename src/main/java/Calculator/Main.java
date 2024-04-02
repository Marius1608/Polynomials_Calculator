package Calculator;
import Calculator.Gui.PolynomialView;

public class Main {
    public static void main(String[] args) {

        PolynomialView view = new PolynomialView();
        PolynomialController controller = new PolynomialController();
        controller.addView(view);
        view.setVisible(true);

    }
}