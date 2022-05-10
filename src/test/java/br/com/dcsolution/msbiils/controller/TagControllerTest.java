package br.com.dcsolution.msbiils.controller;

import br.com.dcsolution.msbiils.dto.TagDto;
import br.com.dcsolution.msbiils.entity.Tag;
import br.com.dcsolution.msbiils.repository.TagRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TagControllerTest {

    private String URL_BASE;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    TagRepository tagRepository;

    // bind the above RANDOM_PORT
    @LocalServerPort
    int port;

    @BeforeEach
    public void init() throws MalformedURLException {
        generateTags();
        URL_BASE = new URL("http://localhost:" + port + "/tag").toString();
    }

    @Test
    void get() {
        final ResponseEntity<TagDto> response = restTemplate.getForEntity(URL_BASE + "/1", TagDto.class);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(1, Objects.requireNonNull(response.getBody()).getId());
    }

    @Test
    void findByIdBadRequest() throws JsonProcessingException {

        final ResponseEntity<String> response = restTemplate.getForEntity(URL_BASE + "/999", String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode message = root.path("message");

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

        Assertions.assertEquals("Registro não encontrado", message.asText());
    }

    private void generateTags() {
        final List<Tag> tags = new ArrayList<>();
        tags.add(createTag(1, "meu"));
        tags.add(createTag(2, "mae"));

        tagRepository.saveAll(tags);
    }

    private Tag createTag(final Integer id, final String name) {
        final Tag tag = new Tag();
        tag.setId(id);
        tag.setName(name);

        return tag;
    }
}