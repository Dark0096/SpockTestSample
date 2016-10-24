package com.dark.spock.sample.sample1

import spock.lang.Specification

class FixtureMethodsSpecification extends Specification {

    // Fixture Methods
    // 1. setupSpec
    def setupSpec() {
        println "setupSpec : Run before the first feature method\n"
    }
    // 2. setup
    def setup() {
        println "setup : Run before every feature method"
    }
    // 3. cleanup
    def cleanup() {
        println "cleanup : Run after every feature method"
    }
    // 4. cleanupSpec
    def cleanupSpec() {
        println "cleanupSpec : Run after the last feature method"
    }

    // Feature Methods
    def "First feature methods"() {
        println "First feature method start!"
        given:
        def stack = new Stack()

        when:
        stack.push(1)

        then:
        stack.size() == 1
    }

    def "Last feature methods"() {
        println "Last feature method start!"
        given:
        def stack = new Stack()

        when:
        stack.push(1)

        then:
        stack.size() == 1
    }
}