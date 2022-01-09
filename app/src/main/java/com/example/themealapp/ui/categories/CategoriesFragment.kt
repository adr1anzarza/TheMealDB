package com.example.themealapp.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themealapp.R
import com.example.themealapp.databinding.FragmentCategoriesBinding
import com.example.themealapp.ui.CategoryGridAdapter
import com.example.themealapp.ui.viewmodel.MainActivityViewModel
import com.example.themealapp.ui.viewmodel.MainActivityViewModelFactory

class CategoriesFragment : Fragment() {

    private lateinit var mBinding: FragmentCategoriesBinding
    private lateinit var mViewModel: MainActivityViewModel
    private lateinit var mAdapter: CategoryGridAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false)
        mViewModel = ViewModelProvider(this, MainActivityViewModelFactory()).get(MainActivityViewModel::class.java)

        mBinding.viewModel = mViewModel

        mAdapter = CategoryGridAdapter(CategoryGridAdapter.OnClickListener{

        })

        mBinding.lifecycleOwner = this

        mBinding.photosGrid.adapter = mAdapter

        val manager = LinearLayoutManager(requireContext())
        mBinding.photosGrid.layoutManager = manager

        mViewModel.mCategoriesList.observe(viewLifecycleOwner, { response ->
            if(!response.categories.isNullOrEmpty()){
                mAdapter.submitList(response.categories)
            }
        })

        return mBinding.root
    }

}