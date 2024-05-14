package com.beproud.application.port.community.out

import com.beproud.domain.community.Community
import java.util.UUID

interface RetrieveCommunityPort {
    fun retrieveCommunityById(id: UUID): Community
}