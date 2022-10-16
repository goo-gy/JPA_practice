package practice;

import practice.domain.Member;
import practice.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.persistContext();
//        memberRepository.entitySame();
//        memberRepository.batchFlush();
//        memberRepository.detectChange();
//        memberRepository.delete();
//        memberRepository.testFlush();
//        memberRepository.testDetach();
        memberRepository.testMapping();
    }
}
