package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
class RoundedPanel1 extends JPanel {
    private int arcWidth;
    private int arcHeight;

    public RoundedPanel1(int arcWidth, int arcHeight) {
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
    }}
public class RecipeReverse extends JFrame {

    private JLabel[] nameLabel;
    private JLabel[] priceLabel;
    private JLabel[] ingredientLabel;

    private String[] namelist = {"된장", "양파", "애호박", "두부", "감자", "다진마늘", "고추가루", "청양고추"};
    private String[] pricelist = {"100", "700", "900", "1000", "900", "400", "500", "1000"};
    private String[] ingredientlist = {"2스푼", "1/2개", "1/2개", "1/2모", "1/2개", "1스푼", "1스푼", "1개"};


    public RecipeReverse() {
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



        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ImageIcon jaeryoIcon = new ImageIcon(MyNaengAdd.class.getResource("/image/recipebutton.png")); // 이미지 아이콘 로드
        Image jaeryoImage = jaeryoIcon.getImage().getScaledInstance(220, 95, Image.SCALE_SMOOTH); // 이미지 크기 조절
        ImageIcon resizedjaeryoIcon = new ImageIcon(jaeryoImage); // 조절된 이미지 아이콘 생성
        JButton imgButton = new JButton(resizedjaeryoIcon); // 버튼에 이미지 아이콘 추가
        imgButton.setBounds(115, 190, resizedjaeryoIcon.getIconWidth(), resizedjaeryoIcon.getIconHeight()); // 버튼 위치 및 크기 설정
        imgButton.setBorderPainted(false);
        leftmainpanel.add(imgButton); // 패널에 버튼 추가

        nameLabel = new JLabel[namelist.length];
        priceLabel = new JLabel[pricelist.length];
        ingredientLabel = new JLabel[ingredientlist.length];


        for (int i = 0; i < namelist.length; i++) {
            nameLabel[i] = new JLabel(namelist[i]);
            nameLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 20));
            nameLabel[i].setBounds(200, 70 + i * 50, 100, 50);
            rightmainpanel.add(nameLabel[i]);

            priceLabel[i] = new JLabel(pricelist[i] + "원");
            priceLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 20));
            priceLabel[i].setBounds(320, 70 + i * 50, 100, 50);
            rightmainpanel.add(priceLabel[i]);

            ingredientLabel[i] = new JLabel(ingredientlist[i]);
            ingredientLabel[i].setFont(new Font("맑은 고딕", Font.BOLD, 20));
            ingredientLabel[i].setBounds(440, 70 + i * 50, 100, 50);
            rightmainpanel.add(ingredientLabel[i]);
        }




        //namelist={"된장","양파","애호박","두부","감자","다진마늘","고추가루","청양고추"};
        //pricelist={"100","700","900","1000","900","400","500","1000"};
        //ingredientlist = {"2스푼","1/2개","1/2개","1/2모","1/2개","1스푼","1스푼","1개"};




        imgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "My Page" 버튼을 클릭하면 MyPageOrder 창을 열도록 함
                SwingUtilities.invokeLater(() -> {
                    Recipe recipe = new Recipe();
                    recipe.setVisible(true);

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
        SwingUtilities.invokeLater(() -> new RecipeReverse()); // 프로그램 실행
    }
}