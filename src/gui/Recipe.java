package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        leftmainpanel.setBackground(new Color(242, 242, 242));
        leftmainpanel.setBounds(100, 395, 450, 295);

        JPanel rightmainpanel = new JPanel();
        rightmainpanel.setLayout(null);
        rightmainpanel.setBackground(Color.WHITE);
        rightmainpanel.setBounds(570, 120, 630, 585);


        RoundedPanel1 roundedPanel = new RoundedPanel1(40, 40); // 둥근 사각형의 둥글기 설정
        roundedPanel.setBackground(new Color(242, 242, 242));
        roundedPanel.setLayout(new BorderLayout()); // 원하는 레이아웃 설정 가능

        String imageUrl = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzA5MjlfMzQg%2FMDAxNjk1OTE1ODYxMzk1.BjVHVzI9S38ufhYGW0qmt8g8-Sn3LkYfQeQ4Ic4boawg.iPjcbVcTTAiBF_TkK5Hd1rb_--LP_O9h_63kBIRNOyog.JPEG.firehouse79%2FDSC02414.jpg&type=a340"; // 이미지 URL을 여기에 입력하세요
        String food_name = "존나 맛있는\n 김치찌개" ;
        int totalprice= 7600;
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
            foodlabel.setFont(new Font("맑은 고딕", Font.BOLD, 32));
            foodlabel.setBounds(25, 10, 330, 40); // 위치와 크기 설정
            leftmainpanel.add(foodlabel);

            JLabel pricelabel = new JLabel(Integer.toString(totalprice)+"원");
            pricelabel.setFont(new Font("맑은 고딕", Font.BOLD, 55));
            pricelabel.setForeground(new Color(123, 199, 139));
            pricelabel.setBounds(240, 70, 190, 55); // 위치와 크기 설정
            leftmainpanel.add(pricelabel);

            JLabel recipelabel = new JLabel("<html>" +
                    "1. 물을 6컵을 넣은 냄비에 다시마와 멸치등으로 육수를 내끓입니다. 이 과정은 대략 15분정도가 걸려요. 물이 증발하여 4컵 또는 5컵 정도의 양이 남는데요, 종이컵으로 6컵을 측정했다 해도 실제로는 이 정도가 됩니다.<br>" +
                    "<br>" +
                    "2. 재료들은 준비해놓고 두부는 적당한 크기로, 양파, 감자, 호박, 대파, 청양고추는 먹기 좋게 잘라둡니다.<br>" +
                    "<br>" +
                    "3. 뚝배기에 된장을 2스푼을 풀어 육수에 넣어줍니다. 된장은 개인의 취향에 따라 다른 맛과 간을 줄 수 있으니 처음에는 1스푼만 넣고, 끓이면서 간을 맞춰보세요.<br>" +
                    "<br>" +
                    "4. 감자를 먼저 넣고 2분 정도 끓여준 후 양파와 호박을 넣어주세요. 마늘, 청양고추, 대파를 넣고 약간 더 끓입니다. 간을 확인하고 부족하다면 된장을 추가하거나 짠 맛이면 육수를 더 넣으면 돼요.<br>" +
                    "<br>" +
                    "5. 불을 끄기 전에 두부를 넣고, 고추가루 반 스푼을 넣고 30초 정도만 더 끓여주면 완성입니다! 재료들의 순서는 크게 중요하지 않으니 한 번에 모두 넣고 끓여도 괜찮아요!");
            recipelabel.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
            recipelabel.setBounds(1, 1, 630, 585); // 위치와 크기 설정
            rightmainpanel.add(recipelabel);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ImageIcon jaeryoIcon = new ImageIcon(MyNaengAdd.class.getResource("/image/jaeryobutton.png")); // 이미지 아이콘 로드
        Image jaeryoImage = jaeryoIcon.getImage().getScaledInstance(220, 95, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedjaeryoIcon = new ImageIcon(jaeryoImage); // 조절된 이미지 아이콘 생성
        JButton imgButton = new JButton(resizedjaeryoIcon); // 버튼에 이미지 아이콘 추가
        imgButton.setBounds(115, 190, resizedjaeryoIcon.getIconWidth(), resizedjaeryoIcon.getIconHeight()); // 버튼 위치 및 크기 설정
        imgButton.setBorderPainted(false);
        leftmainpanel.add(imgButton); // 패널에 버튼 추가





        imgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    RecipeReverse recipereverse = new RecipeReverse();
                    recipereverse.setVisible(true);

                    // 현재 창을 닫음
                    ((JFrame) SwingUtilities.getWindowAncestor(imgButton)).dispose();
                });
            }
        });

//RecipeReverse


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