package dev.trizio.cozybnb.service

import dev.trizio.cozybnb.models.UsersEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface UsersEntityService {

    fun addUsersEntity(model: UsersEntity): UsersEntity?
    fun deleteUsersEntity(id: Long): Int
    fun deleteAllUsersEntitys()
    fun getUsersEntityById(id: Long): UsersEntity?
    fun getUsersEntitys(pageable: Pageable): Page<UsersEntity>
    fun updateUsersEntity(id: Long, model: UsersEntity): UsersEntity?
    fun loadUsers()
}