package com.example.react07_phone_backend.repository;

import com.example.react07_phone_backend.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}