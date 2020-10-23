package webec

class Booking {
    Room   room     // many-to-one
    Person booker   // many-to-one

    static constraints = {
        room      nullable: false // is the default but better be explicit
        booker    nullable: false
    }
}
