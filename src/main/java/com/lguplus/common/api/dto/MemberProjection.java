package com.lguplus.common.api.dto;

import lombok.Data;

public interface MemberProjection {

    public String getLoginname();
    public String getUsername();
    public String getPassword();
    public int getAge();
    public String getTeamName();
}
