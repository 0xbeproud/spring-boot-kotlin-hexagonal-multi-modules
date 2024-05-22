package com.beproud.framework.rds.adapter.out.community

import com.beproud.application.port.community.CommunityNotFoundException
import com.beproud.application.port.community.out.RetrieveCommunityPort
import com.beproud.application.port.community.out.SaveCommunityPort
import com.beproud.domain.community.Community
import com.beproud.framework.rds.adapter.out.community.mapper.CommunityMapper
import com.beproud.framework.rds.entity.community.CommunityRepository
import com.beproud.framework.rds.support.PersistenceAdapter
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
