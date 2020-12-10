package dev.trizio.cozybnb.models

import javax.persistence.*

@Entity
@Table(name = "users", schema = "cozybnb")
data class UsersEntity(

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Long? = null,

    @Basic
    @Column(name = "name", nullable = false)
    var name: String? = null,

    @Basic
    @Column(name = "email", nullable = false)
    var email: String? = null,

    @Basic
    @Column(name = "email_verified_at", nullable = true)
    var emailVerifiedAt: java.sql.Timestamp? = null,

    @Basic
    @Column(name = "password", nullable = false)
    var password: String? = null,

    @Basic
    @Column(name = "remember_token", nullable = true)
    var rememberToken: String? = null,

    @Basic
    @Column(name = "created_at", nullable = false)
    var createdAt: java.sql.Timestamp? = null,

    @Basic
    @Column(name = "updated_at", nullable = true)
    var updatedAt: java.sql.Timestamp? = null,

    @Basic
    @Column(name = "phone_number", nullable = true)
    var phoneNumber: String? = null,

    @Basic
    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    var description: String? = null,

    @Basic
    @Column(name = "profile_image_url", nullable = true)
    var profileImageUrl: String? = null,

    @OneToMany(mappedBy = "refUsersEntity")
    var refReservationsEntities: MutableList<ReservationsEntity> = arrayListOf(),

    @OneToMany(mappedBy = "refUsersEntity")
    var refRoomsEntities: MutableList<RoomsEntity> = arrayListOf())

