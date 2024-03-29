package com.test.data.service

import com.test.domain.model.Job
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class JobMockService {
    private val data: List<Job> = initMockData()

    suspend fun getAllJobs(): List<Job> = withContext(Dispatchers.IO) {
        data
    }

    suspend fun getJobById(id: Long): Job? = withContext(Dispatchers.IO) {
        data.find { it.id == id }
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
                "27",
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
                "27",
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
                "27",
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
                "27",
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
                "27",
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