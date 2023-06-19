package com.example.frigy_project.di.module

import androidx.lifecycle.ViewModel
import com.example.frigy_project.di.utils.ViewModelKey
import com.example.frigy_project.presentation.viewModels.FridgeFragmentViewModel
import com.example.frigy_project.presentation.viewModels.InfoRecipeFragmentViewModel
import com.example.frigy_project.presentation.viewModels.RecipeFragmentViewModel
import com.example.frigy_project.presentation.viewModels.ShopFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(RecipeFragmentViewModel::class)
    abstract fun provideRecipeFragmentViewModel(viewModel: RecipeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(FridgeFragmentViewModel::class)
    abstract fun provideFridgeFragmentViewModel(viewModel: FridgeFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(ShopFragmentViewModel::class)
    abstract fun provideShopFragmentViewModel(viewModel: ShopFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @Singleton
    @ViewModelKey(InfoRecipeFragmentViewModel::class)
    abstract fun provideInfoRecipeFragmentViewModel(viewModel: InfoRecipeFragmentViewModel): ViewModel
}