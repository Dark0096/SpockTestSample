package com.dark.spock.sample.Sample4

import spock.lang.Specification
import spock.lang.Unroll


/**
 * Data Driven Testing Smaple Specification
 * Reference : http://spockframework.org/spock/docs/1.1-rc-2/data_driven_testing.html
 */
class DataDrivenSpecification extends Specification {

    def setup() {
        println "The setup methods will be called before and after each iteration"
    }

    def cleanup() {
        println "The cleanup methods will be called before and after each iteration"
    }

    def "Maximum of numbers" (int a, int b, int c) {
        expect:
        c == Math.max(a, b)

        where:
        // Data Table
        // If an iteration fails, the remaining iterations will nevertheless be executed.
        a | b || c   // Table header
        1 | 2 || 2
        3 | 8 || 8
        -1| 1 || 1
    }

    def "Maximum of numbers using data pipes" (int a, int b, int c) {
        expect:
        c == Math.max(a, b)

        where:
        // Data Pipe
        a << [1, 3, -1]
        b << [2, 8, 1]
        c << [2, 8, 1]
    }

    @Unroll
    def "Maximum of #a and #b is #c" (int a, int b, int c) {
        expect:
        c == Math.max(a, b)

        where:
        // Data Table
        // If an iteration fails, the remaining iterations will nevertheless be executed.
        a | b || c   // Table header
        1 | 2 || 2
        3 | 8 || 3
        -1| 1 || 1
    }

    def "Single Data Table을 이용하여 나보다 나이 많은 사람들인지 테스트를 한다." () {
        expect:
        def myAge = 28
        a == Math.max(a, myAge)

        // Data tables must have at least two columns. A single-column table can be written as:
        where:
        a | _
        30 | _
        31 | _
    }
}