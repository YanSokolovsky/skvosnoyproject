package main.java.org;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class xmlserialiser extends StdSerializer<ex> {

    public xmlserialiser() {
        this(null);
    }

    public xmlserialiser(Class<ex> t) {
        super(t);
    }

    @Override
    public void serialize(
            ex value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeFieldName("expre");
        gen.writeStartObject();
        gen.writeArrayFieldStart("one");
        for (int i = 0 ; i < value.expre.size(); i++) {
            gen.writeStartObject();
            gen.writeStringField("on", value.expre.get(i).on);
            gen.writeEndObject();
        }
        gen.writeEndArray();
        gen.writeEndObject();
        gen.writeEndObject();
    }
}