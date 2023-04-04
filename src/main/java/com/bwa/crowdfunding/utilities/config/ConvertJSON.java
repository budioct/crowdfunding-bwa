package com.bwa.crowdfunding.utilities.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class ConvertJSON {

    private static volatile ObjectMapper ourObjectMapper;

    private static final Object mutex = new Object();

    static {
        try {
            ObjectMapper instance = ourObjectMapper;

            if (instance == null) {
                synchronized (mutex) {
                    instance = ourObjectMapper;

                    if (instance == null) {
                        ourObjectMapper = instance = new ObjectMapper().registerModule(new JavaTimeModule());
                        instance.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                    }
                }
            }
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }

    }

    // access singleton
    public static final ObjectMapper getObjectMapper() {
        return ourObjectMapper;
    }

}
