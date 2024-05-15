package com.beproud.application.exception

open class ApplicationException(
    val code: String,
    val reason: String,
) : RuntimeException()
