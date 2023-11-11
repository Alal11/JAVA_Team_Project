package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;

    public SignUp() {
        setTitle("회원가입");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel registerLabel = new JLabel("회원가입");
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        registerLabel.setBounds(0, 30, 1280, 20);

        usernameField = new JTextField("아이디를 입력해주세요");
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        usernameField.setForeground(Color.GRAY);
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.setBounds(540, 100, 200, 30);
        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (usernameField.getText().equals("아이디를 입력해주세요")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setForeground(Color.GRAY);
                    usernameField.setText("아이디를 입력해주세요");
                }
            }
        });

        passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setForeground(Color.GRAY);
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setBounds(540, 150, 200, 30);
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                char[] pass = passwordField.getPassword();
                if (new String(pass).equals("비밀번호를 입력해주세요")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                char[] pass = passwordField.getPassword();
                if (new String(pass).isEmpty()) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("비밀번호를 입력해주세요");
                }
            }
        });
        passwordField.setEchoChar('*');
        passwordField.setText("비밀번호를 입력해주세요");

        nameField = new JTextField("이름을 입력해주세요");
        nameField.setHorizontalAlignment(JTextField.CENTER);
        nameField.setForeground(Color.GRAY);
        nameField.setPreferredSize(new Dimension(200, 30));
        nameField.setBounds(540, 200, 200, 30);
        nameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (nameField.getText().equals("이름을 입력해주세요")) {
                    nameField.setText("");
                    nameField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (nameField.getText().isEmpty()) {
                    nameField.setForeground(Color.GRAY);
                    nameField.setText("이름을 입력해주세요");
                }
            }
        });

        emailField = new JTextField("이메일을 입력해주세요");
        emailField.setHorizontalAlignment(JTextField.CENTER);
        emailField.setForeground(Color.GRAY);
        emailField.setPreferredSize(new Dimension(200, 30));
        emailField.setBounds(540, 250, 200, 30);
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (emailField.getText().equals("이메일을 입력해주세요")) {
                    emailField.setText("");
                    emailField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (emailField.getText().isEmpty()) {
                    emailField.setForeground(Color.GRAY);
                    emailField.setText("이메일을 입력해주세요");
                }
            }
        });

        phoneField = new JTextField("휴대폰 번호를 입력해주세요");
        phoneField.setHorizontalAlignment(JTextField.CENTER);
        phoneField.setForeground(Color.GRAY);
        phoneField.setPreferredSize(new Dimension(200, 30));
        phoneField.setBounds(540, 300, 200, 30);
        phoneField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (phoneField.getText().equals("휴대폰 번호를 입력해주세요")) {
                    phoneField.setText("");
                    phoneField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (phoneField.getText().isEmpty()) {
                    phoneField.setForeground(Color.GRAY);
                    phoneField.setText("휴대폰 번호를 입력해주세요");
                }
            }
        });

        addressField = new JTextField("주소를 입력해주세요");
        addressField.setHorizontalAlignment(JTextField.CENTER);
        addressField.setForeground(Color.GRAY);
        addressField.setPreferredSize(new Dimension(200, 30));
        addressField.setBounds(540, 350, 200, 30);
        addressField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (addressField.getText().equals("주소를 입력해주세요")) {
                    addressField.setText("");
                    addressField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (addressField.getText().isEmpty()) {
                    addressField.setForeground(Color.GRAY);
                    addressField.setText("주소를 입력해주세요");
                }
            }
        });

        JButton registerButton = new JButton("회원가입");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performRegister();
            }
        });
        registerButton.setBounds(540, 400, 200, 40);

        panel.add(registerLabel);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(nameField);
        panel.add(emailField);
        panel.add(phoneField);
        panel.add(addressField);
        panel.add(registerButton);

        add(panel);

        setVisible(true);
    }

    private void performRegister() {
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUp());
    }
}
