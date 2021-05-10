package com.example.myapplication.data.model


data class SuperHeroResponse(
    val error: String,
    val response: String,
    val superHero: ArrayList<SuperHero>
)

data class SuperHero(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    val powerstats: Powerstats,
    val response: String,
    val work: Work
)

data class Appearance(
    val eyeColor: String,
    val gender: String,
    val hairColor: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
)

data class Biography(
    val aliases: List<String>,
    val alignment: String,
    val alterEgos: String,
    val firstAppearance: String,
    val fullName: String,
    val placeOfBirth: String,
    val publisher: String
)

data class Connections(
    val groupAffiliation: String,
    val relatives: String
)

data class Image(
    val url: String
)

data class Powerstats(
    val combat: String,
    val durability: String,
    val intelligence: String,
    val power: String,
    val speed: String,
    val strength: String
)

data class Work(
    val base: String,
    val occupation: String
)