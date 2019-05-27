package ru.hse.spb.keylogger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Change {
    private final ChangeType type;
    private final Long position;
    private final String text;

    @JsonCreator
    public Change(@JsonProperty("type") ChangeType type,
                  @JsonProperty("position") Long position,
                  @JsonProperty("text") String text) {
        this.type = type;
        this.position = position;
        this.text = text;
    }

    public ChangeType getType() {
        return type;
    }

    public Long getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Change that = (Change) o;
        return type == that.type &&
                Objects.equals(position, that.position) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, position, text);
    }

    @Override
    public String toString() {
        return "Response{" + " " + type + ", " + position + ", " + text + '}';
    }

}

