package graphql.mutations.plain

import graphql.schema.DataFetchingEnvironment

interface GraphQLMutationResolver<T> {

    /**
     * Name of the type from your SDL definition
     */
    val typeName: String

    /**
     * Name of the field from your schema which wants to provide data fetcher
     */
    val fieldName: String

    /**
     * Data fetcher for your field
     */
    fun fieldDataFetcher(): (environment: DataFetchingEnvironment) -> T
}