package com.beproud.application.community.port.out

import com.beproud.domain.community.Community
import java.util.UUID

interface RetrieveCommunityPort {
    fun retrieveCommunityById(id: UUID): Community
}
