package com.exsolv.tempglovo.room

import com.exsolv.tempglovo.model.University
import com.exsolv.tempglovo.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<UniversityCacheEntity, University> {

    override fun mapFromEntity(entity: UniversityCacheEntity): University {
        return University(
            domains = entity.domain,
            webPages = entity.webPage,
            name = entity.name,
            country = entity.country,
            alphaTwoCode = entity.alphaTwoCode
        )
    }

    override fun mapToEntity(domainModel: University): UniversityCacheEntity {
        return UniversityCacheEntity(
            domain = domainModel.domains,
            webPage = domainModel.webPages,
            name = domainModel.name,
            country = domainModel.country,
            alphaTwoCode = domainModel.alphaTwoCode
        )
    }

    fun mapFromEntityList(entities: List<UniversityCacheEntity>): List<University> {
        return entities.map { mapFromEntity(it) }
    }
}