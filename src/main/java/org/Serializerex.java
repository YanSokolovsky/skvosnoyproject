package main.java.org;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class Serializerex extends StdSerializer<JSONallex> {

    public Serializerex() {
        this(null);
    }

    public Serializerex(Class<JSONallex> t) {
        super(t);
    }

    @Override
    public void serialize(
            JSONallex value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.setPrettyPrinter(new DefaultPrettyPrinter());
        jgen.writeStartObject();
        jgen.writeArrayFieldStart("array");
        for (int i = 0 ; i < value.array.size(); i++) {
            jgen.writeString(value.array.get(i).getRes());
        }
        jgen.writeEndArray();
        jgen.writeEndObject();
        jgen.close();
    }
}