package org.bluebridge.lang3;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TemplateLiteralsTest {

    @Test
    public void testTemplateLiterals() {
        Map<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("name", "Alice");
        valuesMap.put("age", 30);
        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        String greeting = sub.replace("Hello, ${name}! You are ${age} years old.");
        System.out.println(greeting);
    }

}
