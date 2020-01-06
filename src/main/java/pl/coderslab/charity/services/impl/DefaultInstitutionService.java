package pl.coderslab.charity.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.domain.repositories.InstitutionRepository;
import pl.coderslab.charity.dtos.InstitutionDTO;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service

public class DefaultInstitutionService implements InstitutionService {

    private final InstitutionRepository institutionRepository;


    public DefaultInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;

    }

    @Override
    public List<InstitutionDTO> findAllInstitutions() {
        ModelMapper mapper = new ModelMapper();
        return institutionRepository.findAll().stream()
                .map(i -> mapper.map(i, InstitutionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addInstitution(InstitutionDTO institutionDTO) {
        ModelMapper mapper = new ModelMapper();
        Institution newInstitution = mapper.map(institutionDTO, Institution.class);
        institutionRepository.save(newInstitution);

    }

    @Override
    public void deleteInstitution(InstitutionDTO institutionDTO, Long id) {
        Institution institution = institutionRepository.findById(id).get();
        institutionRepository.delete(institution);
    }


    @Override
    public InstitutionDTO prepareUpdate(Long id) {
        Institution institution = institutionRepository.findById(id).get();
        ModelMapper mapper = new ModelMapper();
        return mapper.map(institution, InstitutionDTO.class);


    }


}



