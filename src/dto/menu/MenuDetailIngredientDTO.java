package dto.menu;

public class MenuDetailIngredientDTO {

    private String menuName;
    private int totalPrice;
    private String[] ingredientNames;
    private int[] ingredientPrices;
    private boolean[] haves;
    private String MenuImage;
    private String[] IngredientImage;

    public MenuDetailIngredientDTO() {
    }

    public MenuDetailIngredientDTO(String menuName, int totalPrice, String[] ingredientNames, int[] ingredientPrices, boolean[] haves, String menuImage, String[] ingredientImage) {
        this.menuName = menuName;
        this.totalPrice = totalPrice;
        this.ingredientNames = ingredientNames;
        this.ingredientPrices = ingredientPrices;
        this.haves = haves;
        MenuImage = menuImage;
        IngredientImage = ingredientImage;
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

    public String[] getIngredientNames() {
        return ingredientNames;
    }

    public void setIngredientNames(String[] ingredientNames) {
        this.ingredientNames = ingredientNames;
    }

    public int[] getIngredientPrices() {
        return ingredientPrices;
    }

    public void setIngredientPrices(int[] ingredientPrices) {
        this.ingredientPrices = ingredientPrices;
    }

    public boolean[] getHaves() {
        return haves;
    }

    public void setHaves(boolean[] haves) {
        this.haves = haves;
    }

    public String getMenuImage() {
        return MenuImage;
    }

    public void setMenuImage(String menuImage) {
        MenuImage = menuImage;
    }

    public String[] getIngredientImage() {
        return IngredientImage;
    }

    public void setIngredientImage(String[] ingredientImage) {
        IngredientImage = ingredientImage;
    }
}
