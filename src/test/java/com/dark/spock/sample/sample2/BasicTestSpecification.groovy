package com.dark.spock.sample.sample2

import behavior.Publisher
import behavior.Subscriber
import spock.lang.Specification

/**
 * Created by dark on 2016. 10. 29..
 */
class BasicTestSpecification extends Specification {

    // 1. Basic Condition
    def "Stack push the one elem"() {
        given:
        def stack = new Stack()
        def elem = "push me"

        when:
        stack.push(elem)

        then:
        !stack.empty
        stack.size() == 1
    }

    // 2. Diagnostic Message
    def "Show the error message"() {
        given:
        def stack = new Stack()
        def elem = "push me"

        when:
        stack.push(elem)

        then:
        !stack.empty
        stack.size() == 2
    }

    // 3. Exception condition
    def "When empty stack pop, exception is thrown"() {
        given:
        def stack = new Stack()

        when:
        stack.pop()

        then:
        thrown(EmptyStackException)
        stack.empty()
    }

    // 4. Exception Message Test
    def "When empty stack pop, exception is thrown 2"() {
        given:
        def stack = new Stack()

        when:
        stack.pop()

        then:
        EmptyStackException e = thrown()
        e.cause == null

//        Another exception condition syntax
//        def err = thrown(EmptyStackException)
//        err.cause == null
    }

    // 5. Non exception test
    def "HashMap accepts null key"() {
        given:
        def map = new HashMap()

        when:
        map.put(null, "value")

        then:
        notThrown(NullPointerException)
    }

    def "Events are published to all subscribers"() {
        given:
        def subscriber1 = Mock(Subscriber)
        def subscriber2 = Mock(Subscriber)

        def publisher = new Publisher()

        publisher.add(subscriber1)
        publisher.add(subscriber2)

        when:
        publisher.fire("event")

        then:
        1 * subscriber1.receive("event")
        1 * subscriber2.receive("event")
    }

    def "Use When and then block"() {
        when:
        def x = Math.max(1, 2)

        then:
        x == 2
    }

    def "It is useful in situations where it is more natural to describe stimulus and expected response in a single expression."() {
        expect:
        Math.max(1, 2) == 2
    }

    def "To Use Groovy’s safe dereference operator siplifies writing defensive code."() {
        given:
        Subscriber var = null

        when:
        var?.receive("event")

        then:
        notThrown(NullPointerException)
    }

    // where block
    def "computing the maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
//        a << [5, 3]
//        b << [1, 9]
//        c << [5, 9]

        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }
}