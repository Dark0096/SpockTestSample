package com.dark.spock.sample.sample3

import behavior.Publisher
import behavior.Subscriber
import sample3.Shop
import spock.lang.Specification


/**
 * Created by dark on 2016. 10. 29..
 */
class HelperMethodSpecification extends Specification {

    def shop

    def setup() {
        shop = new Shop()
    }

    def "Buy the right pc spec using multiple assertion"() {
        given:

        when:
        def pc = shop.buyPc()

        then:
        pc.vendor == "Sunny"
        pc.clockRate == 2333
        pc.ram == 406
        pc.os == "Linux"
    }

    def "Buy the right pc spec using helper methods"() {
        given:

        when:
        def pc = shop.buyPc()

        then:
        matchesPreferredConfiguration1(pc)
        matchesPreferredConfiguration2(pc)
    }

    def matchesPreferredConfiguration1(pc) {
        pc.vendor == "Sunny" && pc.clockRate == 2333 && pc.ram == 406 && pc.os == "Linux"
    }

    // Please note that return is void
    void matchesPreferredConfiguration2(pc) {
        assert pc.vendor == "Sunny"
        assert pc.clockRate == 2333
        assert pc.ram == 406
        assert pc.os == "Linux"
    }

    def "Buy the right pc spec using with block"() {
        given:

        when:
        def pc = shop.buyPc()

        then:
        with(pc) {
            vendor == "Sunny"
            clockRate == 2333
            ram == 406
            os == "Linux"
        }
    }

    def "Behavior test using with block"() {
        given:
        def subscriber1 = Mock(Subscriber)

        def publisher = new Publisher()

        publisher.add(subscriber1)

        when:
        publisher.fire("event")

        then:
        with(subscriber1) {
            1 * receive("event")
        }
    }
}