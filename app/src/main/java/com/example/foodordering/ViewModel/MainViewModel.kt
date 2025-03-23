package com.example.foodordering.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodordering.Domain.BannerModel
import com.example.foodordering.Domain.CategoryModel
import com.example.foodordering.Domain.FoodModel
import com.example.foodordering.Repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadFiltered(id: String) : LiveData<MutableList<FoodModel>> {
        return repository.loadFiltered(id)
    }
}