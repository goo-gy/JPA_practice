package practice.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class Member {
    @Id
    private Long id;

    @Column(unique = true, length = 10)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate createLocalDate;
    private LocalDateTime createLocalDateTime;

    @Lob

    public Long getId() {
        return id;
    }

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member(Long id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
