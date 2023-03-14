package p20.insitu.model.entities.enums

enum class RoomType(val designation: String) {

    BATHROOM("Badezimmer"),
    BEDROOM("Schlafzimmer"),
    HALLWAY("Flur"),
    KITCHEN("Küche"),
    LIVING_ROOM("Wohnzimmer"),
    OFFICE("Büro"),
    UNSPECIFIED("Sonstiger Raum");

    companion object {
        fun getRoomTypeByDesignation(designation: String?): RoomType? {
            return values().find { it.designation == designation }
        }
    }

}

