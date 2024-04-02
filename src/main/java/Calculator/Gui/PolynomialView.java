package Calculator.Gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PolynomialView extends JFrame {
    private JTextField polynomial1, polynomial2, result;
    private JButton addButton, subtractButton, multiplyButton;
    private JButton divisionButton,  derivateButton, integrateButton;

    public PolynomialView() {

        setTitle("Polynomial Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color backgroundColor = new Color(23, 240, 233, 255);
        Color buttonColor = new Color(60, 92, 255);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(backgroundColor);

        JPanel inputPanel = new JPanel(new GridLayout(5, 5, 5, 5));
        inputPanel.setBackground(backgroundColor);

        JLabel polynomial1Label = new JLabel("Polynomial 1:");
        JLabel polynomial2Label = new JLabel("Polynomial 2:");
        polynomial1 = new JTextField(20);
        polynomial2 = new JTextField(20);
        inputPanel.add(polynomial1Label);
        inputPanel.add(polynomial1);
        inputPanel.add(polynomial2Label);
        inputPanel.add(polynomial2);

        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultPanel.setBackground(backgroundColor);
        JLabel resultLabel = new JLabel("Result:");
        result = new JTextField(25);
        result.setEditable(false);
        result.setBackground(Color.WHITE);
        result.setHorizontalAlignment(JTextField.CENTER);
        resultPanel.add(resultLabel);
        resultPanel.add(result);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBackground(backgroundColor);
        addButton = createButton("Add", buttonColor);
        subtractButton = createButton("Subtract", buttonColor);
        multiplyButton = createButton("Multiply", buttonColor);
        divisionButton = createButton("Division", buttonColor);
        derivateButton = createButton("Derivate", buttonColor);
        integrateButton = createButton("Integrate", buttonColor);

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divisionButton);
        buttonPanel.add(derivateButton);
        buttonPanel.add(integrateButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(resultPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

    }

    private JButton createButton(String label, Color color) {
        JButton button = new JButton(label);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.BOLD, 15));
        button.setPreferredSize(new Dimension(200, 80));
        return button;
    }

    public String getPolynomial1() {
        return polynomial1.getText().trim();
    }
    //ia textul fara spatiile de la inceput si sfarsit

    public String getPolynomial2() {
        return polynomial2.getText().trim();
    }

    public void setResult(String resultText) {
        result.setText(resultText);
    }

    public void addButtonListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void subtractButtonListener(ActionListener listener) {
        subtractButton.addActionListener(listener);
    }

    public void multiplyButtonListener(ActionListener listener) {
        multiplyButton.addActionListener(listener);
    }

    public void derivateButtonListener(ActionListener listener) {
        derivateButton.addActionListener(listener);
    }

    public void integrateButtonListener(ActionListener listener) {
        integrateButton.addActionListener(listener);
    }

    public void divisionButtonListener(ActionListener listener) {divisionButton.addActionListener(listener);}
}