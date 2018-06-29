package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles(profiles = "test")
public class ReadPropertyTests {

    @Autowired
    public DemoService demoService;

    @Test
    public void canReadAPropertyWithValuesListedInASingleLine() {
        assertThat(demoService.getPropertyWithValuesListedInASingleLine())
                .hasSize(3)
                .containsExactly("val1a from test/r/app.yml", "val2a from test/r/app.yml", "val3a from test/r/app.yml");
    }

    @Test
    public void canReadAPropertyWithValuesListedInMultipleLines() {
        assertThat(demoService.getPropertyWithValuesListedInMultipleLines())
                .hasSize(3)
                .containsExactly("val1b from test/r/app.yml", "val2b from test/r/app.yml", "val3b from test/r/app.yml");
    }

    @Test
    public void canReadAPropertyWithValuesListedInASingleLineInAnArray() {
        assertThat(demoService.getPropertyWithValuesListedInASingleLineInAnArray())
                .hasSize(3)
                .containsExactly("val1c from test/r/app.yml", "val2c from test/r/app.yml", "val3c from test/r/app.yml");
    }
}
