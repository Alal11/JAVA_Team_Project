package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class MyPageEditMember extends JFrame {
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JTextField addressField = new JTextField();
    private JTextField postalCodeField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JPasswordField confirmPasswordField = new JPasswordField();
    private JButton registerButton = new JButton("회원가입");
    private JButton duplicateCheckIDButton = new JButton("중복확인");
    private JButton duplicateCheckPWButton = new JButton("확인");

    private JButton WithdrawalMemberButton = new JButton("회원 탈퇴");
    private JButton editmemberButton = new JButton("정보 수정");


    public MyPageEditMember() {
        // 프레임 설정
        setTitle("My Page");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 표시

        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel panel = new JPanel();
        panel.setLayout(null); // 절대 위치 레이아웃으로 설정
        panel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        add(panel);

        // 1. "My page" 메인 텍스트 추가 (좌측 상단에)
        JLabel mainText = new JLabel("My Page");
        mainText.setFont(new Font("Arial", Font.BOLD, 60));
        mainText.setHorizontalAlignment(SwingConstants.LEFT);
        mainText.setBounds(30, 10, 350, 170); // 위치 및 크기 조정
        panel.add(mainText);

        // 2. "주문내역 >"과 "회원정보 수정>" 버튼 추가 (메인 텍스트 밑에 수직으로 배열)
        JButton orderHistoryButton = new JButton("주문내역                          >");
        orderHistoryButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        orderHistoryButton.setHorizontalAlignment(SwingConstants.CENTER);
        orderHistoryButton.setBounds(30, 180, 320, 80);
        orderHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MyPageOrder myPageOrder = new MyPageOrder();
                    myPageOrder.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(orderHistoryButton)).dispose();
                });
            }
        });

        JButton modifyUserInfoButton = new JButton("회원정보 수정                    >");
        modifyUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        modifyUserInfoButton.setHorizontalAlignment(SwingConstants.CENTER);
        modifyUserInfoButton.setBounds(30, 260, 320, 80);
        panel.add(orderHistoryButton);
        panel.add(modifyUserInfoButton);

        // 3. 메인 텍스트 우측에 가로선과 "주문내역" label 추가
        JSeparator horizontalLine = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine.setBounds(390, 175, 810, 50); // 위치 및 크기 조정
        panel.add(horizontalLine);

        JLabel orderLabel = new JLabel("회원 정보 수정");
        orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        orderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderLabel.setBounds(390, 20, 300, 180); // 위치 및 크기 조정
        panel.add(orderLabel);

       /* signUpFrame = new SignUp();
        JPanel mainPanelFromSignUp = signUpFrame.movepanel;
        mainPanelFromSignUp.setBounds(390, 210, 300, 400);
        panel.add(mainPanelFromSignUp);*/


        JLabel IDLabel = new JLabel("아이디");
        IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        IDLabel.setBounds(550, 190, 100, 42);
        idField.setHorizontalAlignment(SwingConstants.CENTER);
        idField.setBounds(650, 190, 300, 42);
        duplicateCheckIDButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckIDButton.setBounds(955, 190, 100, 42);


        JLabel PWLabel = new JLabel("비밀번호");
        PWLabel.setHorizontalAlignment(SwingConstants.LEFT);
        PWLabel.setBounds(550, 240, 100, 42);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(650, 240, 300, 42);


        JLabel RPWLabel = new JLabel("비밀번호 확인");
        RPWLabel.setHorizontalAlignment(SwingConstants.LEFT);
        RPWLabel.setBounds(550, 290, 100, 42);
        confirmPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPasswordField.setBounds(650, 290, 300, 42);
        duplicateCheckPWButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckPWButton.setBounds(955, 290, 100, 42);

        JLabel NameLabel = new JLabel("이름");
        NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        NameLabel.setBounds(550, 340, 100, 42);
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setBounds(650, 340, 300, 42);


        JLabel emailLabel = new JLabel("이메일");
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setBounds(550, 390, 100, 42);
        emailField.setHorizontalAlignment(SwingConstants.CENTER);
        emailField.setBounds(650, 390, 300, 42);



        JLabel phoneLabel = new JLabel("휴대폰");
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneLabel.setBounds(550, 440, 100, 42);
        phoneField.setHorizontalAlignment(SwingConstants.CENTER);
        phoneField.setBounds(650, 440, 300, 42);


        JLabel addressLabel = new JLabel("주소");
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setBounds(550, 490, 100, 42);
        addressField.setHorizontalAlignment(SwingConstants.CENTER);
        addressField.setBounds(650, 490, 300, 42);


        JLabel postalLabel = new JLabel("우편번호");
        postalLabel.setHorizontalAlignment(SwingConstants.LEFT);
        postalLabel.setBounds(550, 540, 100, 42);
        postalCodeField.setHorizontalAlignment(SwingConstants.CENTER);
        postalCodeField.setBounds(650, 540, 300, 42);



        panel.add(IDLabel);
        panel.add(idField);
        panel.add(duplicateCheckIDButton);
        panel.add(PWLabel);
        panel.add(passwordField);
        panel.add(RPWLabel);
        panel.add(confirmPasswordField);
        panel.add(duplicateCheckPWButton);
        panel.add(NameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addressLabel);
        panel.add(addressField);
        panel.add(postalLabel);
        panel.add(postalCodeField);
        panel.add(registerButton);


        WithdrawalMemberButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        WithdrawalMemberButton.setHorizontalAlignment(SwingConstants.CENTER);
        WithdrawalMemberButton.setBounds(683, 600, 100, 50);
        WithdrawalMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MainTest mainTest = new MainTest();
                    mainTest.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(WithdrawalMemberButton)).dispose();
                });
            }
        });
        editmemberButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        editmemberButton.setHorizontalAlignment(SwingConstants.CENTER);
        editmemberButton.setBounds(817, 600, 100, 50);
        panel.add(WithdrawalMemberButton);
        panel.add(editmemberButton);






    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyPageEditMember myPageEditMember = new MyPageEditMember();
            myPageEditMember.setVisible(true);
        });


        /*디자인 할 때 수정할 부분 글씨체
         *주문내역, 개인 정보 수정버튼 클릭된 상태는 글씨색 초록색으로 표시
         * 즉 이 페이지에서는 주문내역 글씨색 초록색으로 표시
         * 클릭이 되지 않으면 연한 회색 테두리도 연한 회색
         * 버튼 바탕색은 모두 하얀색으로 하기
         * 주문날짜 label은 나중에 의견 나눔 해야됨
         * */
    }
}

