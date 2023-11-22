package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class orderMessage extends JFrame {

    public orderMessage() {
        // 프레임 설정
        setTitle("주문하기");
        setSize(275, 130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 레이아웃 설정
        setLayout(new BorderLayout());

        // 텍스트 라벨 추가
        JLabel label = new JLabel("주문이 완료되었습니다.");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        // 버튼 패널 추가
        JPanel buttonPanel = new JPanel(new FlowLayout());

        // "장바구니로 가기" 버튼 추가
        JButton gotomainButton = new JButton("메인화면으로 가기");
        gotomainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(() -> {
                    MainTest mainTest = new MainTest();
                    mainTest.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(gotomainButton)).dispose();
                });
            }
        });
        buttonPanel.add(gotomainButton);

        // "계속 쇼핑하기" 버튼 추가
        JButton goshoppingButton = new JButton("쇼핑하러 가기");
        goshoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> {
                    PriceSearch priceSearch = new PriceSearch();
                    priceSearch.setVisible(true);
                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(goshoppingButton)).dispose();
                });
            }
        });
        buttonPanel.add(goshoppingButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // 화면에 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new orderMessage();
            }
        });
    }
}


