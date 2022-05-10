package br.com.dcsolution.msbiils.dto;

import br.com.dcsolution.msbiils.entity.Tag;

import java.io.Serializable;

public class TagDto implements Serializable {

    private Integer id = 0;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static TagDto fromToDto(final Tag tag) {

        final TagDto tagDto = new TagDto();
        tagDto.setId(tag.getId());
        tagDto.setName(tag.getName());

        return tagDto;
    }

}
