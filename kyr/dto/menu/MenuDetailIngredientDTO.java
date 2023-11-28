package kyr.dto.menu;

public class MenuDetailIngredientDTO {

    private String menuName;

    public String getMenuName() {
        return menuName;
    }

    private int totalPrice;

    public int getTotalPrice() {
        return totalPrice;
    }

    private String[] ingredientNames;

    public String[] getIngredientNames() {
        return ingredientNames;
    }

    private int[] ingredientPrices;

    public int[] getIngredientPrices() {
        return ingredientPrices;
    }

    private boolean[] haves;

    public boolean[] getHaves() {
        return haves;
    }
}

