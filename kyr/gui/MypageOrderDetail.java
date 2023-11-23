package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MypageOrderDetail extends JFrame {

    public MypageOrderDetail() {
        // 프레임 설정
        setTitle("My Page");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 표시

        // 헤더 불러오기
        Head head = new Head();
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
        prouductpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        prouductpanel.setBounds(390, 200, 810, 270); // 위치 및 크기 조정


        // 4. 메인 버튼들 좌측에 가로선, "주문번호" label, "전체 다시 담기" 버튼 추가
        JSeparator horizontalLine2 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine2.setBounds(30, 40, 760, 70); // 위치 및 크기 조정
        horizontalLine2.setForeground(Color.LIGHT_GRAY); // Set line color
        prouductpanel.add(horizontalLine2);

       /* JPanel 주문번호패널 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                // 수평으로 그라데이션 그리기
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint 그라데이션 = new GradientPaint(0, 0, new Color(123, 199, 139),
                        getWidth(), 0, Color.WHITE);
                g2d.setPaint(그라데이션);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        주문번호패널.setLayout(null); // 수동 위치 지정을 위해 레이아웃을 null로 설정
        주문번호패널.setBackground(new Color(123, 199, 139)); // 배경색을 초록색으로 설정
        주문번호패널.setBounds(30, 5, 810, 30); // 위치 및 크기 조정*/

        JLabel dateLabel = new JLabel("주문번호");
        dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setBounds(40, 0, 760, 30); // 위치 및 크기 조정
        /*주문번호패널.add(dateLabel);
        prouductpanel.add(주문번호패널);*/
        prouductpanel.add(dateLabel);


        // 배송패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel deliverypanel = new JPanel();
        deliverypanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        deliverypanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        deliverypanel.setBounds(390, 465, 810, 280); // 위치 및 크기 조정


        //5. 메인 버튼들 좌측에 가로선, "배송정보" label 추가
        JSeparator horizontalLine3 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine3.setBounds(30, 40, 760, 70); // 위치 및 크기 조정
        horizontalLine3.setForeground(Color.LIGHT_GRAY); // Set line color
        deliverypanel.add(horizontalLine3);

      /*  JPanel 배송정보패널 = new JPanel();
        배송정보패널.setLayout(null); // 수동 위치 지정을 위해 레이아웃을 null로 설정
        배송정보패널.setBackground(new Color(123, 199, 139)); // 배경색을 초록색으로 설정
        배송정보패널.setBounds(30, 5, 810, 30); // 위치 및 크기 조정*/

        JLabel OrederdataLabel = new JLabel("배송정보");
        OrederdataLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        OrederdataLabel.setHorizontalAlignment(SwingConstants.LEFT);
        OrederdataLabel.setBounds(40, 0, 100, 30); // 위치 및 크기 조정
        /*배송정보패널.add(OrederdataLabel);
        deliverypanel.add(배송정보패널);*/
        deliverypanel.add(OrederdataLabel);



        JLabel productNameLabel = new JLabel("상품명");
        productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        productNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        productNameLabel.setBounds(40, 50, 70, 20);
        prouductpanel.add(productNameLabel);

        JLabel orderNumberLabel = new JLabel("주문번호");
        orderNumberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        orderNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderNumberLabel.setBounds(40, 80, 70, 20);
        prouductpanel.add(orderNumberLabel);

        JLabel paymentAmountLabel = new JLabel("결제금액");
        paymentAmountLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        paymentAmountLabel.setHorizontalAlignment(SwingConstants.LEFT);
        paymentAmountLabel.setBounds(40, 110, 70, 20);
        prouductpanel.add(paymentAmountLabel);

        // 텍스트 필드에 데이터베이스에서 가져온 값 설정 (임시 데이터 사용)
        JTextField productNameField = new JTextField();
        productNameField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        productNameField.setHorizontalAlignment(SwingConstants.LEFT);
        productNameField.setBounds(120, 50, 70, 20);
        prouductpanel.add(productNameField);

        JTextField orderNumberField = new JTextField();
        orderNumberField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        orderNumberField.setHorizontalAlignment(SwingConstants.LEFT);
        orderNumberField.setBounds(120, 80, 70, 20);
        prouductpanel.add(orderNumberField);

        JTextField paymentAmountField = new JTextField();
        paymentAmountField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        paymentAmountField.setHorizontalAlignment(SwingConstants.LEFT);
        paymentAmountField.setBounds(120, 110, 70, 20);
        prouductpanel.add(paymentAmountField);

        //배송정보 내용적기
        JLabel recipientLabel = new JLabel("수령자");
        recipientLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        recipientLabel.setHorizontalAlignment(SwingConstants.LEFT);
        recipientLabel.setBounds(40, 50, 70, 20);
        deliverypanel.add(recipientLabel);

        JLabel phonenumberLabel = new JLabel("휴대폰");
        phonenumberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        phonenumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phonenumberLabel.setBounds(40, 80, 70, 20);
        deliverypanel.add(phonenumberLabel);

        JLabel addressLabel = new JLabel("주소");
        addressLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setBounds(40, 110, 70, 20);
        deliverypanel.add(addressLabel);


        JTextField recipientField = new JTextField();
        recipientField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        recipientField.setHorizontalAlignment(SwingConstants.LEFT);
        recipientField.setBounds(120, 50, 70, 20);
        deliverypanel.add(recipientField);

        JTextField phonenumberField = new JTextField();
        phonenumberField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        phonenumberField.setHorizontalAlignment(SwingConstants.LEFT);
        phonenumberField.setBounds(120, 80, 70, 20);
        deliverypanel.add(phonenumberField);

        JTextField adreesField = new JTextField();
        adreesField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        adreesField.setHorizontalAlignment(SwingConstants.LEFT);
        adreesField.setBounds(120, 110, 70, 20);
        deliverypanel.add(adreesField);


        add(panel);
        add(prouductpanel);
        add(deliverypanel);
        add(subpanel);
        add(headerPanel);
        add(mainpanel);




    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MypageOrderDetail myPageOrderDetail = new MypageOrderDetail();
            myPageOrderDetail.setVisible(true);
        });


        /*디자인 할 때 수정할 부분 글씨체
         *주문내역, 개인 정보 수정버튼 클릭된 상태는 글씨색 초록색으로 표시
         * 즉 이 페이지에서는 주문내역 글씨색 초록색으로 표시
         * 클릭이 되지 않으면 연한 회색 테두리도 연한 회색
         * 버튼 바탕색은 모두 하얀색으로 하기
         * 주문날짜 label은 나중에 의견 나눔 해야됨
         * */
    }
}


