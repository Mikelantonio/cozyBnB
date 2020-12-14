package dev.trizio.cozybnb.controller

import com.querydsl.core.types.Predicate
import dev.trizio.cozybnb.models.RoomsEntity
import dev.trizio.cozybnb.service.RoomsEntityService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.querydsl.binding.QuerydslPredicate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/rooms")
class RoomController (private val service: RoomsEntityService){

    @GetMapping("/")
    fun getRooms(@QuerydslPredicate(root = RoomsEntity::class) predicate: Predicate, pageable: Pageable) : Page<RoomsEntity> {

       return service.getRoomsEntities(predicate, pageable)
    }

}