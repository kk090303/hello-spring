package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //Map to save member
    private static long sequence = 0L; //key value maker


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
       //Filter only when the name getName() from the member and the name of the parameter are the same,
        // and return if found by findAny()
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //clear the store
    public void clearStore(){
        store.clear();
    }
}
