package org.entando.web.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BaseMapModel {

    @JsonAnySetter
    protected Map<String, Object> data = new HashMap<>();

    public BaseMapModel(Map<String, Object> map) {
        data = map == null ? new HashMap<>() : new HashMap<>(map);
    }

    @JsonAnyGetter
    public Map<String, Object> getData() {
        return data;
    }

    public void putAll(Map<String, Object> map) {
        data.putAll(map);
    }
}
