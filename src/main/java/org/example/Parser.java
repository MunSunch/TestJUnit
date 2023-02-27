package org.example;

import com.google.gson.Gson;

public class Parser {
    public static <T> String toJSON(T obj) {
        return new Gson().toJson(obj, obj.getClass());
    }
}
