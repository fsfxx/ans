package com.p.ans;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Xunxiao Ren on 2017/10/21.
 * 将Date转换为Unix时间
 */

@JsonComponent
public class DateUnixTimeSerializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
            gen.writeNumber(value.getTime() / 1000);
        }
}
