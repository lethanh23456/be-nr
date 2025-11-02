package com.example.NROBACKEND.service;

import com.example.NROBACKEND.dto.LoginRequest;
import com.example.NROBACKEND.dto.RegisterRequest;
import com.example.NROBACKEND.dto.AuthResponse;
import com.example.NROBACKEND.entity.AuthService;
import com.example.NROBACKEND.entity.User;
import com.example.NROBACKEND.repository.AuthServiceRepository;
import com.example.NROBACKEND.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceService {

    private final AuthServiceRepository authServiceRepository;
    private final UserRepository userRepository;

    public AuthServiceService(AuthServiceRepository authServiceRepository, UserRepository userRepository) {
        this.authServiceRepository = authServiceRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        // Kiểm tra username đã tồn tại
        if (authServiceRepository.findByUsername(request.getUsername()).isPresent()) {
            return new AuthResponse(null, null, null, null, null, "Username đã tồn tại");
        }

        // Kiểm tra email đã tồn tại
        if (authServiceRepository.findByEmail(request.getEmail()).isPresent()) {
            return new AuthResponse(null, null, null, null, null, "Email đã tồn tại");
        }

        // Tạo AuthService
        com.example.NROBACKEND.entity.AuthService authService = new com.example.NROBACKEND.entity.AuthService();
        authService.setUsername(request.getUsername());
        authService.setEmail(request.getEmail());
        authService.setPassword(request.getPassword()); // Nên mã hóa password
        authService.setRealname(request.getRealname());
        authService.setRole("USER"); // Mặc định role là USER

        // Save AuthService
        authService = authServiceRepository.save(authService);

        // Tạo User
        User user = new User();
        user.setAuthService(authService);

        // Save User
        userRepository.save(user);

        return new AuthResponse(
                authService.getId(),
                authService.getUsername(),
                authService.getEmail(),
                authService.getRealname(),
                authService.getRole(),
                "Đăng ký thành công"
        );
    }

    public AuthResponse login(LoginRequest request) {
        // Tìm user theo username
        com.example.NROBACKEND.entity.AuthService authService = authServiceRepository
                .findByUsername(request.getUsername())
                .orElse(null);

        if (authService == null) {
            return new AuthResponse(null, null, null, null, null, "Username không tồn tại");
        }

        // Kiểm tra password (nên sử dụng BCrypt để so sánh)
        if (!authService.getPassword().equals(request.getPassword())) {
            return new AuthResponse(null, null, null, null, null, "Mật khẩu không đúng");
        }

        // Kiểm tra tài khoản có bị ban không
        if (authService.getBiBan() != null && authService.getBiBan()) {
            return new AuthResponse(null, null, null, null, null, "Tài khoản đã bị khóa");
        }

        return new AuthResponse(
                authService.getId(),
                authService.getUsername(),
                authService.getEmail(),
                authService.getRealname(),
                authService.getRole(),
                "Đăng nhập thành công"
        );
    }
}