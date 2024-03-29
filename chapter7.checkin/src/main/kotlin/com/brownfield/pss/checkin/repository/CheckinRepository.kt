package com.brownfield.pss.checkin.repository

import org.springframework.data.jpa.repository.JpaRepository

import com.brownfield.pss.checkin.entity.CheckInRecord

interface CheckinRepository : JpaRepository<CheckInRecord, Long>
