package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cartMessage2 extends JFrame {

    public cartMessage2() {
        // 프레임 설정
        setTitle("장바구니");
        setSize(275, 130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 레이아웃 설정
        setLayout(new BorderLayout());

        // 텍스트 라벨 추가
        JLabel label = new JLabel("수량을 확인하셨습니까");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        // 버튼 패널 추가
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // "장바구니로 가기" 버튼 추가
        JButton goToCartButton = new JButton("아니요");
        goToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(() -> {


                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(goToCartButton)).dispose();
                });
            }
        });
        buttonPanel.add(goToCartButton);

        // "계속 쇼핑하기" 버튼 추가
        JButton goButton = new JButton("주문하기");
        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(() -> {
                    orderMessage orderMessage = new orderMessage();
                    orderMessage.setVisible(true);


                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(goButton)).dispose();
                });
            }
        });
        buttonPanel.add(goButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // 화면에 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new cartMessage2();
            }
        });
    }
}



