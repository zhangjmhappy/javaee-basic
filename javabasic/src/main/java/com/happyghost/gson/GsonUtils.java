package com.happyghost.gson;

import com.google.gson.Gson;

import java.io.Reader;
import java.lang.reflect.Type;

public class GsonUtils {

    public static <T> Result<T> fromJsonObject(Reader reader, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(Result.class, new Class[]{clazz});
        return new Gson().fromJson(reader, type);

    }
}
