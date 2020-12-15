package dev.trizio.cozybnb.controller

import dev.trizio.cozybnb.dto.ReservationRequest
import dev.trizio.cozybnb.dto.ReservationResponse
import dev.trizio.cozybnb.dto.toReservationEntity
import dev.trizio.cozybnb.dto.toReservationResponse
import dev.trizio.cozybnb.models.ReservationsEntity
import dev.trizio.cozybnb.service.ReservationsEntityService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.validation.Valid

@RestController
@RequestMapping("")
class ReservationsEntityController(private val service: ReservationsEntityService) {

    @PostMapping("")
    fun addReservationsEntity(@Valid @RequestBody request: ReservationRequest): ReservationResponse? =
            service.addReservationsEntity(request.toReservationEntity())?.toReservationResponse()
                    ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST)

    @GetMapping("")
    fun getReservationEntities(pageable: Pageable): Page<ReservationResponse> =
            service.getReservationsEntities(pageable).map {
                it.toReservationResponse()
            }

    @GetMapping("/{id}")
    fun getReservationsEntity(@PathVariable("id") id: Long): ReservationsEntity =
            service.getReservationsEntityById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PutMapping("/{id}")
    fun updateReservationsEntity(@PathVariable("id") id: Long, @Valid @RequestBody request: ReservationRequest): ReservationResponse =
            service.updateReservationsEntity(id, request.toReservationEntity())?.toReservationResponse()
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @DeleteMapping("/{id}")
    fun deleteReservationsEntity(@PathVariable("id") id: Long) {

        try {
            service.deleteReservationsEntity(id)
        } catch (exception : Exception) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.message)
        }
    }

    @DeleteMapping("")
    fun deleteAllReservationEntities(): Nothing = throw ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED)

}