package org.jboss.as.quickstarts.kitchensink.repository;

import java.util.List;

import org.jboss.as.quickstarts.kitchensink.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);
    List<Member> findAllByOrderByNameAsc();
}
