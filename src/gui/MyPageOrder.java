package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPageOrder extends JFrame {

    public MyPageOrder() {
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
        panel.setBackground(new Color(242, 242, 242)); // 패널 배경색을 흰색으로 설정
        //panel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        panel.setBounds(100, 100, 270, 760); // 위치 및 크기 조정

        // 1. "My page" 메인 텍스트 추가 (좌측 상단에)
        JLabel mainText = new JLabel("My Page");
        mainText.setFont(new Font("Arial", Font.PLAIN, 40));
        mainText.setHorizontalAlignment(SwingConstants.CENTER);
        mainText.setBounds(35, 35, 200, 60); // 위치 및 크기 조정
        panel.add(mainText);

        // 2. "주문내역 >"과 "회원정보 수정>" 버튼 추가 (메인 텍스트 밑에 수직으로 배열)
        JButton orderHistoryButton = new JButton("주문내역                  >");
        orderHistoryButton.setForeground(new Color(29, 185, 89)); // Set text color to green
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
        modifyUserInfoButton.setForeground(Color.LIGHT_GRAY); // Set text color to light gray
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
        MemberDeleteButton.setForeground(Color.LIGHT_GRAY); // Set text color to light gray
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
        horizontalLine.setBounds(15, 64, 775, 50); // 위치 및 크기 조정
        subpanel.add(horizontalLine);

        JLabel orderLabel = new JLabel("주문내역");
        orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        orderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderLabel.setBounds(25, 2, 300, 60); // 위치 및 크기 조정
        subpanel.add(orderLabel);


        // 상품패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        MyPageProductpanel myPageProductpanel = new MyPageProductpanel();

        // MyPageProductpanel에서 생성한 JScrollPane을 얻어옵니다.
        JScrollPane scrollPane = myPageProductpanel.getScrollPane();

        scrollPane.setBounds(405,185,775,500);




        add(panel);
        add(scrollPane);
        add(subpanel);
        add(headerPanel);
        add(mainpanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyPageOrder myPageOrder = new MyPageOrder();
            myPageOrder.setVisible(true);
        });
    }
}



