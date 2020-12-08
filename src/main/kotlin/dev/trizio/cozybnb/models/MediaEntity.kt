package dev.trizio.cozybnb.models

import javax.persistence.*

@Entity
@Table(name = "media", schema = "cozybnb")
data class MediaEntity (

        @Id
    @Column(name = "id", nullable = false)
    var id: Long? = null,

    @Basic
    @Column(name = "room_id", nullable = false, insertable = false, updatable = false)
    var roomId: Long? = null,

    @Basic
    @Column(name = "title", nullable = false)
    var title: String? = null,

    @Basic
    @Column(name = "file_url", nullable = false)
    var fileUrl: String? = null,

    @Basic
    @Column(name = "mime_type", nullable = false)
    var mimeType: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    var refRoomsEntity: RoomsEntity? = null)

