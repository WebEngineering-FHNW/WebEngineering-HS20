package webec

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RoomSpec extends Specification implements DomainUnitTest<Room> {

    void "Room can be created and accessed in various ways"() {
        given: "a room"
            Room webPrRoom = new Room(description: "1.311", capacity: 40)
        expect:"can read description and capacity"
            webPrRoom.getDescription() == "1.311"
            webPrRoom.description      == "1.311" // shortcut for property access
    }
}
