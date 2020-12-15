package dev.trizio.cozybnb.service

import dev.trizio.cozybnb.models.ReservationsEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ReservationsEntityService {

    fun addReservationsEntity(model: ReservationsEntity): ReservationsEntity?
    fun deleteReservationsEntity(id: Long): Int
    fun deleteAllReservationsEntities()
    fun getReservationsEntityById(id: Long): ReservationsEntity?
    fun getReservationsEntities(pageable: Pageable): Page<ReservationsEntity>
    fun updateReservationsEntity(id: Long, model: ReservationsEntity): ReservationsEntity?
}