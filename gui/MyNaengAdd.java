package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MyNaengAdd extends JFrame {


    int labelLimit = 13; // 라벨 추가 제한 수
    ArrayList<JLabel> labelList = new ArrayList<>(); // 라벨을 저장하는 리스트

    public MyNaengAdd() {
        setTitle("My Refrigerator"); // 프레임 타이틀 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫으면 프로그램 종료
        setSize(1280, 760); // 프레임 크기 설정
        setLocationRelativeTo(null);

        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(30, 100, 320, 760);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(242, 242, 242));
        panel.setBounds(100, 100, 270, 760);

        JPanel subpanel = new JPanel();
        subpanel.setLayout(null);
        subpanel.setBackground(Color.WHITE);
        subpanel.setBounds(390, 120, 900, 65);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBounds(410, 180, 360, 480);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBounds(770, 180, 390, 480);

        add(panel);
        add(rightPanel);
        add(leftPanel);
        add(subpanel);
        add(headerPanel);
        add(mainpanel);

        JLabel mainText = new JLabel("My 냉장고");
        mainText.setFont(new Font("맑은 고딕", Font.BOLD, 36));
        mainText.setHorizontalAlignment(SwingConstants.CENTER);
        mainText.setBounds(35, 35, 200, 60); // 위치 및 크기 조정
        panel.add(mainText);

        JLabel orderLabel = new JLabel("재료를 추가하세요!");
        orderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        orderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        orderLabel.setBounds(25, 2, 400, 60); // 위치 및 크기 조정
        subpanel.add(orderLabel);

        ImageIcon logoIcon1 = new ImageIcon(MyNaengAdd.class.getResource("/image/line.png")); // 이미지 아이콘 로드
        Image logoImage1 = logoIcon1.getImage().getScaledInstance(1, 1110, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedLogoIcon1 = new ImageIcon(logoImage1); // 조절된 이미지 아이콘 생성
        JLabel imgLabel1 = new JLabel(resizedLogoIcon1); // 이미지 아이콘을 담을 라벨 생성
        imgLabel1.setBounds(0, 30, resizedLogoIcon1.getIconWidth(), resizedLogoIcon1.getIconHeight()); // 라벨 위치 설정
        rightPanel.add(imgLabel1); // 우측 패널에 이미지 라벨 추가

        // SaveButton 이미지 로드 및 조절
        ImageIcon saveButtonIcon = new ImageIcon(MyNaengAdd.class.getResource("/image/SaveButton.png")); // SaveButton 아이콘 로드
        Image saveButtonImage = saveButtonIcon.getImage().getScaledInstance(83, 38, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedSaveButtonIcon = new ImageIcon(saveButtonImage); // 조절된 이미지 아이콘 생성
        JButton saveButton = new JButton(resizedSaveButtonIcon); // 버튼 생성 및 아이콘 설정
        saveButton.setBounds(160, 400, resizedSaveButtonIcon.getIconWidth(), resizedSaveButtonIcon.getIconHeight()); // 버튼 위치 설정
        saveButton.setBorder(null); // 테두리 없애기
        saveButton.setContentAreaFilled(false); // 내용 영역 채우기 없애기
        rightPanel.add(saveButton); // 우측 패널에 버튼 추가


        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainTestLoginfinish mainTest2 = new MainTestLoginfinish(); // MainTest2 클래스의 객체 생성
                mainTest2.setVisible(true); // 새 창 보이기
                for (JLabel label : labelList) {
                    System.out.println(label.getText());
                }
                dispose(); // 현재 창 닫기 (MyNaengAdd 클래스의 객체가 있어야 함)
            }
        });

        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(340, 50)); // 검색 필드 크기 설정
        int x = 20;
        int y = 60;
        searchField.setBounds(x, y, searchField.getPreferredSize().width, searchField.getPreferredSize().height); // 위치 설정
        rightPanel.add(searchField); // 좌측 패널에 검색 필드 추가

        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredText = searchField.getText().trim();
                if (!enteredText.isEmpty()) { // 입력된 텍스트가 비어있지 않은 경우
                    if (labelList.size() < labelLimit) { // 라벨 추가 제한 수를 넘지 않는 경우
                        JLabel textLabel = new JLabel(enteredText);
                        textLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 20)); // 폰트 설정
                        textLabel.setBounds(30, 50 + labelList.size() * 33, 300, 30); // 라벨 위치 설정

                        leftPanel.add(textLabel); // 우측 패널에 라벨 추가
                        labelList.add(textLabel); // 라벨 리스트에 추가
                        leftPanel.revalidate(); // 패널 다시 그리기
                        leftPanel.repaint(); // 패널 재페인트

                        searchField.setText(""); // 검색 필드 초기화

                        // 라벨을 클릭하여 삭제하는 기능 추가

                        textLabel.addMouseListener(new java.awt.event.MouseAdapter() {

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
                        JOptionPane.showMessageDialog(null, "냉장고가 가득 찼습니다!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "공백만 입력할 수 없습니다!");
                }
            }
        });


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
        SwingUtilities.invokeLater(() -> new MyNaengAdd()); // 프로그램 실행
    }
}
