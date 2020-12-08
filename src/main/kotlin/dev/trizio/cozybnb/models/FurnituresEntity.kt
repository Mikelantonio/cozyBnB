package dev.trizio.cozybnb.models

import javax.persistence.*

@Entity
@Table(name = "furnitures", schema = "cozybnb")
data class FurnituresEntity (
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Int? = null,

    @Basic
    @Column(name = "type", nullable = false)
    var type: String? = null,

    @ManyToMany(mappedBy = "refFurnituresEntities")
    var refRoomEntities: MutableList<RoomsEntity> = arrayListOf())

