package com.example.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {


    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Item>
    lateinit var imageId: Array<Int>
    lateinit var content: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        content = arrayOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5",
            "Item 6",
            "Item 7",
            "Item 8",
            "Item 9",
            "Item 10",
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val inflated = inflater.inflate(R.layout.fragment_home, container, false)
        newRecyclerView = inflated.findViewById(R.id.recyclerView)

        newRecyclerView.layoutManager = LinearLayoutManager(inflated.context)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<Item>()

        getUserData()

        newRecyclerView.adapter = ItemAdapter(newArrayList)

        return inflated
    }

    private fun getUserData(){

        for(i in content.indices){

            val item = Item(content[i])
            newArrayList.add(item)

        }

    }


}