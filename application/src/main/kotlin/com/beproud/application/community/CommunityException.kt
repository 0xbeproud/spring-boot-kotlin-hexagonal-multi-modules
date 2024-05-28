package com.beproud.application.community

import com.beproud.exception.ApplicationException

private const val PREFIX = "CM"

class CommunityNotFoundException : ApplicationException("${PREFIX}00001", "커뮤니티를 찾을 수 없습니다")

class CommunityAlreadyExistFoundException : ApplicationException("${PREFIX}00002", "커뮤니티가 이미 존재합니다")
