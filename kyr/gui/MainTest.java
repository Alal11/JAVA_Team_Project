package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainTest extends JFrame {

    public MainTest() {
        setTitle("Cookeryket");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 전체를 감싸는 패널
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.WHITE);
        getContentPane().add(mainPanel);

        // 로그인, 회원가입, 마이페이지 버튼을 담을 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

        // 로그인 버튼
        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                setVisible(false);
            }
        });
        buttonPanel.add(loginButton);

        // 회원가입 버튼
        JButton signupButton = new JButton("회원가입");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp();
                setVisible(false);
            }
        });
        buttonPanel.add(signupButton);

        // 마이페이지 버튼
        JButton myPageButton = new JButton("마이페이지");
        myPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyPage();
                setVisible(false);
            }
        });
        buttonPanel.add(myPageButton);

        buttonPanel.setBounds(0, 0, getWidth(), 30);
        mainPanel.add(buttonPanel);

        // 상단 패널
        JPanel topPanel = new JPanel(null);
        topPanel.setBackground(Color.WHITE);

        ImageIcon logoIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/logo.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoIcon = new ImageIcon(logoImage);
        JLabel imgLabel = new JLabel(resizedLogoIcon);
        imgLabel.setBounds(200, 0, 200, 100); // 이미지의 위치와 크기 설정

        // 검색창
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(500, 50)); // 검색창 크기 조절
        searchField.setBounds(400, 30, 500, 50); // 검색창의 위치와 크기 설정

        // 이미지 버튼
        ImageIcon cartIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/cart2.png"));
        Image cartImage = cartIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedCartIcon = new ImageIcon(cartImage);
        JButton cartButton = new JButton(resizedCartIcon);
        cartButton.setBounds(1100, 30, 50, 50); // 이미지 버튼의 위치와 크기 설정
        cartButton.setBorderPainted(false); // 배경 투명화 설정

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Cart();
                setVisible(false);
            }
        });

        topPanel.add(imgLabel);
        topPanel.add(searchField);
        topPanel.add(cartButton);

        topPanel.setBounds(0, 30, getWidth(), 100); // 상단 패널의 위치와 크기 설정
        mainPanel.add(topPanel);

        // 화면 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainTest());
    }
}

