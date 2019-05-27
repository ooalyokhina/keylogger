package ru.hse.spb.keylogger.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiffDto {
    private final List<ChangeDto> changes;
    private final String fileName;
    private final String projectName;
    private final Long timestamp;
    private final String action;
    private final Map<String, String> params;

    @JsonCreator
    public DiffDto(@JsonProperty("changes") @Nonnull List<ChangeDto> changes,
                   @JsonProperty("fileName") @Nonnull String fileName,
                   @JsonProperty("projectName") @Nonnull String projectName,
                   @JsonProperty("timestamp") @Nonnull Long timestamp,
                   @JsonProperty("action") String action,
                   @JsonProperty("params") Map<String, String> params) {
        this.changes = changes;
        this.fileName = fileName;
        this.projectName = projectName;
        this.timestamp = timestamp;
        this.action = action;
        this.params = params;
    }

    public List<ChangeDto> getChanges() {
        return changes;
    }

    public String getFileName() {
        return fileName;
    }

    public String getProjectName() {
        return projectName;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getAction() {
        return action;
    }

    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final DiffDto that = (DiffDto) o;
        return Objects.equals(that.changes, changes)
                && Objects.equals(that.fileName, fileName)
                && Objects.equals(that.projectName, projectName)
                && Objects.equals(that.timestamp, timestamp)
                && Objects.equals(that.action, action)
                && Objects.equals(that.params, params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changes, fileName, projectName, timestamp, action, params);
    }

    @Override
    public String toString() {
        return "ResponseDto{" + changes + ", " +
                "" + fileName + ", " + projectName + ", " +
                timestamp + ", " + action + ", " + params + '}';
    }

}
