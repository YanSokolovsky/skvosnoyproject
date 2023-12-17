package filemanagement.writers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class Serializer extends StdSerializer<JSONoutput> {

    public Serializer() {
        this(null);
    }

    public Serializer(Class<JSONoutput> t) {
        super(t);
    }

    @Override
    public void serialize(
            JSONoutput value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.setPrettyPrinter(new DefaultPrettyPrinter());
        jgen.writeStartObject();
        jgen.writeStringField("res", value.getRes());
        jgen.writeEndObject();
        jgen.close();
    }
}