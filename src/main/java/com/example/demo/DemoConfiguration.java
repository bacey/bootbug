package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties
public class DemoConfiguration {

    private List<String> propertyWithValuesListedInASingleLine = new ArrayList<>();

    private List<String> propertyWithValuesListedInMultipleLines = new ArrayList<>();

    private List<String> propertyWithValuesListedInASingleLineInAnArray = new ArrayList<>();

    public List<String> getPropertyWithValuesListedInASingleLine() {
        return propertyWithValuesListedInASingleLine;
    }

    public void setPropertyWithValuesListedInASingleLine(final List<String> propertyWithValuesListedInASingleLine) {
        this.propertyWithValuesListedInASingleLine = propertyWithValuesListedInASingleLine;
    }

    public List<String> getPropertyWithValuesListedInMultipleLines() {
        return propertyWithValuesListedInMultipleLines;
    }

    public void setPropertyWithValuesListedInMultipleLines(final List<String> propertyWithValuesListedInMultipleLines) {
        this.propertyWithValuesListedInMultipleLines = propertyWithValuesListedInMultipleLines;
    }

    public List<String> getPropertyWithValuesListedInASingleLineInAnArray() {
        return propertyWithValuesListedInASingleLineInAnArray;
    }

    public void setPropertyWithValuesListedInASingleLineInAnArray(final List<String> propertyWithValuesListedInASingleLineInAnArray) {
        this.propertyWithValuesListedInASingleLineInAnArray = propertyWithValuesListedInASingleLineInAnArray;
    }

}
