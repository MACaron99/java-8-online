package ua.com.alevel.depends;

import org.apache.commons.math3.CharSet;

import java.util.stream.Stream;

public class Depends {
    protected CharSet(String... set) {
        Stream.of(set).forEach(this::add);
    }