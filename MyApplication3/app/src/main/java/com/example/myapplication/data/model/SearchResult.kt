package com.example.myapplication.data.model

data class SearchResult(
    val response: String,
    val results: ArrayList<Result>,
    val resultsFor: String
)

data class Result(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    val powerstats: Powerstats,
    val work: Work
)

