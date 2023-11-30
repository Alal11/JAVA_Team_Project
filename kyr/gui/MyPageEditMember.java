package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.text.*;

public class MyPageEditMember extends JFrame {
    private JTextField idField = new JTextField();
    private JTextField nameField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField phoneField = new JTextField();
    private JTextField addressField = new JTextField();
    private JTextField postalCodeField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JPasswordField confirmPasswordField = new JPasswordField();
    private JButton duplicateCheckIDButton = new JButton("중복확인");
    private JButton duplicateCheckPWButton = new JButton("확인");

    private JButton WithdrawalMemberButton = new JButton("회원 탈퇴");
    private JButton editmemberButton = new JButton("정보 수정");

    private JPanel memberPanel;
    private boolean isIdAvailable = false; // 아이디 중복 여부를 저장할 변수 추가
    private boolean passwordsMatch = false; // 아이디 중복 여부를 저장할 변수 추가
    private boolean isEmailAvailable = false; // 아이디 중복 여부를 저장할 변수 추가


    public MyPageEditMember() {
        // 프레임 설정
        setTitle("My Page");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 표시

        // 헤더 불러오기
        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();


        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        mainpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        mainpanel.setBounds(30, 100, 320, 760); // 위치 및 크기 조정

        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel panel = new JPanel();
        panel.setLayout(null); // 절대 위치 레이아웃으로 설정
        //panel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        panel.setBackground(new Color(242, 242, 242)); // 패널 배경색을 흰색으로 설정
        panel.setBounds(100, 100, 270, 760); // 위치 및 크기 조정

        // 1. "My page" 메인 텍스트 추가 (좌측 상단에)
        JLabel mainText = new JLabel("My Page");
        mainText.setFont(new Font("Arial", Font.PLAIN, 40));
        mainText.setHorizontalAlignment(SwingConstants.CENTER);
        mainText.setBounds(35, 35, 200, 60); // 위치 및 크기 조정
        panel.add(mainText);

        // 2. "주문내역 >"과 "회원정보 수정>" 버튼 추가 (메인 텍스트 밑에 수직으로 배열)
        JButton orderHistoryButton = new JButton("주문내역                  >");
        orderHistoryButton.setForeground(Color.LIGHT_GRAY); // Set text color to green
        orderHistoryButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        orderHistoryButton.setHorizontalAlignment(SwingConstants.CENTER);
        orderHistoryButton.setBounds(0, 130, 270, 80);
        orderHistoryButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        orderHistoryButton.setBackground(Color.WHITE); // Set background color
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
        panel.add(orderHistoryButton);

        JButton modifyUserInfoButton = new JButton("개인정보 수정            >");
        modifyUserInfoButton.setForeground(new Color(29, 185, 89)); // Set text color to light gray
        modifyUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        modifyUserInfoButton.setHorizontalAlignment(SwingConstants.CENTER);
        modifyUserInfoButton.setBounds(0, 210, 270, 80);
        modifyUserInfoButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        modifyUserInfoButton.setBackground(Color.WHITE); // Set background color
        modifyUserInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    checkpw checkpw = new checkpw();
                    checkpw.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(modifyUserInfoButton)).dispose();
                });
            }
        });
        panel.add(modifyUserInfoButton);

        JPanel subpanel = new JPanel();
        subpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        subpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        subpanel.setBounds(390, 120, 900, 65); // 위치 및 크기 조정

        // 3. 메인 텍스트 우측에 가로선과 "주문내역" label 추가
        JSeparator horizontalLine = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine.setBounds(15, 64, 795, 50); // 위치 및 크기 조정
        subpanel.add(horizontalLine);

        JLabel orderLabel = new JLabel("개인정보 수정");
        orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        orderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderLabel.setBounds(25, 2, 300, 60); // 위치 및 크기 조정
        subpanel.add(orderLabel);



        memberPanel = new JPanel();
        memberPanel.setLayout(null);
        memberPanel.setBackground(Color.WHITE);
        memberPanel.setBounds(370, 175, 810, 420);

        idField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        postalCodeField = new JTextField();
        duplicateCheckPWButton = new JButton("중복확인");
        duplicateCheckPWButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));


        JLabel IDLabel = new JLabel("아이디");
        IDLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        IDLabel.setForeground(Color.BLACK); // 검정색으로 설정
        IDLabel.setBounds(127,20,150,40);
        idField.setHorizontalAlignment(SwingConstants.CENTER);
        idField.setBounds(277,20,300,40);
        idField.setDocument(createDocumentWithMaxLength(10));


        JLabel PWLabel = new JLabel("비밀번호");
        PWLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        PWLabel.setHorizontalAlignment(SwingConstants.LEFT);
        PWLabel.setBounds(127,80,150,40);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(277,80,300,40);
        //필드에 길이 제한이 있는 Document를 설정합니다.
        passwordField.setDocument(createDocumentWithMaxLength(10));
        JLabel RPWLabel = new JLabel("비밀번호 확인");
        RPWLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        RPWLabel.setHorizontalAlignment(SwingConstants.LEFT);
        RPWLabel.setBounds(127,140,150,40);
        confirmPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPasswordField.setBounds(277,140,300,40);
        confirmPasswordField.setDocument(createDocumentWithMaxLength(10));
        duplicateCheckPWButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckPWButton.setBounds(582,140,100,40);
        duplicateCheckPWButton.setBorder(new Login.RoundedBorder(10,new Color(29,185,89)));
        duplicateCheckPWButton.setBackground(Color.WHITE); // 하얀색 배경
        duplicateCheckPWButton.setBorder(new Login.RoundedBorder(10,new Color(29,185,89))); // 연두색 테두리
        duplicateCheckPWButton.setForeground(new Color(29,185,89)); // 연두색 글씨

        JLabel NameLabel = new JLabel("이름");
        NameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        NameLabel.setBounds(127,200,150,40);
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setBounds(277,200,300,40);


        JLabel emailLabel = new JLabel("이메일");
        emailLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setBounds(127,260,150,40);
        emailField.setHorizontalAlignment(SwingConstants.CENTER);
        emailField.setBounds(277,260,300,40);



        JLabel phoneLabel = new JLabel("휴대폰");
        phoneLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneLabel.setBounds(127,320,150,40);
        phoneField.setHorizontalAlignment(SwingConstants.CENTER);
        phoneField.setBounds(277,320,300,40);


        JLabel addressLabel = new JLabel("주소");
        addressLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setBounds(127,380,150,40);
        addressField.setHorizontalAlignment(SwingConstants.CENTER);
        addressField.setBounds(277,380,300,40);



        // 아이디 입력 필드에 한글 입력 방지
        idField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                char c = e.getKeyChar();
                if ((c >= '가' && c <= '힣') || (c >= 'ㄱ' && c <= 'ㅎ')) {
                    e.consume();
                }
            }
        });



        duplicateCheckPWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                // Check if password or confirmPassword fields are empty
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호를 입력하세요.");
                    return;
                }

                if (confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호 확인도 입력하세요.");
                    return;
                }

                if (password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호 설정이 완료되었습니다!");
                } else {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                }
            }
        });



        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                char c = e.getKeyChar();

                // 허용된 문자: 영어 소문자, 대문자, 숫자, '@'
                if (!((Character.isLetter(c) && Character.isLowerCase(c)) ||
                        (Character.isLetter(c) && Character.isUpperCase(c)) ||
                        (Character.isDigit(c)) ||
                        (c == '@') ||
                        (c == '.'))) {
                    e.consume();
                }
            }
        });




        // 우편번호 입력 필드에 숫자만 입력되도록 이벤트 추가
        postalCodeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });

        // 휴대폰 번호 입력 필드에 숫자만 입력되도록 이벤트 추가
        phoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });




        memberPanel.add(IDLabel);
        memberPanel.add(idField);
        memberPanel.add(PWLabel);
        memberPanel.add(passwordField);
        memberPanel.add(RPWLabel);
        memberPanel.add(confirmPasswordField);
        memberPanel.add(duplicateCheckPWButton);
        memberPanel.add(NameLabel);
        memberPanel.add(nameField);
        memberPanel.add(emailLabel);
        memberPanel.add(emailField);
        memberPanel.add(phoneLabel);
        memberPanel.add(phoneField);
        memberPanel.add(addressLabel);
        memberPanel.add(addressField);





        WithdrawalMemberButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        WithdrawalMemberButton.setHorizontalAlignment(SwingConstants.CENTER);
        WithdrawalMemberButton.setBounds(683, 610, 90, 50);
        WithdrawalMemberButton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        WithdrawalMemberButton.setBackground(new Color(123, 199, 139)); // 연두색 배경
        WithdrawalMemberButton.setForeground(Color.WHITE); // 흰색 글씨

        WithdrawalMemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MemberoutMessage memberoutMessage = new MemberoutMessage();
                    memberoutMessage.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(memberoutMessage)).dispose();
                });
            }
        });
        editmemberButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        editmemberButton.setHorizontalAlignment(SwingConstants.CENTER);
        editmemberButton.setBounds(817, 610, 90, 50);
        editmemberButton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        editmemberButton.setBackground(new Color(123, 199, 139)); // 연두색 배경
        editmemberButton.setForeground(Color.WHITE); // 흰색 글씨

        editmemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아이디 필드가 비어있는지 확인
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "아이디를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 비밀번호 필드가 비어있는지 확인
                if (new String(passwordField.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 이름 필드가 비어있는지 확인
                if (nameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "이름을 입력하세요.");
                    return; // 회원가입 중단
                }

                // 이메일 필드가 비어있는지 확인
                if (emailField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "이메일을 입력하세요.");
                    return; // 회원가입 중단
                }

                // 휴대폰 번호 필드가 비어있는지 확인
                if (phoneField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "휴대폰 번호를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 주소 필드가 비어있는지 확인
                if (addressField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "주소를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 우편번호 필드가 비어있는지 확인
                if (postalCodeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "우편번호를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 여기에서 아이디 중복 여부를 확인하는 로직 추가
                boolean isIdAvailable = true; // 아이디 중복 여부를 확인하는 로직을 추가해야 합니다.

                // 아이디 중복 여부와 비밀번호 일치 여부를 확인하고 처리
                if (isIdAvailable) {
                    char[] passwordChars = passwordField.getPassword();
                    char[] confirmPasswordChars = confirmPasswordField.getPassword();

                    // 비밀번호 일치 여부 확인
                    if (passwordChars.length == confirmPasswordChars.length) {
                        boolean passwordsMatch = true;
                        for (int i = 0; i < passwordChars.length; i++) {
                            if (passwordChars[i] != confirmPasswordChars[i]) {
                                passwordsMatch = false;
                                break;
                            }
                        }

                        if (passwordsMatch) {
                            JOptionPane.showMessageDialog(MyPageEditMember.this, "회원정보 수정이 완료되었습니다.");

                            /*performRegister();*/
                        } else {
                            JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                    }
                } else {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "이미 사용 중인 아이디입니다. 다른 아이디를 입력하세요.");
                }
            }
        });




      /*  editmemberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    editMemberMessage editMemberMessage = new editMemberMessage();
                    editMemberMessage.setVisible(true);

                });
            }
        });*/

        add(panel);
        add(subpanel);
        add(headerPanel);
        add(memberPanel);
        add(WithdrawalMemberButton);
        add(editmemberButton);
        //signUpPanel.setBounds(370, 175, 810, 490); // 헤더 위치 및 크기 조정




        add(mainpanel);






    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyPageEditMember myPageEditMember = new MyPageEditMember();
            myPageEditMember.setVisible(true);
        });




        /* 디자인 할 때 수정할 부분 글씨체
         *주문내역, 개인 정보 수정버튼 클릭된 상태는 글씨색 초록색으로 표시
         * 즉 이 페이지에서는 주문내역 글씨색 초록색으로 표시
         * 클릭이 되지 않으면 연한 회색 테두리도 연한 회색
         * 버튼 바탕색은 모두 하얀색으로 하기
         * 주문날짜 label은 나중에 의견 나눔 해야됨 */
    }

    private Document createDocumentWithMaxLength(int maxLength) {
        PlainDocument document = new PlainDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= maxLength) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() - length + text.length() <= maxLength) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        return document;
    }
}

