package com.test.data.service

import com.test.domain.model.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventMockService {
    private val data: List<Event> = initMockData()

    suspend fun getAllEvents(): List<Event> = withContext(Dispatchers.IO) {
        data
    }

    suspend fun getLastEvents(): List<Event> = withContext(Dispatchers.IO) {
        data.subList(0, 5)
    }

    suspend fun getEventById(id: Long): Event? = withContext(Dispatchers.IO) {
        data.find { it.id == id }
    }

    private fun initMockData(): List<Event> {
        return listOf(
            Event(
                1,
                "Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "2023-10-23 22:00",
                37.815329185289976,
                -122.26598299147614
            ),
            Event(
                2,
                "Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "2023-10-23 22:00",
                37.818360349137215,
                -122.26215171207369
            ),
            Event(
                3,
                "Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "2023-10-23 22:00",
                37.81927759322666,
                -122.27265058153152
            ),
            Event(
                4,
                "Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "2023-10-23 22:00",
                37.81829522870205,
                -122.26691799839777
            ),
            Event(
                5,
                "Self improving stories: A Amazing Workshop",
                "California",
                "10:00 PM",
                "23",
                "Oct",
                "",
                "Friday",
                "11:00 PM",
                "Street, 3, California, USA",
                "+1 100 12 467",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "2023-10-23 22:00"
            )
        )
    }
}