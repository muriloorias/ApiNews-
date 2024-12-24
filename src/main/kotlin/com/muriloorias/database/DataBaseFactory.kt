package com.muriloorias.database

import com.muriloorias.model.NewsTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DataBaseFactory {
    fun initDB(
        driverClassName: String = "org.h2.Driver",
        jdbcUrl: String = "jdbc:h2:file:./build/db"
    ){
        val database = Database.connect(jdbcUrl, driverClassName)
        transaction(database) {
            SchemaUtils.create(NewsTable)
        }
    }
}