package com.lguplus.common.service.login;

import com.lguplus.common.domain.Entity.Member;
import com.lguplus.common.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return null - 로그인 실패
     */

    public Optional <Member>  login(String loginname, String password) {

        /**
        List<Member> members = memberRepository.findByloginname(loginname);

        for (Member member : members) {
            if(member.getPassword().equals(password)) {
                return member;
            }
        }
        return null; -> Optional로 반화하여 return 필요
        */

        // password는 DB에 저장시 암호화하여 저장하여야 한다.

        return memberRepository.findByloginname(loginname)
                .stream().filter(m->m.getPassword().equals(password))
                .findAny();

    }
}
