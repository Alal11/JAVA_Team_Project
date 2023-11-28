package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PriceSearch extends JFrame {

    private JPanel foodInfoPanel;

    public PriceSearch() {
        setTitle("금액 맞춤 검색 ");
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
        searchPanel.setBounds(100, 125, 1080, 50);

        JTextField foodSearchField = new JTextField();
        ImageIcon searchIcon = new ImageIcon(MainTest.class.getResource("/image/searchicon.png"));
        Image searchImage = searchIcon.getImage().getScaledInstance(49, 49, Image.SCALE_SMOOTH);
        ImageIcon sIcon = new ImageIcon(searchImage);
        JButton searchButton = new JButton(sIcon);

        foodSearchField.setBounds(0, 0, 800, 50);
        searchButton.setBounds(800, 0, 50, 50);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProductPanel();
            }
        });

        searchPanel.add(foodSearchField);
        searchPanel.add(searchButton);

        foodInfoPanel = new JPanel(null);
        foodInfoPanel.setBounds(100, 200, 1080, 550);
        foodInfoPanel.setBackground(Color.WHITE);

        add(searchPanel);
        add(foodInfoPanel);
        add(headerPanel);
        add(mainPanel);
        setVisible(true);
    }

    private void showProductPanel() {
        JPanel productPanel = createProductPanel();
        foodInfoPanel.removeAll();
        foodInfoPanel.add(productPanel);
        revalidate();
        repaint();
    }

    private JPanel createProductPanel() {
        ImageIcon foodImage = new ImageIcon("kyr/image/ex)food.png");
        JLabel imageLabel = new JLabel(foodImage);
        JTextField nameTextField = new JTextField("음식 이름");
        JTextField priceTextField = new JTextField("가격");

        imageLabel.setBounds(0, 0, 200, 200);
        nameTextField.setBounds(0, 200, 140, 50);
        nameTextField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        nameTextField.setHorizontalAlignment(SwingConstants.LEFT);
        priceTextField.setBounds(0, 250, 140, 30);
        priceTextField.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        priceTextField.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel foodPanel = new JPanel(null);
        foodPanel.setBackground(Color.WHITE);
        foodPanel.setBounds(10, 10, 200, 280);
        foodPanel.add(imageLabel);
        foodPanel.add(nameTextField);
        foodPanel.add(priceTextField);

        return foodPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PriceSearch();
            }
        });
    }
}