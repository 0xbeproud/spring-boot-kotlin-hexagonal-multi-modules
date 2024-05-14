package com.beproud.application.port.community

import com.beproud.application.ApplicationException

private const val PREFIX = "CM"

class CommunityNotFoundException : ApplicationException("${PREFIX}00001", "커뮤니티를 찾을 수 없습니다")