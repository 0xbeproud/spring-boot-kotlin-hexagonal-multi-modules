package com.beproud.framework.support

import com.querydsl.core.BooleanBuilder

interface SearchQuery {
    fun predicate(): BooleanBuilder
}
