package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPageProductpanel extends JPanel {

        private JLabel[] dateLabel;
        //private JLabel[] foodLabel;
        private JLabel[] productName2Label;
        private JLabel[] orderNumber2Label;
        private JLabel[] paymentAmount2Label;

        private String[] orderdaylist = {"2023.11.20", "2023.11.21", "2023.11.22", "2023.11.23", "2023.11.24", "2023.11.25", "2023.11.26"};
        //private String[] foodlabellist = {"2023.11.20", "2023.11.21", "2023.11.22", "2023.11.23", "2023.11.24", "2023.11.25", "2023.11.26"};
        private String[] productNamelist = {"된장", "양파", "애호박", "두부", "감자", "다진마늘", "고추가루"};
        private String[] ordernumberlist = {"25182462", "28218518", "18672942", "27618497", "35729146", "29438194", "19842921"};
        private String[] paymentAmountlist = {"100", "700", "900", "1000", "900", "400", "500"};

        private JPanel MPPpanel;

        public MyPageProductpanel(){
                setLayout(null);
                setBackground(Color.WHITE);
                setBounds(0,0,1280,760);

                // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
                MPPpanel = new JPanel();
                MPPpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
                MPPpanel.setBackground(new Color(123, 199, 139)); // 헤더 배경색을 녹색으로 설정
                //MPPpanel.setBounds(0, 0, 730, 1000); // 헤더 위치 및 크기 조정

                // 이미지 버튼
                ImageIcon calendarIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/달력.png"));
                Image calendarImage = calendarIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
                ImageIcon recalendarIcon = new ImageIcon(calendarImage);

                ImageIcon foodIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/ex)food.png"));
                Image foodImage = foodIcon.getImage().getScaledInstance(70, 80, Image.SCALE_SMOOTH);
                ImageIcon fIcon = new ImageIcon(foodImage);


                //JLabel[] foodLabel = new JLabel[orderdaylist.length];
                dateLabel = new JLabel[orderdaylist.length];
                productName2Label = new JLabel[orderdaylist.length];
                orderNumber2Label = new JLabel[orderdaylist.length];
                paymentAmount2Label = new JLabel[orderdaylist.length];



                for (int i = 0; i < orderdaylist.length; i++) {
                        JLabel foodLabel = new JLabel(fIcon);
                        foodLabel.setBounds(40, 75 + i * 160, 70, 80);
                        MPPpanel.add(foodLabel);

                        JLabel dateLabel = new JLabel(orderdaylist[i]);
                        dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
                        dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
                        dateLabel.setBounds(90, 15 + i * 160, 150, 50);
                        MPPpanel.add(dateLabel);

                        JLabel imageLabel = new JLabel(recalendarIcon);
                        imageLabel.setBounds(30, 10 + i * 160, 50, 50);
                        MPPpanel.add(imageLabel);

                        JButton detailButton = new JButton("주문내역 상세보기>");
                        detailButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
                        detailButton.setForeground(Color.BLACK);
                        detailButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        detailButton.setBackground(Color.WHITE);
                        detailButton.setHorizontalAlignment(SwingConstants.RIGHT);
                        detailButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        SwingUtilities.invokeLater(() -> {
                                                MypageOrderDetail mypageOrderDetail = new MypageOrderDetail();
                                                mypageOrderDetail.setVisible(true);
                                                ((JFrame) SwingUtilities.getWindowAncestor(detailButton)).dispose();
                                        });
                                }
                        });
                        detailButton.setBounds(570, 15 + i * 160, 140, 50);
                        MPPpanel.add(detailButton);

                        JLabel productNameLabel = new JLabel("상품명");
                        productNameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
                        productNameLabel.setHorizontalAlignment(SwingConstants.LEFT);
                        productNameLabel.setBounds(120, 75 + i * 160, 70, 20);
                        MPPpanel.add(productNameLabel);

                        JLabel orderNumberLabel = new JLabel("주문번호");
                        orderNumberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
                        orderNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
                        orderNumberLabel.setBounds(120, 105 + i * 160, 70, 20);
                        MPPpanel.add(orderNumberLabel);

                        JLabel paymentAmountLabel = new JLabel("결제금액");
                        paymentAmountLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
                        paymentAmountLabel.setHorizontalAlignment(SwingConstants.LEFT);
                        paymentAmountLabel.setBounds(120, 135 + i * 160, 70, 20);
                        MPPpanel.add(paymentAmountLabel);

                        productName2Label[i] = new JLabel(productNamelist[i]);
                        productName2Label[i].setFont(new Font("맑은 고딕", Font.BOLD, 10));
                        productName2Label[i].setHorizontalAlignment(SwingConstants.LEFT);
                        productName2Label[i].setBounds(200, 75 + i * 160, 70, 20);
                        MPPpanel.add(productName2Label[i]);

                        orderNumber2Label[i] = new JLabel(ordernumberlist[i]);
                        orderNumber2Label[i].setFont(new Font("맑은 고딕", Font.BOLD, 10));
                        orderNumber2Label[i].setHorizontalAlignment(SwingConstants.LEFT);
                        orderNumber2Label[i].setBounds(200, 105 + i * 160, 70, 20);
                        MPPpanel.add(orderNumber2Label[i]);

                        paymentAmount2Label[i] = new JLabel(paymentAmountlist[i]);
                        paymentAmount2Label[i].setFont(new Font("맑은 고딕", Font.BOLD, 10));
                        paymentAmount2Label[i].setHorizontalAlignment(SwingConstants.LEFT);
                        paymentAmount2Label[i].setBounds(200, 135 + i * 160, 70, 20);
                        MPPpanel.add(paymentAmount2Label[i]);
                }



                MPPpanel.setPreferredSize(new Dimension(730, 160*orderdaylist.length));

                JScrollPane scrollPane = new JScrollPane(MPPpanel);
                // 수직 및 수평 스크롤바 항상 표시
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.setBounds(405,185,775,500);


                add(scrollPane);







        }

        public static void main(String[] args) {
                JFrame frame = new JFrame("My Page");
                frame.setSize(1280, 760);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                MyPageProductpanel myPageProductpanel = new MyPageProductpanel();
                frame.add(myPageProductpanel);

                frame.setVisible(true);
        }


        public JScrollPane getScrollPane() {
                JScrollPane scrollPane = new JScrollPane(MPPpanel);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setBounds(405, 185, 775, 500);
                return scrollPane;
        }




}
