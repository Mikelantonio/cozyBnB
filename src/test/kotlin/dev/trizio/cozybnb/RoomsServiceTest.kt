package dev.trizio.cozybnb

import dev.trizio.cozybnb.models.RoomsEntity
import dev.trizio.cozybnb.repository.RoomsEntityRepository
import dev.trizio.cozybnb.service.RoomsEntityService
import dev.trizio.cozybnb.service.RoomsEntityServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class RoomsServiceTest {

    @Mock
    private lateinit var repository: RoomsEntityRepository

    @InjectMocks
    private val service : RoomsEntityService = RoomsEntityServiceImpl()

    @Test
    fun whenRemoveRoomsEntity_thenReturnDeletedInstaceNumber() {

        //given
        val room = RoomsEntity(
                id = 120,
                ownerId = 1,
                roomType = 1)

        given(repository.removeByOwnerId(1)).willReturn(arrayListOf(room))

        //when
        val result = service.removeRoomsByOwnerId(1)

        //then
        assertThat(result.size).isGreaterThan(0)
    }


}