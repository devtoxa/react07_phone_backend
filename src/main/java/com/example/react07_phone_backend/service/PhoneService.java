package com.example.react07_phone_backend.service;

import com.example.react07_phone_backend.entity.Phone;
import com.example.react07_phone_backend.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    // 전체 목록 조회 (GET)
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    // 데이터 등록 (POST)
    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    // 데이터 수정 (PUT)
    public Phone updatePhone(Long id, Phone phoneDetails) {
        Phone phone = phoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 연락처가 존재하지 않습니다. id=" + id));
        
        phone.setName(phoneDetails.getName());
        phone.setPhone(phoneDetails.getPhone());
        
        return phoneRepository.save(phone);
    }

    // 데이터 삭제 (DELETE)
    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }
}