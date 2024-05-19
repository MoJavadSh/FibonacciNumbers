import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FibonacciGUI extends JFrame {

    private JTextField inputField;
    private JTextArea outputArea;

    public FibonacciGUI() {
        // Set up the frame
        setTitle("Fibonacci Numbers");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel inputLabel = new JLabel("Enter a number:");
        inputField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        // Set up layout
        JPanel panel = new JPanel();
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(calculateButton);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add components to frame
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add button action listener
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateFibonacci();
            }
        });
    }

    private void calculateFibonacci() {
        try {
            int number = Integer.parseInt(inputField.getText());
            outputArea.setText("");
            if(number <= 20){
            for (int i = 0; i <= number; i++)
                outputArea.append(fibonacci(i) + "\n");
            } else {
                outputArea.setText("Please enter a number from 0 - 20");
            }
        } catch (NumberFormatException e) {
            outputArea.setText("Please enter a valid number.");
        }
    }


    private int fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FibonacciGUI().setVisible(true);
            }
        });
    }
}
