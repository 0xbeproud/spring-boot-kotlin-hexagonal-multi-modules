package com.beproud.framework.rds.entity.community

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommunityRepository : JpaRepository<CommunityEntity, UUID>

