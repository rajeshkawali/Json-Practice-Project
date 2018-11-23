package com.jackson.test;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonIntArray {
    static final String JSON = "{ \"version\" : 1, \"data\" : [ [1,2,3], [4.5,6]] }";

    static class Outer {
        public int version;
        public List<Inner> data;

        @Override
        public String toString() {
            return "Outer{" +
                    "version=" + version +
                    ", data=" + data +
                    '}';
        }
    }

    static class Inner {
        public List<Integer> intlist;

        @JsonCreator
        public Inner(final List<Integer> intlist) {
            this.intlist = intlist;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "intlist=" + intlist +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.readValue(JSON, Outer.class));
    }
}