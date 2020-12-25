package com.rudio.moviesdemo.presentation.mappers

interface ModelMapper<DomainModel, OuterModel> {

    fun mapToDomain(outerLayerModel: OuterModel): DomainModel

    fun mapToOuter(domainModel: DomainModel): OuterModel

    fun mapToDomainList(list: List<OuterModel>): List<DomainModel> {
        return list.map { mapToDomain(it) }
    }

    fun mapToOuterList(list: List<DomainModel>): List<OuterModel> {
        return list.map { mapToOuter(it) }
    }
}