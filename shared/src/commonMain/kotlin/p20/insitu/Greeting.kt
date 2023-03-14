package p20.insitu


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}