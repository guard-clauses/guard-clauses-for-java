package io.github.chrisdostert.guardclauses;

import java.util.ArrayList;

public class Dummy {

    /*
    fields
     */
    String string =
            "string";

    Object object =
            new Object();

    Long _long = 21L;

    Integer _integer = 1;

    Iterable iterable =
            new ArrayList();

    /*
    getter methods
     */
    public String getString() {
        return string;
    }

    public Object getObject() {
        return object;
    }

    public Long getLong() {
        return _long;
    }

    public Integer getInteger() {
        return _integer;
    }

    public Iterable getIterable() {
        return iterable;
    }
}
