package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Donation;
import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.domain.entities.User;
import pl.coderslab.charity.domain.repositories.DonationRepository;
import pl.coderslab.charity.domain.repositories.UserRepository;
import pl.coderslab.charity.dtos.DonationDTO;
import pl.coderslab.charity.dtos.InstitutionDTO;
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
        User user = userRepository.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Donation newDonation = mapper.map(donationDTO, Donation.class);
        newDonation.setUser(user);
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

    @Override
    public void deleteDonationForLoggedUser(Long id) {
        Donation donation = donationRepository.findById(id).get();
        donationRepository.delete(donation);

    }

    @Override
    public DonationDTO updateDonationForLoggedUser(Long id) {
        ModelMapper mapper = new ModelMapper();
        Donation donation = donationRepository.findById(id).get();
        return mapper.map(donation, DonationDTO.class);
    }
}
