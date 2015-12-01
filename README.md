[ ![Codeship Status for chrisdostert/guard-clauses-for-java](https://codeship.com/projects/8ee08ae0-7299-0132-9cb8-1e472470a5ab/status?branch=master)](https://codeship.com/projects/54824)

## Description
Java library offering guard clauses via a fluent interface

## Usage

```java
import static io.github.chrisdostert.guardclauses.Guards.guardThat;

String someString =
                guardThat(
                        "foobar",
                        value
                )
                        .isNotNull()
                        .hasCharacterLengthEqualTo(6)
                        .thenGetValue();
    
```

## Maven Installation

in pom.xml (release versions)
```xml
<dependencies>
    <dependency>
        <groupId>io.github.chrisdostert.guardclauses</groupId>
        <artifactId>guard-clauses-for-java</artifactId>
        <version>${guard-clauses-for-java.version}</version>
    </dependency>
    ...
</dependencies>
```

## Develop:

#### Software
- git
- java 8 JDK
- maven

#### Scripts

compile & unit test
```PowerShell
mvn verify
```

prepare release
```PowerShell
mvn release:prepare
```

## License

This code is open source software licensed under the Apache 2.0 License.