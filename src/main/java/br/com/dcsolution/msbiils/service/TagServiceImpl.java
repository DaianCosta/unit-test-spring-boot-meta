package br.com.dcsolution.msbiils.service;

import br.com.dcsolution.msbiils.dto.TagDto;
import br.com.dcsolution.msbiils.entity.Tag;
import br.com.dcsolution.msbiils.exception.BusinessException;
import br.com.dcsolution.msbiils.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public TagDto findById(final Integer id) {

        final Tag tag = tagRepository
                .findById(id).orElseThrow(() -> new BusinessException("Registro não encontrado"));

        return TagDto.fromToDto(tag);
    }
}
