package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {


    //DI
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //sign-up
    public Long join(Member member) {
        //Duplicate Member with Same Name X
        validateDuplicateMember(member); //verification duplicated member
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                   throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //All Membership Lookup
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID){
        return memberRepository.findById(memberID);
    }

}
