package com.example.frigy_project.di.module

import androidx.lifecycle.ViewModel
import com.example.frigy_project.di.utils.ViewModelKey
import com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecipeFragmentViewModel::class)
    abstract fun recipeFragmentViewModel(viewModel: RecipeFragmentViewModel): ViewModel
}