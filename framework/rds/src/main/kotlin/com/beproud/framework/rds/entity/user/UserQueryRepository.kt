package com.beproud.framework.rds.entity.user

import com.beproud.framework.rds.user.QUser.user
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Slice
import org.springframework.data.domain.SliceImpl
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
class UserQueryRepository(
    private val factory: JPAQueryFactory,
) {

    fun search(searchQuery: UserSearchQuery, pageable: Pageable, lastId: UUID?): Slice<UserEntity> {
        val results = factory.selectFrom(user)
            .where(
                ltId(lastId),
                searchQuery.predicate(),
            ).limit(pageable.pageSize.toLong() + 1)
            .orderBy(user.id.desc())
            .fetch()
        return checkLastPage(pageable, results.toMutableList())
    }

    private fun checkLastPage(pageable: Pageable, results: MutableList<UserEntity>): Slice<UserEntity> {
        var hasNext = false
        if (results.size > pageable.pageSize) {
            hasNext = true
            results.removeAt(pageable.pageSize)
        }
        return SliceImpl(results, pageable, hasNext)
    }

    private fun ltId(id: UUID?): BooleanExpression? {
        return if (id == null) {
            null
        } else {
            user.id.lt(id)
        }
    }
}
