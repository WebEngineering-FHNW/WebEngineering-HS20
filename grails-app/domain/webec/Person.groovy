package webec

class Person {
    String firstName
    String lastName

    static constraints = {
        firstName blank: false
        lastName  blank: false
    }
}
