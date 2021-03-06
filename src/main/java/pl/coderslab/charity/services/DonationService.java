package pl.coderslab.charity.services;

import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.dtos.DonationDTO;

import java.security.Principal;
import java.util.List;

public interface DonationService {

    void makeDonation(DonationDTO donationDTO); // tutaj popraw tak aby pobieralo id zalogowanego usera

    Long sumOfDonatedInstitutions();
    Long sumOfBags ();

    List<Donation> getAllDonationsForLoggedUser (Principal principal);

    void deleteDonationForLoggedUser(Long id);

    DonationDTO updateDonationForLoggedUser(Long id);
}
