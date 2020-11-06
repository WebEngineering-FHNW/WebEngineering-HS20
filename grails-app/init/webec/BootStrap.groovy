package webec

import grails.util.Environment
import org.codehaus.groovy.runtime.DateGroovyMethods
import webec.SecRole
import webec.SecUser
import webec.SecUserSecRole

class BootStrap {

    def init = { servletContext ->

        // in production or test, this might already be in the DB
        SecRole adminRole = save(SecRole.findOrCreateWhere(authority: SecRole.ADMIN))
        SecRole guestRole = save(SecRole.findOrCreateWhere(authority: SecRole.GUEST))

        if (Environment.current != Environment.DEVELOPMENT) { // guard clause
            return;
        }

        SecUser testUser  = save(new SecUser(username: 'me',    password: 'toobad'))
        SecUser guest     = save(new SecUser(username: 'guest', password: 'guest'))


        testUser.withTransaction { tx ->
            SecUserSecRole.create(testUser, adminRole, true) //flush
            SecUserSecRole.create(guest,    guestRole, true)
        }

        // plausibility check
        assert SecRole.count()          == 2
        assert SecUser.count()          == 2
        assert SecUserSecRole.count()   == 2

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

    static save(domainObject) {
        domainObject.withTransaction { tx ->
            domainObject.save(failOnError: true, flush: true)
        }
        return domainObject
    }
}
