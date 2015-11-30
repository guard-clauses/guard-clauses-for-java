## Description
Java library offering guard clauses via a fluent interface

## Usage

```java
import static io.github.chrisdostert.guardclauses.Guards.guardThat;

public class AccountContactIdImpl {    
    
    /*snipped*/

    /*
    constructors
     */
    public AccountContactIdImpl(
            String value
    ) {

        this.value =
                guardThat(
                        "accountContactId",
                        value
                )
                        .isNotNull()
                        .hasCharacterLengthEqualTo(18)
                        .thenGetValue();
    }
    
    /*snipped*/
}

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

## License

This code is open source software licensed under the Apache 2.0 License.