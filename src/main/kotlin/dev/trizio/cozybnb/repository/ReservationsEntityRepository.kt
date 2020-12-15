package dev.trizio.cozybnb.repository

import dev.trizio.cozybnb.models.ReservationsEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface ReservationsEntityRepository : JpaRepository<ReservationsEntity, Long>, QuerydslPredicateExecutor<ReservationsEntity> {

    @Modifying
    @Transactional
    @Query("delete from ReservationsEntity r where r.roomId = ?1")
    fun deleteAllByRoomIdWithQuery(roomId : Long)
}