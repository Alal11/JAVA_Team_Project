package gui;

import api.MemberApi;
import dto.member.*;


import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class SignUppart extends JPanel {
    private JPanel memberPanel, aPanel, bPanel;
    private JTextField idField, nameField, emailField, phoneField, addressField, postalCodeField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton duplicateCheckIDButton, duplicateCheckPWButton,/*duplicateCheckemailButton,*/ registerButton;
    //private boolean isIdAvailable = false; // 아이디 중복 여부를 저장할 변수 추가

    private boolean isPWAvailable = false; // 아이디 중복 여부를 저장할 변수 추가
    //private boolean isEmailAvailable = false; // 아이디 중복 여부를 저장할 변수 추가

    public SignUppart() {
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0, 0, 810, 490);

        memberPanel = new JPanel();
        memberPanel.setLayout(null);
        memberPanel.setBackground(Color.WHITE);
        memberPanel.setBounds(0, 0, 810, 550);

        idField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        postalCodeField = new JTextField();
        //duplicateCheckIDButton = new JButton("중복확인");
        duplicateCheckPWButton = new JButton("중복확인");
        //duplicateCheckemailButton = new JButton("중복확인");

        JLabel IDLabel = new JLabel("아이디");
        IDLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        IDLabel.setForeground(Color.BLACK); // 검정색으로 설정
        IDLabel.setBounds(127,20,150,40);
        idField.setHorizontalAlignment(SwingConstants.CENTER);
        idField.setBounds(277,20,300,40);
        idField.setDocument(createDocumentWithMaxLength(10));

        /*duplicateCheckIDButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckIDButton.setBounds(582,20,100,40);
        duplicateCheckIDButton.setBorder(new Login.RoundedBorder(10,new Color(29,185,89)));
        duplicateCheckIDButton.setBackground(Color.WHITE); // 하얀색 배경
        duplicateCheckIDButton.setBorder(new Login.RoundedBorder(10,new Color(29,185,89))); // 연두색 테두리
        duplicateCheckIDButton.setForeground(new Color(29,185,89)); // 연두색 글씨*/

        JLabel PWLabel = new JLabel("비밀번호");
        PWLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        PWLabel.setHorizontalAlignment(SwingConstants.LEFT);
        PWLabel.setBounds(127,80,150,40);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(277,80,300,40);
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

        /*duplicateCheckemailButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckemailButton.setBounds(582,260,100,40);
        duplicateCheckemailButton.setBorder(new Login.RoundedBorder(10,new Color(29,185,89)));
        duplicateCheckemailButton.setBackground(Color.WHITE); // 하얀색 배경
        duplicateCheckemailButton.setBorder(new Login.RoundedBorder(10,new Color(29,185,89))); // 연두색 테두리
        duplicateCheckemailButton.setForeground(new Color(29,185,89)); // 연두색 글씨*/

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

        // 중복확인 버튼 이벤트 처리
        /*duplicateCheckIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the ID field is empty
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "아이디를 입력하세요.");
                    return; // 중복확인 중단
                }

                // 임시로 아이디 중복 여부를 true로 설정
                isIdAvailable = true;




                // 아이디 중복 여부에 따라 메시지 출력
                if (isIdAvailable) {
                    JOptionPane.showMessageDialog(SignUppart.this, "사용 가능한 아이디입니다!");

                } else {
                    JOptionPane.showMessageDialog(SignUppart.this, "이미 사용 중인 아이디입니다. 다른 아이디를 입력하세요.");

                }
            }
        });*/




        duplicateCheckPWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if password or confirmPassword fields are empty
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호를 입력하세요.");
                    return;
                }

                if (confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호 확인도 입력하세요.");
                    return;
                }

                // 임시로 아이디 중복 여부를 true로 설정
                isPWAvailable = true;

                if (isPWAvailable) {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호 설정이 완료되었습니다!");
                } else {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                }

                /*if (password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호 설정이 완료되었습니다!");
                } else {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                }*/
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

       /* duplicateCheckemailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the email field is empty
                if (emailField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "이메일을 입력하세요.");
                    return; // 중복확인 중단
                }

                // 여기에서 이메일 형식이 올바른지 확인하는 로직 추가
                String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
                String inputEmail = emailField.getText();

                if (inputEmail.matches(emailPattern)) {
                    // 이메일 형식이 올바를 경우

                    // 여기에서 이메일 중복 확인 로직을 구현
                    // (예: 서버에 이메일을 전송하여 중복 여부를 확인하는 등)

                    // 임시로 이메일 중복 여부를 true로 설정
                    isEmailAvailable = true;

                    // 이메일 중복 여부에 따라 메시지 출력
                    if (isEmailAvailable) {
                        JOptionPane.showMessageDialog(SignUppart.this, "사용 가능한 이메일입니다!");
                    } else {
                        JOptionPane.showMessageDialog(SignUppart.this, "이미 가입된 이메일입니다. 다른 이메일을 입력하세요.");
                    }
                } else {
                    // 이메일 형식이 올바르지 않을 경우
                    JOptionPane.showMessageDialog(SignUppart.this, "올바른 이메일 형식이 아닙니다.");
                }
            }
        });*/



        phoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = phoneField.getText();

                // 숫자 또는 하이픈이 아닌 경우 입력 차단
                if (!(Character.isDigit(c) || c == '-' || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }

                // 첫 번째 그룹에 숫자 3개 입력 후 하이픈 추가
                if (!text.contains("-") && Character.isDigit(c) && text.length() == 3) {
                    phoneField.setText(text + "-");
                }

                if (Character.isDigit(c) &&text.length() == 8) {
                    phoneField.setText(text + "-");
                }
                // 전체 길이가 13이 되면 더 이상 입력 차단
                if (text.length() >= 13) {
                    e.consume();
                }
            }
        });




        registerButton = new JButton("회원가입");
        registerButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        registerButton.setBounds(380, 450, 100, 50);
        registerButton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        registerButton.setBackground(new Color(29, 185, 89)); // 연두색 배경
        registerButton.setForeground(Color.WHITE); // 흰색 글씨

        // 회원가입 버튼 이벤트 처리
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아이디 필드가 비어있는지 확인
                if (idField == null || idField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "아이디를 입력하세요.");
                    return; // 회원가입 중단
                }


                // 비밀번호 필드가 비어있는지 확인
                if (new String(passwordField.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 이름 필드가 비어있는지 확인
                if (nameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "이름을 입력하세요.");
                    return; // 회원가입 중단
                }

                // 이메일 필드가 비어있는지 확인
                if (emailField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "이메일을 입력하세요.");
                    return; // 회원가입 중단
                }

                // 휴대폰 번호 필드가 비어있는지 확인
                if (phoneField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "휴대폰 번호를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 주소 필드가 비어있는지 확인
                if (addressField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "주소를 입력하세요.");
                    return; // 회원가입 중단
                }

                /*if (!isIdAvailable) {
                    JOptionPane.showMessageDialog(SignUppart.this, "아이디 중복 확인이 필요합니다.");
                    return; // 회원가입 중단
                }*/

                if (!isPWAvailable) {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호 중복 확인이 필요합니다.");
                    return; // 회원가입 중단
                }

                /*if (!isEmailAvailable) {
                    JOptionPane.showMessageDialog(SignUppart.this, "이메일 중복 확인이 필요합니다.");
                    return; // 회원가입 중단
                }*/

                    // 여기에서 이메일 형식이 올바른지 확인하는 로직 추가
                String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
                String inputEmail = emailField.getText();

                if (!inputEmail.matches(emailPattern)) {
                    // 이메일 형식이 올바르지 않을 경우
                    JOptionPane.showMessageDialog(SignUppart.this, "올바른 이메일 형식이 아닙니다.");
                    return; // 회원가입 중단
                }

