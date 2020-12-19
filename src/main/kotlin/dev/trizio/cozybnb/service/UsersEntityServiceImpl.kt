package dev.trizio.cozybnb.service

import com.github.javafaker.Faker
import dev.trizio.cozybnb.models.UsersEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import dev.trizio.cozybnb.repository.UsersEntityRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional

@Service
class UsersEntityServiceImpl : UsersEntityService {

    @Autowired
    private lateinit var repository: UsersEntityRepository
    override fun addUsersEntity(model: UsersEntity): UsersEntity? {
        TODO("Not yet implemented")
    }

    override fun deleteUsersEntity(id: Long): Int {
        TODO("Not yet implemented")
    }

    override fun deleteAllUsersEntitys() {
        TODO("Not yet implemented")
    }

    override fun getUsersEntityById(id: Long): UsersEntity? {
        TODO("Not yet implemented")
    }

    override fun getUsersEntitys(pageable: Pageable): Page<UsersEntity> {
        TODO("Not yet implemented")
    }

    override fun updateUsersEntity(id: Long, model: UsersEntity): UsersEntity? {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun loadUsers() {

        val faker = Faker()
        for(i in 0..2){

            val user = UsersEntity(
                    name = faker.hitchhikersGuideToTheGalaxy().character(),
                    email = faker.internet().safeEmailAddress(),
                    password = faker.lorem().characters(8, 12))

            repository.save(user)
        }
    }

}