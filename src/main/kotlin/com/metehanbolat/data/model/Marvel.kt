package com.metehanbolat.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Marvel(
    val id: String,
    val name: String,
    val description: String,
    val imageUrl: String
)

