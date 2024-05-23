package com.beproud.framework.rds

import com.github.f4b6a3.ulid.UlidCreator
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PostLoad
import jakarta.persistence.PostPersist
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.proxy.HibernateProxy
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.domain.Persistable
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.ZonedDateTime
import java.util.Objects
import java.util.UUID

// https://spoqa.github.io/2022/08/16/kotlin-jpa-entity.html
// https://github.com/veluxer62/kotlin-entity-tutorial
// https://jehuipark.github.io/java/my-sql-binary-reference
// https://helloworld.kurly.com/blog/jpa-uuid-sapjil/

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity : Persistable<UUID> {
    @Id
    @Column(columnDefinition = "uuid", nullable = false, updatable = false)
    private val id: UUID = UlidCreator.getMonotonicUlid().toUuid()

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: ZonedDateTime = ZonedDateTime.now()

    @CreationTimestamp
    @Column(name = "modified_at", nullable = false)
    val modifiedAt: ZonedDateTime = ZonedDateTime.now()

    @CreatedBy
    @Column(name = "created_by")
    var createdBy: String? = null

    @LastModifiedBy
    @Column(name = "modified_by")
    var modifiedBy: String? = null

    @Transient
    private var _isNew = true

    override fun getId(): UUID = id

    override fun isNew(): Boolean = _isNew

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }

        if (other !is HibernateProxy && this::class != other::class) {
            return false
        }

        return id == getIdentifier(other)
    }

    private fun getIdentifier(obj: Any): Serializable {
        return if (obj is HibernateProxy) {
            obj.hibernateLazyInitializer.identifier as Serializable
        } else {
            (obj as BaseEntity).id
        }
    }

    override fun hashCode() = Objects.hashCode(id)

    @PostPersist
    @PostLoad
    protected fun load() {
        _isNew = false
    }
}
