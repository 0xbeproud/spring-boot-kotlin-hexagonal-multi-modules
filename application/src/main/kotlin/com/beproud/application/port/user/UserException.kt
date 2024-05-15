package com.beproud.application.port.user

import com.beproud.application.exception.ApplicationException

private const val PREFIX = "UR"

class UserNotFoundException : ApplicationException("${PREFIX}00001", "사용자를 찾을 수 없습니다")
