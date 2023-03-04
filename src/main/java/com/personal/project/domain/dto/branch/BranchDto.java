package com.personal.project.domain.dto.branch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {
    private Long id;
    private String branchId;
    private String branchName;
    private String address;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastUpdateDate;
    private String lastUpdateBy;
}
