package webec

class Booking {     // relation, many-to-many
    Room   room     // many-to-one
    Person booker   // many-to-one
    Date   date
    String timeslot

    public static final String AM  = "08:15 - 11:00"
    public static final String PM1 = "12:15 - 15:00"
    public static final String PM2 = "15:15 - 18:00"
    public static final List<String> TIME_SLOTS = [AM, PM1, PM2]

    String toString() { "$booker $room $date $timeslot" }

    static constraints = {
        date      nullable: false
        timeslot  nullable: false, inList: TIME_SLOTS
        room      nullable: false // is the default but better be explicit
        booker    nullable: false
    }
}
