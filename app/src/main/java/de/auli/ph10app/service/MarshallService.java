package de.auli.ph10app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import de.auli.ph10app.model.Model;
import de.auli.ph10app.model.PlayerGroup;

public class MarshallService<T> {
    ObjectMapper mapper = new ObjectMapper();

    public MarshallService() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
    }

    public List<T> marshall(Object object, Class<? extends Model> clazz) throws IOException {
        List<T> modelList = mapper.readValue((String) object, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        return modelList;
    }

    public String unmarshall(T model) throws JsonProcessingException {
        return mapper.writeValueAsString(model);
    }
}
