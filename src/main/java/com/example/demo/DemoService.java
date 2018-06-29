package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {

    private final DemoConfiguration demoConfiguration;

    @Autowired
    public DemoService(final DemoConfiguration demoConfiguration) {
        this.demoConfiguration = demoConfiguration;
    }

    public List<String> getPropertyWithValuesListedInASingleLine() {
        return demoConfiguration.getPropertyWithValuesListedInASingleLine();
    }

    public List<String> getPropertyWithValuesListedInMultipleLines() {
        return demoConfiguration.getPropertyWithValuesListedInMultipleLines();
    }

    public List<String> getPropertyWithValuesListedInASingleLineInAnArray() {
        return demoConfiguration.getPropertyWithValuesListedInASingleLineInAnArray();
    }

}
