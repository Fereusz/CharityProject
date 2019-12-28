package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.repositories.DonationRepository;
import pl.coderslab.charity.dtos.DonationDTO;
import pl.coderslab.charity.services.DonationService;

@Transactional
@Service
public class DefaultDonationService implements DonationService {

    private final DonationRepository donationRepository;

    public DefaultDonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public void makeDonation(DonationDTO donationDTO) {
        ModelMapper mapper = new ModelMapper();
        Donation newDonation = mapper.map(donationDTO, Donation.class);
        donationRepository.save(newDonation);

    }

    @Override
    public Long sumOfDonatedInstitutions() {
        return donationRepository.sumOfInstitutionsDonated();
    }

    @Override
    public Long sumOfBags() {
        return donationRepository.sumOfGivenBags();
    }
}
