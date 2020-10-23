package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {

    void "Person can be created with validation errors"() {
        given: "a person"
            Person dierk = new Person(firstName:"Dierk", lastName: "" ) // blank is not allowed
        expect:"can read first and last name"
            dierk.firstName     == "Dierk"
            dierk.getLastName() == null
            dierk.validate()    == false // we expect that this does not validate !!
    }
}
