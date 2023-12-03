package gui;
import api.BasketApi;
import api.MenuApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.basket.BasketAddDTO;
import dto.basket.BasketInquiryDTO;
import dto.basket.BasketUpdateDTO;
import dto.menu.MenuSearchInfoDTO;
import login.LoginMember;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class Cart extends JFrame {
    private JPanel productPanel1;

    java.util.List<String> ingredients = new ArrayList<>();
    java.util.List<Integer> Prices = new ArrayList<>();

    List<String> menuImages = new ArrayList<>();

    private JLabel[] ingredientLabels;
    private JLabel[] PriceLabels;

    //private String[] productNamelist = {"된장", "양파", "애호박", "두부", "감자", "다진마늘", "고추가루"};

    //private String[] paymentAmountlist = {"100", "700", "900", "1000", "900", "400", "500"};



    private JLabel[] MenuNameLabel;
    private JLabel[] totalLabel;

    private JButton[] decreaseButtons;  // 배열로 변경
    private JButton[] increaseButtons;  // 배열로 변경
    private JTextField[] quantityFields; // 배열로 변경
    private JButton[] deleteButtons;   // 배열로 변경


    public Cart() throws MalformedURLException, JsonProcessingException {
        setTitle("장바구니");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 760);
        setLocationRelativeTo(null);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);

        // 헤더 불러오기
        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();

        List<BasketInquiryDTO> basketInquiryDTOList = BasketApi.inquiryBasket(LoginMember.getMemberKey());

        // 추가: JSON 데이터 출력
        String json = "[";
        for (BasketInquiryDTO basketInquiryDTO : basketInquiryDTOList) {
            json += "{\"ingredientPrice\":\"" + basketInquiryDTO.getIngredientPrice() + "\",\"ingredientName\":" + basketInquiryDTO.getIngredientName() + ",\"basketQuantity\":\"" + basketInquiryDTO.getBasketQuantity() + ",\"basketKey\":\"" + basketInquiryDTO.getBasketKey() +"\"},";

        }
        if (!basketInquiryDTOList.isEmpty()) {
            json = json.substring(0, json.length() - 1); // 마지막 쉼표 제거
        }
        json += "]";
        System.out.println(json);

        // 추가: JSON을 처리하여 두 개의 리스트로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);


            for (JsonNode node : jsonNode) {
                int ingredientPrice = node.get("")

            String menuName = node.get("menuName").asText();
            int memberPrice = node.get("totalPrice").asInt();
            String menuImage = node.get("menuImage").asText();


            menuNames.add(menuName);
            totalPrices.add(memberPrice);
            menuImages.add(menuImage);
        }

        // 결과 출력
        System.out.println("Menu Names: " + menuNames);
        System.out.println("Total Prices: " + totalPrices);
        System.out.println("menuimages : " + menuImages);
    }

        JLabel titleLabel = new JLabel("장바구니");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(540, 130, 200, 50);
        add(titleLabel);

        JSeparator horizontalLine = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine.setBounds(100, 210, 650, 2); // 위치 및 크기 조정
        horizontalLine.setForeground(Color.LIGHT_GRAY); // Set line color
        add(horizontalLine);


        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(null);
        orderPanel.setBounds(810, 210, 350, 160);
        orderPanel.setBackground(Color.WHITE);
        orderPanel.setBorder(new LineBorder(Color.LIGHT_GRAY,1));

        JLabel totalAmountLabel = new JLabel("결제예정금액");
        totalAmountLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        totalAmountLabel.setHorizontalAlignment(SwingConstants.LEFT);
        totalAmountLabel.setBounds(30, 20, 100, 50);
        orderPanel.add(totalAmountLabel);

        JTextField totalAmountField = new JTextField();
        totalAmountField.setBounds(130, 20, 200, 50);
        orderPanel.add(totalAmountField);

        JButton orderButton = new JButton("주문하기");
        orderButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        orderButton.setBounds(30, 90, 300, 50);
        orderButton.setBorder(new Login.RoundedBorder(10, new Color(39, 185, 89)));
        orderButton.setBackground(Color.WHITE); // 하얀색 배경
        orderButton.setForeground(new Color(39, 185, 89)); // 연두색 글씨
        orderPanel.add(orderButton);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(() -> {
                    orderMessage orderMessage = new orderMessage();
                    orderMessage.setVisible(true);


                });
            }
        });

        add(createProductPanel());


        add(orderPanel);
        add(headerPanel);
        add(mainpanel);
        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Cart();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void decreaseQuantity(int index) {
        int currentQuantity = Integer.parseInt(quantityFields[index].getText());
        if (currentQuantity > 1) {
            quantityFields[index].setText(String.valueOf(currentQuantity - 1));
        }
        updateDecreaseButtonTextColor(index);
    }

    private void increaseQuantity(int index) {
        int currentQuantity = Integer.parseInt(quantityFields[index].getText());
        quantityFields[index].setText(String.valueOf(currentQuantity + 1));
        updateDecreaseButtonTextColor(index);
    }

    private void updateDecreaseButtonTextColor(int index) {
        int currentQuantity = Integer.parseInt(quantityFields[index].getText());
        if (currentQuantity == 1) {
            decreaseButtons[index].setForeground(Color.LIGHT_GRAY);
        } else {
            decreaseButtons[index].setForeground(new Color(39, 185, 89));
        }
    }





    private JScrollPane createProductPanel() throws MalformedURLException {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BoxLayout(productPanel, BoxLayout.Y_AXIS)); // 레이아웃 매니저 설정
        productPanel.setBounds(100, 220, 660, 380);
        productPanel.setBackground(Color.WHITE);

        ingredientLabels = new JLabel[ingredients.size()];
        PriceLabels = new JLabel[Prices.size()];
        decreaseButtons = new JButton[ingredients.size()];
        increaseButtons = new JButton[ingredients.size()];
        quantityFields = new JTextField[ingredients.size()];
        deleteButtons = new JButton[ingredients.size()];


        /*ImageIcon foodIcon = new ImageIcon(MainTest.class.getResource("/image/ex)food.png"));
        Image foodImage = foodIcon.getImage().getScaledInstance(50, 55, Image.SCALE_SMOOTH);
        ImageIcon fIcon = new ImageIcon(foodImage);*/


        for (int i = 0; i < ingredients.size(); i++) {
            JPanel cartlistPanel = new JPanel();
            cartlistPanel.setLayout((new BorderLayout()));
            cartlistPanel.setBackground(Color.WHITE);
            cartlistPanel.setPreferredSize(new Dimension(660, 80)); // 각 cartlistPanel의 크기를 고정


            URL imageUrl = new URL(menuImages.get(i));
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            JLabel foodimageLabel = new JLabel(imageIcon);
            foodimageLabel.setBounds(10, 10, 50, 50);
            cartlistPanel.add(foodimageLabel);

            JLabel MenunameLabel = new JLabel(ingredients.get(i));
            MenunameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
            MenunameLabel.setHorizontalAlignment(SwingConstants.LEFT);
            MenunameLabel.setBounds(100, 10, 140, 50);
            cartlistPanel.add(MenunameLabel);


            decreaseButtons[i] = new JButton("-");
            decreaseButtons[i].setBounds(250, 20, 30, 30);
            decreaseButtons[i].setFont(new Font("Arial", Font.PLAIN, 25));
            decreaseButtons[i].setForeground(Color.LIGHT_GRAY);
            decreaseButtons[i].setBackground(Color.WHITE);
            decreaseButtons[i].setBorder(BorderFactory.createLineBorder(Color.black));
            decreaseButtons[i].setMargin(new Insets(0, 0, 0, 0));

            quantityFields[i] = new JTextField("1");
            quantityFields[i].setBounds(280, 20, 30, 30);
            quantityFields[i].setFont(new Font("Arial", Font.PLAIN, 15));
            quantityFields[i].setBorder(BorderFactory.createLineBorder(Color.black));
            quantityFields[i].setHorizontalAlignment(SwingConstants.CENTER);

            increaseButtons[i] = new JButton("+");
            increaseButtons[i].setBounds(310, 20, 30, 30);
            increaseButtons[i].setFont(new Font("Arial", Font.PLAIN, 25));
            increaseButtons[i].setForeground(new Color(39, 185, 89)); // 항상 초록색으로 설정
            increaseButtons[i].setBackground(Color.WHITE);
            increaseButtons[i].setBorder(BorderFactory.createLineBorder(Color.black));
            increaseButtons[i].setMargin(new Insets(0, 0, 0, 0));
            cartlistPanel.add(decreaseButtons[i]);
            cartlistPanel.add(quantityFields[i]);
            cartlistPanel.add(increaseButtons[i]);



            PriceLabels[i] = new JLabel(String.valueOf(Prices.get(i)));
            PriceLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
            PriceLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
            PriceLabels[i].setBounds(425, 20, 150, 30);
            cartlistPanel.add(totalLabel[i]);

            deleteButtons[i] = new JButton("X");
            deleteButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            deleteButtons[i].setBounds(600, 10, 50, 50);
            deleteButtons[i].setFocusPainted(false);
            deleteButtons[i].setVisible(true);
            deleteButtons[i].setForeground(Color.LIGHT_GRAY);
            deleteButtons[i].setBackground(Color.WHITE);
            deleteButtons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE)); // 테두리 색을 흰색으로 설
            cartlistPanel.add(deleteButtons[i]);

            JSeparator horizontalLine2 = new JSeparator(JSeparator.HORIZONTAL);
            horizontalLine2.setBounds(0, 79, 650, 70); // 위치 및 크기 조정
            horizontalLine2.setForeground(Color.LIGHT_GRAY); // Set line color
            cartlistPanel.add(horizontalLine2);



            int finalI = i;
            decreaseButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    decreaseQuantity(finalI);
                }
            });

            int finalI1 = i;
            increaseButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    increaseQuantity(finalI1);
                }
            });

            deleteButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove the selected product from the panel
                    BasketInquiryDTO basketInquiryDTO = new BasketInquiryDTO();
                    BasketApi.deleteBasket(basketInquiryDTO.getBasketKey());
                    productPanel.remove(cartlistPanel);
                    productPanel.revalidate();
                    productPanel.repaint();

                    updateProductPanelSize(productPanel);
                }
            });



            productPanel.add(cartlistPanel);



        }




        JButton checkbutton= new JButton("확인");
        checkbutton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        checkbutton.setBounds(350, 600, 100, 50);
        checkbutton.setBorder(new Login.RoundedBorder(10,Color.WHITE));
        checkbutton.setBackground(Color.WHITE); // 연두색 배경
        checkbutton.setForeground(new Color(29, 185, 89)); // 흰색 글씨
        add(checkbutton);

        checkbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long memberKey = LoginMember.getMemberKey();
                int[] basketQuantities = getBasketQuantities();

                /*BasketUpdateDTO basketUpdateDTO = new BasketUpdateDTO(memberKey, basketQuantities);
                BasketApi.updateBasket(basketUpdateDTO);*/

                // 여기서 API 호출 등 필요한 로직을 수행하면 됩니다.
                // List<MenuSearchInfoDTO> menuSearchInfoDTOList = MenuApi.totalCost(memberKey, Long.valueOf(foodSearchField.getText()));
            }
        });





        //productPanel.setPreferredSize(new Dimension(640, 350*(productNamelist.length/4+1)));

        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(100,210,660,380);





        return scrollPane;
    }
    // productPanel 크기를 업데이트하기 위한 메소드 추가
    private void updateProductPanelSize(JPanel productPanel) {
        int componentsCount = productPanel.getComponentCount();
        int rows = (int) Math.ceil((double) componentsCount / 4);
        int height = rows * 80; // 각 cartlistPanel의 높이를 80으로 가정 (필요에 따라 조정)

        productPanel.setPreferredSize(new Dimension(640, height));
        productPanel.revalidate();
        productPanel.repaint();
    }

    // quantityFields 배열을 int 배열로 변환하는 메서드
    private int[] getBasketQuantities() {
        int[] basketQuantities = new int[quantityFields.length];

        for (int i = 0; i < quantityFields.length; i++) {
            String quantityText = quantityFields[i].getText();

            try {
                basketQuantities[i] = Integer.parseInt(quantityText);
            } catch (NumberFormatException ex) {
                // 유효한 숫자로 변환할 수 없는 경우의 예외 처리
                ex.printStackTrace(); // 또는 다른 예외 처리 로직 추가
            }
        }

        return basketQuantities;
    }


}


//상품이 없을 시
// 장바구니에 담긴 상품이 없습니다.(밝은 회색글씨)

