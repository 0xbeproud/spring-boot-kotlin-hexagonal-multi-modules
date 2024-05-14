package com.beproud.framework.rds.adapter.community.mapper

import com.beproud.domain.community.Community
import com.beproud.framework.rds.entity.community.CommunityEntity
import com.beproud.framework.rds.support.Mapper

@Mapper
class CommunityMapper {
    fun toDomain(communityEntity: CommunityEntity): Community {
        return Community(
            id = communityEntity.id,
            name = communityEntity.name
        )
    }

    fun toEntity(community: Community): CommunityEntity {
        return CommunityEntity.create(
            name = community.name
        )
    }
}