package ru.hse.spb.keylogger.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeDto {
    private final ChangeTypeDto type;
    private final Long position;
    private final String text;

    @JsonCreator
    public ChangeDto(@JsonProperty("type") @Nonnull ChangeTypeDto type,
                     @JsonProperty("position") @Nonnull Long position,
                     @JsonProperty("text") String text) {
        this.type = type;
        this.position = position;
        this.text = text;
    }

    public ChangeTypeDto getType() {
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
        final ChangeDto that = (ChangeDto) o;
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
        return "ResponseDto{" + " " + type + ", " + position + ", " + text + '}';
    }

}
