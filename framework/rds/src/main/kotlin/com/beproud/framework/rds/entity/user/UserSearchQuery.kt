package com.beproud.framework.rds.entity.user

import com.beproud.framework.rds.entity.SearchQuery
import com.beproud.framework.rds.user.QUser.user
import com.querydsl.core.BooleanBuilder

data class UserSearchQuery(
    val name: String? = null,
) : SearchQuery {
    override fun predicate(): BooleanBuilder {
        val builder = BooleanBuilder()
        name?.let { builder.and(user.name.eq(it)) }
        return builder
    }
}
