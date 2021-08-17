package com.hlx.posterm.service;

import com.hlx.posterm.dto.ChipInfo;
import com.hlx.posterm.dto.ValidationStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
// Written to prepare students for what they'll see soon...
// (overly verbose assignments and use of builder)

@Service
public class PrevalidationService implements ValidationService<ChipInfo, ValidationStatus> {
    @Override
    public ValidationStatus validate(ChipInfo candidateIn) {
        String message = "unknown network";
        String status = "invalid";
        if(candidateIn.getNumber().startsWith("4")) {
            message = "complete";
            status = "valid";
        }
        ValidationStatus returnValue = ValidationStatus.builder().timeStamp(Instant.now().toString()).message(message).status(status).build();
        return returnValue;
    }
}