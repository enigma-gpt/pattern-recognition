package com.enigmagpt.learning.patternrecognitionworker.domain

import spock.lang.Specification

class BruteForceTextFinderTest extends Specification {

    BruteForceTextFinder finder = new BruteForceTextFinder()

    def "First case"() {

        given:
            def input = "ABCD"
        and:
            def pattern = "BCD"
        when:
            def res = finder.find(input, pattern)
        then:
            res.getPosition() == 1
            res.getTypos() == 0
    }

    def "Second case"() {

        given:
            def input = "ABCD"
        and:
            def pattern = "BWD"
        when:
            def res = finder.find(input, pattern)
        then:
            res.getPosition() == 1
            res.getTypos() == 1
    }

    def "Third case"() {

        given:
        def input = "ABCDEFG"
        and:
        def pattern = "CFG"
        when:
        def res = finder.find(input, pattern)
        then:
        res.getPosition() == 4
        res.getTypos() == 1
    }

    def "Forth case"() {

        given:
        def input = "ABCABC"
        and:
        def pattern = "ABC"
        when:
        def res = finder.find(input, pattern)
        then:
        res.getPosition() == 0
        res.getTypos() == 0
    }

    def "Fifth case"() {

        given:
        def input = "ABCDEFG"
        and:
        def pattern = "TDD"
        when:
        def res = finder.find(input, pattern)
        then:
        res.getPosition() == 1
        res.getTypos() == 2
    }
}