package dev.trizio.cozybnb.dto

import dev.trizio.cozybnb.models.ReservationsEntity
import java.sql.Timestamp
import java.util.*
import kotlin.reflect.full.memberProperties

fun ReservationRequest.toReservationEntity() = with(::ReservationsEntity){

    val propertiesByName = ReservationRequest::class.memberProperties.associateBy { it.name }
    callBy(parameters.associate { parameter ->
        parameter to when(parameter.name){
            ReservationsEntity::startDate.name -> Date(startDate)
            ReservationsEntity::endDate.name -> Date(endDate)
            ReservationsEntity::createdAt.name -> Timestamp(createdAt)
            ReservationsEntity::updatedAt.name -> Timestamp(updatedAt)
            else -> propertiesByName[parameter.name]?.get(this@toReservationEntity)
        }
    })
}

fun ReservationsEntity.toReservationResponse() = with(::ReservationResponse){

    val propertiesByName = ReservationsEntity::class.memberProperties.associateBy { it.name }
    callBy(parameters.associate { parameter ->
        parameter to when(parameter.name){
            ReservationResponse::startDate.name -> startDate.time
            ReservationResponse::endDate.name -> endDate.time
            ReservationResponse::createdAt.name -> createdAt.time
            ReservationResponse::updatedAt.name -> updatedAt.time
            else -> propertiesByName[parameter.name]?.get(this@toReservationResponse)
        }
    })
}