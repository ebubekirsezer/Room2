package com.example.room2.basket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.room2.MainActivity
import com.example.room2.R
import com.example.room2.home.BasketActivity
import kotlinx.android.synthetic.main.all_basket_fragment.*

class AllBasketFragment : Fragment(R.layout.all_basket_fragment) {
    lateinit var basketViewModel: BasketViewModel
    lateinit var basketAdapter: BasketAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basketViewModel=(activity as BasketActivity).basketViewModel

        setupRecyclerView()

        basketViewModel.basket.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource2.Success -> {
                    Log.e("Fragment","${response.data}")
                    response.data?.let { basketResponse ->
                        basketAdapter.differ.submitList(basketResponse.sepet_yemekler)
                        Log.i("Fragment", "Resource'daa")
                    }
                }
                is Resource2.Error -> {
                    response.message?.let {
                        Log.e("Fragment", "Resource'da hata oluştu")
                    }
                }
                is Resource2.Loading -> {
                    Log.e("Fragment","Loading")

                }
                else -> Log.e("Fragment","else'deyim")
            }
        })
    }
    private fun setupRecyclerView(){
        basketAdapter= BasketAdapter()
        rv3.apply {
            adapter=basketAdapter
            layoutManager= LinearLayoutManager(activity)
            Log.e("BasketFragment","RVDEYİM")
        }

    }

}