package kyr.gui;


import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class SignUp extends JFrame {
   private JButton registerButton, backButton;

    public SignUp() {
        setTitle("회원가입");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        SignUppart signUppart = new SignUppart();
        JTextField idField = signUppart.getIdField();
        JPasswordField passwordField = (JPasswordField) signUppart.getPasswordField();
        JPasswordField confirmPasswordField = (JPasswordField) signUppart.getconPasswordField();
        JTextField nameField = signUppart.getNameField();
        JTextField emailField = signUppart.getEmailField();
        JTextField phoneField = signUppart.getPhoneField();
        JTextField addressField = signUppart.getAddressField();
        JTextField postalCodeField = signUppart.getPostalCodeField();

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


        registerButton = new JButton("회원가입");
        registerButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        registerButton.setBounds(590, 610, 100, 50);
        registerButton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        registerButton.setBackground(new Color(29, 185, 89)); // 연두색 배경
        registerButton.setForeground(Color.WHITE); // 흰색 글씨

        // 회원가입 버튼 이벤트 처리
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아이디 필드가 비어있는지 확인
                if (idField == null || idField.getText().trim().isEmpty()) {
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
                            //performRegister();
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


        backButton = new JButton("<-");
        backButton.setBounds(0, 0, 40, 20);

        // 회원가입틀 불러오기
        SignUppart signUpPanel = new SignUppart();
        signUpPanel.setBounds(210, 100, 810, 490); // 헤더 위치 및 크기 조정
        getContentPane().add(signUpPanel);
        mainpanel.add(registerLabel);


        // back 버튼 이벤트 처리
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // MainTest 클래스로 전환
                new MainTest();
                setVisible(false); // 현재 창은 숨김
            }
        });


        mainpanel.add(registerButton);
        mainpanel.add(backButton);
        add(mainpanel);
        setVisible(true);
    }



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




//비밀번호와 비밀번호 확인 한글 입력 방지가 안됨.


//이메일에 @이 미입력시 이메일 입력이 잘못되었습니다.라는 문구 띄우기
