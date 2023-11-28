package kyr.gui;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

class RoundedPanel extends JPanel {
    private int arcWidth;
    private int arcHeight;

    public RoundedPanel(int arcWidth, int arcHeight) {
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        setOpaque(false); // 패널의 투명도 설정
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g.create();

        // 둥근 사각형 모양 그리기
        graphics.setColor(getBackground());
        graphics.fillRoundRect(100, 120, 450, 585, arcWidth, arcHeight);
        //////////////////////////둥근 사각형 크기, 위치/////////////////////////
        graphics.dispose();
    }
}
public class Recipe extends JFrame {
    public Recipe() {
        setTitle("Recipe"); // 프레임 타이틀 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우를 닫으면 프로그램 종료
        setSize(1280, 760); // 프레임 크기 설정
        setLocationRelativeTo(null);

        Head head = new Head();
        JPanel headerPanel = head.getHeaderPanel();

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBackground(Color.WHITE);
        mainpanel.setBounds(30, 100, 330, 760);

        JPanel leftmainpanel = new JPanel();
        leftmainpanel.setLayout(null);
        leftmainpanel.setBackground(Color.PINK);
        leftmainpanel.setBounds(100, 395, 450, 295);

        JPanel rightmainpanel = new JPanel();
        rightmainpanel.setLayout(null);
        rightmainpanel.setBackground(Color.YELLOW);
        rightmainpanel.setBounds(550, 120, 630, 585);


        RoundedPanel roundedPanel = new RoundedPanel(40, 40); // 둥근 사각형의 둥글기 설정
        roundedPanel.setBackground(new Color(242, 242, 242));
        roundedPanel.setLayout(new BorderLayout()); // 원하는 레이아웃 설정 가능

        String imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA5MjlfMzQg%2FMDAxNjk1OTE1ODYxMzk1.BjVHVzI9S38ufhYGW0qmt8g8-Sn3LkYfQeQ4Ic4boawg.iPjcbVcTTAiBF_TkK5Hd1rb_--LP_O9h_63kBIRNOyog.JPEG.firehouse79%2FDSC02414.jpg&type=a340"; // 이미지 URL을 여기에 입력하세요
        String food_name = "존나 맛있는 김치찌개" ;
        // 이미지 불러와서 JLabel에 설정
        try {
            URL url = new URL(imageUrl);
            ImageIcon imageIcon = new ImageIcon(url);
            Image foodimg = imageIcon.getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH);
            ImageIcon resizedfoodimg =new ImageIcon(foodimg);
            JButton foodButton = new JButton(resizedfoodimg); // 이미지 아이콘을 담은 버튼 생성
            foodButton.setBounds(125, 140, 400, 250); // 버튼의 위치 및 크기 설정
            mainpanel.add(foodButton); // 패널에 로그인 버튼 추가
            foodButton.setBorderPainted(false); // 버튼 테두리 표시 안 함




            JLabel foodlabel = new JLabel(food_name);
            foodlabel.setFont(new Font("맑은 고딕", Font.PLAIN, 49));
            foodlabel.setBounds(50, 50, 200, 30); // 위치와 크기 설정
            leftmainpanel.add(foodlabel);

            JLabel recipelabel = new JLabel("asdasasdsdasdasdasdasdasdasdasadasasda");
            recipelabel.setFont(new Font("맑은 고딕", Font.PLAIN, 55));
            recipelabel.setBounds(220, 50, 200, 185); // 위치와 크기 설정
            rightmainpanel.add(recipelabel);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



        add(leftmainpanel);
        add(rightmainpanel);
        add(roundedPanel);
        setVisible(true);
        add(headerPanel);
        add(mainpanel);





    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Recipe()); // 프로그램 실행
    }
}