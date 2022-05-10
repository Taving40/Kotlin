package com.example.helloworld

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {


    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Item>
    private lateinit var tempArrayList: ArrayList<Item>
    private lateinit var searchbar: TextView
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
        tempArrayList = arrayListOf<Item>()

        getUserData()

        newRecyclerView.adapter = ItemAdapter(tempArrayList)

        //add the searchbar listener
        searchbar = inflated.findViewById(R.id.search_action)
        searchbar.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                return;
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0 != null){
                    if(p0.isNotEmpty()){

                        tempArrayList.clear()

                        //get the searchtext to lowercase
                        var searchText: String = ""
                        p0.forEach {
                            searchText = searchText.plus(it.lowercase(Locale.getDefault()))
                        }

                        newArrayList.forEach{
                            val content = it.content.lowercase(Locale.getDefault())
                            if(it.content.lowercase(Locale.getDefault()).contains(searchText)){
                                tempArrayList.add(it)
                            }
                        }

                        newRecyclerView.adapter!!.notifyDataSetChanged()


                    } else { //when searchbar is empty show all

                        tempArrayList.clear()
                        tempArrayList.addAll(newArrayList)
                        newRecyclerView.adapter!!.notifyDataSetChanged()
                    }
                }
                println(tempArrayList)
            }

            override fun afterTextChanged(p0: Editable?) {
                return;
            }

        })

        return inflated
    }

    private fun getUserData(){

        for(i in content.indices){

            val item = Item(content[i])
            newArrayList.add(item)

        }

        tempArrayList.addAll(newArrayList)

    }


}