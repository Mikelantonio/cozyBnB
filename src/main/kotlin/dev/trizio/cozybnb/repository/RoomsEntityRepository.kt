package dev.trizio.cozybnb.repository

import dev.trizio.cozybnb.models.RoomsEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RoomsEntityRepository : JpaRepository<RoomsEntity, Long>{

    fun findByOwnerId(ownerId : Long) : List<RoomsEntity>

    fun findByOwnerIdAndRoomType(ownerId : Long, roomType : Int) : List<RoomsEntity>

    fun findByTotalBathroomsOrTotalBedrooms(bathrooms: Int, bedrooms : Int) : List<RoomsEntity>

    fun findByOwnerIdOrderByPriceAsc(ownerId : Long) : List<RoomsEntity>

    fun findByRefAddressesEntityZip(zipCode : String) : List<RoomsEntity>

    fun findByRefAddressesEntity_Zip(zipCode : String) : List<RoomsEntity>

    fun findByOwnerId(ownerId : Long, pageable: Pageable) : Page<RoomsEntity>

    fun findByOwnerId(ownerId : Long, sort : Sort) : List<RoomsEntity>

    fun findFirstByOwnerIdOrderByPriceDesc(ownerId : Long)

    fun findFirst10ByOwnerIdOrderByPriceDesc(ownerId : Long)

    fun findAllByPriceGreaterThan(price : Double) : List<RoomsEntity>

    fun findAllByPriceLessThan(price : Double) : List<RoomsEntity>

    fun findAllByRefAddressesEntity_CountryLike(country : String) : List<RoomsEntity>

    fun findAllByPublishedAtIsNull() : List<RoomsEntity>

    fun countByOwnerId(ownerId : Long) : Long

    fun deleteByOwnerId(ownerId : Long) : Long

    fun removeByOwnerId(ownerId : Long) : List<RoomsEntity>

    @Query("select r from RoomsEntity r where r.ownerId =?1")
    fun findByOwnerIdWithQuery(ownerId : Long) : List<RoomsEntity>

    @Query(value = "select * from rooms where total_bedrooms=?1", nativeQuery= true)
    fun findAllByTotalBedrooms(bedrooms : Int) : List<RoomsEntity>

    @Query(value = "select * from rooms where total_bedrooms=?1",
            countQuery = "select count(*) from rooms where total_bedrooms=?1",
            nativeQuery= true)
    fun findAllByTotalBedrooms(bedrooms : Int, pageable: Pageable) : Page<RoomsEntity>

    @Query(value = "select * from rooms where total_bedrooms= : bedrooms", nativeQuery= true)
    fun findAllByTotalBedroomsWithParam(@Param("bedrooms") bedrooms : Int) : List<RoomsEntity>

    @Modifying
    @Query("update RoomsEntity r set r.price = ?1 where r.id =?2")
    fun setPrice(price : Double, id : Long) : Int

    @Modifying
    @Query("delete from RoomsEntity r where r.ownerId = ?1")
    fun deleteByOwnerIdWithQuery(ownerId : Long)



}