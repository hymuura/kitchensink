package org.jboss.as.quickstarts.kitchensink.service.impl;

import org.jboss.as.quickstarts.kitchensink.entity.Member;
import org.jboss.as.quickstarts.kitchensink.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MemberServiceImplTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberServiceImpl memberService;

    private Member member;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        member = new Member();
        member.setId(1L);
        member.setName("John Doe");
        member.setEmail("john.doe@example.com");
        member.setPhoneNumber("1234567890");
    }

    @Test
    public void testRegister() throws Exception {
        when(memberRepository.save(member)).thenReturn(member);

        Member registeredMember = memberService.register(member);

        assertEquals("John Doe", registeredMember.getName());
        assertEquals("john.doe@example.com", registeredMember.getEmail());
        verify(memberRepository, times(1)).save(member);
    }
}
