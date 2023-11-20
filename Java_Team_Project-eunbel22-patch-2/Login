package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("로그인");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel loginLabel = new JLabel("로그인");
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setBounds(0, 30, 1280, 20);

        usernameField = new JTextField("아이디를 입력해주세요");
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        usernameField.setForeground(Color.GRAY);
        usernameField.setPreferredSize(new Dimension(200, 30));
        usernameField.setBounds(540, 200, 200, 30);
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
        passwordField.setBounds(540, 250, 200, 30);
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
        passwordField.setEchoChar('*'); // EchoChar 속성 설정
        passwordField.setText("비밀번호를 입력해주세요");

        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        loginButton.setBounds(540, 300, 200, 40);

        panel.add(loginLabel);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);

        setVisible(true);
    }

    private void performLogin() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        System.out.println("아이디: " + username);
        System.out.println("비밀번호: " + new String(password));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}
