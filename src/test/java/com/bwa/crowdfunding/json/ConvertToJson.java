package com.bwa.crowdfunding.json;

import com.bwa.crowdfunding.entity.Users;
import com.bwa.crowdfunding.utilities.config.ConvertJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Slf4j
public class ConvertToJson {

    private ObjectMapper mapper;

    @Test
    void testConvertToJson() throws JsonProcessingException {

        mapper = ConvertJSON.getObjectMapper(); // singleton

        Users dika = Users.builder()
                .name("dika")
                .role("user")
                .email("dika@gmail.com")
                .occupation("magang")
                .create_at(LocalDateTime.now(ZoneId.of("Asia/Jakarta")))
                .build();

        String json = mapper.writeValueAsString(dika);

        log.info("json: {}", json);

        /**
         * 10:48:31.984 [main] INFO com.bwa.crowdfunding.json.ConvertToJson - json: {"iduser":0,"name":"dika","occupation":"magang","email":"dika@gmail.com","passwordhash":null,"avatarfilename":null,"role":"user","token":null,"create_at":"2023-04-04T10:48:31.855588","update_at":null,"campaignList":null,"transactionList":null}
         */
    }

}
