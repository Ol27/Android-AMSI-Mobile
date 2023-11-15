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
                "Tech Career Fair",
                "San Francisco",
                "10:00 AM",
                "15",
                "Nov",
                "Exhibition Hall",
                "Thursday",
                "4:00 PM",
                "123 Tech Street, San Francisco, USA",
                "+1 123 45 678",
                "Connect with top tech companies and explore job opportunities at our career fair.",
                "2023-11-15 10:00",
                37.818360349137215,
                -122.26215171207369
            ),
            Event(
                3,
                "Professional Development Workshop",
                "New York",
                "2:00 PM",
                "18",
                "Nov",
                "Conference Room B",
                "Sunday",
                "5:00 PM",
                "456 Career Avenue, New York, USA",
                "+1 987 65 432",
                "Enhance your skills and advance your career with our hands-on professional development workshop.",
                "2023-11-18 14:00",
                37.81927759322666,
                -122.27265058153152
            ),
            Event(
                4,
                "Job Search Strategies Seminar",
                "Los Angeles",
                "6:00 PM",
                "20",
                "Nov",
                "Seminar Room",
                "Tuesday",
                "8:00 PM",
                "789 Job Lane, Los Angeles, USA",
                "+1 555 88 999",
                "Learn effective job search strategies and get insights from industry experts at our seminar.",
                "2023-11-20 18:00",
                37.81829522870205,
                -122.26691799839777
            ),
            Event(
                5,
                "Networking Mixer for Professionals",
                "Chicago",
                "7:00 PM",
                "25",
                "Nov",
                "Networking Lounge",
                "Sunday",
                "9:00 PM",
                "101 Business Street, Chicago, USA",
                "+1 777 22 333",
                "Expand your professional network and connect with like-minded individuals at our networking mixer.",
                "2023-11-25 19:00"
            ),
            Event(
                6,
                "Entrepreneurship Panel Discussion",
                "San Francisco",
                "3:00 PM",
                "28",
                "Nov",
                "Entrepreneurship Hub",
                "Wednesday",
                "6:00 PM",
                "234 Startup Street, San Francisco, USA",
                "+1 333 55 777",
                "Gain insights into entrepreneurship and startups from successful founders in this panel discussion.",
                "2023-11-28 15:00",
            ),
            Event(
                7,
                "Career Fair for Recent Graduates",
                "Chicago",
                "11:00 AM",
                "15",
                "Dec",
                "Graduate Pavilion",
                "Saturday",
                "3:00 PM",
                "101 University Street, Chicago, USA",
                "+1 111 22 333",
                "Connect with employers looking to hire recent graduates at our specialized career fair.",
                "2023-12-15 11:00",
            )
        )
    }
}