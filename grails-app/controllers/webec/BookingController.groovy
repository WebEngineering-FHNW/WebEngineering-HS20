package webec

class BookingController {

    static scaffold = Booking // do the default action (and views !)

    def test() {
        Person koenig = Person.findByLastName("König")
        Room   aula   = Room.findByDescriptionLike("Au%")
        List<Booking> bookings = Booking.findAllByBookerAndDateGreaterThan(koenig, new Date())
        def result = bookings.room

        println result

        List<Booking> bookings1 = Booking.findAllByRoom(aula)
        def persons_unique = bookings1.booker.unique()

        render text: "" + persons_unique
    }

}
