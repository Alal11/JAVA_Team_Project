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
        Head2 head = new Head2();
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
                    MyPageEditMember myPageEditMember = new MyPageEditMember();
                    myPageEditMember.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(modifyUserInfoButton)).dispose();
                });
            }
        });
        panel.add(modifyUserInfoButton);

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
        JPanel prouductpanel = new JPanel();
        prouductpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        prouductpanel.setBackground(Color.white); // 패널 배경색을 흰색으로 설정
        prouductpanel.setBounds(390, 185, 900, 760); // 위치 및 크기 조정



        // 이미지 버튼
        ImageIcon calendarIcon = new ImageIcon(MainTest.class.getResource("/image/달력.png"));
        Image calendarImage = calendarIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon recalendarIcon = new ImageIcon(calendarImage);
        JLabel imageLabel = new JLabel(recalendarIcon);
        imageLabel.setBounds(30, 10, 50, 50);

        JLabel dateLabel = new JLabel("2023.11.21");
        dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setBounds(90, 15, 150, 50); // 위치 및 크기 조정

        JButton detailButton = new JButton("주문내역 상세보기>");
        detailButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        detailButton.setForeground(Color.BLACK); // Set text color to light gray
        detailButton.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // Set border color
        detailButton.setBackground(Color.WHITE); // Set background color
        detailButton.setHorizontalAlignment(SwingConstants.RIGHT);
        detailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    MypageOrderDetail mypageOrderDetail = new MypageOrderDetail();
                    mypageOrderDetail.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(detailButton)).dispose();
                });
            }
        });

        JLabel productNameLabel = new JLabel("상품명");
        productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        productNameLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel orderNumberLabel = new JLabel("주문번호");
        orderNumberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        orderNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JLabel paymentAmountLabel = new JLabel("결제금액");
        paymentAmountLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        paymentAmountLabel.setHorizontalAlignment(SwingConstants.LEFT);

        // 텍스트 필드에 데이터베이스에서 가져온 값 설정 (임시 데이터 사용)
        JTextField productNameField = new JTextField();
        productNameField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        productNameField.setHorizontalAlignment(SwingConstants.LEFT);

        JTextField orderNumberField = new JTextField();
        orderNumberField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        orderNumberField.setHorizontalAlignment(SwingConstants.LEFT);

        JTextField paymentAmountField = new JTextField();
        paymentAmountField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        paymentAmountField.setHorizontalAlignment(SwingConstants.LEFT);

        add(panel);



// 각 반복에서 구성 요소의 y 좌표 조절을 위한 yOffset 변수 초기화
        int yOffset = 0;


        for (int i = 0; i < 1; i++) {
            // 각 반복에서 구성 요소의 y 좌표 조절
            imageLabel.setBounds(30, 10 + yOffset, 50, 50);
            prouductpanel.add(imageLabel);
            dateLabel.setBounds(90, 15 + yOffset, 150, 50);
            prouductpanel.add(dateLabel);
            detailButton.setBounds(620, 15 + yOffset, 140, 50);
            prouductpanel.add(detailButton);

            productNameLabel.setBounds(40, 75 + yOffset, 70, 20);
            orderNumberLabel.setBounds(40, 105 + yOffset, 70, 20);
            paymentAmountLabel.setBounds(40, 135 + yOffset, 70, 20);
            prouductpanel.add(productNameLabel);
            prouductpanel.add(orderNumberLabel);
            prouductpanel.add(paymentAmountLabel);

            productNameField.setBounds(120, 75 + yOffset, 70, 20);
            orderNumberField.setBounds(120, 105 + yOffset, 70, 20);
            paymentAmountField.setBounds(120, 135 + yOffset, 70, 20);
            prouductpanel.add(productNameField);
            prouductpanel.add(orderNumberField);
            prouductpanel.add(paymentAmountField);

            yOffset += 140; // 다음 상품 간의 간격 조절
        }




        add(prouductpanel);
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

/*
//for문 참고용
// 이미지, 날짜, 상품명, 주문번호, 결제 금액 등에 대한 정보를 배열로 관리
String[] imagePaths = {
        "/image/달력.png",
        // 여러 상품 이미지 경로 추가
};
String[] dates = {"2023.11.21", "2023.11.22", "2023.11.23"};
String[] productNames = {"상품1", "상품2", "상품3"};
String[] orderNumbers = {"주문번호1", "주문번호2", "주문번호3"};
String[] paymentAmounts = {"금액1", "금액2", "금액3"};

// 텍스트 필드에 데이터베이스에서 가져온 값 설정 (임시 데이터 사용)
JTextField productNameField = new JTextField();
JTextField orderNumberField = new JTextField();
JTextField paymentAmountField = new JTextField();

// 각 반복에서 구성 요소의 y 좌표 조절을 위한 yOffset 변수 초기화
int yOffset = 0;

for (int i = 0; i < 3; i++) {
    // 이미지 버튼
    ImageIcon calendarIcon = new ImageIcon(MainTest.class.getResource(imagePaths[i]));
    Image calendarImage = calendarIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
    ImageIcon recalendarIcon = new ImageIcon(calendarImage);
    JLabel imageLabel = new JLabel(recalendarIcon);
    imageLabel.setBounds(30, 10 + yOffset, 50, 50);

    JLabel dateLabel = new JLabel(dates[i]);
    dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
    dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
    dateLabel.setBounds(90, 15 + yOffset, 150, 50);

    JButton detailButton = new JButton("주문내역 상세보기>");
    detailButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
    detailButton.setForeground(Color.BLACK);
    detailButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    detailButton.setBackground(Color.WHITE);
    detailButton.setHorizontalAlignment(SwingConstants.RIGHT);
    final int finalI = i; // ActionListener에서 사용하기 위한 변수
    detailButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // "주문내역 상세보기" 버튼을 클릭하면 상세 창을 열도록 함
            SwingUtilities.invokeLater(() -> {
                MypageOrderDetail mypageOrderDetail = new MypageOrderDetail();
                mypageOrderDetail.setData(productNames[finalI], orderNumbers[finalI], paymentAmounts[finalI]);
                mypageOrderDetail.setVisible(true);

                // 현재 창을 닫음
                ((JFrame) SwingUtilities.getWindowAncestor(detailButton)).dispose();
            });
        }
    });

    // 나머지 컴포넌트들의 위치 설정도 유사하게 수행
    // productNameLabel, orderNumberLabel, paymentAmountLabel 등등...

    prouductpanel.add(imageLabel);
    prouductpanel.add(dateLabel);
    prouductpanel.add(detailButton);
    prouductpanel.add(productNameLabel);
    prouductpanel.add(orderNumberLabel);
    prouductpanel.add(paymentAmountLabel);

    prouductpanel.add(productNameField);
    prouductpanel.add(orderNumberField);
    prouductpanel.add(paymentAmountField);

    yOffset += 140; // 다음 상품 간의 간격 조절
}
*/

