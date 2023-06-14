package com.example.frigy_project.di

import androidx.lifecycle.ViewModel
import com.example.frigy_project.presentation.utils.ViewModelKey
import com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppModule {

    @IntoMap
    @ViewModelKey(RecipeFragmentViewModel::class)
    abstract fun recipeFragmentViewModel(viewModel: com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel): ViewModel
}