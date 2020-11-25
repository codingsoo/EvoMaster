package org.tsdes.spring.examples.news.dto

import org.tsdes.spring.examples.news.db.NewsEntity

/*
    It might be tempting to use the @Entity objects directly as DTOs.
    That is not advisable.
    It might work for small applications developed by one single person,
    but it can become a problem (eg, maintainability and de-coupling) for
    larger projects.

    So here we need a converter from @Entity to DTO
 */
class NewsConverter {

    companion object {

        fun transform(entity: NewsEntity): NewsDto {

            return NewsDto(
                    newsId = entity.id?.toString(),
                    authorId = entity.authorId,
                    text = entity.text,
                    country = entity.country,
                    creationTime = entity.creationTime
            ).apply {
                //here setup both ids, even if one is deprecated
                id =  entity.id?.toString()
            }
        }

        fun transform(entities: Iterable<NewsEntity>): List<NewsDto> {
            return entities.map { transform(it) }
        }
    }
}