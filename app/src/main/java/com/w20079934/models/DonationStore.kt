package com.w20079934.models

interface DonationStore {
    fun findAll() : List<DonationModel>
    fun findById(id: Long) : DonationModel?
    fun create(donation: DonationModel)
}