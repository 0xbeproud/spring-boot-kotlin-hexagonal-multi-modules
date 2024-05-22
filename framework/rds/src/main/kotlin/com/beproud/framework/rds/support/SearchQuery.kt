package com.beproud.framework.rds.support

import com.querydsl.core.BooleanBuilder

interface SearchQuery {
    fun predicate(): BooleanBuilder
}
