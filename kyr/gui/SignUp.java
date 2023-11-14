package kyr.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame {

    private JTextField idField, nameField, emailField, phoneField, phonelastField, addressField, postalCodeField;
    private JPasswordField passwordField, confirmPasswordField;
    private JComboBox<String> birthYearCombo, birthMonthCombo, birthDayCombo, emailDomainCombo, phonePrefixCombo;
    private JButton registerButton, duplicateCheckIDButton, duplicateCheckPWButton,backButton;


    public SignUp() {
        idField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        nameField = new JTextField();
        birthYearCombo = new JComboBox<>(new String[]{"1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959",
                "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969",
                "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
                "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989",
                "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999",
                "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019",
                "2020", "2021", "2022", "2023"});
        birthMonthCombo = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
        });
        birthDayCombo = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"
        });
        emailField = new JTextField();
        emailDomainCombo = new JComboBox<>(new String[]{"naver.com", "daum.net", "gmail.com", "example.com"});
        phonePrefixCombo = new JComboBox<>(new String[]{"010", "011", "012"});
        phoneField = new JTextField();
        phonelastField = new JTextField();
        addressField = new JTextField();
        postalCodeField = new JTextField();
        duplicateCheckIDButton = new JButton("중복확인");
        duplicateCheckPWButton = new JButton("중복확인");
        backButton = new JButton("<-");



        setTitle("회원가입");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);

        JLabel 필수입력사항레이블 = new JLabel("*필수 입력사항");
        필수입력사항레이블.setForeground(Color.RED);
        필수입력사항레이블.setHorizontalAlignment(SwingConstants.RIGHT);
        필수입력사항레이블.setBounds(0, 0, 1180, 20);

        JLabel registerLabel = new JLabel("회원가입");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(540, 30, 100, 20);


        JLabel IDLabel = new JLabel("아이디*");
        IDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        IDLabel.setBounds(0, 60, 400, 20);
        idField.setHorizontalAlignment(SwingConstants.CENTER);
        idField.setBounds(400, 60, 400, 20);
        duplicateCheckIDButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckIDButton.setBounds(800, 60, 200, 20);


        JLabel PWLabel = new JLabel("비밀번호*");
        PWLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        PWLabel.setBounds(0, 90, 400, 20);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(400, 90, 400, 20);


        JLabel RPWLabel = new JLabel("비밀번호 확인*");
        RPWLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        RPWLabel.setBounds(0, 120, 400, 20);
        confirmPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPasswordField.setBounds(400, 120, 400, 20);
        duplicateCheckPWButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckPWButton.setBounds(800, 120, 200, 20);

        JLabel NameLabel = new JLabel("이름*");
        NameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        NameLabel.setBounds(0, 150, 400, 20);
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setBounds(400, 150, 400, 20);


        JLabel birthLabel = new JLabel("생년월일");
        birthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        birthLabel.setBounds(0, 180, 400, 20);
        birthYearCombo.setAlignmentX(SwingConstants.CENTER);
        birthYearCombo.setBounds(400, 180, 200, 20);
        birthMonthCombo.setAlignmentX(SwingConstants.CENTER);
        birthMonthCombo.setBounds(650, 180, 200, 20);
        birthDayCombo.setAlignmentX(SwingConstants.CENTER);
        birthDayCombo.setBounds(900, 180, 200, 20);

        JLabel emailLabel = new JLabel("이메일*");
        emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        emailLabel.setBounds(0, 210, 400, 20);
        emailField.setHorizontalAlignment(SwingConstants.CENTER);
        emailField.setBounds(400, 210, 400, 20);
        JLabel esignLabel = new JLabel("@");
        esignLabel.setHorizontalAlignment(SwingConstants.CENTER);
        esignLabel.setBounds(800, 210, 100, 20);
        emailDomainCombo.setAlignmentX(SwingConstants.CENTER);
        emailDomainCombo.setBounds(900, 210, 400, 20);


        JLabel phoneLabel = new JLabel("휴대폰*");
        phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        phoneLabel.setBounds(0, 240, 400, 20);
        phonePrefixCombo.setAlignmentX(SwingConstants.CENTER);
        phonePrefixCombo.setBounds(400, 240, 200, 20);
        JLabel pfLabel = new JLabel("-");
        pfLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pfLabel.setBounds(600, 240, 50, 20);
        phoneField.setHorizontalAlignment(SwingConstants.CENTER);
        phoneField.setBounds(650, 240, 200, 20);
        JLabel plLabel = new JLabel("-");
        plLabel.setHorizontalAlignment(SwingConstants.CENTER);
        plLabel.setBounds(850, 240, 50, 20);
        phonelastField.setHorizontalAlignment(SwingConstants.CENTER);
        phonelastField.setBounds(900, 240, 200, 20);

        JLabel addressLabel = new JLabel("주소*");
        addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        addressLabel.setBounds(0, 270, 400, 20);
        addressField.setHorizontalAlignment(SwingConstants.CENTER);
        addressField.setBounds(400, 270, 400, 20);


        JLabel postalLabel = new JLabel("우편번호*");
        postalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        postalLabel.setBounds(0, 300, 400, 20);
        postalCodeField.setHorizontalAlignment(SwingConstants.CENTER);
        postalCodeField.setBounds(400, 300, 400, 20);


        registerButton = new JButton("회원가입");
        registerButton.setBounds(540, 400, 100, 20);


        backButton.setBounds(0, 0, 80, 40);




