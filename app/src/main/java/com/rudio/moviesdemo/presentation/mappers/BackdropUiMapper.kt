package com.rudio.moviesdemo.presentation.mappers

import com.rudio.moviesdemo.domain.models.Backdrop
import com.rudio.moviesdemo.presentation.models.BackdropUi
import com.rudio.moviesdemo.presentation.utils.prependBackdropPath
import javax.inject.Inject

class BackdropUiMapper @Inject constructor() : ModelMapper<Backdrop, BackdropUi> {

    override fun mapToDomain(outerLayerModel: BackdropUi): Backdrop {
        return Backdrop(
            width = outerLayerModel.width,
            height = outerLayerModel.height,
            path = outerLayerModel.path
        )
    }

    override fun mapToOuter(domainModel: Backdrop): BackdropUi {
        return BackdropUi(
            width = domainModel.width,
            height = domainModel.height,
            path = domainModel.path.prependBackdropPath()
        )
    }
}