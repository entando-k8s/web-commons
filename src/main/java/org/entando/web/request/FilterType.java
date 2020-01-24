package org.entando.web.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public enum FilterType {
    STRING("string") {
        public String parseFilterValue(String value) {
            return value;
        }
    },
    DATE("date") {
        public LocalDateTime parseFilterValue(String value) {
            return LocalDateTime.parse(value);
        }
    },
    BOOLEAN("boolean") {
        public Boolean parseFilterValue(String value) {
            return Boolean.parseBoolean(value.toLowerCase());
        }
    },
    NUMBER("number") {
        public BigDecimal parseFilterValue(String value) {
            return new BigDecimal(Double.parseDouble(value));
        }
    };

    private final String value;

    private FilterType(String value) {
        this.value = value;
    }

    public static FilterType parse(String type) {
        final FilterType[] values = values();
        for (FilterType value : values) {
            if (value.getValue().equals(type)) {
                return value;
            }
        }
        throw new IllegalArgumentException(type + " is not a supported filter type");
    }

    public String getValue() {
        return this.value;
    }

    public abstract Object parseFilterValue(String var1);
}