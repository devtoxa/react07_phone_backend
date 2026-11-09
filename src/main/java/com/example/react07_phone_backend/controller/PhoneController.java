package com.example.react07_phone_backend.controller;

import com.example.react07_phone_backend.entity.Phone;
import com.example.react07_phone_backend.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phones")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // React 개발 서버 주소 허용
public class PhoneController {

    private final PhoneService phoneService;

    // GET /api/phones : 목록 조회
    @GetMapping
    public List<Phone> getAllPhones() {
        return phoneService.getAllPhones();
    }

    // POST /api/phones : 데이터 등록
    @PostMapping
    public Phone createPhone(@RequestBody Phone phone) {
        return phoneService.createPhone(phone);
    }

    // PUT /api/phones/{id} : 데이터 수정
    @PutMapping("/{id}")
    public Phone updatePhone(@PathVariable Long id, @RequestBody Phone phoneDetails) {
        return phoneService.updatePhone(id, phoneDetails);
    }

    // DELETE /api/phones/{id} : 데이터 삭제
    @DeleteMapping("/{id}")
    public void deletePhone(@PathVariable Long id) {
        phoneService.deletePhone(id);
    }
}