// 회원가입 버튼 이벤트 처리
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아이디 필드가 비어있는지 확인
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "아이디를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 비밀번호 필드가 비어있는지 확인
                if (new String(passwordField.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "비밀번호를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 이름 필드가 비어있는지 확인
                if (nameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "이름을 입력하세요.");
                    return; // 회원가입 중단
                }

                // 이메일 필드가 비어있는지 확인
                if (emailField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "이메일을 입력하세요.");
                    return; // 회원가입 중단
                }

                // 휴대폰 번호 필드가 비어있는지 확인
                if (phoneField.getText().isEmpty() || phonelastField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "휴대폰 번호를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 주소 필드가 비어있는지 확인
                if (addressField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "주소를 입력하세요.");
                    return; // 회원가입 중단
                }

                // 우편번호 필드가 비어있는지 확인
                if (postalCodeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "우편번호를 입력하세요.");
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
                            JOptionPane.showMessageDialog(SignUp.this, "가입되었습니다!");
                            new MainTest();
                            setVisible(false);
                            /*performRegister();*/
                        } else {
                            JOptionPane.showMessageDialog(SignUp.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(SignUp.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                    }
                } else {
                    JOptionPane.showMessageDialog(SignUp.this, "이미 사용 중인 아이디입니다. 다른 아이디를 입력하세요.");
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
                // 여기에서 아이디 중복 확인 로직을 구현
                // (예: 서버에 아이디를 전송하여 중복 여부를 확인하는 등)

                // 임시로 아이디 중복 여부를 true로 설정
                boolean isIdAvailable = true;

                // 아이디 중복 여부에 따라 메시지 출력
                if (isIdAvailable) {
                    JOptionPane.showMessageDialog(SignUp.this, "사용 가능한 아이디입니다!");
                } else {
                    JOptionPane.showMessageDialog(SignUp.this, "이미 사용 중인 아이디입니다. 다른 아이디를 입력하세요.");
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
                        JOptionPane.showMessageDialog(SignUp.this, "비밀번호 설정이 완료되었습니다!");
                    } else {
                        JOptionPane.showMessageDialog(SignUp.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                    }
                } else {
                    JOptionPane.showMessageDialog(SignUp.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                }
            }
        });

        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
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

        // 휴대폰 번호 뒷자리 입력 필드에 숫자만 입력되도록 이벤트 추가
        phonelastField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                }
            }
        });

        // back 버튼 이벤트 처리
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // MainTest 클래스로 전환
                new MainTest();
                setVisible(false); // 현재 창은 숨김
            }
        });




        add(registerLabel);
        add(필수입력사항레이블);
        add(IDLabel);
        add(idField);
        add(duplicateCheckIDButton);
        add(PWLabel);
        add(passwordField);
        add(RPWLabel);
        add(confirmPasswordField);
        add(duplicateCheckPWButton);
        add(NameLabel);
        add(nameField);
        add(birthLabel);
        add(birthYearCombo);
        add(birthMonthCombo);
        add(birthDayCombo);
        add(emailLabel);
        add(emailField);
        add(esignLabel);
        add(emailDomainCombo);
        add(phoneLabel);
        add(phonePrefixCombo);
        add(pfLabel);
        add(phoneField);
        add(plLabel);
        add(phonelastField);
        add(addressLabel);
        add(addressField);
        add(postalLabel);
        add(postalCodeField);
        add(registerButton);
        add(backButton);
        add(mainpanel);






        setVisible(true);
    }




    /*private void performRegister() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressField.getText();

        // 여기에서 실제 회원가입 기능을 구현하면 됩니다.
        // (예: 입력한 정보를 서버에 전송하여 저장하는 등)
        // 아래는 간단한 출력으로 대체합니다.
        System.out.println("아이디: " + username);
        System.out.println("비밀번호: " + new String(password));
        System.out.println("이름: " + name);
        System.out.println("이메일: " + email);
        System.out.println("휴대폰 번호: " + phone);
        System.out.println("주소: " + address);
    }*/


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUp());
    }
}


//비밀번호와 비밀번호 확인 한글 입력 방지가 안됨.