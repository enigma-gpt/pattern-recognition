package com.enigmagpt.learning.patternrecognitionfinder.domain

import com.enigmagpt.learning.patternrecognitionfinder.domain.BruteForceTextFinder
import groovy.util.logging.Slf4j
import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.cloud.stream.function.StreamOperations
import spock.lang.Specification

@Slf4j
class BruteForceTextFinderTest extends Specification {

    def UUID = "70972f67-f2d0-4bd2-9330-b5864e266b53"

    def streamBridge = Mock(StreamOperations)

    BruteForceTextFinder finder = new BruteForceTextFinder(streamBridge)

    def "First case"() {

        given:
            def input = "ABCD"
        and:
            def pattern = "BCD"
        when:
            def res = finder.find(UUID, input, pattern)
        then:
            res.position() == 1
            res.typos() == 0
    }

    def "Second case"() {

        given:
            def input = "ABCD"
        and:
            def pattern = "BWD"
        when:
            def res = finder.find(UUID, input, pattern)
        then:
            res.position() == 1
            res.typos() == 1
    }

    def "Third case"() {

        given:
        def input = "ABCDEFG"
        and:
        def pattern = "CFG"
        when:
        def res = finder.find(UUID, input, pattern)
        then:
        res.position() == 4
        res.typos() == 1
    }

    def "Forth case"() {

        given:
        def input = "ABCABC"
        and:
        def pattern = "ABC"
        when:
        def res = finder.find(UUID, input, pattern)
        then:
        res.position() == 0
        res.typos() == 0
    }

    def "Fifth case"() {

        given:
        def input = "ABCDEFG"
        and:
        def pattern = "TDD"
        when:
        def res = finder.find(UUID, input, pattern)
        then:
        res.position() == 1
        res.typos() == 2
    }
}