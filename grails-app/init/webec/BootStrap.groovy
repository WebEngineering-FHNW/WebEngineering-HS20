package webec

import org.codehaus.groovy.runtime.DateGroovyMethods

class BootStrap {

    def init = { servletContext ->

        Person koenig = new Person(firstName: "Dierk",  lastName: "König").save()
        Person holz   = new Person(firstName: "Dieter", lastName: "Holz").save()

        Room aula     = new Room(description: "Aula",  capacity: 60).save()
        Room seminar  = new Room(description: "1.311", capacity: 40).save()

        Date today = new Date()
        Date tomorrow = today
        use(DateGroovyMethods) {
            today.clearTime()
            tomorrow = today + 1
        } // small Groovy trick ;-)

        new Booking(room: aula,    booker: koenig, date: today,    timeslot: Booking.AM).save()
        new Booking(room: aula,    booker: koenig, date: tomorrow, timeslot: Booking.PM1).save()
        new Booking(room: seminar, booker: holz,   date: today,    timeslot: Booking.PM1).save()

        for(int i=1; i<10; i++) {
            new Room(description: "room"+i, capacity: 10).save()
        }
        for(int i=1; i<10; i++) {
            new Person(firstName: "person"+i, lastName: "König").save()
        }

    }
    def destroy = {
    }
}
