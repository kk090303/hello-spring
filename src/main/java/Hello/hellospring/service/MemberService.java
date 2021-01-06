package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    //회원 서비스 제공을 위한 repository 생성
    //DI(의존성 주입) 을 위해 코드상에서 객체를 직접적으로 만드는게 아니라
    //객체의 밖에서 객체를 넣어주는 방식이다.
    //생성자를 통해 memberRepository를 생성해주면 의존성을 주입 받을 수 있다.
    //memaberRepository에 다양한 객체를 받아서 의존성을 주입 받을 수 있다.

    //before
    /* 이렇게 new를 통해 직접 객체를 생성하면 MemberSeirvice 는 MemoryMemberRepository에 의존이 되어버린다.
    private final MemberRepository memberRepository = new
            MemoryMemberRepository();
     */

    //after
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
