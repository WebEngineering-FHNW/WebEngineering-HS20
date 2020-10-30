package webec

class BookingController {

    static scaffold = Booking // do the default action (and views !)

    def test() {
        Person koenig = Person.findByLastName("König")
        Room   aula   = Room.findByDescriptionLike("Au%")
        List<Booking> bookings = Booking.findAllByBookerAndDateGreaterThan(koenig, new Date())
        def result = bookings.


        render text: "" + result
    }

}
