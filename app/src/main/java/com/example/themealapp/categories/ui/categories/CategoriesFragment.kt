package com.example.themealapp.categories.ui.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.themealapp.R
import com.example.themealapp.databinding.FragmentCategoriesBinding
import com.example.themealapp.categories.ui.CategoryGridAdapter
import com.example.themealapp.categories.ui.viewmodel.MainActivityViewModel
import com.example.themealapp.categories.ui.viewmodel.MainActivityViewModelFactory

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
            mViewModel.displayPropertyDetails(it)
        })

        mBinding.lifecycleOwner = this

        mBinding.photosGrid.adapter = mAdapter

        mViewModel.mCategoriesList.observe(viewLifecycleOwner, { response ->
            if(!response.categories.isNullOrEmpty()){
                mAdapter.submitList(response.categories)
            }
        })

        mViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, {
            if ( null != it ) {
                this.findNavController().navigate(CategoriesFragmentDirections.actionCategoryFragmentToMealsFragment(it))
                mViewModel.displayPropertyDetailsComplete()
            }
        })

        mBinding.actSwipeRefresh.setColorSchemeResources(R.color.purple_700)
        mBinding.actSwipeRefresh.setOnRefreshListener { mViewModel.onOrderRefresh() }

        mViewModel.mOnRefresh.observe(viewLifecycleOwner, { isRefreshed ->
            if(isRefreshed){
                mViewModel.getRandomMeals()
                mViewModel.onDataRefreshed()
                mBinding.actSwipeRefresh.isRefreshing = false
            }
        })

        return mBinding.root
    }

}