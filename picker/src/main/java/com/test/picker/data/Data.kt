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

    enum class State(val fullName: String) {
        NEW_YORK("New York"),
        CALIFORNIA("California"),
        TEXAS("Texas"),
        FLORIDA("Florida"),
        ILLINOIS("Illinois");

        companion object {
            fun asList() = values().map { it.fullName }
        }
    }

    enum class University(val fullName: String) {
        HARVARD("Harvard University"),
        STANFORD("Stanford University"),
        MIT("Massachusetts Institute"),
        UCLA("University of California"),
        OXFORD("University of Oxford");

        companion object {
            fun asList() = values().map { it.fullName }
        }
    }

    enum class Specialty(val fullName: String) {
        COMPUTER_SCIENCE("Computer Science"),
        MEDICINE("Medicine"),
        BUSINESS("Business Administration"),
        ENGINEERING("Engineering"),
        PSYCHOLOGY("Psychology");

        companion object {
            fun asList() = values().map { it.fullName }
        }
    }

    enum class Language(val fullName: String) {
        ENGLISH("English"),
        FRENCH("French"),
        POLISH("Polish");

        companion object {
            fun asList() = values().map { it.fullName }
        }
    }

    enum class Level(val fullName: String) {
        A1("A1"),
        A2("A2"),
        B1("B1"),
        B2("B2"),
        C1("C1"),
        C2("C2");

        companion object {
            fun asList() = values().map { it.fullName }
        }
    }

    enum class Position(val fullName: String) {
        CEO("Chief Executive Officer"),
        CTO("Chief Technology Officer"),
        CFO("Chief Financial Officer"),
        HR_MANAGER("Human Resources Manager"),
        SOFTWARE_ENGINEER("Software Engineer");

        companion object {
            fun asList() = values().map { it.fullName }
        }
    }

    enum class Company(val fullName: String) {
        GOOGLE("Google LLC"),
        APPLE("Apple Inc."),
        MICROSOFT("Microsoft Corporation"),
        AMAZON("Amazon.com, Inc."),
        FACEBOOK("Meta Platforms, Inc.");

        companion object {
            fun asList() = values().map { it.fullName }
        }
    }

    enum class Date(val fullName: String) {
        JANUARY_1("January 1, 2023"),
        MARCH_15("March 15, 2023"),
        JULY_1("July 1, 2023"),
        SEPTEMBER_1("September 1, 2023"),
        DECEMBER_25("December 25, 2023");

        companion object {
            fun asList() = values().map { it.fullName }
        }
    }

}