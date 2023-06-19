package com.sample.wireviewer.data

data class CharacterListResponse(
    val abstract: String,
    val abstractSource: String,
    val abstractText: String,
    val abstractURL: String,
    val answer: String,
    val answerType: String,
    val definition: String,
    val definitionSource: String,
    val definitionURL: String,
    val entity: String,
    val heading: String,
    val image: String,
    val imageHeight: Int,
    val imageIsLogo: Int,
    val imageWidth: Int,
    val infobox: String,
    val redirect: String,
    val relatedTopics: List<RelatedTopic>,
    val results: List<Any>,
    val type: String,
    val meta: Meta
)