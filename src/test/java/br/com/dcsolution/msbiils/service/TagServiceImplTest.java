package br.com.dcsolution.msbiils.service;

import br.com.dcsolution.msbiils.TagMock;
import br.com.dcsolution.msbiils.dto.TagDto;
import br.com.dcsolution.msbiils.exception.BusinessException;
import br.com.dcsolution.msbiils.repository.TagRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TagServiceImplTest {
    @Mock
    private TagRepository tagRepository;

    @InjectMocks
    private TagServiceImpl tagService;

    @Test
    void findByIdException() {
        Mockito.when(tagRepository.findById(TagMock.ID)).thenReturn(Optional.empty());
        Assertions.assertThrows(BusinessException.class, () -> tagService.findById(TagMock.ID));
        Mockito.verify(tagRepository, Mockito.times((1))).findById(TagMock.ID);
    }

    @Test
    void findById() {
        Mockito.when(tagRepository.findById(TagMock.ID)).thenReturn(Optional.of(TagMock.fromToEntity()));
        final TagDto result = tagService.findById(TagMock.ID);
        Assertions.assertEquals(TagMock.NAME, result.getName());
        Assertions.assertEquals(TagMock.ID, result.getId());
        Mockito.verify(tagRepository, Mockito.times((1))).findById(TagMock.ID);
    }

}