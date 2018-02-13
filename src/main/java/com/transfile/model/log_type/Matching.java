package com.transfile.model.log_type;

import org.springframework.stereotype.Component;

@Component
public class Matching extends ALogType {
    
    @Override
    public String getContent() {
        return "Matching";
    }
    
}
