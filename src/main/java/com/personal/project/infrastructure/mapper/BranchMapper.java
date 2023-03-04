package com.personal.project.infrastructure.mapper;

import com.personal.project.domain.dto.branch.BranchDto;
import com.personal.project.infrastructure.entity.branch.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BranchMapper {
    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);

    Branch branchDtoToBranch(BranchDto branchDto);

    BranchDto branchToBranchDto(Branch branch);

    List<BranchDto> listBranchToListBranchDto(List<Branch> branchList);
}
