/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.samples.storage.mediastore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.samples.storage.R
import com.samples.storage.databinding.FragmentListBinding
import com.samples.storage.ui.Action
import com.samples.storage.ui.ActionListAdapter

private val demoList = arrayOf(
    Action(R.string.mediastore_add, R.id.action_mediaStoreFragment_to_addMediaFragment),
    Action(R.string.mediastore_edit, R.id.action_mediaStoreFragment_to_editMediaFragment),
    Action(R.string.mediastore_delete, R.id.action_mediaStoreFragment_to_deleteMediaFragment),
    Action(R.string.mediastore_downloads, R.id.action_mediaStoreFragment_to_addDocumentFragment),
)

class MediaStoreFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = ActionListAdapter(demoList)

        binding.recyclerView

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
