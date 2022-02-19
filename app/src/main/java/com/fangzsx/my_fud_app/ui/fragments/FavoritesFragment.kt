package com.fangzsx.my_fud_app.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fangzsx.my_fud_app.R
import com.fangzsx.my_fud_app.databinding.FragmentFavoritesBinding
import com.fangzsx.my_fud_app.viewmodels.FavoritesViewModel

class FavoritesFragment : Fragment() {

    private lateinit var binding : FragmentFavoritesBinding
    private lateinit var favoritesVM : FavoritesViewModel
    private val TAG = "FavoritesFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoritesVM = ViewModelProvider(this)[FavoritesViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }
}