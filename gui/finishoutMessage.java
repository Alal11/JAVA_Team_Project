package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class finishoutMessage extends JFrame {

    public finishoutMessage() {
        // 프레임 설정
        setTitle("회원탈퇴");
        setSize(275, 130);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 레이아웃 설정
        setLayout(new BorderLayout());

        // 텍스트 라벨 추가
        JLabel label = new JLabel("탈퇴가 완료되었습니다.");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);

        // 버튼 패널 추가
        JPanel buttonPanel = new JPanel(new FlowLayout());

        //회원탈퇴 버튼
        JButton okButton = new JButton("메인으로 돌아가기");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(() -> {
                    MainTest mainTest = new MainTest();
                    mainTest.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(okButton)).dispose();
                });
            }
        });
        buttonPanel.add(okButton);
        add(buttonPanel,BorderLayout.SOUTH);

        // 화면에 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new finishoutMessage();
            }
        });
    }
}




