package org.example.json;

public class SuccessConditionDeserializer {
    private String type;

    public SuccessConditionDeserializer(String type) {
        this.type = type;
    }

    public SuccessConditionDeserializer() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
