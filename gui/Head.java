package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Head extends JPanel {
    private JPanel headerPanel;

    public Head() {
        setLayout(null); // 절대 위치 레이아웃으로 설정
        setBackground(Color.WHITE); // 전체 배경색을 하얀색으로 설정
        setBounds(0, 0, 1280, 760); // 전체 크기 설정


        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        headerPanel = new JPanel();
        headerPanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        headerPanel.setBackground(new Color(123, 199, 139)); // 헤더 배경색을 녹색으로 설정
        headerPanel.setBounds(100, 0, 1080, 100); // 헤더 위치 및 크기 조정



        ImageIcon logoIcon = new ImageIcon(MainTest.class.getResource("/image/logo_out.png"));
        Image logoImage = logoIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon resizedLogoIcon = new ImageIcon(logoImage);
        JLabel imgLabel = new JLabel(resizedLogoIcon);
        imgLabel.setBounds(30, 20, 70, 60); // 이미지의 위치와 크기 설정
        headerPanel.add(imgLabel);


        // "cookeryket" 버튼
        JButton titleButton = new JButton("cookeryket");
        titleButton.setFont(new Font("Arial", Font.BOLD, 50));
        titleButton.setBounds(100, 20, 300, 60);
        titleButton.setBackground(new Color(123, 199, 139)); // 배경 색상 설정
        titleButton.setForeground(Color.WHITE); // 글씨 색상 설정
        titleButton.setBorder(BorderFactory.createLineBorder(new Color(123, 199, 139))); // 테두리 색상 설정
        titleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MainTestLoginfinish mainTestLoginfinish = new MainTestLoginfinish();
                    mainTestLoginfinish.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(titleButton)).dispose();
                });
            }
        });
        headerPanel.add(titleButton);

        // "땡땡땡님" 텍스트
        JLabel nameLabel = new JLabel("땡땡땡님");
        nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setBounds(840, 5, 70, 40);
        headerPanel.add(nameLabel);

        // "mypage" 버튼
        JButton myPageButton = new JButton("mypage");
        myPageButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        myPageButton.setBounds(915, 3, 70, 40);
        myPageButton.setBackground(new Color(123, 199, 139)); // 배경 색상 설정
        myPageButton.setForeground(Color.WHITE); // 글씨 색상 설정
        myPageButton.setBorder(BorderFactory.createLineBorder(new Color(123, 199, 139))); // 테두리 색상 설정
        myPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MyPageOrder myPageOrder = new MyPageOrder();
                    myPageOrder.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(myPageButton)).dispose();
                });
            }
        });
        headerPanel.add(myPageButton);


        // "로그아웃" 버튼
        JButton logoutButton = new JButton("로그아웃");
        logoutButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        logoutButton.setBounds(990, 5, 70, 40);
        logoutButton.setBackground(new Color(123, 199, 139)); // 배경 색상 설정
        logoutButton.setForeground(Color.WHITE); // 글씨 색상 설정
        logoutButton.setBorder(BorderFactory.createLineBorder(new Color(123, 199, 139))); // 테두리 색상 설정
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MainTest mainTest = new MainTest();
                    mainTest.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(logoutButton)).dispose();
                });
            }
        });
        headerPanel.add(logoutButton);
        add(headerPanel);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Page");
        frame.setSize(1280, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Head2 head = new Head2();
        frame.add(head);

        frame.setVisible(true);
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }


}
