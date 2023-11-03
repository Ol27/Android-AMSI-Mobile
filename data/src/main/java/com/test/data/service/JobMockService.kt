package com.test.data.service

import com.test.domain.model.Job

class JobMockService {
    private val data: List<Job> = initMockData()

    suspend fun getAllJobs(): List<Job> {
        return data
    }

    suspend fun getJobById(id: Long): Job? {
        return data.find { it.id == id }
    }

    private fun initMockData(): List<Job> {
        return listOf(
            Job(
                1,
                "UI Researcher",
                "Pinterest",
                "45",
                "Placeholder",
                "Permanent",
                23,
                "Travel paid, Breaks paid, Parking paid",
                "Full time",
                "Full time",
                2,
                "250",
                "19.11.2023",
                "23",
                "+1 929 303 45 56",
                "Ann",
                "Native",
                "Intermediate",
                "Medium",
                "Vacancy only for students"
            ),
            Job(
                2,
                "UI Researcher",
                "Pinterest",
                "45",
                "Placeholder",
                "Permanent",
                23,
                "Travel paid, Breaks paid, Parking paid",
                "Full time",
                "Full time",
                2,
                "250",
                "19.11.2023",
                "23",
                "+1 929 303 45 56",
                "Ann",
                "Native",
                "Intermediate",
                "Medium",
                "Vacancy only for students"
            ),
            Job(
                3,
                "UI Researcher",
                "Pinterest",
                "45",
                "Placeholder",
                "Permanent",
                23,
                "Travel paid, Breaks paid, Parking paid",
                "Full time",
                "Full time",
                2,
                "250",
                "19.11.2023",
                "23",
                "+1 929 303 45 56",
                "Ann",
                "Native",
                "Intermediate",
                "Medium",
                "Vacancy only for students"
            ),
            Job(
                4,
                "UI Researcher",
                "Pinterest",
                "45",
                "Placeholder",
                "Permanent",
                23,
                "Travel paid, Breaks paid, Parking paid",
                "Full time",
                "Full time",
                2,
                "250",
                "19.11.2023",
                "23",
                "+1 929 303 45 56",
                "Ann",
                "Native",
                "Intermediate",
                "Medium",
                "Vacancy only for students"
            ),
            Job(
                5,
                "UI Researcher",
                "Pinterest",
                "45",
                "Placeholder",
                "Permanent",
                23,
                "Travel paid, Breaks paid, Parking paid",
                "Full time",
                "Full time",
                2,
                "250",
                "19.11.2023",
                "23",
                "+1 929 303 45 56",
                "Ann",
                "Native",
                "Intermediate",
                "Medium",
                "Vacancy only for students"
            ),
            Job(
                6,
                "UI Researcher",
                "Pinterest",
                "45",
                "Placeholder",
                "Permanent",
                23,
                "Travel paid, Breaks paid, Parking paid",
                "Full time",
                "Full time",
                2,
                "250",
                "19.11.2023",
                "23",
                "+1 929 303 45 56",
                "Ann",
                "Native",
                "Intermediate",
                "Medium",
                "Vacancy only for students"
            )
        )
    }
}