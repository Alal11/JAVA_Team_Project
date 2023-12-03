package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.basket.BasketAddDTO;
import dto.basket.BasketInquiryDTO;

import javax.swing.*;
import java.util.List;

public class BasketApi {

    private static ObjectMapper mapper = new ObjectMapper();
    private static final HttpRequestManager HTTP_REQUEST_MANAGER = new HttpRequestManager();

    // 장바구니 상품 추가
    public static void addBasket(Long memberKey, List<BasketAddDTO> basketAddDTOList) {
        String endPoint = "/basket/add?memberKey=" + memberKey;
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(basketAddDTOList);
            HTTP_REQUEST_MANAGER.postRequest(endPoint, requestBody);
        } catch (JsonProcessingException e) {
            JOptionPane.showMessageDialog(null, "추가 실패", "Cookeryket", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("추가 실패");
        }
    }

    // 장바구니 상품 삭제 (성공!)
    public static void deleteBasket(Long basketKey) {
        String endPoint = "/basket/delete?basketKey=" + basketKey;
        String requestBody;

        try {
            requestBody = mapper.writeValueAsString(basketKey);
            HTTP_REQUEST_MANAGER.deleteRequest(endPoint, requestBody);
        } catch (JsonProcessingException e) {
            JOptionPane.showMessageDialog(null, "삭제 실패", "Cookeryket", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("삭제 실패");
        }

    }

    // 장바구니에 상품 수량 수정
    public static void updateBasket(Long basketKey, int basketQuantity) {
        String endPoint = "/basket/update?basketKey=" + basketKey + "&basketQuantity=" + basketQuantity;
        String requestBody;

        try {
            String basketKeyQuantity = String.valueOf(basketKey + basketQuantity);
            requestBody = mapper.writeValueAsString(basketKeyQuantity);
            HTTP_REQUEST_MANAGER.putRequest(endPoint, requestBody);
        } catch (JsonProcessingException e) {
            JOptionPane.showMessageDialog(null, "수정 실패", "Cookeryket", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("수정 실패");
        }
    }

    // 장바구니 조회 (성공!)
    public static List<BasketInquiryDTO> inquiryBasket(Long memberKey) {
        List<BasketInquiryDTO> basketInquiryDTOList;
        String endPoint = "/basket/inquiry?memberKey=" + memberKey;
        String response = HTTP_REQUEST_MANAGER.getRequest(endPoint);

        try {
            basketInquiryDTOList = mapper.readValue(response, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            JOptionPane.showMessageDialog(null, "조회 실패", "Cookeryket", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("조회 실패");
        }
        return basketInquiryDTOList;
    }

}