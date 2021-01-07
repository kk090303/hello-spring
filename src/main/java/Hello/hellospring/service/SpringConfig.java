package Hello.hellospring.service;

import Hello.hellospring.repository.JdbcTemplateMemberRepository;
import Hello.hellospring.repository.JpaMemberRepository;
import Hello.hellospring.repository.MemberRepository;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //   private DataSource dataSource;
    //   @Autowired
    //   public SpringConfig(DataSource dataSource){
    //       this.dataSource = dataSource;
    //   }
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
      //return new MemoryMemberRepository();
      //return new JdbcMemberRepository(dataSource);
      // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
