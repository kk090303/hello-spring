package Hello.hellospring;

import Hello.hellospring.aop.TimeTraceAop;
import Hello.hellospring.repository.JdbcTemplateMemberRepository;
import Hello.hellospring.repository.JpaMemberRepository;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //JdbcTemplate을 통한 DB접근
    /* private DataSource dataSource;
       @Autowired
       public SpringConfig(DataSource dataSource){
          this.dataSource = dataSource;
      }*/

    //JPA 방식을 통합 DB접근
    /* private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    //스프링 데이터 JPA 를 통합 DB접근
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


    /*
    @Bean
    public MemberRepository memberRepository(){
      //return new MemoryMemberRepository();
      //return new JdbcMemberRepository(dataSource);
      // return new JdbcTemplateMemberRepository(dataSource);
      // return new JpaMemberRepository(em);
    }
    */
}
