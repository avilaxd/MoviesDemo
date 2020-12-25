package com.rudio.moviesdemo.framework.mappers

import com.rudio.moviesdemo.domain.models.Backdrop
import com.rudio.moviesdemo.framework.models.BackdropDto
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import javax.inject.Inject

class BackdropDtoMapper @Inject constructor() : ModelMapper<Backdrop, BackdropDto> {

    override fun mapToDomain(outerLayerModel: BackdropDto): Backdrop {
        return Backdrop(
            width = outerLayerModel.width,
            height = outerLayerModel.height,
            path = outerLayerModel.path
        )
    }

    override fun mapToOuter(domainModel: Backdrop): BackdropDto {
        return BackdropDto(
            width = domainModel.width,
            height = domainModel.height,
            path = domainModel.path
        )
    }
}