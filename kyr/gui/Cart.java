package kyr.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cart extends JFrame {

    private JTextField quantityField;

    public Cart() {
        setTitle("장바구니");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 760);
        setLocationRelativeTo(null); // 화면 중앙에 표시
        setLayout(null);

        JLabel titleLabel = new JLabel("장바구니");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(540, 0, 200, 190);
        add(titleLabel);

        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setBounds(80, 190, 800, 120);


        JTextField productNameField = new JTextField();
        productNameField.setBounds(0, 10, 200, 50);
        productNameField.setHorizontalAlignment(SwingConstants.LEFT);
        productPanel.add(productNameField);


        JButton decreaseButton = new JButton("-");
        decreaseButton.setBounds(225, 10, 50, 50);
        quantityField = new JTextField("1");
        quantityField.setBounds(275, 10, 50, 50);
        quantityField.setHorizontalAlignment(SwingConstants.CENTER);
        JButton increaseButton = new JButton("+");
        increaseButton.setBounds(325, 10, 50, 50);
        productPanel.add(decreaseButton);
        productPanel.add(quantityField);
        productPanel.add(increaseButton);

        JTextField priceField = new JTextField();
        priceField.setBounds(425, 10, 150, 50);

        JButton deleteButton = new JButton("X");
        deleteButton.setBounds(675, 10, 50, 50);

        productPanel.add(priceField);
        productPanel.add(deleteButton);

        add(productPanel);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove all components from the productPanel
                productPanel.removeAll();
                productPanel.revalidate();
                productPanel.repaint();
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decreaseQuantity();
            }
        });

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increaseQuantity();
            }
        });


        JLabel totalAmountLabel = new JLabel("결제예정금액");
        totalAmountLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        totalAmountLabel.setHorizontalAlignment(SwingConstants.LEFT);
        totalAmountLabel.setBounds(910, 200, 200, 50);

        JTextField totalAmountField = new JTextField();
        totalAmountField.setBounds(1010, 200, 200, 50);

        JButton orderButton = new JButton("주문하기");
        orderButton.setBounds(910, 260, 300, 50);

        add(totalAmountLabel);
        add(totalAmountField);
        add(orderButton);



        setVisible(true);
    }

    private void decreaseQuantity() {
        int currentQuantity = Integer.parseInt(quantityField.getText());
        if (currentQuantity > 1) {
            quantityField.setText(String.valueOf(currentQuantity - 1));
        }
    }

    private void increaseQuantity() {
        int currentQuantity = Integer.parseInt(quantityField.getText());
        quantityField.setText(String.valueOf(currentQuantity + 1));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cart();
            }
        });
    }
}
