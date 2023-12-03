package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.IngredientSearchDTO;
import dto.myfridge.MyFridgeDTO;
import dto.myfridge.MyFridgeListDTO;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MyFridgeApi {

    private static ObjectMapper mapper = new ObjectMapper();
    private static final HttpRequestManager HTTP_REQUEST_MANAGER = new HttpRequestManager();


    // 마냉 추가 (테스트 성공!)
    public static void addMyfridge(MyFridgeDTO myFridgeDTO) {
        String endPoint = "/myfridge/add/"+myFridgeDTO.getMemberKey()+"/"+myFridgeDTO.getIngredientKey();
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(myFridgeDTO);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HTTP_REQUEST_MANAGER.postRequest(endPoint, requestBody);

    }

    // 마냉 리스트 조회 (테스트 성공!)
    public static List<MyFridgeListDTO> getMyfridgeList(Long memberKey) {
        List<MyFridgeListDTO> myFridgeListDTOList = new ArrayList<>();
        String endPoint = "/myfridge/list/"+memberKey;
        String response = HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            myFridgeListDTOList = mapper.readValue(response, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return myFridgeListDTOList;
    }

    // 마냉 삭제 (테스트 성공!)
    public static void deleteMyfridge(Long myfridgeKey) {
        String endPoint = "/myfridge/delete/" + myfridgeKey;
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(myfridgeKey);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        HTTP_REQUEST_MANAGER.deleteRequest(endPoint, requestBody);
    }


    // 마냉 재료 추가할 때 재료 검색 (테스트 성공!)
    public static List<IngredientSearchDTO> ingredidentSearch(String ingredientName){
        List<IngredientSearchDTO> ingredientSearchDTOList = new ArrayList<>();
        String endPoint = "/myfridge/ingredientSearch?ingredientName=" + URLEncoder.encode(ingredientName, StandardCharsets.UTF_8);
        String response = HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            ingredientSearchDTOList = mapper.readValue(response, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return ingredientSearchDTOList;
    }

}
