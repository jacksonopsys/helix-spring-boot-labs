package com.hlx.posterm;

import com.hlx.posterm.dto.ChipInfo;
import com.hlx.posterm.dto.ValidationPredilection;
import com.hlx.posterm.dto.ValidationStatus;
import com.hlx.posterm.service.PrevalidationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrevalidationServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(PrevalidationServiceTest.class);

    private ApplicationContext ctxt;
    private PrevalidationService svc;

    @BeforeEach
    public void setUp() {
        ctxt = new AnnotationConfigApplicationContext(Application.class);
        svc = (PrevalidationService) ctxt.getBean("prevalidationService");
        LOG.debug("in setup");
    }

    @AfterEach
    public void tearDown() {
        LOG.debug("in tearDown");
        ((AbstractApplicationContext)ctxt).close();
    }

    @Test
    public void canPassGoodCardNo() {
        LOG.debug("in canPassGoodCardNo");
        ChipInfo chipData = new ChipInfo("Lucy","4123","1111", ValidationPredilection.NONE);
        ValidationStatus status = svc.validate(chipData);
        assertEquals(status.getStatus(),"valid");
    }
}
