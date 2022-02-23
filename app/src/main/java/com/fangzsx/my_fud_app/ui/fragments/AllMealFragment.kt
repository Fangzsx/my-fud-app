package com.fangzsx.my_fud_app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.fangzsx.my_fud_app.R
import com.fangzsx.my_fud_app.adapters.LetterAdapter
import com.fangzsx.my_fud_app.databinding.FragmentCategoryBinding
import com.fangzsx.my_fud_app.viewmodels.AllMealViewHolder

class AllMealFragment : Fragment() {
    lateinit var binding : FragmentCategoryBinding
    lateinit var lettersAdapter : LetterAdapter
    lateinit var allMealVM : AllMealViewHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lettersAdapter = LetterAdapter()
        allMealVM = AllMealViewHolder()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpLetterRecyclerView()


    }

    private fun setUpLetterRecyclerView() {
        val alphabets = mutableListOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',  'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z')
        lettersAdapter.setList(alphabets as ArrayList)

        binding.rvLetters.apply {
            layoutManager = GridLayoutManager(activity, 7, GridLayoutManager.VERTICAL,false)
            adapter = lettersAdapter
        }
    }

    private fun setUpFilteredMealRecyclerView(){
        allMealVM.observeFilteredMealListLiveData().observe(viewLifecycleOwner){

        }
    }

}