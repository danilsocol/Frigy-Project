package com.example.frigy_project.di.module

import androidx.lifecycle.ViewModel
import com.example.frigy_project.di.utils.ViewModelKey
import com.example.frigy_project.presentation.viewModels.FridgeFragmentViewModel
import com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel
import com.example.frigy_project.presentation.viewModels.ShopFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(RecipeFragmentViewModel::class)
    abstract fun provideRecipeFragmentViewModel(viewModel: RecipeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FridgeFragmentViewModel::class)
    abstract fun provideFridgeFragmentViewModel(viewModel: FridgeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopFragmentViewModel::class)
    abstract fun provideShopFragmentViewModel(viewModel: ShopFragmentViewModel): ViewModel
}