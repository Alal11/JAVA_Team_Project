package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.AbstractBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUppart extends JPanel {
    private JPanel memberPanel;
    private JTextField idField, nameField, emailField, phoneField, addressField, postalCodeField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton duplicateCheckIDButton, duplicateCheckPWButton;

    public SignUppart() {
        setLayout(null); // 절대 위치 레이아웃으로 설정
        setBackground(Color.WHITE); // 전체 배경색을 하얀색으로 설정
        setBounds(0, 0, 810, 490); // 전체 크기 설정
/*
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        mainPanel.setBackground(Color.WHITE); // 헤더 배경색을 녹색으로 설정

*/
        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        memberPanel = new JPanel();
        memberPanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        memberPanel.setBackground(Color.WHITE); // 헤더 배경색을 녹색으로 설정
        //memberPanel.setBounds(370, 165, 810, 490); // 헤더 위치 및 크기 조정
        memberPanel.setBounds(0, 0, 810, 490); // 헤더 위치 및 크기 조정

        idField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        nameField = new JTextField();
        emailField = new JTextField();
        phoneField = new JTextField();
        addressField = new JTextField();
        postalCodeField = new JTextField();
        duplicateCheckIDButton = new JButton("중복확인");
        duplicateCheckIDButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        duplicateCheckPWButton = new JButton("중복확인");
        duplicateCheckPWButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));

        JLabel IDLabel = new JLabel("아이디");
        IDLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        IDLabel.setForeground(Color.BLACK); // 검정색으로 설정
        IDLabel.setBounds(127,20,150,40);
        idField.setHorizontalAlignment(SwingConstants.CENTER);
        idField.setBounds(277,20,300,40);
        idField.setDocument(createDocumentWithMaxLength(10));

        duplicateCheckIDButton.setHorizontalAlignment(SwingConstants.CENTER);
        duplicateCheckIDButton.setBounds(582,20,100,40);
        duplicateCheckIDButton.setBorder(new Login.RoundedBorder(10,new Color(29,185,89)));
        duplicateCheckIDButton.setBackground(Color.WHITE); // 하얀색 배경
        duplicateCheckIDButton.setBorder(new Login.RoundedBorder(10,new Color(29,185,89))); // 연두색 테두리
        duplicateCheckIDButton.setForeground(new Color(29,185,89)); // 연두색 글씨


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


        JLabel postalLabel = new JLabel("우편번호");
        postalLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        postalLabel.setHorizontalAlignment(SwingConstants.LEFT);
        postalLabel.setBounds(127,440,100,40);
        postalCodeField.setHorizontalAlignment(SwingConstants.CENTER);
        postalCodeField.setBounds(277,440,300,40);






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
        duplicateCheckIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                // Check if the ID field is empty
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "아이디를 입력하세요.");
                    return; // 중복확인 중단
                }

                // 여기에서 아이디 중복 확인 로직을 구현
                // (예: 서버에 아이디를 전송하여 중복 여부를 확인하는 등)

                // 임시로 아이디 중복 여부를 true로 설정
                boolean isIdAvailable = true;

                // 아이디 중복 여부에 따라 메시지 출력
                if (isIdAvailable) {
                    JOptionPane.showMessageDialog(SignUppart.this, "사용 가능한 아이디입니다!");
                } else {
                    JOptionPane.showMessageDialog(SignUppart.this, "이미 사용 중인 아이디입니다. 다른 아이디를 입력하세요.");
                }

                //System.out.println(idField.getText());
            }
        });


        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped (KeyEvent e){
                char c = e.getKeyChar();
                // 유니코드 범위 내의 한글 입력을 막음
                if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_SYLLABLES ||
                        Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_JAMO ||
                        Character.UnicodeBlock.of(c) == Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed (KeyEvent e){
                // 키 누름 이벤트 처리
            }

            @Override
            public void keyReleased (KeyEvent e){
                // 키 뗌 이벤트 처리
            }
        });

        duplicateCheckPWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                // Check if password or confirmPassword fields are empty
                if (new String(passwordField.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호를 입력하세요.");
                    return;
                }

                if (new String(confirmPasswordField.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호확인도 입력하세요.");
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
                        JOptionPane.showMessageDialog(SignUppart.this, "비밀번호 설정이 완료되었습니다!");
                    } else {
                        JOptionPane.showMessageDialog(SignUppart.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
                    }
                } else {
                    JOptionPane.showMessageDialog(SignUppart.this, "비밀번호가 일치하지 않습니다. 다시 입력하세요.");
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
        memberPanel.add(duplicateCheckIDButton);
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
        memberPanel.add(postalLabel);
        memberPanel.add(postalCodeField);



// 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel aPanel = new JPanel();
        //memberPanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        //memberPanel.setBackground(Color.WHITE); // 헤더 배경색을 녹색으로 설정
        //memberPanel.setBounds(370, 165, 810, 490); // 헤더 위치 및 크기 조정
        //memberPanel.setBounds(0, 0, 810, 490); // 헤더 위치 및 크기 조정
        aPanel.add(memberPanel);
        aPanel.remove(postalLabel);



        add(memberPanel);
        //add(mainPanel);
    }













    public static void main(String[] args) {
        JFrame frame = new JFrame("My Page");
        frame.setSize(1280, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SignUppart signUppart = new SignUppart();
        frame.add(signUppart);

        frame.setVisible(true);
    }

    public JTextField getIdField() {
        return idField;
    }


    public JTextField getPasswordField() {
        return passwordField;
    }

    public JTextField getconPasswordField() {
        return passwordField;
    }

    public JTextField getNameField() {
        return nameField;
    }
    public JTextField getEmailField() {
        return emailField;
    }
    public JTextField getPhoneField() {
        return phoneField;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JTextField getPostalCodeField() {
        return postalCodeField;
    }

    static class RoundedBorder extends AbstractBorder {
        private final int radius;
        private final Color outsideColor;
        private final Color insideColor;

        public RoundedBorder(int radius, Color outsideColor, Color insideColor) {
            this.radius = radius;
            this.outsideColor = outsideColor;
            this.insideColor = insideColor;
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

    public JPanel getmemberPanel() {
            return memberPanel;
        }


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


//이메일에 @이 미입력시 이메일 입력이 잘못되었습니다.라는 문구 띄우기
