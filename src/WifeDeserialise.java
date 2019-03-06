import com.google.gson.*;

import java.lang.reflect.Type;

public class WifeDeserialise implements JsonSerializer<Wife> {

    @Override
    public JsonElement serialize(Wife wife, Type type, JsonSerializationContext jsonSerializationContext) {
        if (wife == null)
            return new JsonPrimitive("");
        else
            return new JsonPrimitive(new StringBuilder().append(wife.name).append(" ").append(wife.age).toString());
    }
}
