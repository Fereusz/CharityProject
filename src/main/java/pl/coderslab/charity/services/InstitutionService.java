package pl.coderslab.charity.services;

import pl.coderslab.charity.dtos.InstitutionDTO;

import java.util.List;

public interface InstitutionService {

    List<InstitutionDTO> findAllInstitutions();
}
