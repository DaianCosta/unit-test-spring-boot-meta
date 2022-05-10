package br.com.dcsolution.msbiils.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BusinessExceptionTest {

    @Test
    void exceptionTest(){
        final BusinessException businessException = new BusinessException("Error");
        Assertions.assertEquals("Error", businessException.getMessage());
    }

    @Test
    void exceptionNotEqualsTest(){
        final BusinessException businessException = new BusinessException("Error2");
        Assertions.assertNotEquals("Error", businessException.getMessage());
    }
}