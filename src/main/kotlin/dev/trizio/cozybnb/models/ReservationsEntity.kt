package dev.trizio.cozybnb.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "reservations", schema = "cozybnb")
data class ReservationsEntity(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false, insertable = false, updatable = false)
        var id: Long? = null,

        @Basic
        @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
        var userId: Long? = null,

        @Basic
        @Column(name = "room_id", nullable = false, insertable = false, updatable = false)
        var roomId: Long? = null,

        @Basic
        @Column(name = "start_date", nullable = false)
        var startDate: Date,

        @Basic
        @Column(name = "end_date", nullable = false)
        var endDate: Date,

        @Basic
        @Column(name = "price", nullable = false)
        var price: Double,

        @Basic
        @Column(name = "total", nullable = false)
        var total: Double,

        @Basic
        @Column(name = "created_at", nullable = false)
        var createdAt: java.sql.Timestamp,

        @Basic
        @Column(name = "updated_at", nullable = true)
        var updatedAt: java.sql.Timestamp,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        var refUsersEntity: UsersEntity? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "room_id", referencedColumnName = "id")
        var refRoomsEntity: RoomsEntity? = null,

        @OneToOne(mappedBy = "refReservationsEntity")
        var refReviewsEntity: ReviewsEntity? = null)

