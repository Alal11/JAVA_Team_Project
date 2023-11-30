/*package kyr.gui;

import javax.swing.*;
import java.awt.*;

public class MPODproductpanel extends JPanel {
    private JLabel[] orderNumber2Label;
    private JLabel[] productNamedetailLabel;
    private JLabel[] payLabel;

    private String[] ordernumberlist = {"25182462", "28218518", "18672942", "27618497", "35729146", "29438194", "19842921"};
    private String[] productNamedetaillist = {"된장", "양파", "애호박", "두부", "감자", "다진마늘", "고추가루"};
    private String[] paymentAmountlist = {"100", "700", "900", "1000", "900", "400", "500"};

    private JPanel MPODPpanel;

    public MPODproductpanel(){
        setLayout(null);
        setBackground(Color.WHITE);
        setBounds(0,0,1280,760);

        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        MPODPpanel = new JPanel();
        MPODPpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        MPODPpanel.setBackground(new Color(123, 199, 139)); // 헤더 배경색을 녹색으로 설정








        // 4. 메인 버튼들 좌측에 가로선, "주문번호" label, "전체 다시 담기" 버튼 추가
        JSeparator horizontalLine2 = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine2.setBounds(30, 40, 760, 70); // 위치 및 크기 조정
        horizontalLine2.setForeground(Color.LIGHT_GRAY); // Set line color
        prouductpanel.add(horizontalLine2);


        JLabel dateLabel = new JLabel("주문번호");
        dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dateLabel.setBounds(40, 0, 760, 30); // 위치 및 크기 조정
        /*주문번호패널.add(dateLabel);
        prouductpanel.add(주문번호패널);*/
       /* prouductpanel.add(dateLabel);

        ImageIcon foodIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/ex)food.png"));
        Image foodImage = foodIcon.getImage().getScaledInstance(60, 70, Image.SCALE_SMOOTH);
        ImageIcon fIcon = new ImageIcon(foodImage);
        JLabel FoodLabel = new JLabel(fIcon);
        FoodLabel.setBounds(40, 50, 60, 70);
        prouductpanel.add(FoodLabel);



        JLabel productNameLabel = new JLabel("상품명");
        productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        productNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        productNameLabel.setBounds(110, 50, 70, 20);
        prouductpanel.add(productNameLabel);


        JLabel paymentAmountLabel = new JLabel("결제금액");
        paymentAmountLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        paymentAmountLabel.setHorizontalAlignment(SwingConstants.LEFT);
        paymentAmountLabel.setBounds(110, 80, 70, 20);
        prouductpanel.add(paymentAmountLabel);

        // 텍스트 필드에 데이터베이스에서 가져온 값 설정 (임시 데이터 사용)
        JTextField productNameField = new JTextField();
        productNameField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        productNameField.setHorizontalAlignment(SwingConstants.LEFT);
        productNameField.setBounds(190, 50, 70, 20);
        prouductpanel.add(productNameField);


        JTextField paymentAmountField = new JTextField();
        paymentAmountField.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        paymentAmountField.setHorizontalAlignment(SwingConstants.LEFT);
        paymentAmountField.setBounds(190, 80, 70, 20);
        prouductpanel.add(paymentAmountField);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Page");
        frame.setSize(1280, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MPODproductpanel mpoDproductpanel = new MPODproductpanel();
        frame.add(mpoDproductpanel);

        frame.setVisible(true);
    }





}
*/