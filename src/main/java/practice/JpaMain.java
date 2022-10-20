package practice;

import practice.repository.MemberRepository;

public class JpaMain {
    public static void main(String[] args) {
        MemberRepository memberRepository = new MemberRepository();
        memberRepository.testAllocationSize();
    }
}
