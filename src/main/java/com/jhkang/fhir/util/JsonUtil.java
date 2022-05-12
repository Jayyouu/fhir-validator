package com.jhkang.fhir.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class JsonUtil {

    private JsonUtil() {
    }

    public static JsonObject readFileToObject(String filePath) {

        try {
            Reader reader = new FileReader(filePath);
            Gson gson = new Gson();
            return gson.fromJson(reader, JsonObject.class);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return new JsonObject();
    }

    public static String readObjectToString(JsonObject jsonObject) {
        return jsonObject.toString();
    }
}
