package dto.menu;

public class MenuDetailRecipeDTO {

    private String menuName;
    private int totalPrice;
    private String menuRecipe;

    public MenuDetailRecipeDTO() {
    }

    public MenuDetailRecipeDTO(String menuName, int totalPrice, String menuRecipe) {
        this.menuName = menuName;
        this.totalPrice = totalPrice;
        this.menuRecipe = menuRecipe;
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

    public String getMenuRecipe() {
        return menuRecipe;
    }

    public void setMenuRecipe(String menuRecipe) {
        this.menuRecipe = menuRecipe;
    }
}
