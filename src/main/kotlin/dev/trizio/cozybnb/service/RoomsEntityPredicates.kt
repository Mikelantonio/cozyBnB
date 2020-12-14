package dev.trizio.cozybnb.service

import com.querydsl.core.types.Predicate
import dev.trizio.cozybnb.models.QRoomsEntity

class RoomsEntityPredicates {

    companion object {
        fun published() : Predicate {
            return QRoomsEntity.roomsEntity.publishedAt.isNotNull
        }
    }

}