package com.beproud.framework.rds.community.adapter

import com.beproud.application.community.CommunityNotFoundException
import com.beproud.application.community.port.out.RetrieveCommunityPort
import com.beproud.application.community.port.out.SaveCommunityPort
import com.beproud.domain.community.Community
import com.beproud.framework.rds.community.adapter.mapper.CommunityMapper
import com.beproud.framework.rds.community.entity.CommunityRepository
import com.beproud.framework.support.PersistenceAdapter
import org.springframework.data.repository.findByIdOrNull
import java.util.UUID

@PersistenceAdapter
class CommunityPersistenceAdapter(
    private val communityRepository: CommunityRepository,
    private val communityMapper: CommunityMapper,
) : RetrieveCommunityPort, SaveCommunityPort {
    override fun retrieveCommunityById(id: UUID): Community {
        val communityEntity = communityRepository.findByIdOrNull(id) ?: throw CommunityNotFoundException()
        return communityMapper.toDomain(communityEntity)
    }

    override fun saveCommunity(community: Community) {
        val communityEntity = communityMapper.toEntity(community)
        communityRepository.save(communityEntity)
    }

    override fun editCommunity(community: Community) {
        val communityEntity = communityMapper.toEntity(community)
        communityRepository.save(communityEntity)
    }
}
