    package gui;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class MainTest extends JFrame {

        public MainTest() {
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

            // 카트 이미지 버튼 설정
            ImageIcon cartIcon = new ImageIcon(MainTest.class.getResource("/image/cart2.png")); // 이미지 아이콘 로드
            Image cartImage = cartIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // 이미지 크기 조절
            ImageIcon resizedCartIcon = new ImageIcon(cartImage); // 조절된 이미지 아이콘 생성
            JButton cartButton = new JButton(resizedCartIcon); // 이미지 아이콘을 담은 버튼 생성
            cartButton.setBounds(1100, 30, 50, 50); // 버튼의 위치 및 크기 설정
            cartButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
            cartButton.addActionListener(e -> { // 카트 버튼에 대한 액션 설정
                new Cart();
                setVisible(false);
            });
            mainPanel.add(cartButton); // 패널에 카트 버튼 추가





            /////이게 로그인 아이콘
            ImageIcon loginIcon = new ImageIcon(MainTest.class.getResource("/image/loginIcon.png")); // 로그인 이미지 아이콘 로드
            Image loginImage = loginIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH); // 이미지 크기 조절
            ImageIcon resizedLoginIcon = new ImageIcon(loginImage); // 조절된 이미지 아이콘 생성
            JButton loginButton = new JButton(resizedLoginIcon); // 이미지 아이콘을 담은 버튼 생성
            loginButton.setBounds(550, 400, 65, 65); // 버튼의 위치 및 크기 설정
            JLabel loginLabel = new JLabel("로그인", resizedLoginIcon, SwingConstants.CENTER); // "로그인" 텍스트와 로그인 아이콘을 담은 라벨 생성
            loginLabel.setHorizontalTextPosition(SwingConstants.CENTER); // 텍스트를 아이콘 가운데에 위치시킴
            loginLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // 텍스트를 아이콘 아래에 위치시킴
            loginLabel.setBounds(550, 400, 65, 85); // 라벨의 위치 및 크기 설정
            loginButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
            loginButton.addActionListener(e -> { // 로그인 버튼에 대한 액션 설정
                new Login();
                setVisible(false);
            });
            mainPanel.add(loginLabel); // 패널에 로그인 라벨 추가
            mainPanel.add(loginButton); // 패널에 로그인 버튼 추가




            /////이게 로그인 아이콘
            ImageIcon signupIcon = new ImageIcon(MainTest.class.getResource("/image/signupIcon.png")); // 회원가입 이미지 아이콘 로드
            Image signupImage = signupIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH); // 이미지 크기 조절
            ImageIcon resizedSignupIcon = new ImageIcon(signupImage); // 조절된 이미지 아이콘 생성
            JButton signupButton = new JButton(resizedSignupIcon); // 이미지 아이콘을 담은 버튼 생성
            signupButton.setBounds(680, 400, 65, 65); // 버튼의 위치 및 크기 설정
            JLabel signupLabel = new JLabel("회원가입", resizedSignupIcon, SwingConstants.CENTER); // "회원가입" 텍스트와 회원가입 아이콘을 담은 라벨 생성
            signupLabel.setHorizontalTextPosition(SwingConstants.CENTER); // 텍스트를 아이콘 가운데에 위치시킴
            signupLabel.setVerticalTextPosition(SwingConstants.BOTTOM); // 텍스트를 아이콘 아래에 위치시킴
            signupLabel.setBounds(680, 400, 65, 85); // 라벨의 위치 및 크기 설정
            signupButton.setBorderPainted(false); // 버튼 테두리 표시 안 함
            signupButton.addActionListener(e -> { // 회원가입 버튼에 대한 액션 설정
                new SignUp();
                setVisible(false);
            });
            mainPanel.add(signupLabel); // 패널에 회원가입 라벨 추가
            mainPanel.add(signupButton); // 패널에 회원가입 버튼 추가










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
            SwingUtilities.invokeLater(MainTest::new);
        }
    }