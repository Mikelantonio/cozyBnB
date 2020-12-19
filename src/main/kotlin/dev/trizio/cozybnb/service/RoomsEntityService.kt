package dev.trizio.cozybnb.service

import com.querydsl.core.types.Predicate
import dev.trizio.cozybnb.models.RoomsEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface RoomsEntityService {

    fun addRoomsEntity(model: RoomsEntity): RoomsEntity
    fun updateRoomsEntity(id: Long, model: RoomsEntity): RoomsEntity
    fun deleteRoomsEntity(id: Long)
    fun removeRoomsByOwnerId(ownerId : Long) : List<RoomsEntity>
    fun getRoomsEntities(predicate: Predicate, pageable: Pageable): Page<RoomsEntity>
    fun getRoomsEntities(ownerId : Long, publishedAt : Long, city : String) : List<RoomsEntity>
    fun readRooms()

}