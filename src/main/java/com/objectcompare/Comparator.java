package com.objectcompare;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class Comparator {

    public String compare(Object obj1, Object obj2) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode obj1Json = mapper.valueToTree(obj1);
        JsonNode obj2Json = mapper.valueToTree(obj2);

        if (obj1Json.equals(obj2Json)) return "";

        StringBuilder strBldr = new StringBuilder();
        findMismatches(obj1Json, obj2Json, strBldr, "");
        return strBldr.toString();
    }

    private void findMismatches(JsonNode obj1Json, JsonNode obj2Json, StringBuilder strBldr, String name) {
        if (obj1Json.isValueNode()) {
            String obj1Value = obj1Json.asText();
            String obj2Value = obj2Json.asText();

            if (!obj1Value.equals(obj2Value)) {
                strBldr.append(String.format("%s=obj1:%s, obj2:%s\n", name, obj1Value, obj2Value));
            }
        }

        else if (obj1Json.isArray()) {
            int len = obj1Json.size();

            for (int i = 0; i < len; i++) {
                if (obj1Json.get(i).isValueNode()) {
                    findMismatches(obj1Json.get(i), obj2Json.get(i), strBldr, name);
                }
                else {
                    parseJson(obj1Json.get(i), obj2Json.get(i), strBldr);
                }
            }
        }

        else if (obj1Json.isObject()) {
            parseJson(obj1Json, obj2Json, strBldr);
        }
    }

    private void parseJson(JsonNode obj1Json, JsonNode obj2Json, StringBuilder strBldr) {
        Iterator<Map.Entry<String, JsonNode>> fields = obj1Json.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> obj1Field = fields.next();
            String fieldName = obj1Field.getKey();
            JsonNode obj1Value = obj1Field.getValue();
            JsonNode obj2Value = obj2Json.findValue(fieldName);
            findMismatches(obj1Value, obj2Value, strBldr, fieldName);
        }
    }
}
