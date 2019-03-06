import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public class WifeSerialise implements JsonSerializer<Wife> {

    @Override
    public JsonElement serialize(Wife wife, Type type, JsonSerializationContext jsonSerializationContext) {
        List<String> list = new LinkedList<String>();

        return new JsonPrimitive(wife.name + " " + wife.age);
    }
}
