package com.beproud.framework.rds.community

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommunityRepository : JpaRepository<Community, UUID>

