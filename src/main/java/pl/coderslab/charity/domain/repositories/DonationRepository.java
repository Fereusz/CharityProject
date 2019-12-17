package pl.coderslab.charity.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.domain.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

   // Long countByQuantityExists();

    @Query(value = "select sum (quantity)from Donation ")
    Long sumOfBags ();

//    Long countAllByInstitutionId();

//    @Query(value = "select count (institution_id) from donations",nativeQuery = true)
//    Long numberOfInstitutions();

    @Query(value = "select count (institution) from Donation ")
    Long sumOfDonatedInstitutions();


}
