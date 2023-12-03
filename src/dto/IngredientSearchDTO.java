package dto;

public class IngredientSearchDTO {

    private Long ingredientKey;
    private String ingredientName;

    public IngredientSearchDTO() {
    }

    public IngredientSearchDTO(Long ingredientKey, String ingredientName) {
        this.ingredientKey = ingredientKey;
        this.ingredientName = ingredientName;
    }

    public void setIngredientKey(Long ingredientKey) {
        this.ingredientKey = ingredientKey;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Long getIngredientKey() {
        return ingredientKey;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}