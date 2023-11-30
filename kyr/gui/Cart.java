package kyr.gui;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cart extends JFrame {

    private JTextField quantityField;
    private JButton decreaseButton;

    public Cart() {
        setTitle("장바구니");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 760);
        setLocationRelativeTo(null);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);

        // 헤더 불러오기
        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();


        JLabel titleLabel = new JLabel("장바구니");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(540, 130, 200, 50);
        add(titleLabel);

        JSeparator horizontalLine = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine.setBounds(100, 210, 650, 2); // 위치 및 크기 조정
        horizontalLine.setForeground(Color.LIGHT_GRAY); // Set line color
        add(horizontalLine);

        JPanel productPanel = new JPanel();
        productPanel.setLayout(null);
        productPanel.setBounds(100, 220, 660, 80);
        productPanel.setBackground(Color.WHITE);


        ImageIcon foodIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/ex)food.png"));
        Image foodImage = foodIcon.getImage().getScaledInstance(50, 55, Image.SCALE_SMOOTH);
        ImageIcon fIcon = new ImageIcon(foodImage);
        JLabel FoodLabel = new JLabel(fIcon);
        FoodLabel.setBounds(0, 5, 50, 60);
        productPanel.add(FoodLabel);

        JTextField productNameField = new JTextField();
        productNameField.setBounds(60, 10, 140, 50);
        productNameField.setHorizontalAlignment(SwingConstants.LEFT);
        productPanel.add(productNameField);

        decreaseButton = new JButton("-");
        decreaseButton.setBounds(250, 20, 30, 30);
        decreaseButton.setFont(new Font("Arial", Font.PLAIN, 25));
        decreaseButton.setForeground(Color.LIGHT_GRAY);
        decreaseButton.setBackground(Color.WHITE);
        decreaseButton.setBorder(BorderFactory.createLineBorder(Color.black));
        decreaseButton.setMargin(new Insets(0, 0, 0, 0));

        quantityField = new JTextField("1");
        quantityField.setBounds(280, 20, 30, 30);
        quantityField.setFont(new Font("Arial", Font.PLAIN, 15));
        quantityField.setBorder(BorderFactory.createLineBorder(Color.black));
        quantityField.setHorizontalAlignment(SwingConstants.CENTER);

        JButton increaseButton = new JButton("+");
        increaseButton.setBounds(310, 20, 30, 30);
        increaseButton.setFont(new Font("Arial", Font.PLAIN, 25));
        increaseButton.setForeground(new Color(39, 185, 89)); // 항상 초록색으로 설정
        increaseButton.setBackground(Color.WHITE);
        increaseButton.setBorder(BorderFactory.createLineBorder(Color.black));
        increaseButton.setMargin(new Insets(0, 0, 0, 0));


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
                // increaseQuantity 이후에 decreaseButton의 글자색을 업데이트
                updateDecreaseButtonTextColor();
            }
        });


        productPanel.add(decreaseButton);
        productPanel.add(quantityField);
        productPanel.add(increaseButton);

        JTextField priceField = new JTextField();
        priceField.setBounds(425, 20, 150, 30);
        productPanel.add(priceField);

        JButton deleteButton = new JButton("X");
        deleteButton.setFont(new Font("Arial", Font.PLAIN, 20));
        deleteButton.setBounds(600, 10, 50, 50);
        deleteButton.setFocusPainted(false);
        deleteButton.setVisible(true);
        deleteButton.setForeground(Color.LIGHT_GRAY);
        deleteButton.setBackground(Color.WHITE);
        deleteButton.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // 테두리 색을 흰색으로 설

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove all components from the productPanel
                productPanel.removeAll();
                productPanel.revalidate();
                productPanel.repaint();
            }
        });
        productPanel.add(deleteButton);



        JButton checkbutton= new JButton("확인");
        checkbutton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        checkbutton.setBounds(350, 600, 100, 50);
        checkbutton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        checkbutton.setBackground(Color.WHITE); // 연두색 배경
        checkbutton.setForeground(new Color(29, 185, 89)); // 흰색 글씨
        add(checkbutton);

        /*checkbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    cartMessage2 cartMessage2 = new cartMessage2();
                    cartMessage2.setVisible(true);

                });
            }
        });*/

        JSeparator horizontalLine2 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine2.setBounds(0, 79, 650, 70); // 위치 및 크기 조정
        horizontalLine2.setForeground(Color.LIGHT_GRAY); // Set line color
        productPanel.add(horizontalLine2);

        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(null);
        orderPanel.setBounds(810, 210, 350, 160);
        orderPanel.setBackground(Color.WHITE);
        orderPanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));

        JLabel totalAmountLabel = new JLabel("결제예정금액");
        totalAmountLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        totalAmountLabel.setHorizontalAlignment(SwingConstants.LEFT);
        totalAmountLabel.setBounds(30, 20, 100, 50);
        orderPanel.add(totalAmountLabel);

        JTextField totalAmountField = new JTextField();
        totalAmountField.setBounds(130, 20, 200, 50);
        orderPanel.add(totalAmountField);

        JButton orderButton = new JButton("주문하기");
        orderButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        orderButton.setBounds(30, 90, 300, 50);
        orderButton.setBorder(new Login.RoundedBorder(10, new Color(39, 185, 89)));
        orderButton.setBackground(Color.WHITE); // 하얀색 배경
        orderButton.setForeground(new Color(39, 185, 89)); // 연두색 글씨
        orderPanel.add(orderButton);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(() -> {
                    orderMessage orderMessage = new orderMessage();
                    orderMessage.setVisible(true);


                });
            }
        });

        add(productPanel);
        add(orderPanel);
        add(headerPanel);
        add(mainpanel);
        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cart();
            }
        });
    }

    private void updateDecreaseButtonTextColor() {
        int currentQuantity = Integer.parseInt(quantityField.getText());
        if (currentQuantity == 1) {
            decreaseButton.setForeground(Color.LIGHT_GRAY);
        } else {
            decreaseButton.setForeground(new Color(39, 185, 89));
        }
    }

    private void decreaseQuantity() {
        int currentQuantity = Integer.parseInt(quantityField.getText());
        if (currentQuantity > 1) {
            quantityField.setText(String.valueOf(currentQuantity - 1));
        }
        updateDecreaseButtonTextColor();
    }

    private void increaseQuantity() {
        int currentQuantity = Integer.parseInt(quantityField.getText());
        quantityField.setText(String.valueOf(currentQuantity + 1));
    }

}


//상품이 없을 시
// 장바구니에 담긴 상품이 없습니다.(밝은 회색글씨)

