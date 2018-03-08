package org.zerock.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {

    private String userid;
    private String userpw;
    private String uname;
    private String role;
    private boolean enabled;
    private Date regdate, updatedate;

}
