package com.example.hakaton2.data

object LocationDatabase {
    fun getRecommendations(city: String, isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        return when (city.lowercase()) {
            "mumbai" -> getMumbaiRecommendations(isITProfessional, hasFamily)
            "delhi" -> getDelhiRecommendations(isITProfessional, hasFamily)
            "bangalore" -> getBangaloreRecommendations(isITProfessional, hasFamily)
            "hyderabad" -> getHyderabadRecommendations(isITProfessional, hasFamily)
            "chennai" -> getChennaiRecommendations(isITProfessional, hasFamily)
            "pune" -> getPuneRecommendations(isITProfessional, hasFamily)
            "kolkata" -> getKolkataRecommendations(isITProfessional, hasFamily)
            "ahmedabad" -> getAhmedabadRecommendations(isITProfessional, hasFamily)
            else -> emptyList()
        }
    }

    private fun getMumbaiRecommendations(isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        val recommendations = mutableListOf<LocationRecommendation>()

        if (isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Powai",
                    floodRisk = 7.0,
                    connectivity = 6.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 9.0,
                    airQuality = 7.0,
                    propertyPrice = "₹14,000 - ₹16,000 per sq. ft.",
                    overallScore = 7.0,
                    verdict = "A modern, well-planned township with excellent access to IT hubs, but traffic congestion and metro connectivity can be improved."
                ),
                LocationRecommendation(
                    name = "Andheri (West & East)",
                    floodRisk = 5.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 3.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹20,000 - ₹30,000 per sq. ft.",
                    overallScore = 6.7,
                    verdict = "A well-connected and fast-developing locality, but extreme traffic congestion is a major issue."
                ),
                LocationRecommendation(
                    name = "Goregaon",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 6.0,
                    propertyPrice = "₹15,000 - ₹20,000 per sq. ft.",
                    overallScore = 7.0,
                    verdict = "Offers good metro connectivity, modern housing options, and proximity to business hubs, making it ideal for professionals."
                )
            ))
        }

        if (isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Thane",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 6.0,
                    airQuality = 7.0,
                    propertyPrice = "₹10,000 - ₹14,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "An affordable and fast-growing locality with good connectivity and clean air, making it great for families."
                ),
                LocationRecommendation(
                    name = "Navi Mumbai",
                    floodRisk = 8.0,
                    connectivity = 7.0,
                    waterSupply = 9.0,
                    trafficCongestion = 8.0,
                    proximityToHubs = 7.0,
                    airQuality = 9.0,
                    propertyPrice = "₹8,000 - ₹12,000 per sq. ft.",
                    overallScore = 8.0,
                    verdict = "One of the cleanest and most well-planned areas in Mumbai, with affordable housing and great infrastructure."
                )
            ))
        }

        if (!isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Bandra",
                    floodRisk = 5.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 4.0,
                    proximityToHubs = 7.0,
                    airQuality = 6.0,
                    propertyPrice = "₹50,000 - ₹55,000 per sq. ft.",
                    overallScore = 6.7,
                    verdict = "A high-end locality with excellent connectivity and vibrant social life, but heavy traffic and monsoon flooding can be drawbacks."
                ),
                LocationRecommendation(
                    name = "South Mumbai",
                    floodRisk = 4.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 3.0,
                    proximityToHubs = 10.0,
                    airQuality = 6.0,
                    propertyPrice = "₹60,000 - ₹80,000 per sq. ft.",
                    overallScore = 6.8,
                    verdict = "The city's most elite and well-connected area, but extreme congestion and high property prices make it challenging for many buyers."
                ),
                LocationRecommendation(
                    name = "Juhu",
                    floodRisk = 5.0,
                    connectivity = 6.0,
                    waterSupply = 9.0,
                    trafficCongestion = 4.0,
                    proximityToHubs = 5.0,
                    airQuality = 7.0,
                    propertyPrice = "₹49,000 - ₹52,000 per sq. ft.",
                    overallScore = 6.0,
                    verdict = "Offers premium coastal living with excellent water supply, but connectivity to business hubs and traffic congestion are concerns."
                )
            ))
        }

        if (!isITProfessional && hasFamily) {
            // For non-IT professionals with family, we'll reuse some of the good family-friendly areas
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Thane",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 6.0,
                    airQuality = 7.0,
                    propertyPrice = "₹10,000 - ₹14,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "An affordable and fast-growing locality with good connectivity and clean air, making it great for families."
                ),
                LocationRecommendation(
                    name = "Navi Mumbai",
                    floodRisk = 8.0,
                    connectivity = 7.0,
                    waterSupply = 9.0,
                    trafficCongestion = 8.0,
                    proximityToHubs = 7.0,
                    airQuality = 9.0,
                    propertyPrice = "₹8,000 - ₹12,000 per sq. ft.",
                    overallScore = 8.0,
                    verdict = "One of the cleanest and most well-planned areas in Mumbai, with affordable housing and great infrastructure."
                )
            ))
        }

        return recommendations
    }

    private fun getBangaloreRecommendations(isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        val recommendations = mutableListOf<LocationRecommendation>()

        if (isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Whitefield",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 7.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 10.0,
                    airQuality = 6.0,
                    propertyPrice = "₹12,000 - ₹15,000 per sq. ft.",
                    overallScore = 7.0,
                    verdict = "A prime IT hub with good connectivity and nightlife, but faces traffic congestion and water issues."
                ),
                LocationRecommendation(
                    name = "Electronic City",
                    floodRisk = 7.0,
                    connectivity = 7.0,
                    waterSupply = 7.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 10.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,000 - ₹9,000 per sq. ft.",
                    overallScore = 7.3,
                    verdict = "A budget-friendly IT hub with decent connectivity and open spaces."
                ),
                LocationRecommendation(
                    name = "Indiranagar",
                    floodRisk = 5.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹18,000 - ₹25,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "A vibrant area for professionals with great social life but expensive real estate."
                )
            ))
        }

        if (isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Sarjapur Road",
                    floodRisk = 7.0,
                    connectivity = 7.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 9.0,
                    airQuality = 7.0,
                    propertyPrice = "₹8,000 - ₹12,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "Family-friendly area with good schools and IT access, but growing traffic issues."
                ),
                LocationRecommendation(
                    name = "Hebbal",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 8.0,
                    propertyPrice = "₹12,000 - ₹16,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "Great for families with greenery, healthcare, and good connectivity."
                ),
                LocationRecommendation(
                    name = "Bannerghatta Road",
                    floodRisk = 6.0,
                    connectivity = 7.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹9,000 - ₹13,000 per sq. ft.",
                    overallScore = 7.0,
                    verdict = "Family-friendly with schools and hospitals nearby, but traffic is an issue."
                )
            ))
        }

        if (!isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "MG Road",
                    floodRisk = 7.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 4.0,
                    proximityToHubs = 10.0,
                    airQuality = 6.0,
                    propertyPrice = "₹20,000 - ₹30,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "A prime business area with great connectivity but high living costs."
                ),
                LocationRecommendation(
                    name = "Koramangala",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 8.0,
                    airQuality = 6.0,
                    propertyPrice = "₹14,000 - ₹18,000 per sq. ft.",
                    overallScore = 7.0,
                    verdict = "A social and commercial hub, but expensive and congested."
                ),
                LocationRecommendation(
                    name = "Jayanagar",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 8.0,
                    propertyPrice = "₹12,000 - ₹16,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "A peaceful and green locality with good infrastructure."
                )
            ))
        }

        if (!isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Yelahanka",
                    floodRisk = 8.0,
                    connectivity = 7.0,
                    waterSupply = 9.0,
                    trafficCongestion = 8.0,
                    proximityToHubs = 7.0,
                    airQuality = 9.0,
                    propertyPrice = "₹6,000 - ₹10,000 per sq. ft.",
                    overallScore = 8.0,
                    verdict = "Affordable, peaceful, and perfect for families."
                ),
                LocationRecommendation(
                    name = "Uttarahalli",
                    floodRisk = 8.0,
                    connectivity = 7.0,
                    waterSupply = 9.0,
                    trafficCongestion = 8.0,
                    proximityToHubs = 7.0,
                    airQuality = 9.0,
                    propertyPrice = "₹6,000 - ₹9,000 per sq. ft.",
                    overallScore = 8.0,
                    verdict = "One of Bangalore's best-kept secrets for family living."
                ),
                LocationRecommendation(
                    name = "Rajarajeshwari Nagar",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 7.0,
                    proximityToHubs = 7.0,
                    airQuality = 8.0,
                    propertyPrice = "₹8,000 - ₹11,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "A peaceful and well-connected place for families."
                )
            ))
        }

        return recommendations
    }

    private fun getHyderabadRecommendations(isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        val recommendations = mutableListOf<LocationRecommendation>()

        if (isITProfessional) {
            recommendations.add(
                LocationRecommendation(
                    name = "HITEC City",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 7.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 9.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,000-8,000/sqft",
                    overallScore = 8.0,
                    verdict = "Premier IT hub with modern infrastructure"
                )
            )
        }

        if (hasFamily) {
            recommendations.add(
                LocationRecommendation(
                    name = "Gachibowli",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 7.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹5,500-7,500/sqft",
                    overallScore = 7.5,
                    verdict = "Family-friendly area with good schools and hospitals"
                )
            )
        }

        recommendations.addAll(listOf(
            LocationRecommendation(
                name = "Madhapur",
                floodRisk = 7.0,
                connectivity = 8.0,
                waterSupply = 7.0,
                trafficCongestion = 5.0,
                proximityToHubs = 9.0,
                airQuality = 6.0,
                propertyPrice = "₹6,500-8,500/sqft",
                overallScore = 7.0,
                verdict = "Commercial hub with mixed development"
            )
        ))

        return recommendations
    }

    private fun getPuneRecommendations(isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        val recommendations = mutableListOf<LocationRecommendation>()

        if (isITProfessional) {
            recommendations.add(
                LocationRecommendation(
                    name = "Hinjewadi",
                    floodRisk = 8.0,
                    connectivity = 7.0,
                    waterSupply = 7.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 9.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,000-8,000/sqft",
                    overallScore = 7.5,
                    verdict = "Major IT hub with growing infrastructure"
                )
            )
        }

        if (hasFamily) {
            recommendations.add(
                LocationRecommendation(
                    name = "Kothrud",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 8.0,
                    propertyPrice = "₹9,000-12,000/sqft",
                    overallScore = 8.0,
                    verdict = "Premium residential area with excellent amenities"
                )
            )
        }

        recommendations.addAll(listOf(
            LocationRecommendation(
                name = "Viman Nagar",
                floodRisk = 7.0,
                connectivity = 8.0,
                waterSupply = 7.0,
                trafficCongestion = 6.0,
                proximityToHubs = 8.0,
                airQuality = 7.0,
                propertyPrice = "₹8,000-11,000/sqft",
                overallScore = 7.5,
                verdict = "Upmarket area with good connectivity"
            )
        ))

        return recommendations
    }

    private fun getDelhiRecommendations(isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        val recommendations = mutableListOf<LocationRecommendation>()

        if (isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Cyber City (Gurgaon)",
                    floodRisk = 8.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 10.0,
                    airQuality = 5.0,
                    propertyPrice = "₹15,000 - ₹20,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "A top choice for IT professionals with high-end apartments and excellent connectivity."
                ),
                LocationRecommendation(
                    name = "Noida Sector 62",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹6,000 - ₹10,000 per sq. ft.",
                    overallScore = 7.6,
                    verdict = "An affordable and well-connected IT hub with modern housing."
                ),
                LocationRecommendation(
                    name = "Saket",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 5.0,
                    propertyPrice = "₹15,000 - ₹18,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "A premium locality with great connectivity but higher property prices."
                )
            ))
        }

        if (isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Noida Sector 50",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 8.0,
                    proximityToHubs = 8.0,
                    airQuality = 6.0,
                    propertyPrice = "₹7,000 - ₹10,000 per sq. ft.",
                    overallScore = 8.0,
                    verdict = "A green and peaceful locality with excellent amenities for families."
                ),
                LocationRecommendation(
                    name = "Dwarka (Sector 6, 10, 12)",
                    floodRisk = 8.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 6.0,
                    propertyPrice = "₹6,000 - ₹9,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "A well-planned residential area with good schools and hospitals."
                ),
                LocationRecommendation(
                    name = "Indirapuram (Ghaziabad)",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 6.0,
                    propertyPrice = "₹5,000 - ₹8,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "A well-developed and affordable locality for families."
                )
            ))
        }

        if (!isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Connaught Place",
                    floodRisk = 8.0,
                    connectivity = 10.0,
                    waterSupply = 9.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 10.0,
                    airQuality = 5.0,
                    propertyPrice = "₹20,000 - ₹30,000 per sq. ft.",
                    overallScore = 7.6,
                    verdict = "A premium business hub with high-end apartments but expensive."
                ),
                LocationRecommendation(
                    name = "Karol Bagh",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 8.0,
                    airQuality = 5.0,
                    propertyPrice = "₹12,000 - ₹16,000 per sq. ft.",
                    overallScore = 7.0,
                    verdict = "A well-connected commercial hub with affordable rental options."
                ),
                LocationRecommendation(
                    name = "Lajpat Nagar",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 5.0,
                    propertyPrice = "₹12,000 - ₹16,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "A lively commercial area with great rental options for working professionals."
                )
            ))
        }

        if (!isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Greater Kailash (GK 1 & 2)",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 5.0,
                    propertyPrice = "₹20,000 - ₹30,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "A premium locality with spacious homes and top schools."
                ),
                LocationRecommendation(
                    name = "Rohini (Sector 8, 9, 10)",
                    floodRisk = 8.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 6.0,
                    propertyPrice = "₹7,000 - ₹10,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "A family-friendly locality with green spaces and affordable apartments."
                ),
                LocationRecommendation(
                    name = "Paschim Vihar",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 6.0,
                    propertyPrice = "₹6,000 - ₹9,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "A peaceful residential area with good schools and hospitals nearby."
                )
            ))
        }

        return recommendations
    }

    private fun getKolkataRecommendations(isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        val recommendations = mutableListOf<LocationRecommendation>()

        if (isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Salt Lake (Sector V)",
                    floodRisk = 8.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 10.0,
                    airQuality = 6.0,
                    propertyPrice = "₹7,000 - ₹10,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "The best IT hub in Kolkata with great connectivity, but growing traffic concerns."
                ),
                LocationRecommendation(
                    name = "New Town (Rajarhat)",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 8.0,
                    proximityToHubs = 9.0,
                    airQuality = 7.0,
                    propertyPrice = "₹5,000 - ₹8,000 per sq. ft.",
                    overallScore = 8.0,
                    verdict = "A well-planned township with excellent infrastructure, but still developing."
                ),
                LocationRecommendation(
                    name = "Kasba",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹9,000 - ₹12,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "A central IT zone, but traffic congestion is a drawback."
                )
            ))
        }

        if (isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "New Town (Action Area 1 & 2)",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 8.0,
                    proximityToHubs = 8.0,
                    airQuality = 9.0,
                    propertyPrice = "₹5,000 - ₹8,000 per sq. ft.",
                    overallScore = 8.2,
                    verdict = "A green and family-friendly IT zone with top schools and healthcare."
                ),
                LocationRecommendation(
                    name = "Garia",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,000 - ₹8,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "Affordable and well-connected but traffic needs improvement."
                ),
                LocationRecommendation(
                    name = "Behala",
                    floodRisk = 5.0,
                    connectivity = 7.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹4,500 - ₹6,500 per sq. ft.",
                    overallScore = 7.0,
                    verdict = "A growing family area with upcoming metro lines."
                )
            ))
        }

        if (!isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Park Street",
                    floodRisk = 7.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹12,000 - ₹18,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "The heart of Kolkata with excellent connectivity and vibrant lifestyle."
                ),
                LocationRecommendation(
                    name = "Ballygunge",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹15,000 - ₹20,000 per sq. ft.",
                    overallScore = 7.4,
                    verdict = "An upscale locality with premium housing and good amenities."
                ),
                LocationRecommendation(
                    name = "Alipore",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 7.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹18,000 - ₹25,000 per sq. ft.",
                    overallScore = 7.6,
                    verdict = "One of Kolkata's most prestigious addresses with luxury housing."
                )
            ))
        }

        if (!isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Lake Town",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 7.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,000 - ₹9,000 per sq. ft.",
                    overallScore = 7.4,
                    verdict = "A peaceful residential area with good schools and parks."
                ),
                LocationRecommendation(
                    name = "Jadavpur",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹5,500 - ₹8,000 per sq. ft.",
                    overallScore = 7.3,
                    verdict = "An educational hub with good family infrastructure."
                ),
                LocationRecommendation(
                    name = "Tollygunge",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,000 - ₹9,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "A well-established area with good schools and metro connectivity."
                )
            ))
        }

        return recommendations
    }

    private fun getAhmedabadRecommendations(isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        val recommendations = mutableListOf<LocationRecommendation>()

        if (isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "SG Highway",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹7,000 - ₹10,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "The top locality for IT professionals with modern infrastructure."
                ),
                LocationRecommendation(
                    name = "Prahlad Nagar",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 7.0,
                    proximityToHubs = 9.0,
                    airQuality = 7.0,
                    propertyPrice = "₹7,000 - ₹10,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "A well-developed area with premium apartments."
                ),
                LocationRecommendation(
                    name = "Satellite",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 6.0,
                    propertyPrice = "₹6,000 - ₹9,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "A balanced area for professionals with excellent facilities."
                )
            ))
        }

        if (isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "South Bopal",
                    floodRisk = 8.0,
                    connectivity = 7.0,
                    waterSupply = 8.0,
                    trafficCongestion = 7.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹5,000 - ₹7,000 per sq. ft.",
                    overallScore = 7.6,
                    verdict = "A growing family area with good schools and IT connectivity."
                ),
                LocationRecommendation(
                    name = "Gota",
                    floodRisk = 7.0,
                    connectivity = 7.0,
                    waterSupply = 8.0,
                    trafficCongestion = 7.0,
                    proximityToHubs = 7.0,
                    airQuality = 8.0,
                    propertyPrice = "₹4,500 - ₹6,000 per sq. ft.",
                    overallScore = 7.4,
                    verdict = "Affordable housing with good family infrastructure."
                ),
                LocationRecommendation(
                    name = "Science City Road",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 7.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹5,500 - ₹7,500 per sq. ft.",
                    overallScore = 7.7,
                    verdict = "Modern township with excellent amenities for families."
                )
            ))
        }

        if (!isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Navrangpura",
                    floodRisk = 7.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹8,000 - ₹12,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "Central location with excellent commercial opportunities."
                ),
                LocationRecommendation(
                    name = "CG Road",
                    floodRisk = 7.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹9,000 - ₹13,000 per sq. ft.",
                    overallScore = 7.4,
                    verdict = "Prime commercial area with high-end residential options."
                ),
                LocationRecommendation(
                    name = "Vastrapur",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,500 - ₹9,500 per sq. ft.",
                    overallScore = 7.3,
                    verdict = "Well-developed area with good amenities and nightlife."
                )
            ))
        }

        if (!isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Paldi",
                    floodRisk = 7.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹5,500 - ₹8,000 per sq. ft.",
                    overallScore = 7.2,
                    verdict = "Traditional residential area with good schools and markets."
                ),
                LocationRecommendation(
                    name = "Maninagar",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 6.0,
                    propertyPrice = "₹4,500 - ₹6,500 per sq. ft.",
                    overallScore = 7.0,
                    verdict = "Affordable area with good connectivity and family amenities."
                ),
                LocationRecommendation(
                    name = "Thaltej",
                    floodRisk = 8.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 7.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,500 - ₹9,500 per sq. ft.",
                    overallScore = 7.6,
                    verdict = "Upmarket residential area with excellent infrastructure."
                )
            ))
        }

        return recommendations
    }

    private fun getChennaiRecommendations(isITProfessional: Boolean, hasFamily: Boolean): List<LocationRecommendation> {
        val recommendations = mutableListOf<LocationRecommendation>()

        if (isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "OMR (Old Mahabalipuram Road)",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 10.0,
                    airQuality = 7.0,
                    propertyPrice = "₹6,500 - ₹10,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "A tech corridor with excellent IT opportunities and modern infrastructure but traffic congestion can be an issue."
                ),
                LocationRecommendation(
                    name = "Guindy",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 9.0,
                    airQuality = 6.0,
                    propertyPrice = "₹10,000 - ₹14,000 per sq. ft.",
                    overallScore = 7.7,
                    verdict = "Well-connected to IT hubs and the airport, making it an excellent choice for professionals."
                ),
                LocationRecommendation(
                    name = "Velachery",
                    floodRisk = 5.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 6.0,
                    propertyPrice = "₹8,000 - ₹12,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "A well-developed residential area close to IT parks, suitable for young professionals."
                )
            ))
        }

        if (isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Adyar",
                    floodRisk = 5.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 7.0,
                    propertyPrice = "₹15,000 - ₹20,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "A premium residential area with top schools, hospitals, and a peaceful environment."
                ),
                LocationRecommendation(
                    name = "Anna Nagar",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 6.0,
                    propertyPrice = "₹12,000 - ₹18,000 per sq. ft.",
                    overallScore = 7.7,
                    verdict = "A well-planned area with great social infrastructure, perfect for families."
                ),
                LocationRecommendation(
                    name = "Thiruvanmiyur",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹12,000 - ₹16,000 per sq. ft.",
                    overallScore = 7.6,
                    verdict = "A peaceful coastal area with good connectivity and family-friendly amenities."
                )
            ))
        }

        if (!isITProfessional && !hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "T. Nagar",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 5.0,
                    proximityToHubs = 10.0,
                    airQuality = 6.0,
                    propertyPrice = "₹15,000 - ₹22,000 per sq. ft.",
                    overallScore = 7.6,
                    verdict = "A busy commercial hub with excellent metro connectivity but heavy congestion."
                ),
                LocationRecommendation(
                    name = "Nungambakkam",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 6.0,
                    propertyPrice = "₹15,000 - ₹20,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "A prime commercial area with high-end apartments for professionals."
                ),
                LocationRecommendation(
                    name = "Egmore",
                    floodRisk = 6.0,
                    connectivity = 9.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 8.0,
                    airQuality = 6.0,
                    propertyPrice = "₹10,000 - ₹15,000 per sq. ft.",
                    overallScore = 7.5,
                    verdict = "A centrally located commercial area with excellent metro access."
                )
            ))
        }

        if (!isITProfessional && hasFamily) {
            recommendations.addAll(listOf(
                LocationRecommendation(
                    name = "Mylapore",
                    floodRisk = 5.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹12,000 - ₹18,000 per sq. ft.",
                    overallScore = 7.7,
                    verdict = "A culturally rich neighborhood with good schools and temples."
                ),
                LocationRecommendation(
                    name = "Besant Nagar",
                    floodRisk = 5.0,
                    connectivity = 8.0,
                    waterSupply = 9.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹15,000 - ₹20,000 per sq. ft.",
                    overallScore = 7.8,
                    verdict = "A beachside locality with excellent residential options for families."
                ),
                LocationRecommendation(
                    name = "Porur",
                    floodRisk = 6.0,
                    connectivity = 8.0,
                    waterSupply = 8.0,
                    trafficCongestion = 6.0,
                    proximityToHubs = 7.0,
                    airQuality = 7.0,
                    propertyPrice = "₹7,000 - ₹12,000 per sq. ft.",
                    overallScore = 7.6,
                    verdict = "A growing family-friendly neighborhood with modern amenities."
                )
            ))
        }

        return recommendations
    }
} 