package filemanagement.writers;

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
        jgen.writeStartArray();
        for (int i = 0 ; i < value.array.size(); i++) {
            jgen.writeStartObject();
            jgen.writeStringField("ex", value.array.get(i).getRes());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
        jgen.close();
    }
}