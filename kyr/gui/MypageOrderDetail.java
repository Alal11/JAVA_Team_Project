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

        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel panel = new JPanel();
        panel.setLayout(null); // 절대 위치 레이아웃으로 설정
        panel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        add(panel);

        // 1. "My page" 메인 텍스트 추가 (좌측 상단에)
        JLabel mainText = new JLabel("My Page");
        mainText.setFont(new Font("Arial", Font.BOLD, 60));
        mainText.setHorizontalAlignment(SwingConstants.LEFT);
        mainText.setBounds(30, 10, 350, 170); // 위치 및 크기 조정
        panel.add(mainText);

        // 2. "주문내역 >"과 "회원정보 수정>" 버튼 추가 (메인 텍스트 밑에 수직으로 배열)
        JButton orderHistoryButton = new JButton("주문내역                          >");
        orderHistoryButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        orderHistoryButton.setHorizontalAlignment(SwingConstants.CENTER);
        orderHistoryButton.setBounds(30, 180, 320, 80);
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

        JButton modifyUserInfoButton = new JButton("회원정보 수정                    >");
        modifyUserInfoButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        modifyUserInfoButton.setHorizontalAlignment(SwingConstants.CENTER);
        modifyUserInfoButton.setBounds(30, 260, 320, 80);
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

        // 3. 메인 텍스트 우측에 가로선과 "주문내역" label 추가
        JSeparator horizontalLine = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine.setBounds(390, 175, 810, 50); // 위치 및 크기 조정
        panel.add(horizontalLine);

        JLabel orderLabel = new JLabel("주문내역 상세");
        orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        orderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderLabel.setBounds(390, 20, 300, 180); // 위치 및 크기 조정
        panel.add(orderLabel);

        // 4. 메인 버튼들 좌측에 가로선, "주문번호" label, "전체 다시 담기" 버튼 추가
        JSeparator horizontalLine2 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine2.setBounds(420, 250, 780, 70); // 위치 및 크기 조정
        panel.add(horizontalLine2);

        JLabel dateLabel = new JLabel("주문번호");
        dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setBounds(420, 210, 80, 40); // 위치 및 크기 조정
        panel.add(dateLabel);

        /*JButton detailButton = new JButton("전체 다시담기");
        detailButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        detailButton.setBounds(1030, 210, 170, 40);
        panel.add(detailButton);*/

        //5. 메인 버튼들 좌측에 가로선, "배송정보" label 추가
        JSeparator horizontalLine3 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine3.setBounds(420, 500, 780, 70); // 위치 및 크기 조정
        panel.add(horizontalLine3);

        JLabel OrederdataLabel = new JLabel("배송정보");
        OrederdataLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        OrederdataLabel.setHorizontalAlignment(SwingConstants.LEFT);
        OrederdataLabel.setBounds(420, 460, 80, 40); // 위치 및 크기 조정
        panel.add(OrederdataLabel);


       /* // 6. 메인 버튼들 좌측에 가로선, "배송정보" label 추가
        JSeparator horizontalLine4 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine4.setBounds(420, 700, 780, 70); // 위치 및 크기 조정
        panel.add(horizontalLine4);

        JLabel deliverydataLabel = new JLabel("배송정보");
        deliverydataLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        deliverydataLabel.setHorizontalAlignment(SwingConstants.LEFT);
        deliverydataLabel.setBounds(420, 660, 80, 40); // 위치 및 크기 조정
        panel.add(deliverydataLabel);*/


        // 이미지 파일의 경로에 따라 수정해야 합니다.
        String imagePath = "kyr/image/ex)food.png";
        ImageIcon foodImageIcon = new ImageIcon(imagePath);

        JLabel foodImageLabel = new JLabel(foodImageIcon);
        foodImageLabel.setBounds(430, 280, 70, 100);
        panel.add(foodImageLabel);

        JLabel productNameLabel = new JLabel("상품명");
        productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        productNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        productNameLabel.setBounds(510, 280, 70, 20);
        panel.add(productNameLabel);

        JLabel orderNumberLabel = new JLabel("주문번호");
        orderNumberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        orderNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderNumberLabel.setBounds(510, 310, 70, 20);
        panel.add(orderNumberLabel);

        JLabel paymentAmountLabel = new JLabel("결제금액");
        paymentAmountLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        paymentAmountLabel.setHorizontalAlignment(SwingConstants.LEFT);
        paymentAmountLabel.setBounds(510, 340, 70, 20);
        panel.add(paymentAmountLabel);

        // 텍스트 필드에 데이터베이스에서 가져온 값 설정 (임시 데이터 사용)
        JTextField productNameField = new JTextField();
        productNameField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        productNameField.setHorizontalAlignment(SwingConstants.LEFT);
        productNameField.setBounds(590, 280, 70, 20);
        panel.add(productNameField);

        JTextField orderNumberField = new JTextField();
        orderNumberField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        orderNumberField.setHorizontalAlignment(SwingConstants.LEFT);
        orderNumberField.setBounds(590, 310, 70, 20);
        panel.add(orderNumberField);

        JTextField paymentAmountField = new JTextField();
        paymentAmountField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        paymentAmountField.setHorizontalAlignment(SwingConstants.LEFT);
        paymentAmountField.setBounds(590, 340, 70, 20);
        panel.add(paymentAmountField);

        //배송정보 내용적기
        JLabel recipientLabel = new JLabel("수령자");
        recipientLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        recipientLabel.setHorizontalAlignment(SwingConstants.LEFT);
        recipientLabel.setBounds(430, 530, 70, 20);
        panel.add(recipientLabel);

        JLabel phonenumberLabel = new JLabel("휴대폰");
        phonenumberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        phonenumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phonenumberLabel.setBounds(430, 560, 70, 20);
        panel.add(phonenumberLabel);

        JLabel addressLabel = new JLabel("주소");
        addressLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setBounds(430, 590, 70, 20);
        panel.add(addressLabel);


        JTextField recipientField = new JTextField();
        recipientField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        recipientField.setHorizontalAlignment(SwingConstants.LEFT);
        recipientField.setBounds(510, 530, 70, 20);
        panel.add(recipientField);

        JTextField phonenumberField = new JTextField();
        phonenumberField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        phonenumberField.setHorizontalAlignment(SwingConstants.LEFT);
        phonenumberField.setBounds(510, 560, 70, 20);
        panel.add(phonenumberField);

        JTextField adreesField = new JTextField();
        adreesField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        adreesField.setHorizontalAlignment(SwingConstants.LEFT);
        adreesField.setBounds(510, 590, 70, 20);
        panel.add(adreesField);







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

