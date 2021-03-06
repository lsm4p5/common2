package com.lguplus.common.domain.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@ToString( of = {"id","loginname","username","age","homeAddress"})
@Table(uniqueConstraints={@UniqueConstraint(name="LOGIN_NAME_AGE_UNIQUE",columnNames = {"LOGINNAME","USERNAME","AGE"})})
@NamedQuery(
        name="Member.findByUsername",
        query = "select m from Member m where m.username =:username")
public class Member extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long id;

    @NotEmpty
    private String loginname;
    private String username;
    private String password;
    private Integer age;

    //주소
    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city",column = @Column(name="WORK_CITY")),
            @AttributeOverride(name="street",column = @Column(name="WORK_STREET")),
            @AttributeOverride(name="zipcode",column = @Column(name="WORK_ZIPCODE"))
    })
    private Address workAddress;

    //Period
    @Embedded
    private Period workPeriod;

    @Enumerated(EnumType.STRING)
    private RolType roleType;

   @Lob
   private String description;

  //특정 필드를 컬럼에 매핑하지 않음(매핑 무시) - 테이블에 생성되지 않음.
   @Transient
   int tempVariable;

   @ElementCollection
   @CollectionTable(name ="FAVORITE_FODD",joinColumns = @JoinColumn(name="MEMBER_ID"))
   @Column(name="FOOD_NAME")
   private Set<String> favoriteFoods = new HashSet<>();

   // 컬렉션 값 Type은 사용하지 말고, 값 Type을 Entity로 만들어서 OneToMany, ManyToOne으로 사용해야 한다.
    // 추적할 필요없고 값이 바뀌어도 문제가 없을때에 대해서는 사용할수도 있을듯.
//   @ElementCollection
//   @CollectionTable(name ="ADDRESS",joinColumns = @JoinColumn(name="MEMBER_ID"))
//   private List<Address> addressHistory = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

   // BasicEntity에 포함했고, Date를 Colum으로 사용하는 예시임. 과거의 Date때문...ㅎㅎ
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime createdDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_ID")
    private Team team;

    /**
     * 연관관계 편의 메서드는 연관관계 주인이든, 주인이 아이어든 양쪽으로 변경을 해주어야 하고,
     * 연관관계 메서드는 한쪽에만 두어야 한다, 양쪽에 있으면 무한루프를 돌수 있다.
     * 또한 toString을 객체에 줄 경우 무한 루프에 빠지는 겅을 조심해야 한다. (양쪽에 toString이 되는 경우)
     * JSON 생성라이브러리를 만들때도 동일하게 무한루프가 될수 있다.
     * Controller에는 Entity를 절대 반환하지 않아야 한다.
     */
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        this.team = team;
        if (team != null) {
            changeTeam(team);
        }
    }

    public Member(String loginname, String username, String password, int age,Team team) {
        this.loginname = loginname;
        this.username = username;
        this.password = password;
        this.age = age;
        if(team != null) {
            changeTeam(team);
        }
    }



}
