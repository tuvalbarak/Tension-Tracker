package com.tuv.tensiontracker.data.database.adapters

import app.cash.sqldelight.ColumnAdapter
import com.tuv.tensiontracker.domain.model.TensionUnit

object TensionUnitAdapter : ColumnAdapter<TensionUnit, String> {
    override fun decode(databaseValue: String): TensionUnit {
        return TensionUnit.fromAbbreviation(databaseValue)
    }

    override fun encode(value: TensionUnit): String {
        return value.abbreviation
    }
}