package com.example.NROBACKEND.service;

import com.example.NROBACKEND.entity.Pay;
import com.example.NROBACKEND.entity.User;
import com.example.NROBACKEND.repository.PayRepository;
import com.example.NROBACKEND.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayService {

    private final UserRepository userRepository;
    private final PayRepository payRepository;

    public PayService(UserRepository userRepository, PayRepository payRepository) {
        this.userRepository = userRepository;
        this.payRepository = payRepository;
    }

    @Transactional
    public Pay napTien(String username, Long tien) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return null; // không tìm thấy người dùng
        }

        // chỉ cần lưu lại thông tin giao dịch nạp
        Pay pay = new Pay(tien, user);
        return payRepository.save(pay);
    }
}
