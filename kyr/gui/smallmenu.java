package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.border.*;

public class smallmenu extends JFrame {

    public smallmenu() {

        setTitle("Cookeryket"); // 프레임 제목 설정
        setSize(300, 460); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 시 프레임 닫기 설정
        setLocationRelativeTo(null); // 프레임을 화면 중앙에 위치시킴

        JPanel upmainpanel = new JPanel();
        upmainpanel.setLayout(null);
        upmainpanel.setBackground(Color.WHITE);
        upmainpanel.setBounds(1, 1, 300, 210);

        JPanel downmainpanel = new JPanel();
        downmainpanel.setLayout(null);
        downmainpanel.setBackground(Color.BLACK);
        downmainpanel.setBounds(260, 100, 300, 230);

        String imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzEwMjlfMjE5%2FMDAxNjk4NTY2OTIyMjEy.iPblP9maWJzlfCiGPV9eE2D328XpFx36O1Lkdb-OCzog.lwDq3nPStd4Jjphj6aCv5LbV5D0z2gBf1xnGRfCtVIYg.JPEG.jh80188492%2F4.JPG&type=a340";
        // 이미지 주소 복사 누르면 됩니다. 이미지 URL을 여기에 입력하세요
        String food_name = "존나 맛있는 김치찌개" ;
        // 이미지 불러와서 JLabel에 설정
        try {
            URL url = new URL(imageUrl);
            ImageIcon imageIcon = new ImageIcon(url);
            Image foodimg = imageIcon.getImage().getScaledInstance(256, 177, Image.SCALE_SMOOTH);
            ImageIcon resizedfoodimg =new ImageIcon(foodimg);
            JButton foodButton = new JButton(resizedfoodimg); // 이미지 아이콘을 담은 버튼 생성
            foodButton.setBounds(15, 15, 256, 177); // 버튼의 위치 및 크기 설정
            upmainpanel.add(foodButton); // 패널에 로그인 버튼 추가
            foodButton.setBorderPainted(false); // 버튼 테두리 표시 안 함

            JLabel foodlabel = new JLabel(food_name);
            foodlabel.setFont(new Font("맑은 고딕", Font.PLAIN, 49));
            foodlabel.setBounds(50, 50, 200, 30); // 위치와 크기 설정
            upmainpanel.add(foodlabel);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        add(upmainpanel);
        add(downmainpanel);
    }

    public static void main(String[] args) {
        smallmenu Smallmenu = new smallmenu();
        Smallmenu.setVisible(true);
    }
}