package dev.trizio.cozybnb.service

import com.querydsl.core.types.Predicate
import dev.trizio.cozybnb.models.QRoomsEntity
import dev.trizio.cozybnb.models.RoomsEntity
import dev.trizio.cozybnb.repository.RoomsEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class RoomsEntityServiceImpl : RoomsEntityService {

    @Autowired
    private lateinit var repository : RoomsEntityRepository

    override fun addRoomsEntity(model: RoomsEntity): RoomsEntity {
        return repository.save(model)
    }

    override fun updateRoomsEntity(id: Long, model: RoomsEntity): RoomsEntity {
        TODO("Not yet implemented")
    }

    override fun deleteRoomsEntity(id: Long) {
        TODO("Not yet implemented")
    }

    override fun removeRoomsByOwnerId(ownerId: Long): List<RoomsEntity> {
        return repository.removeByOwnerId(ownerId)
    }

    override fun getRoomsEntities(predicate: Predicate, pageable: Pageable): Page<RoomsEntity> {
        TODO("Not yet implemented")
    }

    override fun getRoomsEntities(ownerId: Long, publishedAt: Long, city: String): List<RoomsEntity> {

        var predicate = QRoomsEntity.roomsEntity.ownerId.eq(ownerId)
                .and(QRoomsEntity.roomsEntity.publishedAt.gt(Timestamp(publishedAt)))
                .and(QRoomsEntity.roomsEntity.refAddressesEntity.city.eq(city))

        return repository.findAll(predicate).toList()

    }

    override fun readRooms() {

       val roomList = repository.findAll()
       for(room in roomList){
           println(room.refUsersEntity?.email)
       }
    }

}