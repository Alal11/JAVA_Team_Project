package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyNaeng extends JFrame {
    private final int labelLimit = 13; // 라벨 추가 제한 수
    ArrayList<JLabel> labelList = new ArrayList<>(); // 라벨을 저장하는 리스트

    public MyNaeng() {
        setTitle("My Refrigerator"); // 프레임 타이틀 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫으면 프로그램 종료
        setSize(1280, 760); // 프레임 크기 설정

        // 좌측 패널 생성 및 설정
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE); // 배경색을 흰색으로 설정
        leftPanel.setPreferredSize(new Dimension(633, 380)); // 패널 크기 설정
        leftPanel.setLayout(null); // 레이아웃 매니저를 수동 설정

        // 우측 패널 생성 및 설정
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE); // 배경색을 흰색으로 설정
        rightPanel.setPreferredSize(new Dimension(633, 380)); // 패널 크기 설정
        rightPanel.setLayout(null); // 레이아웃 매니저를 수동 설정

        // 이미지 아이콘 로드 및 설정
        ImageIcon logoIcon = new ImageIcon(MyNaeng.class.getResource("/image/line.png")); // 이미지 아이콘 로드
        Image logoImage = logoIcon.getImage().getScaledInstance(1, 610, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedLogoIcon = new ImageIcon(logoImage); // 조절된 이미지 아이콘 생성
        JLabel imgLabel = new JLabel(resizedLogoIcon); // 이미지 아이콘을 담을 라벨 생성
        imgLabel.setBounds(1, 70, resizedLogoIcon.getIconWidth(), resizedLogoIcon.getIconHeight()); // 라벨 위치 설정
        rightPanel.add(imgLabel); // 우측 패널에 이미지 라벨 추가

        // 검색 필드 생성 및 설정
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(400, 50)); // 검색 필드 크기 설정
        int x = (leftPanel.getWidth() - searchField.getPreferredSize().width + 640) / 2;
        int y = (leftPanel.getHeight() - searchField.getPreferredSize().height + 200) / 2;
        searchField.setBounds(x, y, searchField.getPreferredSize().width, searchField.getPreferredSize().height); // 위치 설정
        leftPanel.add(searchField); // 좌측 패널에 검색 필드 추가

        // 검색 이벤트 처리
        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredText = searchField.getText().trim();
                if (!enteredText.isEmpty()) { // 입력된 텍스트가 비어있지 않은 경우
                    if (labelList.size() < labelLimit) { // 라벨 추가 제한 수를 넘지 않는 경우
                        JLabel textLabel = new JLabel(enteredText);
                        textLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 28)); // 폰트 설정
                        textLabel.setBounds(50, 100 + labelList.size() * 40, 300, 30); // 라벨 위치 설정

                        rightPanel.add(textLabel); // 우측 패널에 라벨 추가
                        labelList.add(textLabel); // 라벨 리스트에 추가
                        rightPanel.revalidate(); // 패널 다시 그리기
                        rightPanel.repaint(); // 패널 재페인트

                        searchField.setText(""); // 검색 필드 초기화

                        // 라벨을 클릭하여 삭제하는 기능 추가
                        textLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                JLabel clickedLabel = (JLabel) evt.getSource();
                                int option = JOptionPane.showConfirmDialog(null, "재료 삭제하시겠습니까?", "Cookeryket", JOptionPane.YES_NO_OPTION);
                                if (option == JOptionPane.YES_OPTION) {
                                    rightPanel.remove(clickedLabel);
                                    labelList.remove(clickedLabel);
                                    rightPanel.revalidate();
                                    rightPanel.repaint();
                                }
                            }
                            public void mouseEntered(java.awt.event.MouseEvent evt) {
                                JLabel enteredLabel = (JLabel) evt.getSource();
                                Color ourGreen = new Color(29, 185, 89);
                                enteredLabel.setForeground(ourGreen); // 마우스 진입시 텍스트 색상 변경
                            }

                            public void mouseExited(java.awt.event.MouseEvent evt) {
                                JLabel exitedLabel = (JLabel) evt.getSource();
                                exitedLabel.setForeground(UIManager.getColor("Label.foreground")); // 마우스 빠져나갈 때 원래 색상으로 변경
                            }
                        });
                    } else {
                        JOptionPane.showMessageDialog(null, "냉장고가 가득 찼다잉 ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "공백만 입력했다. 제대로 적어라잉? .");
                }
            }
        });

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);

        // GUI 창을 닫을 때 labelList에 있는 요소들을 출력하는 이벤트 처리
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Closing the application...");
                System.out.println("Contents of labelList:");
                for (JLabel label : labelList) {
                    System.out.println(label.getText());
                }
                System.out.println("Application closed.");
            }
        });

        setVisible(true); // 프레임 보이게 설정
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyNaeng()); // 프로그램 실행
    }
}