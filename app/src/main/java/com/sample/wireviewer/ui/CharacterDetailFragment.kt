package com.sample.wireviewer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sample.wireviewer.R
import com.sample.wireviewer.databinding.FragmentCharacterDetailBinding

class CharacterDetailFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentCharacterDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterDetailBinding.inflate(inflater)

        viewModel.selectedCharacterLiveData.observe(viewLifecycleOwner) {
            Glide.with(requireActivity())
                .load(it.icon.url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(binding.image)
            binding.characterName.text = it.text
            binding.description.text = it.result
        }

        return binding.root
    }

}