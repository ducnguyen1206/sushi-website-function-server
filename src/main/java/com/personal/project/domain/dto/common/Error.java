package com.personal.project.domain.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {
    private String code;
    private String message;
}
