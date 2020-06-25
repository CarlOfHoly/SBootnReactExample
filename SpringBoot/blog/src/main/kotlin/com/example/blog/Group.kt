package com.example.blog

import com.fasterxml.jackson.annotation.JsonCreator
import java.time.Instant

data class Group(
        val group: String,
        val likesIceCream: Boolean,
        val timeForIceCream: Instant
)

data class NewGroup @JsonCreator constructor(
        val group: String,
        val likesIceCream: Boolean
)