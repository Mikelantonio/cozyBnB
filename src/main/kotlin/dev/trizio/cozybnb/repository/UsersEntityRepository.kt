package dev.trizio.cozybnb.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import dev.trizio.cozybnb.models.UsersEntity

@Repository
interface UsersEntityRepository : JpaRepository<UsersEntity, Long>,
        QuerydslPredicateExecutor<UsersEntity> {

    fun findByEmail(email : String) : UsersEntity

}