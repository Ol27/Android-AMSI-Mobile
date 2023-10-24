package com.test.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.test.feed.adapter.ContainerEventsAdapter
import com.test.feed.adapter.HeaderAdapter
import com.test.feed.adapter.JobsAdapter
import com.test.feed.adapter.TitleEventsAdapter
import com.test.feed.adapter.TitleJobAdapter
import com.test.feed.databinding.FragmentFeedBinding
import com.test.feed.model.ItemModel
import dev.chrisbanes.insetter.applyInsetter

class FeedFragment : Fragment() {

    private val binding: FragmentFeedBinding by viewBinding(CreateMethod.INFLATE)

    private var headerAdapter: HeaderAdapter? = null

    private var titleEventsAdapter: TitleEventsAdapter? = null
    private var eventsContainerAdapter: ContainerEventsAdapter? = null

    private var titleJobAdapter: TitleJobAdapter? = null
    private var jobsAdapter: JobsAdapter? = null

    private var mAdapter: ConcatAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
        initInsetter()
    }

    private fun initInsetter() = with(binding) {
        recyclerView.apply {
            applyInsetter {
                type(statusBars = true) {
                    padding()
                }
            }
        }
    }

    private fun initList() {
        val mockHeader = listOf(ItemModel.Header("", "", ""))

        val mockTitleEvents = listOf(
            ItemModel.TitleEvents("Upcoming events"),
        )

        val mockEvents = listOf(
            ItemModel.Events("", "", "", "", ""),
            ItemModel.Events("", "", "", "", ""),
            ItemModel.Events("", "", "", "", ""),
        )

        val mockTitleJobs = listOf(
            ItemModel.TitleJob("Jobs for you"),
        )

        val mockJobs = listOf(
            ItemModel.Job("", "", "", "", "", listOf()),
            ItemModel.Job("", "", "", "", "", listOf()),
            ItemModel.Job("", "", "", "", "", listOf()),
        )



        headerAdapter = HeaderAdapter()

        titleEventsAdapter = TitleEventsAdapter()
        eventsContainerAdapter = ContainerEventsAdapter()

        titleJobAdapter = TitleJobAdapter()
        jobsAdapter = JobsAdapter()

        mAdapter = ConcatAdapter(
            headerAdapter,
            titleEventsAdapter,
            eventsContainerAdapter,
            titleJobAdapter,
            jobsAdapter
        )

        binding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        headerAdapter?.submitList(mockHeader)

        titleEventsAdapter?.submitList(mockTitleEvents)
        eventsContainerAdapter?.submitList(listOf(mockEvents))

        titleJobAdapter?.submitList(mockTitleJobs)
        jobsAdapter?.submitList(mockJobs)

    }


}