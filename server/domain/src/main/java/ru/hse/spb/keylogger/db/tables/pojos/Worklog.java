/*
 * This file is generated by jOOQ.
 */
package ru.hse.spb.keylogger.db.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Worklog implements Serializable {

    private static final long serialVersionUID = -1607789014;

    private Long   id;
    private String changes;
    private String fileName;
    private String projectName;
    private Long   timestamp;
    private String action;
    private String params;
    private Long   workerId;

    public Worklog() {}

    public Worklog(Worklog value) {
        this.id = value.id;
        this.changes = value.changes;
        this.fileName = value.fileName;
        this.projectName = value.projectName;
        this.timestamp = value.timestamp;
        this.action = value.action;
        this.params = value.params;
        this.workerId = value.workerId;
    }

    public Worklog(
        Long   id,
        String changes,
        String fileName,
        String projectName,
        Long   timestamp,
        String action,
        String params,
        Long   workerId
    ) {
        this.id = id;
        this.changes = changes;
        this.fileName = fileName;
        this.projectName = projectName;
        this.timestamp = timestamp;
        this.action = action;
        this.params = params;
        this.workerId = workerId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChanges() {
        return this.changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Worklog (");

        sb.append(id);
        sb.append(", ").append(changes);
        sb.append(", ").append(fileName);
        sb.append(", ").append(projectName);
        sb.append(", ").append(timestamp);
        sb.append(", ").append(action);
        sb.append(", ").append(params);
        sb.append(", ").append(workerId);

        sb.append(")");
        return sb.toString();
    }
}
