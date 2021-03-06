package graphql.resources

object Queries {

    val saveManualAccountMutation = """
        mutation SaveAccountMutation {
            a: saveAccount(payload: {name: "Jony"} ) {
                name
            }
            b: saveAccount(payload: {name: "Terry"} ) {
                name
                bank
                password
            }
            c: saveAccount2(payload: {name: "Jaina"}) {
                name
                bank
            }
        }
    """.trimIndent()

    val statementsQuery = """
        query MyQuery2 {
            c: account {
                name
                bank
                statement(statementId: 1) {
                    name
                }
                statements {
                    name
                }
            }
        }
    """.trimIndent()

    val statementAndTransactionsQuery = """
        query MyQuery3 {
            c: account {
                name
                bank
                statement(statementId: 1) {
                    name
                    transactions {
                        value
                    }
                }
                statements {
                    name
                    transaction(transactionId: 1) {
                        value
                    }
                    transactions {
                        value
                    }
                }
            }
        }
    """.trimIndent()

    val userAccountsQuery = """
        query {
            user(userId: 1) {
                username
                accounts {
                    name
                    bank
                    password
                    statements {
                        name
                        transactions {
                            value
                        }
                    }
                }
            }
        }
    """.trimIndent()

    val cashFlowQuery = """
        query {
            user(userId: 1) {
                username
                accounts {
                    name
                }
                userInfoCollector {
                    estimatedEconomy
                    cashFlow {
                        income
                        outcome
                    }
                }
            }
        }
    """.trimIndent()
}