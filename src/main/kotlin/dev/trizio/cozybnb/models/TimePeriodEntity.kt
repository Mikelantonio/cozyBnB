package dev.trizio.cozybnb.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "time_period", schema = "cozybnb")
@IdClass(TimePeriodEntityPK::class)
data class TimePeriodEntity(

        @Id
    @Column(name = "start_at", nullable = false)
    var startAt: Date,

        @Basic
    @Column(name = "finish_at", nullable = true)
    var finishAt: Date? = null,

        @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    var room: RoomsEntity)


