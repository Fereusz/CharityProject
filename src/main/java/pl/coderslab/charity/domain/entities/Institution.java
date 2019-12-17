package pl.coderslab.charity.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString(exclude = {"donations"}) @EqualsAndHashCode(of="id")

@Entity
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)@Size(max = 500)
    private String description;
    @OneToMany(mappedBy = "institution")
    private List<Donation> donations =new ArrayList<>();
}
