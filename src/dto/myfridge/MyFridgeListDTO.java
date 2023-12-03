package dto.myfridge;

public class MyFridgeListDTO {

    private Long myfridgeKey;
    private String ingredientName;

    public MyFridgeListDTO() {
    }

    public MyFridgeListDTO(Long myfridgeKey, String ingredientName) {
        this.myfridgeKey = myfridgeKey;
        this.ingredientName = ingredientName;
    }

    public void setMyfridgeKey(Long myfridgeKey) {
        this.myfridgeKey = myfridgeKey;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Long getMyfridgeKey() {
        return myfridgeKey;
    }

    public String getIngredientName() {
        return ingredientName;
    }
}
