package dev.trizio.cozybnb.models

import javax.persistence.*

@Entity
@Table(name = "addresses", schema = "cozybnb")
data class AddressesEntity(
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Long? = null,

    @Basic
    @Column(name = "street", nullable = false)
    var street: String? = null,

    @Basic
    @Column(name = "city", nullable = false)
    var city: String? = null,

    @Basic
    @Column(name = "province", nullable = false)
    var province: String? = null,

    @Basic
    @Column(name = "zip", nullable = false)
    var zip: String? = null,

    @Basic
    @Column(name = "country", nullable = false)
    var country: String? = null,

    @Basic
    @Column(name = "latitude", nullable = false)
    var latitude: Double? = null,

    @Basic
    @Column(name = "longitude", nullable = false)
    var longitude: Double? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    var refRoomsEntity: RoomsEntity? = null)

