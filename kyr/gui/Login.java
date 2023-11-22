package kyr.gui;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton clearButton;  // "X" 버튼(아이디)
    private JButton passwordClearButton; //"X" 버튼(비번)

    private JButton backButton;

    public Login() {
        setTitle("쿠커리켓");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);



        //backButton 생성
        backButton = new JButton("<-");
        backButton.setBounds(0, 0, 80, 40);
        // back 버튼 이벤트 처리
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // MainTest 클래스로 전환
                new MainTest();
                setVisible(false); // 현재 창은 숨김
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        //mainPanel.setLayout(new FlowLayout());
        // 타이틀 레이블 추가
        JLabel label = new JLabel("로그인");
        label.setFont(new Font("맑은 고딕", Font.BOLD, 36));  // 폰트 설정
        label.setHorizontalAlignment(SwingConstants.CENTER);  // 텍스트 가운데 정렬
        label.setBounds(540, 100, 200, 50);


        // 아이디 필드
        usernameField = new JTextField("아이디를 입력해주세요", 32);
        usernameField.setBounds(390, 200, 500, 60);
        usernameField.setFont(new Font("Serif", Font.PLAIN, 15));
        PlainDocument usernameDocument = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                // 아이디 입력 필드에 최대 글자 수를 10자로 제한
                if (getLength() + str.length() <= 10) {
                    super.insertString(offs, str, a);
                }
            }
        };
        usernameField.setDocument(usernameDocument);
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        usernameField.setForeground(Color.GRAY);
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (usernameField.getText().equals("아이디")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setForeground(Color.GRAY);
                    usernameField.setText("아이디");
                }
            }
        });

        // "X" 버튼을 아이디 입력 필드와 연결
        clearButton = new JButton("X");
        clearButton.setBounds(880, 200, 60, 60);
        clearButton.setFont(new Font("Serif", Font.PLAIN, 12));
        clearButton.setFocusPainted(false);
        clearButton.setVisible(false);
        clearButton.setBackground(Color.WHITE); // Set the background color to white
        clearButton.setOpaque(false);
        clearButton.setBorderPainted(false);

        // 아이디 필드 내용 변경을 감지하는 DocumentListener 추가
        usernameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateClearButtonVisibility();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateClearButtonVisibility();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components may not fire these events
            }
        });

        // 포커스 이벤트를 처리하는 FocusListener 추가
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("아이디")) {
                    usernameField.setText("");
                    clearButton.setVisible(false);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty() && !passwordField.isFocusOwner()) {
                    usernameField.setText("아이디");
                    clearButton.setVisible(false);
                } else {
                    clearButton.setVisible(true);
                }
            }
        });

        // "X" 버튼을 클릭하면 아이디 입력 필드의 내용을 지우기
        clearButton.addActionListener(e -> {
            usernameField.setText("");
            clearButton.setVisible(false);
        });

        // 아이디 입력 필드에 한글 입력 방지
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ((c >= '가' && c <= '힣') || (c >= 'ㄱ' && c <= 'ㅎ')) {
                    e.consume();
                }
            }
        });


        // 비밀번호 필드
        passwordField = new JPasswordField(32);
        passwordField.setBounds(390, 270, 500, 60);
        passwordField.setFont(new Font("Serif", Font.PLAIN, 15));
        PlainDocument passwordDocument = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength() + str.length() <= 10) {
                    super.insertString(offs, str, a);
                }
            }
        };
        passwordField.setDocument(passwordDocument);
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setForeground(Color.GRAY);
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                char[] pass = passwordField.getPassword();
                if (new String(pass).equals("비밀번호")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                char[] pass = passwordField.getPassword();
                if (new String(pass).isEmpty()) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("비밀번호");
                }
            }
        });
        passwordField.setEchoChar('*');

        // "X" 버튼을 비밀번호 입력 필드와 연결
        passwordClearButton = new JButton("X");
        passwordClearButton.setBounds(880, 270, 60, 60);
        passwordClearButton.setFont(new Font("Serif", Font.PLAIN, 12));
        passwordClearButton.setFocusPainted(false);
        passwordClearButton.setVisible(false);
        passwordClearButton.setOpaque(false);
        passwordClearButton.setBackground(Color.WHITE); // Set the background color to white
        passwordClearButton.setBorderPainted(false);

        // 비밀번호 필드 내용 변경을 감지하는 DocumentListener 추가
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePasswordClearButtonVisibility();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePasswordClearButtonVisibility();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Plain text components may not fire these events
            }
        });

        // 포커스 이벤트를 처리하는 FocusListener 추가
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("비밀번호")) {
                    passwordField.setText("");
                    passwordClearButton.setVisible(false);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (new String(passwordField.getPassword()).isEmpty() && !passwordField.isFocusOwner()) {
                    passwordField.setText("비밀번호");
                    passwordClearButton.setVisible(false);
                } else {
                    passwordClearButton.setVisible(true);
                }
            }
        });

        // "X" 버튼을 클릭하면 비밀번호 입력 필드의 내용을 지우기
        passwordClearButton.addActionListener(e -> {
            passwordField.setText("");
            passwordClearButton.setVisible(false);
        });


        // 로그인 버튼
        JButton loginButton = new JButton("로그인");
        loginButton.setBounds(390, 350, 500, 60);
        loginButton.setFont(new Font("Serif", Font.BOLD, 24));
        loginButton.setBorder(new RoundedBorder(10, new Color(39, 185, 89)));
        loginButton.setBackground(new Color(39, 185, 89)); // 연두색 배경
        loginButton.setBorder(new RoundedBorder(10, new Color(39, 185, 89))); // 연두색 테두리
        loginButton.setForeground(Color.WHITE); // 흰색 글씨

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아이디와 비밀번호 필드의 값을 가져옴
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // 아이디 또는 비밀번호가 비어있을 경우 메시지 표시
                if (username.isEmpty() || username.equals("아이디")) {
                    JOptionPane.showMessageDialog(Login.this, "아이디를 입력해주세요.");
                } else if (password.isEmpty() || password.equals("비밀번호")) {
                    JOptionPane.showMessageDialog(Login.this, "비밀번호를 입력해주세요.");
                } else {
                    // 아이디와 비밀번호 모두 입력되었을 경우 로그인 진행
                    JOptionPane.showMessageDialog(Login.this, "로그인이 완료되었습니다.");
                    new MainTestLoginfinish();
                    setVisible(false);
                }
            }
        });




        // 회원가입 버튼
        JButton signupButton = new JButton("회원가입");
        signupButton.setBounds(390, 420, 500, 60);
        signupButton.setFont(new Font("Serif", Font.BOLD, 24));
        signupButton.setBorder(new RoundedBorder(10, new Color(39, 185, 89)));
        signupButton.setBackground(Color.WHITE); // 하얀색 배경
        signupButton.setBorder(new RoundedBorder(10, new Color(39, 185, 89))); // 연두색 테두리
        signupButton.setForeground(new Color(39, 185, 89)); // 연두색 글씨

        signupButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(Login.this, "회원가입을 진행합니다.");
            new SignUp();
            setVisible(false);
        });







        add(backButton);
        add(label);
        add(usernameField);
        add(clearButton);
        add(passwordField);
        add(passwordClearButton);
        add(loginButton);
        add(signupButton);
        add(mainPanel);




        setVisible(true);
    }

    private void updateClearButtonVisibility() {
        clearButton.setVisible(!usernameField.getText().isEmpty() && !usernameField.getText().equals("아이디"));
    }

    private void updatePasswordClearButtonVisibility() {
        String password = new String(passwordField.getPassword());
        boolean showClearButton = !password.isEmpty() && !password.equals("비밀번호");
        passwordClearButton.setVisible(showClearButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }

    static class RoundedBorder extends AbstractBorder {
        private final int radius;

        public RoundedBorder(int radius, Color color) {
            this.radius = radius;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}
