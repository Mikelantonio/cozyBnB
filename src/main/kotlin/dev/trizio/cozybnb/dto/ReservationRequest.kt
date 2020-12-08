package dev.trizio.cozybnb.dto

data class ReservationRequest(

        var userId: Long,

        var roomId: Long,

        var startDate: Long,

        var endDate: Long,

        var price: Double,

        var total: Double,

        var createdAt: Long,

        var updatedAt: Long)
