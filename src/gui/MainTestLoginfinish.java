package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

public class MainTestLoginfinish extends JFrame {

    public MainTestLoginfinish() {
        setTitle("Cookeryket"); // 프레임 제목 설정
        setSize(1280, 760); // 프레임 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 시 프레임 닫기 설정
        setLocationRelativeTo(null); // 프레임을 화면 중앙에 위치시킴

        // 모든 컴포넌트를 담을 패널 생성
        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(30, 100, 320, 760);


        add(headerPanel);
        add(mainpanel);


        // 로고 이미지 설정
        // 로고 이미지 설정
        // 로고 이미지 설정
        ImageIcon logoIcon = new ImageIcon(MainTest.class.getResource("/image/logo_out.png")); // 이미지 아이콘 로드
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
        JTextField searchField = new JTextField("  원하는 가격을 적어주세요");
        searchField.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        searchField.setBackground(Color.WHITE);
        searchField.setForeground(Color.LIGHT_GRAY);
        //searchField.setPreferredSize(new Dimension(600, 60)); // 검색창 크기 설정
        searchField.setBounds(350, 340, 600, 60); // 검색창 위치 및 크기 설정
        int thickness = 2; // 원하는 두께로 수정 가능
        Border border = BorderFactory.createLineBorder(Color.GRAY, thickness);
        searchField.setBorder(border);


        ImageIcon searchIcon = new ImageIcon(MainTest.class.getResource("/image/searchicon.png"));
        Image searchImage = searchIcon.getImage().getScaledInstance(59, 59, Image.SCALE_SMOOTH);
        ImageIcon sIcon = new ImageIcon(searchImage);
        JButton searchButton = new JButton(sIcon);
        searchButton.setBounds(950, 340, 59, 59);

        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchField.getText().equals("  원하는 가격을 적어주세요")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("  원하는 가격을 적어주세요");
                    searchField.setForeground(Color.LIGHT_GRAY);
                }
            }
        });


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PriceSearch();
            }
        });

        // 프레임이 나타날 때 searchField에 포커스를 주기
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                searchButton.requestFocus();
            }
        });



        mainpanel.add(searchField); // 패널에 검색창 추가
        mainpanel.add(searchButton);

        // 카트 아이콘 로드
        ImageIcon cartIcon = new ImageIcon(MainTest.class.getResource("/image/Cartcon.png")); // 카트 아이콘 이미지 로드
        Image cartImage = cartIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedCartIcon = new ImageIcon(cartImage); // 조절된 이미지 아이콘 생성
        JButton cartButton = new JButton(resizedCartIcon); // 이미지 아이콘을 담은 버튼 생성
        cartButton.setBounds(400, 450, 80, 80); // 버튼의 위치 및 크기 설정

        JLabel cartLabel = new JLabel("장바구니");
        cartLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        cartLabel.setForeground(Color.BLACK);
        cartLabel.setBounds(410, 530, 70, 40);
        mainpanel.add(cartLabel);

        cartButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    Cart cart = null;
                    try {
                        cart = new Cart();
                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    }
                    cart.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(cartButton)).dispose();
                });
            }
        });
        mainpanel.add(cartButton); // 패널에 장바구니 버튼 추가


        ImageIcon menuSearchIcon = new ImageIcon(MainTest.class.getResource("/image/menuserch.png")); // 메뉴 검색 아이콘 이미지 로드
        Image menuSearchImage = menuSearchIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedMenuSearchIcon = new ImageIcon(menuSearchImage); // 조절된 이미지 아이콘 생성
        JButton menuSearchButton = new JButton(resizedMenuSearchIcon); // 이미지 아이콘을 담은 버튼 생성
        menuSearchButton.setBounds(540, 450, 80, 80); // 버튼의 위치 및 크기 설정

        JLabel menuSearchLabel = new JLabel("메뉴 검색");
        menuSearchLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        menuSearchLabel.setForeground(Color.BLACK);
        menuSearchLabel.setBounds(543, 530, 100, 40);
        mainpanel.add(menuSearchLabel);

        menuSearchButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
        menuSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MenuSearch menuSearch = new MenuSearch();
                    menuSearch.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(menuSearchButton)).dispose();
                });
            }
        });
        mainpanel.add(menuSearchButton); // 패널에 메뉴 검색 버튼 추가



        /// Myref 아이콘 로드
        ImageIcon myRefIcon = new ImageIcon(MainTest.class.getResource("/image/Myref.png")); // Myref 아이콘 이미지 로드
        Image myRefImage = myRefIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedMyRefIcon = new ImageIcon(myRefImage); // 조절된 이미지 아이콘 생성
        JButton myRefButton = new JButton(resizedMyRefIcon); // 이미지 아이콘을 담은 버튼 생성
        myRefButton.setBounds(670, 450, 80, 80); // 버튼의 위치 및 크기 설정

        JLabel myRefLabel = new JLabel("마이 냉장고");
        myRefLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        myRefLabel.setForeground(Color.BLACK);
        myRefLabel.setBounds(667, 530, 100, 40);
        mainpanel.add(myRefLabel);

        myRefButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
        myRefButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MyNaengAdd MyNaengadd = new MyNaengAdd();
                    MyNaengadd.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(myRefButton)).dispose();
                });
            }
        });
        mainpanel.add(myRefButton);



        ImageIcon myPageIcon = new ImageIcon(MainTest.class.getResource("/image/MyPage.png")); // MyPage 아이콘 이미지 로드
        Image myPageImage = myPageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedMyPageIcon = new ImageIcon(myPageImage); // 조절된 이미지 아이콘 생성
        JButton myPageButton = new JButton(resizedMyPageIcon); // 이미지 아이콘을 담은 버튼 생성
        myPageButton.setBounds(800, 450, 80, 80); // 버튼의 위치 및 크기 설정

        JLabel myPageLabel = new JLabel("마이 페이지");
        myPageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        myPageLabel.setForeground(Color.BLACK);
        myPageLabel.setBounds(798, 530, 110, 40);
        mainpanel.add(myPageLabel);

        myPageButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
        myPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MyPageOrder mypageOrder = new MyPageOrder();
                    mypageOrder.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(myPageButton)).dispose();
                });
            }
        }); // 패널에 마이 페이지 버튼 추가


        mainpanel.add(myPageButton);

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
        SwingUtilities.invokeLater(MainTestLoginfinish::new);
    }
}