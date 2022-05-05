package com.techOne.api.converter;

import com.techOne.api.converter.config.JerseyConfig;
import com.techOne.api.converter.controller.ConverterController;
import com.techOne.api.converter.models.ConverterRequest;
import com.techOne.api.converter.models.ConverterResponse;
import jdk.dynalink.linker.support.Guards;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for the converter controller.
 */
@SpringBootTest
class ConverterControllerTest
{
    @Autowired
    private ConverterController controller;

    /**
     * Tests that we can succesfully convert the provided number to the word values.
     */
    @Test
    void convertSuccess()
    {
        final ConverterRequest request = new ConverterRequest();
        request.setNumber(12345.54);

        final Response response = controller.converter(request);
        final ConverterResponse converterResponse = (ConverterResponse) response.getEntity();

        assertThat(response.getStatus(), equalTo(200));
        assertThat(converterResponse.getWords(), equalTo( "TWELVE THOUSAND THREE HUNDRED AND FOURTY-FIVE DOLLARS AND FIFTY-FOUR CENTS"));
    }
}
