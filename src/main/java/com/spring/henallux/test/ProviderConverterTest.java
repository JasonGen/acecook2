package com.spring.henallux.test;

import com.spring.henallux.dataAccess.Entity.LangueEntity;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProviderConverterTest {
    private ProviderConverter providerConverter;

    @Before
    public void setUp() throws Exception {
        providerConverter = new ProviderConverter();

    }

    @Test
    public void langueModelToEntity() throws Exception {


        LangueEntity langueEntity = new LangueEntity();
        langueEntity.setCodeLangue("Ru");
        langueEntity.setNomLangue("Russe");

        assertNotEquals("Nl", langueEntity.getCodeLangue());
        assertEquals("Russe", langueEntity.getNomLangue());

        //assertNull(langueEntity);

    }
}