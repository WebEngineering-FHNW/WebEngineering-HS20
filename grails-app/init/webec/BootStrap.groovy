package webec

class BootStrap {

    def init = { servletContext ->

        for(int i=1; i<10; i++) {
            new Room(description: "room"+i, capacity: 10).save()
        }

    }
    def destroy = {
    }
}
