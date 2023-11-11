/*
package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class LoginSwingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        JPanel panel = new JPanel();
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // HTTP 요청을 통해 스프링 부트로 데이터 전송
                sendLoginDataToSpring(username, password);
            }
        });
    }

    private static void sendLoginDataToSpring(String username, String password) {
        try {
            // 예시: 스프링 부트 서버의 /login 엔드포인트로 POST 요청 전송
            URL url = new URL("http://localhost:8080/login");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // 아이디와 비밀번호를 전송
            String postData = "username=" + username + "&password=" + password;
            connection.getOutputStream().write(postData.getBytes());

            // 응답 읽기 (실제로는 응답 처리가 필요)
            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
*/
