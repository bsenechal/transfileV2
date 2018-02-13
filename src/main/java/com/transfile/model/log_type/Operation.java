package com.transfile.model.log_type;

import org.springframework.stereotype.Component;

@Component
public class Operation extends ALogType {
    
    @Override
    public String getContent() {
        return "Operation";
    }
    
}
