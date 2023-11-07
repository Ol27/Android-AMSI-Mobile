package com.test.feed.ui

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.common.adapter.JobsAdapter
import com.test.common.base.BaseFragment
import com.test.feed.adapter.ContainerEventsAdapter
import com.test.feed.adapter.HeaderAdapter
import com.test.feed.adapter.TitleEventsAdapter
import com.test.feed.adapter.TitleJobAdapter
import com.test.feed.databinding.FragmentFeedBinding
import com.test.feed.model.ItemModel
import dev.chrisbanes.insetter.applyInsetter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : BaseFragment<FragmentFeedBinding>(FragmentFeedBinding::inflate) {
    private val viewModel: FeedViewModel by viewModel()

    private var headerAdapter: HeaderAdapter? = null

    private var titleEventsAdapter: TitleEventsAdapter? = null
    private var eventsContainerAdapter: ContainerEventsAdapter? = null

    private var titleJobAdapter: TitleJobAdapter? = null
    private var jobsAdapter: JobsAdapter? = null

    private var mAdapter: ConcatAdapter? = null

    override fun initView() {
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

        val mockTitleJobs = listOf(
            ItemModel.TitleJob("Jobs for you"),
        )

        headerAdapter = HeaderAdapter()

        titleEventsAdapter = TitleEventsAdapter {
            findNavController().navigate(com.test.navigation.R.id.eventsListFragment)
        }
        eventsContainerAdapter = ContainerEventsAdapter {
            findNavController().navigate(
                com.test.navigation.R.id.action_feedFragment_to_eventFragment,
                bundleOf("ARG_EVENT_ID" to it.id)
            )
        }

        titleJobAdapter = TitleJobAdapter()
        jobsAdapter = JobsAdapter {
            findNavController().navigate(
                com.test.navigation.R.id.action_feedFragment_to_jobFragment,
                bundleOf("ARG_JOB_ID" to it.id)
            )
        }

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
        titleJobAdapter?.submitList(mockTitleJobs)

        viewModel.getLastEvents()
        viewModel.getJobs()

        viewModel.eventsList.observe(viewLifecycleOwner) {
            eventsContainerAdapter?.submitList(listOf(it))
        }
        viewModel.jobsList.observe(viewLifecycleOwner) {
            jobsAdapter?.submitList(it)
        }
    }
}