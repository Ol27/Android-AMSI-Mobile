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
                "iOS Developer",
                "TechSolutions Inc.",
                "50",
                "San Francisco",
                "Contract",
                30,
                "Travel reimbursed, Health benefits",
                "Full-time",
                "Remote",
                3,
                "300",
                "25.11.2023",
                "35",
                "+1 123 456 7890",
                "John Doe",
                "Intermediate",
                "Advanced",
                "High",
                "Open to all candidates"
            ),
            Job(
                2,
                "Data Scientist",
                "Data Innovators Co.",
                "60",
                "New York",
                "Permanent",
                25,
                "Health insurance, Stock options",
                "Full-time",
                "On-site",
                5,
                "400",
                "28.11.2023",
                "40",
                "+1 987 654 3210",
                "Alice Johnson",
                "Elementary",
                "Expert",
                "High",
                "Experienced candidates preferred"
            ),
            Job(
                3,
                "Web Developer",
                "WebTech Solutions",
                "45",
                "Los Angeles",
                "Permanent",
                28,
                "Flexible work hours, Gym membership",
                "Full-time",
                "Hybrid",
                2,
                "350",
                "30.11.2023",
                "32",
                "+1 345 678 9012",
                "Chris Smith",
                "Intermediate",
                "Intermediate",
                "Medium",
                "Open to all applicants"
            ),
            Job(
                4,
                "UX/UI Designer",
                "Creative Designs Studio",
                "55",
                "Chicago",
                "Permanent",
                22,
                "Professional development allowance",
                "Full-time",
                "On-site",
                4,
                "380",
                "02.12.2023",
                "28",
                "+1 567 890 1234",
                "Emma White",
                "Advanced",
                "Intermediate",
                "Medium",
                "Portfolio required"
            ),
            Job(
                5,
                "Software Engineer",
                "InnovateTech Solutions",
                "48",
                "Seattle",
                "Permanent",
                26,
                "401(k), Wellness program",
                "Full-time",
                "On-site",
                3,
                "370",
                "05.12.2023",
                "30",
                "+1 234 567 8901",
                "Michael Brown",
                "Intermediate",
                "Advanced",
                "High",
                "Tech-related degree required"
            )
        )
    }
}