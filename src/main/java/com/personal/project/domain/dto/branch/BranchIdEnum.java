package com.personal.project.domain.dto.branch;

public enum BranchIdEnum {
    HN1,
    SG1,
    DN1;

    public static BranchIdEnum getEnum(String branchId) {
        for (BranchIdEnum branchIdEnum : values()) {
            if (branchIdEnum.name().equals(branchId))
                return branchIdEnum;
        }
        return null;
    }
}
