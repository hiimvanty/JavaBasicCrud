package com.devcamp.api.task_64dot10_crud_vouchers;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ok");
    }

}
