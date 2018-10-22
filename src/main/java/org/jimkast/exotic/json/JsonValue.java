package org.jimkast.exotic.json;

import org.jimkast.exotic.binary.binary;
import org.jimkast.exotic.number.types.array;

public interface JsonValue {
    binary asBinary();

    JsonObject asObject();

    array<JsonValue> asArray();
}
