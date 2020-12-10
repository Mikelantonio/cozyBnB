package dev.trizio.cozybnb.models

import java.io.Serializable

data class TimePeriodEntityPK (

    var room: Long = -1,

    var startAt: java.sql.Date
) : Serializable