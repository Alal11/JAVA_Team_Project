package kyr.gui;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyNaeng extends JFrame {
    private final int labelLimit = 13; // 라벨 추가 제한 수
    ArrayList<JLabel> labelList = new ArrayList<>(); // 라벨을 저장하는 리스트

    public MyNaeng() {
        setTitle("My Refrigerator"); // 프레임 타이틀 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫으면 프로그램 종료
        setSize(1280, 760); // 프레임 크기 설정
        setLocationRelativeTo(null);

        Head2 head = new Head2();
        JPanel headerPanel = head.getHeaderPanel();

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(30, 100, 320, 760);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(242, 242, 242));
        panel.setBounds(100, 100, 270, 760);

        JPanel subpanel = new JPanel();
        subpanel.setLayout(null);
        subpanel.setBackground(Color.WHITE);
        subpanel.setBounds(390, 120, 900, 65);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBounds(410, 180, 750, 480);


        add(panel);
        add(mainPanel);
        add(subpanel);
        add(headerPanel);
        add(mainpanel);

        JLabel mainText = new JLabel("My 냉장고");
        mainText.setFont(new Font("맑은 고딕", Font.BOLD, 38));
        mainText.setHorizontalAlignment(SwingConstants.CENTER);
        mainText.setBounds(35, 35, 200, 60); // 위치 및 크기 조정
        panel.add(mainText);

        JButton orderHistoryButton = new JButton("재료 추가                >");
        orderHistoryButton.setForeground(Color.LIGHT_GRAY); // Set text color to light gray
        orderHistoryButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        orderHistoryButton.setHorizontalAlignment(SwingConstants.CENTER);
        orderHistoryButton.setBounds(0, 130, 270, 80);
        orderHistoryButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        orderHistoryButton.setBackground(Color.WHITE); // Set background color
        panel.add(orderHistoryButton);

        JButton modifyUserInfoButton = new JButton("재료 삭제                >");
        modifyUserInfoButton.setForeground(Color.LIGHT_GRAY); // Set text color to light gray
        modifyUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        modifyUserInfoButton.setHorizontalAlignment(SwingConstants.CENTER);
        modifyUserInfoButton.setBounds(0, 210, 270, 80);
        modifyUserInfoButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Set border color
        modifyUserInfoButton.setBackground(Color.WHITE); // Set background color
        panel.add(modifyUserInfoButton);

        modifyUserInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyNaengMinus myNaengMinus = new MyNaengMinus();
                myNaengMinus.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(orderHistoryButton)).dispose();
            }
        });

        orderHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyNaengAdd myNaengAdd = new MyNaengAdd();
                myNaengAdd.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(orderHistoryButton)).dispose();
            }
        });




        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Closing the application...");
                System.out.println("Contents of labelList:");
                for (JLabel label : labelList) {
                    System.out.println(label.getText());
                }
                System.out.println("Application closed.");
            }
        });

        setVisible(true); // 프레임 보이게 설정
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyNaeng()); // 프로그램 실행
    }
}
