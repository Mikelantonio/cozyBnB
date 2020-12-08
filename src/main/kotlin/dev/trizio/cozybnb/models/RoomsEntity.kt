package dev.trizio.cozybnb.models

import javax.persistence.*

@Entity
@Table(name = "rooms", schema = "cozybnb")
data class RoomsEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, insertable = false, updatable = false)
        var id: Long? = null,

        @Basic
        @Column(name = "room_type", nullable = false, insertable = false, updatable = false)
        var roomType: Int? = null,

        @Basic
        @Column(name = "description", columnDefinition = "TEXT", nullable = true)
        var description: String? = null,

        @Basic
        @Column(name = "price", nullable = false)
        var price: Double? = null,

        @Basic
        @Column(name = "total_occupancy", nullable = false)
        var totalOccupancy: Int? = null,

        @Basic
        @Column(name = "total_bedrooms", nullable = false)
        var totalBedrooms: Int? = null,

        @Basic
        @Column(name = "total_bathrooms", nullable = false)
        var totalBathrooms: Int? = null,

        @Basic
        @Column(name = "owner_id", nullable = false, insertable = false, updatable = false)
        var ownerId: Long? = null,

        @Basic
        @Column(name = "created_at", nullable = false)
        var createdAt: java.sql.Timestamp? = null,

        @Basic
        @Column(name = "updated_at", nullable = true)
        var updatedAt: java.sql.Timestamp? = null,

        @Basic
        @Column(name = "published_at", nullable = true)
        var publishedAt: java.sql.Timestamp? = null,

        @OneToOne(mappedBy = "refRoomsEntity")
        var refAddressesEntity: AddressesEntity? = null,

        @OneToMany(mappedBy = "refRoomsEntity")
        var refMediaEntities: MutableList<MediaEntity> = arrayListOf(),

        @OneToMany(mappedBy = "refRoomsEntity")
        var refReservationsEntities: MutableList<ReservationsEntity> = arrayListOf(),

        @ManyToMany
        @JoinTable(
                name = "room_furnitures",
                joinColumns = [JoinColumn(name = "room_id")],
                inverseJoinColumns = [JoinColumn(name = "furnitures_id")])
        var refFurnituresEntities: MutableList<FurnituresEntity> = arrayListOf(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "room_type", referencedColumnName = "id")
        var refRoomTypesEntity: RoomTypesEntity? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "owner_id", referencedColumnName = "id")
        var refUsersEntity: UsersEntity? = null,

        @OneToMany(mappedBy = "refRoomsEntity")
        var refTimePeriodEntities: MutableList<TimePeriodEntity> = arrayListOf())

