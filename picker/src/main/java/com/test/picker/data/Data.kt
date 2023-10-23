package com.test.picker.data

// TODO: move to data module
object Data {

    enum class Country(val fullName: String) {
        USA("United States of America"),
        CAN("Canada"),
        GBR("United Kingdom"),
        AUS("Australia");

        companion object {
            fun asList() = values().map { it.fullName }
        }

    }

    enum class City(val fullName: String) {
        TORONTO("Toronto"),
        VANCOUVER("Vancouver"),
        MONTREAL("Montreal"),
        CALGARY("Calgary"),
        EDMONTON("Edmonton");

        companion object {
            fun asList() = values().map { it.fullName }
        }

    }

}