package com.dark.spock.sample.Sample4

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification


/**
 * Created by dark on 2016. 11. 6..
 */
class DatabaseDrivenSpecification extends Specification {

    @Shared
    def sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    // setup is not a good choice here because it gets called after the where block has been evaluated.
//    def setup() {
//        sql.execute("create table maxdata (id int primary key, a int, b int, c int)")
//        sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
//    }

    def setupSpec() {
        sql.execute("create table maxdata (id int primary key, a int, b int, c int)")
        sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
    }

    def "maximum of two numbers"() {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, c] << sql.rows("select a, b, c from maxdata")
    }
}