package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.text.*;

public class checkpw extends JFrame {
    private JTextField idField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    private  JButton checkbutton = new JButton();


    public checkpw() {
        // 프레임 설정
        setTitle("My Page");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 표시

        // 헤더 불러오기
        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();


        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        mainpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        mainpanel.setBounds(30, 100, 320, 760); // 위치 및 크기 조정

        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel panel = new JPanel();
        panel.setLayout(null); // 절대 위치 레이아웃으로 설정
        //panel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        panel.setBackground(new Color(242, 242, 242)); // 패널 배경색을 흰색으로 설정
        panel.setBounds(100, 100, 270, 760); // 위치 및 크기 조정

        // 1. "My page" 메인 텍스트 추가 (좌측 상단에)
        JLabel mainText = new JLabel("My Page");
        mainText.setFont(new Font("Arial", Font.PLAIN, 40));
        mainText.setHorizontalAlignment(SwingConstants.CENTER);
        mainText.setBounds(35, 35, 200, 60); // 위치 및 크기 조정
        panel.add(mainText);

        // 2. "주문내역 >"과 "회원정보 수정>" 버튼 추가 (메인 텍스트 밑에 수직으로 배열)
        JButton orderHistoryButton = new JButton("주문내역                  >");
        orderHistoryButton.setForeground(Color.LIGHT_GRAY); // Set text color to green
        orderHistoryButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        orderHistoryButton.setHorizontalAlignment(SwingConstants.CENTER);
        orderHistoryButton.setBounds(0, 130, 270, 80);
        orderHistoryButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        orderHistoryButton.setBackground(Color.WHITE); // Set background color
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
        panel.add(orderHistoryButton);

        JButton modifyUserInfoButton = new JButton("개인정보 수정            >");
        modifyUserInfoButton.setForeground(new Color(29, 185, 89)); // Set text color to light gray
        modifyUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        modifyUserInfoButton.setHorizontalAlignment(SwingConstants.CENTER);
        modifyUserInfoButton.setBounds(0, 210, 270, 80);
        modifyUserInfoButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        modifyUserInfoButton.setBackground(Color.WHITE); // Set background color
        modifyUserInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MyPageEditMember myPageEditMember = new MyPageEditMember();
                    myPageEditMember.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(modifyUserInfoButton)).dispose();
                });
            }
        });
        panel.add(modifyUserInfoButton);

        JPanel subpanel = new JPanel();
        subpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        subpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        subpanel.setBounds(390, 120, 900, 65); // 위치 및 크기 조정

        // 3. 메인 텍스트 우측에 가로선과 "주문내역" label 추가
        JSeparator horizontalLine = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine.setBounds(15, 64, 795, 50); // 위치 및 크기 조정
        subpanel.add(horizontalLine);

        JLabel orderLabel = new JLabel("개인정보 수정");
        orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        orderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderLabel.setBounds(25, 2, 300, 60); // 위치 및 크기 조정
        subpanel.add(orderLabel);

        // 상품패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel checkpanel = new JPanel();
        checkpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        checkpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        checkpanel.setBounds(405, 200, 795, 500); // 위치 및 크기 조정

       /* JSeparator horizontalLine2 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine2.setForeground(Color.BLACK);
        checkpanel.add(horizontalLine2);
        horizontalLine2.setBounds(15, 64, 795, 50); // 위치 및 크기 조정*/


        //JLabel IDLabel = new JLabel("아이디");

        JLabel IDLabel = new JLabel("아이디");
        IDLabel.setFont(new Font("맑은 고딕", Font.BOLD, 21));
        IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        IDLabel.setBounds(190, 50, 100, 50);
        idField.setHorizontalAlignment(SwingConstants.CENTER);
        idField.setBounds(300, 50, 350, 50);
        checkpanel.add(IDLabel);
        checkpanel.add(idField);

        JLabel PWLabel = new JLabel("비밀번호");
        PWLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        PWLabel.setHorizontalAlignment(SwingConstants.LEFT);
        PWLabel.setBounds(190, 130, 100, 50);
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setBounds(300, 130, 350, 50);
        //필드에 길이 제한이 있는 Document를 설정합니다.
        passwordField.setDocument(createDocumentWithMaxLength(10));
        checkpanel.add(PWLabel);
        checkpanel.add(passwordField);

        // 비밀번호 필드에 대한 힌트 텍스트
        String passwordPlaceholder = "비밀번호를 입력해주세요";
        passwordField.setText(passwordPlaceholder);
        passwordField.setForeground(Color.GRAY);

        // 포커스 리스너를 추가하여 힌트 텍스트를 처리
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals(passwordPlaceholder)) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("")) {
                    passwordField.setText(passwordPlaceholder);
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });


        checkbutton = new JButton("확인");
        checkbutton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        checkbutton.setBounds(350, 220, 100, 50);
        checkbutton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        checkbutton.setBackground(Color.WHITE); // 연두색 배경
        checkbutton.setForeground(new Color(29, 185, 89)); // 흰색 글씨
        checkpanel.add(checkbutton);


        JSeparator horizontalLine3 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine3.setForeground(Color.BLACK);
        checkpanel.add(horizontalLine3);
        horizontalLine3.setBounds(15, 300, 795, 50); // 위치 및 크기 조정





        add(panel);
        add(subpanel);
        add(headerPanel);
        add(checkpanel);




        add(mainpanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            checkpw checkpw = new checkpw();
            checkpw.setVisible(true);
        });
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