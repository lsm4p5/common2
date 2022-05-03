package com.lguplus.common.repository.querydsl;

import com.lguplus.common.api.dto.MemberSearchCondition;
import com.lguplus.common.api.dto.MemberTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryCustom {

    List<MemberTeamDto> search(MemberSearchCondition memberSearchCondition);
    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition,Pageable pageable);

}
