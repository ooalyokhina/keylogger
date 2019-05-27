package ru.hse.spb.keylogger.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    private final ResponseStatusDto status;
    private final String description;
    private final String entityId;

    @JsonCreator
    public ResponseDto(@JsonProperty("status") ResponseStatusDto status,
                       @JsonProperty("description") String description,
                       @JsonProperty("entityId") String entityId) {
        this.status = status;
        this.description = description;
        this.entityId = entityId;
    }

    public ResponseStatusDto getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getEntityId() {
        return entityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ResponseDto that = (ResponseDto) o;
        return status == that.status &&
                Objects.equals(description, that.description) &&
                Objects.equals(entityId, that.entityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, description, entityId);
    }

    @Override
    public String toString() {
        return "ResponseDto{" + " " + status + ", " + description + ", " + entityId + '}';
    }
}
