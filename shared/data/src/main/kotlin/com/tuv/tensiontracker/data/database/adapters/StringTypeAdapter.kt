package com.tuv.tensiontracker.data.database.adapters

import app.cash.sqldelight.ColumnAdapter
import com.tuv.tensiontracker.domain.model.StringType

object StringTypeAdapter : ColumnAdapter<StringType, String> {
    override fun decode(databaseValue: String): StringType {
        return StringType.fromDisplayName(databaseValue)
    }

    override fun encode(value: StringType): String {
        return value.displayName
    }
}