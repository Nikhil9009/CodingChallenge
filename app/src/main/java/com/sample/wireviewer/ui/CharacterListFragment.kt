package com.sample.wireviewer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.sample.wireviewer.R
import com.sample.wireviewer.databinding.FragmentCharacterListBinding
import com.sample.wireviewer.ui.adapter.CharacterListAdapter

class CharacterListFragment : Fragment(), CharacterListAdapter.OnItemClickListener {

    private lateinit var adapter: CharacterListAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentCharacterListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterListBinding.inflate(inflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        // call characters API
        viewModel.getCharacterData()

        viewModel.charactersLiveData.observe(viewLifecycleOwner){
            adapter = CharacterListAdapter(it.relatedTopics, this)
            binding.recyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onItemClick(position: Int) {
        val topics = viewModel.relatedTopic
        viewModel.setSelectedCharacter(topics?.get(position))
    }
}