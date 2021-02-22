package com.example.room2.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room2.*
import kotlinx.android.synthetic.main.all_foods_fragment.*

class AllFoodsFragment: Fragment(R.layout.all_foods_fragment) {
    lateinit var viewModel: FoodsViewModel
    lateinit var foodsAdapter: FoodsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonBasket.setOnClickListener {
            Toast.makeText(context, "Sepet",Toast.LENGTH_SHORT).show()
        }

        setupRecyclerView()

        viewModel.foods.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    Log.e("Fragment","${response.data}")
                    response.data?.let { foodsResponse ->
                        foodsAdapter.differ.submitList(foodsResponse.yemekler)
                        Log.i("Fragment", "Resource'daa")
                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Log.e("Fragment", "Resource'da hata oluştu")
                    }
                }
                is Resource.Loading -> {
                    Log.e("Fragment","Loading")

                }
                else -> Log.e("Fragment","else'deyim")
            }
        })
    }
    private fun setupRecyclerView(){
        foodsAdapter= FoodsAdapter()
        rv_allfoods.apply {
            adapter=foodsAdapter
            layoutManager= LinearLayoutManager(activity)
            Log.e("Fragment","RVDEYİM")
        }

    }
}