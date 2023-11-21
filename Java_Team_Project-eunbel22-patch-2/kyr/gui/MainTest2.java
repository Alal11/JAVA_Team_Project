    package gui;

    import javax.swing.*;
    import java.awt.*;

    public class MainTest2 extends JFrame {

        public MainTest2() {
            setTitle("Cookeryket"); // 프레임 제목 설정
            setSize(1280, 760); // 프레임 크기 설정
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로그램 종료 시 프레임 닫기 설정
            setLocationRelativeTo(null); // 프레임을 화면 중앙에 위치시킴

            // 모든 컴포넌트를 담을 패널 생성
            JPanel mainPanel = new JPanel(null); // 절대 위치 배치를 사용하기 위한 null layout 설정
            mainPanel.setBackground(Color.WHITE); // 패널의 배경색 설정
            getContentPane().add(mainPanel); // 프레임에 패널 추가


            // 로고 이미지 설정
            ImageIcon logoIcon = new ImageIcon(MainTest.class.getResource("/image/logo.png")); // 이미지 아이콘 로드
            Image logoImage = logoIcon.getImage().getScaledInstance(400, 90, Image.SCALE_SMOOTH); // 이미지 크기 조절
            ImageIcon resizedLogoIcon = new ImageIcon(logoImage); // 조절된 이미지 아이콘 생성
            JLabel imgLabel = new JLabel(resizedLogoIcon); // 이미지 아이콘을 담을 라벨 생성
            imgLabel.setBounds(440, 200, 400, 90); // 이미지의 위치 및 크기 설정
            mainPanel.add(imgLabel); // 패널에 이미지 라벨 추가

            // 검색창 설정
            JTextField searchField = new JTextField();
            searchField.setPreferredSize(new Dimension(600, 50)); // 검색창 크기 설정
            searchField.setBounds(400, 320, 500, 50); // 검색창 위치 및 크기 설정
            mainPanel.add(searchField); // 패널에 검색창 추가









            // 카트 아이콘 로드
            ImageIcon cartIcon = new ImageIcon(MainTest.class.getResource("/image/Cartcon.png"));
            Image cartImage = cartIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH); // 이미지 크기 조절
            ImageIcon resizedCartIcon = new ImageIcon(cartImage); // 조절된 이미지 아이콘 생성
            JButton cartButton = new JButton(resizedCartIcon); // 이미지 아이콘을 담은 버튼 생성
            cartButton.setBounds(550, 400, 65, 65); // 버튼의 위치 및 크기 설정
            JLabel cartLabel = new JLabel("장바구니", resizedCartIcon, SwingConstants.CENTER); // "카트" 텍스트와 카트 아이콘을 담은 라벨 생성
            cartLabel.setHorizontalTextPosition(SwingConstants.CENTER); // 텍스트를 아이콘 가운데에 위치시킴
            cartLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // 텍스트를 아이콘 아래에 위치시킴
            cartLabel.setBounds(550, 400, 65, 85); // 라벨의 위치 및 크기 설정
            cartButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
            cartButton.addActionListener(e -> { // 카트 버튼에 대한 액션 설정
                // 카트 기능 구현
            });
            mainPanel.add(cartLabel); // 패널에 카트 라벨 추가
            mainPanel.add(cartButton); // 패널에 카트 버튼 추가


            ImageIcon menuSearchIcon = new ImageIcon(MainTest.class.getResource("/image/menuserch.png"));
            Image menuSearchImage = menuSearchIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH); // 이미지 크기 조절
            ImageIcon resizedMenuSearchIcon = new ImageIcon(menuSearchImage); // 조절된 이미지 아이콘 생성
            JButton menuSearchButton = new JButton(resizedMenuSearchIcon); // 이미지 아이콘을 담은 버튼 생성
            menuSearchButton.setBounds(420, 400, 65, 65); // 버튼의 위치 및 크기 설정
            JLabel menuSearchLabel = new JLabel("메뉴 검색", resizedMenuSearchIcon, SwingConstants.CENTER); // "메뉴 검색" 텍스트와 menuserch 아이콘을 담은 라벨 생성
            menuSearchLabel.setHorizontalTextPosition(SwingConstants.CENTER); // 텍스트를 아이콘 가운데에 위치시킴
            menuSearchLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // 텍스트를 아이콘 아래에 위치시킴
            menuSearchLabel.setBounds(420, 400, 65, 85); // 라벨의 위치 및 크기 설정
            menuSearchButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
            menuSearchButton.addActionListener(e -> { // menuserch 버튼에 대한 액션 설정
                // menuserch 기능 구현
            });
            mainPanel.add(menuSearchLabel); // 패널에 menuserch 라벨 추가
            mainPanel.add(menuSearchButton); // 패널에 menuserch 버튼 추가


            /// Myref 아이콘 로드
            ImageIcon myRefIcon = new ImageIcon(MainTest.class.getResource("/image/Myref.png"));
            Image myRefImage = myRefIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH); // 이미지 크기 조절
            ImageIcon resizedMyRefIcon = new ImageIcon(myRefImage); // 조절된 이미지 아이콘 생성
            JButton myRefButton = new JButton(resizedMyRefIcon); // 이미지 아이콘을 담은 버튼 생성
            myRefButton.setBounds(680, 400, 65, 65); // 버튼의 위치 및 크기 설정
            JLabel myRefLabel = new JLabel("Myref", resizedMyRefIcon, SwingConstants.CENTER); // "Myref" 텍스트와 Myref 아이콘을 담은 라벨 생성
            myRefLabel.setHorizontalTextPosition(SwingConstants.CENTER); // 텍스트를 아이콘 가운데에 위치시킴
            myRefLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // 텍스트를 아이콘 아래에 위치시킴
            myRefLabel.setBounds(680, 400, 65, 85); // 라벨의 위치 및 크기 설정
            myRefButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
            myRefButton.addActionListener(e -> { // Myref 버튼에 대한 액션 설정
                // Myref 기능 구현
            });
            mainPanel.add(myRefLabel); // 패널에 Myref 라벨 추가
            mainPanel.add(myRefButton); // 패널에 Myref 버튼 추가



            // MyPage 아이콘 로드
            ImageIcon myPageIcon = new ImageIcon(MainTest.class.getResource("/image/MyPage.png"));
            Image myPageImage = myPageIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH); // 이미지 크기 조절
            ImageIcon resizedMyPageIcon = new ImageIcon(myPageImage); // 조절된 이미지 아이콘 생성
            JButton myPageButton = new JButton(resizedMyPageIcon); // 이미지 아이콘을 담은 버튼 생성
            myPageButton.setBounds(810, 400, 65, 65); // 버튼의 위치 및 크기 설정
            JLabel myPageLabel = new JLabel("MyPage", resizedMyPageIcon, SwingConstants.CENTER); // "MyPage" 텍스트와 MyPage 아이콘을 담은 라벨 생성
            myPageLabel.setHorizontalTextPosition(SwingConstants.CENTER); // 텍스트를 아이콘 가운데에 위치시킴
            myPageLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // 텍스트를 아이콘 아래에 위치시킴
            myPageLabel.setBounds(810, 400, 65, 85); // 라벨의 위치 및 크기 설정
            myPageButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
            myPageButton.addActionListener(e -> { // MyPage 버튼에 대한 액션 설정
                // MyPage 기능 구현
            });
            mainPanel.add(myPageLabel); // 패널에 MyPage 라벨 추가
            mainPanel.add(myPageButton); // 패널에 MyPage 버튼 추가











            // 로그인, 회원가입, 마이페이지 버튼을 담을 패널
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬된 레이아웃 설정
            buttonPanel.setBounds(0, 330, getWidth(), 30); // 버튼 패널의 위치 설정
            buttonPanel.setBackground(Color.WHITE); // 버튼 패널의 배경색 설정
            mainPanel.add(buttonPanel); // 패널에 버튼 패널 추가

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
            SwingUtilities.invokeLater(MainTest2::new);
        }
    }