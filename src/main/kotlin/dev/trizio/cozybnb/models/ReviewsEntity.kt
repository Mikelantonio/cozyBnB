package dev.trizio.cozybnb.models

import javax.persistence.*

@Entity
@Table(name = "reviews", schema = "cozybnb")
data class ReviewsEntity (
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    var id: Long? = null,

    @Basic
    @Column(name = "rating", nullable = false)
    var rating: Int? = null,

    @Basic
    @Column(name = "comment", nullable = false)
    var comment: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    var refReservationsEntity: ReservationsEntity? = null)



