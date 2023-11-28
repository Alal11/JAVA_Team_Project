package kyr.gui;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class MainTest extends JFrame {

    public MainTest() {


        setTitle("Cookeryket"); // 프레임 제목 설정
        setSize(1280, 760); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 시 프레임 닫기 설정
        setLocationRelativeTo(null); // 프레임을 화면 중앙에 위치시킴

        Head2 head = new Head2();
        JPanel headerPanel = head.getHeaderPanel();

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(30, 100, 320, 760);


        add(headerPanel);
        add(mainpanel);





        // 모든 컴포넌트를 담을 패널 생성

        // 로고 이미지 설정
        ImageIcon logoIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/logo_out.png")); // 이미지 아이콘 로드
        Image logoImage = logoIcon.getImage().getScaledInstance(105, 95, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedLogoIcon = new ImageIcon(logoImage); // 조절된 이미지 아이콘 생성
        JLabel imgLabel = new JLabel(resizedLogoIcon); // 이미지 아이콘을 담을 라벨 생성
        imgLabel.setBounds(285, 200, 400, 100); // 이미지의 위치 및 크기 설정
        mainpanel.add(imgLabel); // 패널에 이미지 라벨 추가



        JLabel titleLabel = new JLabel("cookeryket");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 60));
        titleLabel.setBounds(535, 220, 320, 70);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.WHITE); // 배경 색상 설정
        titleLabel.setForeground(Color.DARK_GRAY); // 글씨 색상 설정
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // 테두리 색상 설정
        mainpanel.add(titleLabel);
        mainpanel.setComponentZOrder(titleLabel, 0);



        // 검색창 설정
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(600, 60)); // 검색창 크기 설정
        searchField.setBounds(350, 340, 600, 60); // 검색창 위치 및 크기 설정
        int thickness = 2; // 원하는 두께로 수정 가능
        Border border = BorderFactory.createLineBorder(Color.GRAY, thickness);
        searchField.setBorder(border);


        mainpanel.add(searchField); // 패널에 검색창 추가

        /////이게 로그인 아이콘
        ImageIcon loginIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/loginIcon.png")); // 로그인 이미지 아이콘 로드
        Image loginImage = loginIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedLoginIcon = new ImageIcon(loginImage); // 조절된 이미지 아이콘 생성
        JButton loginButton = new JButton(resizedLoginIcon); // 이미지 아이콘을 담은 버튼 생성
        loginButton.setBounds(540, 450, 80, 80); // 버튼의 위치 및 크기 설정

        JLabel loginlabel = new JLabel("로그인");
        loginlabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        loginlabel.setForeground(Color.BLACK);
        loginlabel.setBounds(553, 530, 70, 40);
        mainpanel.add(loginlabel);

        loginButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
        loginButton.addActionListener(e -> { // 로그인 버튼에 대한 액션 설정
            new Login();
            setVisible(false);
        });

        mainpanel.add(loginButton); // 패널에 로그인 버튼 추가




        /////이게 로그인 아이콘
        ImageIcon signupIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/signupIcon.png")); // 회원가입 이미지 아이콘 로드
        Image signupImage = signupIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedSignupIcon = new ImageIcon(signupImage); // 조절된 이미지 아이콘 생성
        JButton signupButton = new JButton(resizedSignupIcon); // 이미지 아이콘을 담은 버튼 생성
        signupButton.setBounds(680, 450, 80, 80); // 버튼의 위치 및 크기 설정

        JLabel signlabel = new JLabel("회원가입");
        signlabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        signlabel.setForeground(Color.BLACK);
        signlabel.setBounds(688, 530, 70, 40);
        mainpanel.add(signlabel);

        signupButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
        signupButton.addActionListener(e -> { // 회원가입 버튼에 대한 액션 설정
            new SignUp();
            setVisible(false);
        });

        mainpanel.add(signupButton); // 패널에 회원가입 버튼 추가



        // 로그인, 회원가입, 마이페이지 버튼을 담을 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬된 레이아웃 설정
        buttonPanel.setBounds(0, 330, getWidth(), 30); // 버튼 패널의 위치 설정
        buttonPanel.setBackground(Color.WHITE); // 버튼 패널의 배경색 설정
        mainpanel.add(buttonPanel); // 패널에 버튼 패널 추가

        // 로그인 버튼 생성 및 이벤트 처리
//            JButton loginButton = new JButton("로그인");
//            loginButton.addActionListener(e -> {
//                new Login();
//                setVisible(false);
//            });
//            buttonPanel.add(loginButton); // 버튼 패널에 로그인 버튼 추가

        // 회원가입 버튼 생성 및 이벤트 처리
//            JButton signupButton = new JButton("회원가입");
//            signupButton.addActionListener(e -> {
//                new SignUp();
//                setVisible(false);
//            });
//            buttonPanel.add(signupButton); // 버튼 패널에 회원가입 버튼 추가

        // 마이페이지 버튼 생성 및 이벤트 처리
//            JButton myPageButton = new JButton("마이페이지");
//            myPageButton.addActionListener(e -> {
//                new MyPage();
//                setVisible(false);
//            });
//            buttonPanel.add(myPageButton); // 버튼 패널에 마이페이지 버튼 추가

        // 화면 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainTest::new);
    }
}