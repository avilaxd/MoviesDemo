package com.rudio.moviesdemo.presentation.mappers

import com.rudio.moviesdemo.domain.models.CastMember
import com.rudio.moviesdemo.presentation.models.CastMemberUi
import com.rudio.moviesdemo.presentation.utils.prependCastPath
import javax.inject.Inject

class CastMemberUiMapper @Inject constructor() : ModelMapper<CastMember, CastMemberUi> {

    override fun mapToDomain(outerLayerModel: CastMemberUi): CastMember {
        return CastMember(
            id = outerLayerModel.id,
            nameActor = outerLayerModel.nameActor,
            nameCharacter = outerLayerModel.nameCharacter,
            picture = outerLayerModel.picture
        )
    }

    override fun mapToOuter(domainModel: CastMember): CastMemberUi {
        return CastMemberUi(
            id = domainModel.id,
            nameActor = domainModel.nameActor,
            nameCharacter = domainModel.nameCharacter,
            picture = domainModel.picture.prependCastPath()
        )
    }
}