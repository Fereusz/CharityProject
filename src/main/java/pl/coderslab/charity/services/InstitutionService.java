package pl.coderslab.charity.services;

import pl.coderslab.charity.domain.entities.Institution;
import pl.coderslab.charity.dtos.InstitutionDTO;

import java.util.List;

public interface InstitutionService {

    List<InstitutionDTO> findAllInstitutions();
    void deleteInstitution (InstitutionDTO institutionDTO, Long id);
    void saveInstitution (InstitutionDTO institutionDTO);
    InstitutionDTO  prepareUpdate(Long id);
}

