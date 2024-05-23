package com.beproud.support

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class UseService(
    @get:AliasFor(annotation = Component::class)
    val value: String = "",
)
