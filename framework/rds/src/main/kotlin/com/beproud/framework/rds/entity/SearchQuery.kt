package com.beproud.framework.rds.entity

import com.querydsl.core.BooleanBuilder

interface SearchQuery {
    fun predicate(): BooleanBuilder
}
