package com.example.hakaton2.data

data class LocationRecommendation(
    val name: String,
    val floodRisk: Double,
    val connectivity: Double,
    val waterSupply: Double,
    val trafficCongestion: Double,
    val proximityToHubs: Double,
    val airQuality: Double,
    val propertyPrice: String,
    val overallScore: Double,
    val verdict: String
) 