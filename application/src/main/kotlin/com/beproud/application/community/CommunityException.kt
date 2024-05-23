package com.beproud.application.community

import com.beproud.exception.ApplicationException

private const val PREFIX = "CM"

class CommunityNotFoundException : ApplicationException("${PREFIX}00001", "커뮤니티를 찾을 수 없습니다")
