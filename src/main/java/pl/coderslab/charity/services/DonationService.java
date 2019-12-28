package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.DonationDTO;

public interface DonationService {

    void makeDonation(DonationDTO donationDTO);

    Long sumOfDonatedInstitutions();
    Long sumOfBags ();
}
