package com.example.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class TimeService {
    public Timestamp minustime(){
    LocalDateTime localDateTime = LocalDateTime.now();
    localDateTime = localDateTime.minusHours(24);
    Timestamp timestamp = Timestamp.valueOf(localDateTime);
    return timestamp;
    }
}
