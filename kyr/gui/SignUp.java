package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame {

    public SignUp() {
        setTitle("회원가입");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);

        // 헤더 불러오기
        Head2 head2 = new Head2();
        JPanel headerPanel = head2.getHeaderPanel();

        SignUppart signUppart = new SignUppart();
        JPanel aPanel = signUppart.getAPanel();
        mainpanel.add(aPanel);
        aPanel.setBounds(210, 150, 810, 550);


        JLabel registerLabel = new JLabel("회원가입");
        registerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        registerLabel.setForeground(Color.BLACK);
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(540, 110, 200, 50);


        /*backButton = new JButton("<-");
        backButton.setBounds(0, 0, 40, 20);*/

        // 회원가입틀 불러오기
        /*SignUppart signUpPanel = new SignUppart();
        signUpPanel.setBounds(210, 100, 810, 490);
        getContentPane().add(aPanel);*/

        mainpanel.add(registerLabel);
        add(headerPanel);
        add(mainpanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUp());
    }
}
