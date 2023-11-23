package kyr.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.*;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class MenuSearch extends JFrame {

    public MenuSearch() {
        setTitle("메뉴 검색 ");
        setSize(1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙에 표시

        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        mainpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정


        // 헤더 불러오기
        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();


        // 패널 추가 (이 부분에 내용을 추가할 수 있습니다.)
        JPanel searchpanel = new JPanel();
        searchpanel.setLayout(null); // 절대 위치 레이아웃으로 설정
        searchpanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        searchpanel.setBounds(100, 125, 1080, 50); // 위치 및 크기 조정


        // 상단에 음식 검색 JTextField와 검색 버튼(JButton) 추가
        JTextField foodSearchField = new JTextField();
        ImageIcon searchIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/searchicon.png"));
        Image searchImage = searchIcon.getImage().getScaledInstance(49, 49, Image.SCALE_SMOOTH);
        ImageIcon sIcon = new ImageIcon(searchImage);
        JButton searchButton = new JButton(sIcon);


        foodSearchField.setBounds(0, 0, 800, 50);
        searchButton.setBounds(800, 0, 50, 50);

        searchpanel.add(foodSearchField);
        searchpanel.add(searchButton);

        // 음식 정보를 표시할 패널 추가
        JPanel foodInfoPanel = new JPanel(null);
        foodInfoPanel.setBounds(100, 200, 1080, 550);
        foodInfoPanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정


        // 음식 이미지, 이름, 가격, 장바구니 버튼을 포함한 하나의 패널 생성 및 추가
        ImageIcon foodImage = new ImageIcon("kyr/image/ex)food.png"); // 음식 이미지 파일 경로로 변경
        JLabel imageLabel = new JLabel(foodImage);
        JTextField nameTextField = new JTextField("음식 이름");
        JTextField priceTextField = new JTextField("가격");
        ImageIcon cartIcon = new ImageIcon(MainTest.class.getResource("/kyr/image/cart2.png"));
        Image cartImage = cartIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedCartIcon = new ImageIcon(cartImage);
        JButton addToCartButton = new JButton(resizedCartIcon);
        addToCartButton.setBorderPainted(false); // 배경 투명화 설정


        imageLabel.setBounds(0, 0, 200, 200);
        nameTextField.setBounds(0, 200, 140, 50);
        nameTextField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
        priceTextField.setBounds(0, 250, 140, 30);
        priceTextField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        priceTextField.setHorizontalAlignment(SwingConstants.LEFT);
        addToCartButton.setBounds(150, 200, 50, 50);

        JPanel foodPanel = new JPanel(null);
        foodPanel.setBackground(Color.WHITE); // 패널 배경색을 흰색으로 설정
        foodPanel.setBounds(10, 10, 200, 280);
        foodPanel.add(imageLabel);
        foodPanel.add(nameTextField);
        foodPanel.add(priceTextField);
        foodPanel.add(addToCartButton);
        foodInfoPanel.add(foodPanel);


        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingUtilities.invokeLater(() -> {
                    CartMessage cartMessage = new CartMessage();
                    cartMessage.setVisible(true);
                });
            }
        });


        add(searchpanel);
        add(foodInfoPanel);
        add(headerPanel);
        add(mainpanel);



        setVisible(true);
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
