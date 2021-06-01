package pl.sii.it_conference.service;

import pl.sii.it_conference.dto.PrelectionDto;
import pl.sii.it_conference.dto.PrelectionVO;
import pl.sii.it_conference.entity.Prelection;

import java.util.List;

public interface PrelectionService {

    List<PrelectionVO> getAllPrelections();

    PrelectionDto addUserToPrelection(Long id);

    boolean checkIfPrelectionIsNotFull(Prelection prelection);
}