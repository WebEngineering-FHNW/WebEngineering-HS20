package webec

class Room {
    String description
    int    capacity

    static constraints = {
        description blank: false
        capacity min: 1
    }
}
