package gui;

import api.MemberApi;
import dto.member.*;
import dto.member.MemberCheckPwDTO;
import login.LoginMember;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.text.*;

import static login.LoginMember.getMemberId;
import static login.LoginMember.getMemberKey;

public class MyPageMemberDelete extends JFrame {
    public static JPasswordField passwordField=new JPasswordField();
    private JLabel myidLabel = new JLabel(getMemberId());
    

    private  JButton checkbutton = new JButton();


    public MyPageMemberDelete() {
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
        modifyUserInfoButton.setForeground(Color.LIGHT_GRAY); // Set text color to green
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
                    checkpw checkpw = new checkpw();
                    checkpw.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(modifyUserInfoButton)).dispose();
                });
            }
        });
        panel.add(modifyUserInfoButton);

        JButton MemberDeleteButton = new JButton("회원 탈퇴                  >");
        MemberDeleteButton.setForeground(new Color(29, 185, 89)); // Set text color to light gray
        MemberDeleteButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        MemberDeleteButton.setHorizontalAlignment(SwingConstants.CENTER);
        MemberDeleteButton.setBounds(0, 290, 270, 80);
        MemberDeleteButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        MemberDeleteButton.setBackground(Color.WHITE); // Set background color
        MemberDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MyPageMemberDelete myPageMemberDelete = new MyPageMemberDelete();
                    myPageMemberDelete.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(MemberDeleteButton)).dispose();
                });
            }
        });
        panel.add(MemberDeleteButton);

        JPanel subpanel = new JPanel();
        subpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        subpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        subpanel.setBounds(390, 120, 900, 65); // 위치 및 크기 조정

        // 3. 메인 텍스트 우측에 가로선과 "주문내역" label 추가
        JSeparator horizontalLine = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine.setBounds(15, 64, 795, 50); // 위치 및 크기 조정
        subpanel.add(horizontalLine);

        JLabel orderLabel = new JLabel("회원 탈퇴");
        orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        orderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderLabel.setBounds(25, 2, 300, 60); // 위치 및 크기 조정
        subpanel.add(orderLabel);

        // 상품패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel checkpanel = new JPanel();
        checkpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        checkpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        checkpanel.setBounds(405, 200, 795, 500); // 위치 및 크기 조정



        JLabel IDLabel = new JLabel("아이디");
        IDLabel.setFont(new Font("맑은 고딕", Font.BOLD, 21));
        IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
        IDLabel.setBounds(190, 50, 100, 50);
        myidLabel.setHorizontalAlignment(SwingConstants.CENTER);
        myidLabel.setBounds(300, 50, 350, 50);
        checkpanel.add(IDLabel);
        checkpanel.add(myidLabel);

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





        checkbutton = new JButton("회원탈퇴");
        checkbutton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        checkbutton.setBounds(350, 220, 100, 50);
        checkbutton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        checkbutton.setBackground(Color.WHITE); // 연두색 배경
        checkbutton.setForeground(new Color(29, 185, 89)); // 흰색 글씨
        checkpanel.add(checkbutton);



        checkbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long memberKey = LoginMember.getMemberKey();
                // Check if the password field is empty
                if (String.valueOf(passwordField.getPassword()).trim().isEmpty()) {
                    JOptionPane.showMessageDialog(MyPageMemberDelete.this, "비밀번호를 입력하세요.", "경고", JOptionPane.WARNING_MESSAGE);
                } else {
                    MemberCheckPwDTO checkDto = new MemberCheckPwDTO(memberKey,new String(passwordField.getPassword()));


                    MemberApi.checkPw(checkDto);

                    // If not empty, proceed with your existing logic
                    SwingUtilities.invokeLater(() -> {
                        MemberoutMessage memberoutMessage = new MemberoutMessage();
                        memberoutMessage.setVisible(true);

                        // 현재 창을 닫음
                        //((JFrame) SwingUtilities.getWindowAncestor(checkbutton)).dispose();
                    });
                }
            }
        });

        Window windows = SwingUtilities.getWindowAncestor(checkbutton);
        if (windows != null&&windows instanceof JFrame) {
            ((JFrame) windows).dispose();
        }




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

    public MyPageMemberDelete(Long memberKey, String password) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyPageMemberDelete myPageMemberDelete = new MyPageMemberDelete();
            myPageMemberDelete.setVisible(true);
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