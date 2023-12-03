package gui;


import api.MemberApi;
import com.fasterxml.jackson.databind.introspect.MemberKey;
import dto.member.MemberDeleteDTO;
import login.LoginMember;
import gui.MyPageMemberDelete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static login.LoginMember.getMemberKey;

public class MemberoutMessage extends JFrame {

    public MemberoutMessage() {
        // 프레임 설정
        setTitle("회원탈퇴");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 레이아웃 설정
        setLayout(new BorderLayout());



        // 텍스트 라벨 추가
        JLabel label = new JLabel("정말로 회원탈퇴를 하시겠습니까?");
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);


        // 버튼 패널 추가
        JPanel buttonPanel = new JPanel(new FlowLayout());

        //회원탈퇴 버튼
        JButton outButton = new JButton("회원 탈퇴");
        outButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password =new String(MyPageMemberDelete.passwordField.getPassword());
                Long memberKey = LoginMember.getMemberKey();

                MemberDeleteDTO myPageMemberDelete = new MemberDeleteDTO(memberKey,password);
                MemberApi.delete(myPageMemberDelete);

                SwingUtilities.invokeLater(() -> {
                    finishoutMessage finishoutMessage = new finishoutMessage();
                    finishoutMessage.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(outButton)).dispose();
                });
            }
        });
        buttonPanel.add(outButton);

        // "계속 쇼핑하기" 버튼 추가
        JButton continueShoppingButton = new JButton("취소");
        continueShoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 현재 창을 닫음
                ((JFrame) SwingUtilities.getWindowAncestor(continueShoppingButton)).dispose();
            }
        });
        buttonPanel.add(continueShoppingButton);


        add(buttonPanel, BorderLayout.SOUTH);



        // 화면에 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MemberoutMessage();
            }
        });
    }
}



