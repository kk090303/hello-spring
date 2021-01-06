package Hello.hellospring.repository;
import Hello.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); //return saved member
    Optional<Member> findById(Long id); // search user by id
    Optional<Member> findByName(String name); //search user by name
    List<Member> findAll(); //return all saved member

}