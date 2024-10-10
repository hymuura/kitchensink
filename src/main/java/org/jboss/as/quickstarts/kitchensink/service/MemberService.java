package org.jboss.as.quickstarts.kitchensink.service;

import org.jboss.as.quickstarts.kitchensink.entity.Member;

import java.util.List;

public interface MemberService {
    Member register(Member member) throws Exception;

    Member findByEmail(String email) throws Exception;

    List<Member> findAllByOrderByNameAsc() throws Exception;
}
