package org.entando.web.response;

import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestResponse<T, M> {

    private T payload;
    private M metadata;
    private List<RestError> errors = new ArrayList<>();

    public RestResponse(final T payload) {
        setPayload(payload);
    }

    public RestResponse(final T payload, final M metadata) {
        setPayload(payload);
        setMetaData(metadata);
    }

    public RestResponse(final T payload, final M metadata, final List<RestError> errors) {
        this(payload, metadata);
        setErrors(errors);
    }

    @JsonSetter("metaData")
    public void setMetaData(M metadata) {
        this.metadata = metadata;
    }

    @JsonSetter("metadata")
    public void setMetadata(M metadata) {
        this.metadata = metadata;
    }

    public void addError(final RestError error) {
        errors.add(error);
    }

}
