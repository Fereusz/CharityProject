package pl.coderslab.charity.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
//@ToString(exclude = {"categories", "institution", "user"})

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;
    @ManyToMany
    private List<Category> categories;
    @ManyToOne
    private Institution institution;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String zipCode;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @Column(nullable = false)
    private LocalTime pickUpTime;
    @Column(nullable = false)
    @Size(max = 200)
    private String pickUpComment;
    @ManyToOne
    private User user;
    private Boolean status = Boolean.FALSE;
    private LocalDateTime createDate = LocalDateTime.now();
}
