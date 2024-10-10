package org.jboss.as.quickstarts.kitchensink.controller;

import org.jboss.as.quickstarts.kitchensink.entity.Member;
import org.jboss.as.quickstarts.kitchensink.service.MemberService;
import org.jboss.as.quickstarts.kitchensink.service.impl.MemberServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberServiceImpl;

    public MemberController(MemberServiceImpl memberServiceImpl) {
        this.memberServiceImpl = memberServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) throws Exception {
        Member savedMember = memberServiceImpl.register(member);
        return ResponseEntity.ok(savedMember);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Member> findByEmail(@PathVariable String email) throws Exception {
        Optional<Member> member = Optional.ofNullable(memberServiceImpl.findByEmail(email));
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Member>> findAll() throws Exception {
        List<Member> members = memberServiceImpl.findAllByOrderByNameAsc();
        return ResponseEntity.ok(members);
    }
}
