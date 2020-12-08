package dev.trizio.cozybnb.models

import javax.persistence.*

@Entity
@Table(name = "room_types", schema = "cozybnb")
data class RoomTypesEntity (
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null,

    @Basic
    @Column(name = "type", nullable = false)
    var type: String? = null,

    @OneToMany(mappedBy = "refRoomTypesEntity")
    var refRoomsEntities: MutableList<RoomsEntity> = arrayListOf())

