package dev.trizio.cozybnb

import dev.trizio.cozybnb.models.UsersEntity
import dev.trizio.cozybnb.repository.UsersEntityRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.sql.Timestamp

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class UsersRepositoryIntegrationTest {

    @Autowired
    private lateinit var entityManager : TestEntityManager

    @Autowired
    private lateinit var repository : UsersEntityRepository

    @Test
    fun whenFindByEmail_thenReturnUser(){

        val email = "myawesomemail@trizio.dev"

        //given
        val user = UsersEntity(
                name = "Mike Trizio",
                email = email,
                password = "mypwd",
                createdAt = Timestamp(System.currentTimeMillis()))

        entityManager.persist(user)
        entityManager.flush()

        //when
        val result = repository.findByEmail(email)

        //then
        assertThat(result.email).isEqualTo(email)

    }
}