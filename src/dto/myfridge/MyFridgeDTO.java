package dto.myfridge;

public class MyFridgeDTO {

    private Long myFridgeKey;
    private Long memberKey;
    private Long ingredientKey;

    public MyFridgeDTO() {
    }

    public MyFridgeDTO(Long memberKey, Long ingredientKey) {
        this.memberKey = memberKey;
        this.ingredientKey = ingredientKey;
    }

    public Long getMyFridgeKey() {
        return myFridgeKey;
    }

    public Long getMemberKey() {
        return memberKey;
    }

    public Long getIngredientKey() {
        return ingredientKey;
    }

    public void setMyFridgeKey(Long myFridgeKey) {
        this.myFridgeKey = myFridgeKey;
    }

    public void setMemberKey(Long memberKey) {
        this.memberKey = memberKey;
    }

    public void setIngredientKey(Long ingredientKey) {
        this.ingredientKey = ingredientKey;
    }
}