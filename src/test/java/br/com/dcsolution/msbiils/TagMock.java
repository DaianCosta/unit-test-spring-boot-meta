package br.com.dcsolution.msbiils;

import br.com.dcsolution.msbiils.dto.TagDto;
import br.com.dcsolution.msbiils.entity.Tag;

public class TagMock {

    public static final Integer ID = 1;
    public static final String NAME = "contas-mae";

    public static Tag fromToEntity() {
        final Tag tag = new Tag();
        tag.setId(ID);
        tag.setName(NAME);

        return tag;
    }

    public static TagDto fromToDto() {
        final TagDto tagDto = new TagDto();
        tagDto.setId(ID);
        tagDto.setName(NAME);

        return tagDto;
    }
}
