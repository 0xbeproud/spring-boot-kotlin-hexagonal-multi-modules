package com.beproud.application

open class ApplicationException(
    val code: String,
    val reason: String,
) : RuntimeException()
