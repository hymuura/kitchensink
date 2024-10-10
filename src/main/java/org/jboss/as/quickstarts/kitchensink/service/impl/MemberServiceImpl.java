package org.jboss.as.quickstarts.kitchensink.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.jboss.as.quickstarts.kitchensink.repository.MemberRepository;
import org.jboss.as.quickstarts.kitchensink.entity.Member;
import org.jboss.as.quickstarts.kitchensink.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member register(Member member) throws Exception {
        log.info("Registering {}", member.getName());
        return memberRepository.save(member);
    }

    @Override
    public Member findByEmail(String email) throws Exception {
        log.info("Searching email: {}", email);
        return memberRepository.findByEmail(email);
    }

    @Override
    public List<Member> findAllByOrderByNameAsc() throws Exception {
        log.info("Retrieving all members");
        return memberRepository.findAllByOrderByNameAsc();
    }
}
