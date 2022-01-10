package com.example.themealapp.mealbycategory.ui.meals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.themealapp.R
import com.example.themealapp.categories.ui.CategoryGridAdapter
import com.example.themealapp.categories.ui.categories.CategoriesFragmentDirections
import com.example.themealapp.categories.ui.viewmodel.MainActivityViewModel
import com.example.themealapp.categories.ui.viewmodel.MainActivityViewModelFactory
import com.example.themealapp.databinding.ActivityMainBinding
import com.example.themealapp.databinding.FragmentMealsBinding
import com.example.themealapp.mealbycategory.ui.MealsAdapter
import com.example.themealapp.mealbycategory.ui.viewmodel.MealsViewModel
import com.example.themealapp.mealbycategory.ui.viewmodel.MealsViewModelFactory

class MealsFragment : Fragment() {

    private lateinit var mBinding: FragmentMealsBinding
    private lateinit var mViewModel: MealsViewModel
    private lateinit var mAdapter: MealsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_meals, container, false)
        mViewModel = ViewModelProvider(this, MealsViewModelFactory()).get(MealsViewModel::class.java)

        mBinding.viewModel = mViewModel

        mBinding.lifecycleOwner = this

        val application = requireNotNull(activity).application
        val selectedCategory = MealsFragmentArgs.fromBundle(requireArguments()).selectedCategory

        mViewModel.setCategorySelected(selectedCategory)
        mViewModel.getMealsByCategory(selectedCategory.strCategory!!)

        mAdapter = MealsAdapter(MealsAdapter.OnClickListener{
            mViewModel.displayMealDetails(it)
        })

        mBinding.photosGrid.adapter = mAdapter

        mViewModel.mMealsList.observe(viewLifecycleOwner, { response ->
            if(!response.meals.isNullOrEmpty()){
                mAdapter.submitList(response.meals)
            }
        })

        mViewModel.navigateToSelectedMeal.observe(viewLifecycleOwner, {
            if ( null != it ) {
                this.findNavController().navigate(MealsFragmentDirections.actionMealsFragmentToMealDetailFragment(it))
                mViewModel.displayMealDetailsComplete()
            }
        })

        return mBinding.root
    }

}