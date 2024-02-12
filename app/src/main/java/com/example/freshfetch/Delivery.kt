package com.example.project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.freshfetch.ItemDetail
import com.example.freshfetch.R
import com.example.freshfetch.databinding.ActivityDeliveryBinding


class Delivery : AppCompatActivity() {
    private lateinit var binding: ActivityDeliveryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = arrayListOf(
            Items("Rice","$13", R.drawable.icons8_grain_24,"Fresh rice imported directly from farm"),
            Items("Tomato", "$4", R.drawable.tomato,"Fresh Tomatoes imported from organic farm"),
            Items("Cucumber", "$5",R.drawable.cucumber,"Fresh and Crunchy Cucumber"),
            Items("Grapes", "$5.5",R.drawable.grapes,"Imported Freshly from Local farms"),
            Items("Lettuce", "$3",R.drawable.lettuce,"Fresh Lettuce imported from farms"),
            Items("Cherry", "$7.4",R.drawable.cherry,"Directly picked and imported fresh")
        )
        val adapter = ItemAdapter(items)
        binding.itemLists.adapter = adapter
        binding.itemLists.layoutManager = LinearLayoutManager(this)

        adapter.OnItemClick = {
            val intent =  Intent(this@Delivery, ItemDetail::class.java)
            intent.putExtra("selectedItem", it)
            startActivity(intent)
        }
    }


}