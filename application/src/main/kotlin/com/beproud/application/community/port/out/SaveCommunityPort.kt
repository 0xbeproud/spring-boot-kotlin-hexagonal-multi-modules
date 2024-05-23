package com.beproud.application.community.port.out

import com.beproud.domain.community.Community

interface SaveCommunityPort {
    fun saveCommunity(community: Community)

    fun editCommunity(community: Community)
}
