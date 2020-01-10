package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.repositories.DonationRepository;
import pl.coderslab.charity.domain.repositories.UserRepository;
import pl.coderslab.charity.dtos.DonationDTO;
import pl.coderslab.charity.services.DonationService;

import java.security.Principal;
import java.util.List;

@Transactional
@Service
public class DefaultDonationService implements DonationService {

    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    public DefaultDonationService(DonationRepository donationRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
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

    @Override
    public List<Donation> getAllDonationsForLoggedUser(Principal principal) {
        return donationRepository.findAllByUserOrderByStatusDescPickUpDateAscCreateDateAsc
                (userRepository.findByUsername(principal.getName()));
    }
}
