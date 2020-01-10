package pl.coderslab.charity.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.entities.User;

import java.util.List;


public interface DonationRepository extends JpaRepository<Donation, Long> {


    @Query(value = "select sum (quantity)from Donation ")
    Long sumOfGivenBags ();


    @Query(value = "select count (distinct institution) from Donation ")
    Long sumOfInstitutionsDonated();

    List<Donation>findAllByUserOrderByStatusDescPickUpDateAscCreateDateAsc(User user);

//    Czy dary na liście są posortowane wg: 1) statusu odebrane/nieodebrane,
//            2) daty odebrania (jeśli odebrane) i 3) daty utworzenia wpisu?
//

}
