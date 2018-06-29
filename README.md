Spring Boot (version 1.5.x and 2.1.x) can read properties (or more specifically, a list of property values) without problems:

```
propertyWithValuesListedInASingleLine: val1a from test/r/app.yml, val2a from test/r/app.yml, val3a from test/r/app.yml

propertyWithValuesListedInMultipleLines:
    - val1b from test/r/app.yml
    - val2b from test/r/app.yml
    - val3b from test/r/app.yml

propertyWithValuesListedInASingleLineInAnArray: [val1c from test/r/app.yml, val2c from test/r/app.yml, val3c from test/r/app.yml]
```

Spring Boot can override properties using this syntax:

```java
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE
        , properties = {
                "propertyWithValuesListedInASingleLine=inline overriding value1a, inline overriding value2a, inline overriding value3a",
                "propertyWithValuesListedInMultipleLines=inline overriding value1b, inline overriding value2b, inline overriding value3b",
                "propertyWithValuesListedInASingleLineInAnArray=inline overriding value1c, inline overriding value2c, inline overriding value3c"
        }
)
```

Unfortunately, Spring Boot version 1.5.x can only override such a property which is defined in one single line and without brackets:


```
propertyWithValuesListedInASingleLine: val1a from test/r/app.yml, val2a from test/r/app.yml, val3a from test/r/app.yml
```

But it cannot override these (although it can read them without a problem):

```
propertyWithValuesListedInMultipleLines:
    - val1b from test/r/app.yml
    - val2b from test/r/app.yml
    - val3b from test/r/app.yml

propertyWithValuesListedInASingleLineInAnArray: [val1c from test/r/app.yml, val2c from test/r/app.yml, val3c from test/r/app.yml]
```

To see the failing tests, run the following commands:

The 1.5.x versions are affected by the bug:

```bash
ln -sf pom-1.5.14-RELEASE.xml pom.xml && ./mvnw clean test

ln -sf pom-1.5.15-SNAPSHOT.xml pom.xml && ./mvnw clean test
```

The 2.1 version is not affected:

```bash
ln -sf pom-2.1.0-SNAPSHOT.xml pom.xml && ./mvnw clean test
```

