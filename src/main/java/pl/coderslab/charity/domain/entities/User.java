package pl.coderslab.charity.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"password", "donations"})

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private Boolean active = Boolean.FALSE;
    @OneToMany(mappedBy = "user")
    private List<Donation> donations = new ArrayList<>();
    @ManyToMany
    private Set<Role> roles = new HashSet<>();

//    @Column(name = "enabled")
//    private boolean enabled;

//    public User() {
//        super();
//        this.enabled=false;
//    }


}
