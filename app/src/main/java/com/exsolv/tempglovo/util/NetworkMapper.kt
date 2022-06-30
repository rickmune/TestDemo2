package com.exsolv.tempglovo.util

import com.exsolv.tempglovo.model.University
import com.exsolv.tempglovo.retrofit.UniversityNetworkEntity
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<UniversityNetworkEntity, University> {

    override fun mapFromEntity(entity: UniversityNetworkEntity): University {
        return University(
            domains = entity.domains[0],
            webPages = entity.webPages[0],
            name = entity.name,
            country = entity.country,
            alphaTwoCode = entity.alphaTwoCode
        )
    }

    override fun mapToEntity(domainModel: University): UniversityNetworkEntity {
        return UniversityNetworkEntity(
            domains = listOf(domainModel.domains),
            webPages = listOf(domainModel.webPages),
            name = domainModel.name,
            country = domainModel.country,
            alphaTwoCode = domainModel.alphaTwoCode
        )
    }

    fun mapFromEntity(entities: List<UniversityNetworkEntity>): List<University> {
        return entities.map { mapFromEntity(it) }
    }
}