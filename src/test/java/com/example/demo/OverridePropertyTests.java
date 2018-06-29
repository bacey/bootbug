package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE
        , properties = {
                "propertyWithValuesListedInASingleLine=inline overriding value1a, inline overriding value2a, inline overriding value3a",
                "propertyWithValuesListedInMultipleLines=inline overriding value1b, inline overriding value2b, inline overriding value3b",
                "propertyWithValuesListedInASingleLineInAnArray=inline overriding value1c, inline overriding value2c, inline overriding value3c"
        }
)
@ActiveProfiles(profiles = "test")
public class OverridePropertyTests {

    @Autowired
    public DemoService demoService;

    @Test
    public void canOverrideAPropertyWithValuesListedInASingleLine() {
        assertThat(demoService.getPropertyWithValuesListedInASingleLine())
                .hasSize(3)
                .containsExactly("inline overriding value1a", "inline overriding value2a", "inline overriding value3a");
    }

    @Test
    public void canOverrideAPropertyWithValuesListedInMultipleLines() {
        assertThat(demoService.getPropertyWithValuesListedInMultipleLines())
                .hasSize(3)
                .containsExactly("inline overriding value1b", "inline overriding value2b", "inline overriding value3b");
    }

    @Test
    public void canOverrideAPropertyWithValuesListedInASingleLineInAnArray() {
        assertThat(demoService.getPropertyWithValuesListedInASingleLineInAnArray())
                .hasSize(3)
                .containsExactly("inline overriding value1c", "inline overriding value2c", "inline overriding value3c");
    }
}
