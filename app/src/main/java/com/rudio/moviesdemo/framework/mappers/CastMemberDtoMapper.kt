package com.rudio.moviesdemo.framework.mappers

import com.rudio.moviesdemo.domain.models.CastMember
import com.rudio.moviesdemo.framework.models.CastMemberDto
import com.rudio.moviesdemo.presentation.mappers.ModelMapper
import javax.inject.Inject

class CastMemberDtoMapper @Inject constructor() : ModelMapper<CastMember, CastMemberDto> {

    override fun mapToDomain(outerLayerModel: CastMemberDto): CastMember {
        return CastMember(
            id = outerLayerModel.id,
            nameActor = outerLayerModel.nameActor,
            nameCharacter = outerLayerModel.nameCharacter,
            picture = outerLayerModel.picture
        )
    }

    override fun mapToOuter(domainModel: CastMember): CastMemberDto {
        return CastMemberDto(
            id = domainModel.id,
            nameActor = domainModel.nameActor,
            nameCharacter = domainModel.nameCharacter,
            picture = domainModel.picture
        )
    }
}