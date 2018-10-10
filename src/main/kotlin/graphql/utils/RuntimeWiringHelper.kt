package graphql.utils

import graphql.directives.DirectiveWiring
import graphql.schema.idl.RuntimeWiring.Builder
import graphql.resolvers.GraphQLResolver

fun Builder.directives(vararg directives: DirectiveWiring): Builder {
    directives.forEach { directive ->
        this.directive(directive.directiveName, directive)
    }
    return this
}

fun Builder.resolvers(vararg resolvers: GraphQLResolver<*>): Builder {
    resolvers.forEach { resolver ->
        this.type(resolver.typeName) {
            it.dataFetcher(resolver.fieldName, resolver.fieldDataFetcher())
        }
    }
    return this
}

fun Builder.mutations(vararg mutations: GraphQLResolver<*>): Builder {
    mutations.forEach { mutation ->
        this.type(mutation.typeName) {
            it.dataFetcher(mutation.fieldName, mutation.fieldDataFetcher())
        }
    }
    return this
}