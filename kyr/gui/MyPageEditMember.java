package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;

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
        orderHistoryButton.setForeground(Color.LIGHT_GRAY); // Set text color to light gray
        orderHistoryButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        orderHistoryButton.setBackground(Color.WHITE); // Set background color
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
        modifyUserInfoButton.setForeground(new Color(29,185,89)); // Set text color to green
        modifyUserInfoButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        modifyUserInfoButton.setBackground(Color.WHITE); // Set background color
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
        duplicateCheckIDButton.setBorder(new Login.RoundedBorder(10, new Color(29, 185, 89)));
        duplicateCheckIDButton.setBackground(Color.WHITE); // 하얀색 배경
        duplicateCheckIDButton.setBorder(new Login.RoundedBorder(10, new Color(29, 185, 89))); // 연두색 테두리
        duplicateCheckIDButton.setForeground(new Color(29, 185, 89)); // 연두색 글씨



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
        duplicateCheckPWButton.setBorder(new Login.RoundedBorder(10, new Color(29, 185, 89)));
        duplicateCheckPWButton.setBackground(Color.WHITE); // 하얀색 배경
        duplicateCheckPWButton.setBorder(new Login.RoundedBorder(10, new Color(29, 185, 89))); // 연두색 테두리
        duplicateCheckPWButton.setForeground(new Color(29, 185, 89)); // 연두색 글씨

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
        WithdrawalMemberButton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        WithdrawalMemberButton.setBackground(new Color(29, 185, 89)); // 연두색 배경
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
        editmemberButton.setBounds(817, 600, 100, 50);
        editmemberButton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        editmemberButton.setBackground(new Color(29, 185, 89)); // 연두색 배경
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

        // 아이디 입력 필드에 한글 입력 방지
        idField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c >= '가' && c <= '힣') || (c >= 'ㄱ' && c <= 'ㅎ')) {
                    e.consume();
                }
            }
        });


        // 중복확인 버튼 이벤트 처리
        duplicateCheckIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the ID field is empty
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "아이디를 입력하세요.");
                    return; // 중복확인 중단
                }

                // 여기에서 아이디 중복 확인 로직을 구현
                // (예: 서버에 아이디를 전송하여 중복 여부를 확인하는 등)

                // 임시로 아이디 중복 여부를 true로 설정
                boolean isIdAvailable = true;

                // 아이디 중복 여부에 따라 메시지 출력
                if (isIdAvailable) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "사용 가능한 아이디입니다!");
                } else {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "이미 사용 중인 아이디입니다. 다른 아이디를 입력하세요.");
                }
            }
        });



        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // 유니코드 범위 내의 한글 입력을 막음
                if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_SYLLABLES ||
                        Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_JAMO ||
                        Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // 키 누름 이벤트 처리
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 키 뗌 이벤트 처리
            }
        });

        duplicateCheckPWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if password or confirmPassword fields are empty
                if (new String(passwordField.getPassword()).isEmpty() || new String(confirmPasswordField.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호를 입력하세요.");
                    return;
                }

                char[] passwordChars = passwordField.getPassword();
                char[] confirmPasswordChars = confirmPasswordField.getPassword();

                if (passwordChars.length == confirmPasswordChars.length) {
                    boolean passwordsMatch = true;
                    for (int i = 0; i < passwordChars.length; i++) {
                        if (passwordChars[i] != confirmPasswordChars[i]) {
                            passwordsMatch = false;
                            break;
                        }
                    }

                    if (passwordsMatch) {
                        JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호 설정이 완료되었습니다!");
                    } else {
                        JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                    }
                } else {
                    JOptionPane.showMessageDialog(MyPageEditMember.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                }
            }
        });


        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
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
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });

        // 휴대폰 번호 입력 필드에 숫자만 입력되도록 이벤트 추가
        phoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
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

