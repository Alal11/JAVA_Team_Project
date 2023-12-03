package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.menu.MenuDetailIngredientDTO;
import dto.menu.MenuDetailRecipeDTO;
import dto.menu.MenuSearchInfoDTO;

import javax.swing.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MenuApi {

    private static ObjectMapper mapper = new ObjectMapper();
    private static final HttpRequestManager HTTP_REQUEST_MANAGER = new HttpRequestManager();


    // 메뉴 이름 검색 조회 (테스트 성공!)
    public static List<MenuSearchInfoDTO> menuSearch(Long memberKey, String menuName) {
        List<MenuSearchInfoDTO> list;
        // 한글일 때는 인코드로 바꿔줘야 함
        String endPoint = "/menu/search?memberKey=" + memberKey + "&menuName=" + URLEncoder.encode(menuName, StandardCharsets.UTF_8);
        String response = HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            list = mapper.readValue(response, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    // 가격 입력 조회 (테스트 성공!)
    public static List<MenuSearchInfoDTO> totalCost(Long memberKey, Long memberPrice) {
        List<MenuSearchInfoDTO> list;
        String endPoint = "/menu/totalcost/" + memberKey + "/" + memberPrice;
        String response = HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            list = mapper.readValue(response, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // 메뉴 상세 조회 (재료 리스트) - 테스트 성공!
    public static MenuDetailIngredientDTO menuDetailIngredient(Long memberKey, String menuName) {
        MenuDetailIngredientDTO menuDetailIngredientDTO;
        String endPoint = "/menu/search/detail/ingredient?memberKey=" + memberKey + "&menuName=" + URLEncoder.encode(menuName, StandardCharsets.UTF_8);
        String response = HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            menuDetailIngredientDTO = mapper.readValue(response, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return menuDetailIngredientDTO;
    }


    // 메뉴 상세 조회 (레시피 조회) - 테스트 성공!
    public static MenuDetailRecipeDTO menuDetailRecipe(Long memberKey, String menuName) {
        MenuDetailRecipeDTO menuDetailRecipeDTO;
        String endPoint = "/menu/search/detail/recipe?memberKey=" + memberKey + "&menuName="+ URLEncoder.encode(menuName, StandardCharsets.UTF_8);
        String response = HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            menuDetailRecipeDTO = mapper.readValue(response, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return menuDetailRecipeDTO;
    }
}