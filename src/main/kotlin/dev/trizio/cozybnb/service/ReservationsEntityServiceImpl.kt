package dev.trizio.cozybnb.service

import dev.trizio.cozybnb.models.ReservationsEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import dev.trizio.cozybnb.repository.ReservationsEntityRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ReservationsEntityServiceImpl : ReservationsEntityService {

    @Autowired
    private lateinit var repository: ReservationsEntityRepository

    override fun addReservationsEntity(model: ReservationsEntity): ReservationsEntity? {
        TODO("Not yet implemented")
    }

    override fun deleteReservationsEntity(id: Long): Int {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun deleteAllReservationsEntities() {
        repository.deleteAll()
    }

    override fun getReservationsEntityById(id: Long): ReservationsEntity? {
        TODO("Not yet implemented")
    }

    override fun getReservationsEntities(pageable: Pageable): Page<ReservationsEntity> {
        TODO("Not yet implemented")
    }

    override fun updateReservationsEntity(id: Long, model: ReservationsEntity): ReservationsEntity? {
        TODO("Not yet implemented")
    }

}