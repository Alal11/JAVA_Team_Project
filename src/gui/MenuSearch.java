package gui;

import api.MemberApi;
import api.MenuApi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.member.MemberLoginDTO;
import dto.menu.MenuSearchInfoDTO;
import login.LoginMember;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MenuSearch extends JFrame {

    List<String> menuNames = new ArrayList<>();
    List<Integer> totalPrices = new ArrayList<>();

    List<String> menuImages = new ArrayList<>();

    private JLabel[] menuNameLabels;
    private JLabel[] totalLabels;
    private JLabel[] menuImageLabels;

    /*private String[] productNamelist = {"된장", "양파", "애호박", "두부", "감자", "다진마늘", "고추가루", "고기"};

    private String[] paymentAmountlist = {"100", "700", "900", "1000", "900", "400", "500", "1000"};

    private JLabel[] MenuNameLabel;
    private JLabel[] totalLabel;*/


    private JPanel foodInfoPanel;

    public MenuSearch() {
        setTitle("음식 이름 검색 ");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 표시

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);

        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setBounds(100, 150, 1080, 60);

        // 상단에 음식 검색 JTextField와 검색 버튼(JButton) 추가
        JTextField foodSearchField = new JTextField("   원하는 메뉴의 이름을 적어주세요");
        // 텍스트 필드의 글씨 크기 조절
        Font fieldFont = new Font("맑은 고딕", Font.PLAIN, 16);
        foodSearchField.setFont(fieldFont);

        // 텍스트 필드의 배경색과 텍스트 색상 조절
        foodSearchField.setBackground(Color.WHITE);
        foodSearchField.setForeground(Color.LIGHT_GRAY);
        ImageIcon searchIcon = new ImageIcon(MainTest.class.getResource("/image/searchicon.png"));
        Image searchImage = searchIcon.getImage().getScaledInstance(59, 59, Image.SCALE_SMOOTH);
        ImageIcon sIcon = new ImageIcon(searchImage);
        JButton searchButton = new JButton(sIcon);

        foodSearchField.setBounds(250, 0, 550, 60);
        searchButton.setBounds(800, 0, 59, 59);

        foodSearchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (foodSearchField.getText().equals("   원하는 메뉴의 이름을 적어주세요")) {
                    foodSearchField.setText("");
                    foodSearchField.setForeground(Color.BLACK); // 글씨 색상을 검정색으로 변경
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (foodSearchField.getText().isEmpty()) {
                    foodSearchField.setText("    원하는 메뉴의 이름을 적어주세요");
                    foodSearchField.setForeground(Color.LIGHT_GRAY); // 원래 색상으로 변경
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Long memberKey = LoginMember.getMemberKey();


                // 수정 완료 java.util의 List를 써야지
                List<MenuSearchInfoDTO> menuSearchInfoDTOList = MenuApi.menuSearch(memberKey, foodSearchField.getText());

                // 추가: JSON 데이터 출력
                String json = "[";
                for (MenuSearchInfoDTO menuSearchInfoDTO : menuSearchInfoDTOList) {
                    json += "{\"menuName\":\"" + menuSearchInfoDTO.getMenuName() + "\",\"totalPrice\":" + menuSearchInfoDTO.getTotalPrice() + ",\"menuImage\":\"" + menuSearchInfoDTO.getMenuImage() + "\"},";

                }
                if (!menuSearchInfoDTOList.isEmpty()) {
                    json = json.substring(0, json.length() - 1); // 마지막 쉼표 제거
                }
                json += "]";
                System.out.println(json);

                // 추가: JSON을 처리하여 두 개의 리스트로 변환
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    JsonNode jsonNode = objectMapper.readTree(json);

                    /*List<String> menuNames = new ArrayList<>();
                    List<Integer> totalPrices = new ArrayList<>();*/

                    for (JsonNode node : jsonNode) {
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
                    System.out.println("menuimages : "+menuImages);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                try {
                    showProductPanel();
                } catch (MalformedURLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        searchPanel.add(foodSearchField);
        searchPanel.add(searchButton);

        menuNameLabels = new JLabel[20]; // 예를 들어 배열 크기를 10으로 지정, 실제 크기에 따라 조절
        totalLabels = new JLabel[20]; // 예를 들어 배열 크기를 10으로 지정, 실제 크기에 따라 조절
        menuImageLabels = new JLabel[20]; // 예를 들어 배열 크기를 10으로 지정, 실제 크기에 따라 조절

        foodInfoPanel = new JPanel(null);
        foodInfoPanel.setBounds(100, 230, 1080, 550);
        foodInfoPanel.setBackground(Color.WHITE);

        add(searchPanel);
        add(foodInfoPanel);
        add(headerPanel);
        add(mainPanel);
        setVisible(true);
    }

    private void showProductPanel() throws MalformedURLException {
        JScrollPane productPanel = createProductPanel();
        foodInfoPanel.removeAll();
        foodInfoPanel.add(productPanel);
        revalidate();
        repaint();
    }

    private JScrollPane createProductPanel() throws MalformedURLException {
        JPanel allfoodPanel = new JPanel(null);
        allfoodPanel.setBackground(Color.BLUE);
        allfoodPanel.setBounds(10, 0, 1060, 400);



        //MenuNameLabel = new JLabel[menuNames.size()];
        //totalLabel = new JLabel[totalPrices.size()];
        //menuImageLabel = new JLabel[menuImages.size()];


        /*JButton foodButton = new JButton(sIcon);
        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RecipeReverse();
            }
        });*/

        int xSpacing = 260;
        int ySpacing = 350;

        for (int i = 0; i < menuNames.size(); i++) {
            JPanel foodPanel = new JPanel(null);
            foodPanel.setBackground(Color.WHITE);
            foodPanel.setBounds(20 + (i % 4) * xSpacing, 30 + (i / 4) * ySpacing, 200, 280);

            menuNameLabels[i] = new JLabel(menuNames.get(i));
            menuNameLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
            menuNameLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
            menuNameLabels[i].setBounds(10, 200, 140, 50);
            foodPanel.add(menuNameLabels[i]);



            URL imageUrl = new URL(menuImages.get(i));
            ImageIcon imageIcon = new ImageIcon(imageUrl);


            JButton foodButton = new JButton(imageIcon);
            foodButton.setLayout(new BorderLayout());
            //foodButton.add(foodLabel, BorderLayout.CENTER);

            // 버튼 크기 및 위치 설정
            foodButton.setBounds(10, 0, 200, 200);
            foodButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new RecipeReverse();
                }
            });
            foodPanel.add(foodButton);

            totalLabels[i] = new JLabel(totalPrices.get(i).toString());
            totalLabels[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
            totalLabels[i].setHorizontalAlignment(SwingConstants.LEFT);
            totalLabels[i].setBounds(10, 250, 140, 30);
            foodPanel.add(totalLabels[i]);

            allfoodPanel.add(foodPanel);
        }

        allfoodPanel.setPreferredSize(new Dimension(1040, 350*(menuNames.size()/4+1)));

        JScrollPane scrollPane = new JScrollPane(allfoodPanel);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0,30,1080,450);


        menuNames.clear();  // 기존의 항목을 모두 지우고 새로운 항목을 추가하기 위해 리스트를 초기화
        totalPrices.clear();  // 마찬가지로 totalPrices도 초기화
        menuImages.clear();


        return scrollPane;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuSearch();
            }
        });
    }
}
