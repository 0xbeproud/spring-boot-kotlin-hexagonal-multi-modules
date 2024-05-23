package com.beproud.framework.rds.community.adapter.mapper

import com.beproud.domain.community.Community
import com.beproud.framework.rds.community.entity.CommunityEntity
import com.beproud.framework.support.Mapper

@Mapper
class CommunityMapper {
    fun toDomain(communityEntity: CommunityEntity): Community {
        return Community(
            id = communityEntity.id,
            name = communityEntity.name,
        )
    }

    fun toEntity(community: Community): CommunityEntity {
        return CommunityEntity.create(
            name = community.name,
        )
    }
}
