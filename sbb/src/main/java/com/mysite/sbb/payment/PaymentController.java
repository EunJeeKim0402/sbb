package com.mysite.sbb.payment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Value("${inicis.merchantKey}") // 가맹점 키
    private String merchantKey;

    @Value("${inicis.url.prepare}") // 이니시스 결제 준비 URL
    private String prepareUrl;

    @Value("${inicis.url.approval}") // 이니시스 결제 승인 URL
    private String approvalUrl;

    // 결제 준비 API
    @PostMapping("/prepare")
    public Map<String, Object> preparePayment(@RequestBody Payment payment) {
        Map<String, Object> response = new HashMap<>();

        try {
            // 이니시스 결제 준비 요청 데이터
            Map<String, String> paymentData = new HashMap<>();
            paymentData.put("mid", "INIpayTest");  // 가맹점 아이디
            paymentData.put("price", String.valueOf(payment.getPaymentAmount())); // 결제 금액
            paymentData.put("orderId", "order-" + System.currentTimeMillis()); // 주문 ID
            paymentData.put("productName", "상품명");
            paymentData.put("returnUrl", "http://localhost:8080/api/payment/approval"); // 결제 후 리디렉션 URL

            // HTTP 요청을 위한 RestTemplate 사용
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + merchantKey);  // 가맹점 키

            HttpEntity<Map<String, String>> entity = new HttpEntity<>(paymentData, headers);
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<Map> responseEntity = restTemplate.exchange(prepareUrl, HttpMethod.POST, entity, Map.class);

            // 결제 준비 결과
            Map<String, Object> body = responseEntity.getBody();
            if (body != null && "SUCCESS".equals(body.get("status"))) {
                response.put("success", true);
                response.put("paymentUrl", body.get("paymentUrl"));  // 이니시스 결제 페이지 URL
            } else {
                response.put("success", false);
                response.put("message", body != null ? body.get("message") : "Unknown error");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

}
