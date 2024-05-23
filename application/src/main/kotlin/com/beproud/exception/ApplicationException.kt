package com.beproud.exception

open class ApplicationException(
    val code: String,
    val reason: String,
) : RuntimeException()
