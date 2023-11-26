package gui;


import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class SignUp extends JFrame {

    private JTextField idField, nameField, emailField, phoneField, addressField, postalCodeField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, duplicateCheckIDButton, duplicateCheckPWButton,backButton;

    public JPanel movepanel;

    public SignUp() {
        idField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        postalCodeField = new JTextField();
        duplicateCheckIDButton = new JButton("중복확인");
        duplicateCheckPWButton = new JButton("중복확인");
        backButton = new JButton("<-");
        JPanel movepanel = new JPanel();



        setTitle("회원가입");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);



        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);


        JLabel registerLabel = new JLabel("회원가입");
        // 글꼴 설정
        registerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        // 텍스트 색상 설정
        registerLabel.setForeground(Color.BLACK);
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(540, 30, 200, 50);


        JLabel IDLabel = new JLabel("아이디");
        IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        IDLabel.setBounds(360, 100, 100, 42);
        idField.setHorizontalAlignment(SwingConstants.CENTER);
        idField.setBounds(488, 100, 300, 42);
        idField.setDocument(createDocumentWithMaxLength(10));
        duplicateCheckIDButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckIDButton.setBounds(793, 100, 100, 42);
        duplicateCheckIDButton.setBorder(new Login.RoundedBorder(10, new Color(29, 185, 89)));
        duplicateCheckIDButton.setBackground(Color.WHITE); // 하얀색 배경
        duplicateCheckIDButton.setBorder(new Login.RoundedBorder(10, new Color(29, 185, 89))); // 연두색 테두리
        duplicateCheckIDButton.setForeground(new Color(29, 185, 89)); // 연두색 글씨



        JLabel PWLabel = new JLabel("비밀번호");
        PWLabel.setHorizontalAlignment(SwingConstants.LEFT);
        PWLabel.setBounds(360, 162, 100, 42);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(488, 162, 300, 42);
        //필드에 길이 제한이 있는 Document를 설정합니다.
        passwordField.setDocument(createDocumentWithMaxLength(10));


        JLabel RPWLabel = new JLabel("비밀번호 확인");
        RPWLabel.setHorizontalAlignment(SwingConstants.LEFT);
        RPWLabel.setBounds(360, 224, 100, 42);
        confirmPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
        confirmPasswordField.setBounds(488, 224, 300, 42);
        confirmPasswordField.setDocument(createDocumentWithMaxLength(10));
        duplicateCheckPWButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckPWButton.setBounds(793, 224, 100, 42);
        duplicateCheckPWButton.setBorder(new Login.RoundedBorder(10, new Color(29, 185, 89)));
        duplicateCheckPWButton.setBackground(Color.WHITE); // 하얀색 배경
        duplicateCheckPWButton.setBorder(new Login.RoundedBorder(10, new Color(29, 185, 89))); // 연두색 테두리
        duplicateCheckPWButton.setForeground(new Color(29, 185, 89)); // 연두색 글씨

        JLabel NameLabel = new JLabel("이름");
        NameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        NameLabel.setBounds(360, 286, 100, 42);
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setBounds(488, 286, 300, 42);


        JLabel emailLabel = new JLabel("이메일");
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setBounds(360, 348, 100, 42);
        emailField.setHorizontalAlignment(SwingConstants.CENTER);
        emailField.setBounds(488, 348, 300, 42);
        


        JLabel phoneLabel = new JLabel("휴대폰");
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneLabel.setBounds(360, 410, 100, 42);
        phoneField.setHorizontalAlignment(SwingConstants.CENTER);
        phoneField.setBounds(488, 410, 300, 42);


        JLabel addressLabel = new JLabel("주소");
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setBounds(360, 472, 100, 42);
        addressField.setHorizontalAlignment(SwingConstants.CENTER);
        addressField.setBounds(488, 472, 300, 42);


        JLabel postalLabel = new JLabel("우편번호");
        postalLabel.setHorizontalAlignment(SwingConstants.LEFT);
        postalLabel.setBounds(360, 534, 100, 42);
        postalCodeField.setHorizontalAlignment(SwingConstants.CENTER);
        postalCodeField.setBounds(488, 534, 300, 42);


        registerButton = new JButton("회원가입");
        registerButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        registerButton.setBounds(590, 610, 100, 50);
        registerButton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        registerButton.setBackground(new Color(29, 185, 89)); // 연두색 배경
        registerButton.setForeground(Color.WHITE); // 흰색 글씨


        backButton.setBounds(0, 0, 40, 20);




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
                if (phoneField.getText().isEmpty()) {
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


       /* // 아이디 입력 필드에 한글 입력 방지
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
                    JOptionPane.showMessageDialog(SignUp.this, "아이디를 입력하세요.");
                    return; // 중복확인 중단
                }

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
                // Check if password or confirmPassword fields are empty
                if (new String(passwordField.getPassword()).isEmpty() || new String(confirmPasswordField.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "비밀번호를 입력하세요.");
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
        });*/


        // back 버튼 이벤트 처리
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // MainTest 클래스로 전환
                new MainTest();
                setVisible(false); // 현재 창은 숨김
            }
        });




        mainpanel.add(registerLabel);
        /*mainpanel.add(IDLabel);
        mainpanel.add(idField);
        mainpanel.add(duplicateCheckIDButton);
        mainpanel.add(PWLabel);
        mainpanel.add(passwordField);
        mainpanel.add(RPWLabel);
        mainpanel.add(confirmPasswordField);
        mainpanel.add(duplicateCheckPWButton);
        mainpanel.add(NameLabel);
        mainpanel.add(nameField);
        mainpanel.add(emailLabel);
        mainpanel.add(emailField);
        mainpanel.add(phoneLabel);
        mainpanel.add(phoneField);
        mainpanel.add(addressLabel);
        mainpanel.add(addressField);
        mainpanel.add(postalLabel);
        mainpanel.add(postalCodeField);*/
        mainpanel.add(registerButton);
        mainpanel.add(backButton);
        movepanel.add(mainpanel);

        // 회원가입틀 불러오기
        SignUppart signUpPanel = new SignUppart();
        signUpPanel.setBounds(210, 100, 810, 490); // 헤더 위치 및 크기 조정
        getContentPane().add(signUpPanel);
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

    static class RoundedBorder extends AbstractBorder {
        private final int radius;


        public RoundedBorder(int radius, Color outsideColor, Color insideColor) {
            this.radius = radius;

        }


    }

    // 최대 길이가 있는 Document를 만드는 도우미 메서드
    private Document createDocumentWithMaxLength(int maxLength) {
        PlainDocument document = new PlainDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // 문서의 길이가 제한 내에 있는지 확인합니다.
                if (fb.getDocument().getLength() + string.length() <= maxLength) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // 문서의 길이가 제한 내에 있는지 확인합니다.
                if (fb.getDocument().getLength() - length + text.length() <= maxLength) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        return document;
    }


}


//디자인 할 예정
/* 중복확인 버튼 바탕은 하얀색 / 글씨와 테두리는 연두?초록색
회원가입 버튼 바탕색과 테두리 둘다 연두? 초록색 / 글씨를 하얀색
버튼과 입력 필드 둘다 테두리 둥글게 만들기
회원가입이라는 라벨과 아이디 입력 필드 사이에 검정색 직선 넣기
직선의 길이는 아이디라벨부터 버튼까지 연결할 정도
 */

//비밀번호와 비밀번호 확인 한글 입력 방지가 안됨.
// 단일 색상으로 배경색 설정
//button.setBackground(Color.RED);
// 그라데이션 배경색 설정
/*GradientPaint gradient = new GradientPaint(0, 0, Color.RED, 0, button.getHeight(), Color.YELLOW);
button.setPaint(gradient);*/