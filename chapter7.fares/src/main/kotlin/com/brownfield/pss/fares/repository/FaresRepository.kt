package com.brownfield.pss.fares.repository

import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.pss.fares.entity.Fare

interface FaresRepository : JpaRepository<Fare, Long> {
    fun getFareByFlightNumberAndFlightDate(flightNumber: String, flightDate: String): Fare
}
