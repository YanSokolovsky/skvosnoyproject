package main.java.org;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class Serializer extends StdSerializer<JSONallex> {

    public Serializer() {
        this(null);
    }

    public Serializer(Class<JSONallex> t) {
        super(t);
    }

    @Override
    public void serialize(
            JSONallex value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        String[] arr = new String[value.array.size()];
        for (int i = 0; i < value.array.size(); i++)
        {
            String serialized = value.array.get(i).getRes();
            arr[i] = serialized;
        }
        jgen.writeStartArray("array", value.array.size());
        for (int i = 0 ; i < value.array.size(); i++)
        {
            jgen.writeString(arr[i]);
        }
        jgen.writeEndArray();
        jgen.close();
    }
}