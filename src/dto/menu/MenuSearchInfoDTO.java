package dto.menu;


public class MenuSearchInfoDTO {

    private String menuName;

    private int totalPrice;
    private String menuImage;

    public MenuSearchInfoDTO() {
    }

    public MenuSearchInfoDTO(String menuName, int totalPrice, String menuImage) {
        this.menuName = menuName;
        this.totalPrice = totalPrice;
        this.menuImage=menuImage;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }
}
