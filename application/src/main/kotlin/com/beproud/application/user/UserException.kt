package com.beproud.application.user

import com.beproud.exception.ApplicationException

private const val PREFIX = "UR"

class UserNotFoundException : ApplicationException("${PREFIX}00001", "사용자를 찾을 수 없습니다")

class UserAlreadyExistException : ApplicationException("${PREFIX}00002", "사용자가 이미 존재합니다")
