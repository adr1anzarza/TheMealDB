package com.example.themealapp.mealbycategory.ui.mealdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.themealapp.R
import com.example.themealapp.databinding.FragmentMealDetailBinding
import com.example.themealapp.databinding.FragmentMealsBinding
import com.example.themealapp.mealbycategory.ui.meals.MealsFragmentArgs
import com.example.themealapp.mealbycategory.ui.viewmodel.MealsViewModel
import com.example.themealapp.mealbycategory.ui.viewmodel.MealsViewModelFactory

class MealDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentMealDetailBinding
    private lateinit var mViewModel: MealsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_meal_detail, container, false)
        mViewModel = ViewModelProvider(this, MealsViewModelFactory()).get(MealsViewModel::class.java)

        mBinding.viewModel = mViewModel

        mBinding.lifecycleOwner = this

        val application = requireNotNull(activity).application
        val selectedMeal = MealDetailFragmentArgs.fromBundle(requireArguments()).selectedMeal

        mViewModel.getMealDetail(selectedMeal.idMeal!!)

        return mBinding.root
    }

}