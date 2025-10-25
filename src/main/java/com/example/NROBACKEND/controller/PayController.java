package com.example.NROBACKEND.controller;

import com.example.NROBACKEND.entity.Pay;
import com.example.NROBACKEND.service.PayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pay")
@CrossOrigin(origins = "*")
public class PayController {

    private final PayService payService;

    public PayController(PayService payService) {
        this.payService = payService;
    }

    @PostMapping("/nap")
    public ResponseEntity<?> napTien(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String tienStr = request.get("tien");

        if (username == null || tienStr == null) {
            return ResponseEntity.badRequest().body("Thiếu username hoặc số tiền nạp!");
        }

        try {
            Long tien = Long.parseLong(tienStr);
            Pay pay = payService.napTien(username, tien);
            if (pay == null) {
                return ResponseEntity.badRequest().body("Không tìm thấy người dùng!");
            }
            return ResponseEntity.ok("Người dùng " + username + " đã nạp " + tien + " thành công!");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Trường 'tien' phải là số hợp lệ!");
        }
    }
}
