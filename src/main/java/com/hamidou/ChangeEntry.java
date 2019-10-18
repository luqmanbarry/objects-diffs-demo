package com.hamidou;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.StringJoiner;

public class ChangeEntry implements Serializable {
    private static final long serialVersionUID = 2802826128753977374L;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String entityType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String entityKey;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String oldValue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String newValue;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fieldName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String changeType;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityKey() {
        return entityKey;
    }

    public void setEntityKey(String entityKey) {
        this.entityKey = entityKey;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChangeEntry.class.getSimpleName() + "[", "]")
                .add("entityType='" + entityType + "'")
                .add("entityKey='" + entityKey + "'")
                .add("oldValue='" + oldValue + "'")
                .add("newValue='" + newValue + "'")
                .add("fieldName='" + fieldName + "'")
                .add("description='" + description + "'")
                .add("changeType='" + changeType + "'")
                .toString();
    }
}