// 이후의 코드는 올바른 이메일 형식일 때만 실행됩니다.








                String password = new String(passwordField.getPassword());

                MemberSignupDTO memberSignupDTO = new MemberSignupDTO(
                        idField.getText(),
                        password,
                        nameField.getText(),
                        phoneField.getText(),
                        emailField.getText(),
                        addressField.getText());
                MemberApi.signup(memberSignupDTO);



                JOptionPane.showMessageDialog(SignUppart.this, "가입되었습니다!");
                new MainTest();
                // 현재 창을 닫음
                ((JFrame) SwingUtilities.getWindowAncestor(registerButton)).dispose();
                setVisible(false);
            }
        });

        memberPanel.add(IDLabel);
        memberPanel.add(idField);
        //memberPanel.add(duplicateCheckIDButton);
        memberPanel.add(PWLabel);
        memberPanel.add(passwordField);
        memberPanel.add(RPWLabel);
        memberPanel.add(confirmPasswordField);
        memberPanel.add(duplicateCheckPWButton);
        memberPanel.add(NameLabel);
        memberPanel.add(nameField);
        memberPanel.add(emailLabel);
        memberPanel.add(emailField);
        //memberPanel.add(duplicateCheckemailButton);
        memberPanel.add(phoneLabel);
        memberPanel.add(phoneField);
        memberPanel.add(addressLabel);
        memberPanel.add(addressField);
        memberPanel.add(registerButton);

        aPanel = new JPanel();
        aPanel.setLayout(null);
        aPanel.setBackground(Color.WHITE);
        aPanel.setBounds(0, 0, 810, 550);
        aPanel.add(memberPanel);

        add(aPanel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Page");
        frame.setSize(1280, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SignUppart signUppart = new SignUppart();
        frame.add(signUppart);

        frame.setVisible(true);
    }

    public JPanel getAPanel() {
        return aPanel;
    }

    private Document createDocumentWithMaxLength(int maxLength) {
        PlainDocument document = new PlainDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + string.length() <= maxLength) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() - length + text.length() <= maxLength) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        return document;
    }
}