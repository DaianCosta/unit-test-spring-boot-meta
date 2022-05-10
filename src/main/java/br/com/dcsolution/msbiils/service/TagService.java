package br.com.dcsolution.msbiils.service;

import br.com.dcsolution.msbiils.dto.TagDto;

public interface TagService {

    TagDto findById(final Integer id);
}
