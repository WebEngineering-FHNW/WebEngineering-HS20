package webec

class Room {
    String description
    int    capacity

    String toString() { return description + "(" + capacity + ")"}

    static constraints = {
        description blank: false
        capacity min: 1
    }
}
