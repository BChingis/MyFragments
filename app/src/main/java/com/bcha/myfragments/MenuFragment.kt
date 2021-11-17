package com.bcha.myfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val carList: List<Car> = listOf(
            Car("FORD", "Focus", R.drawable.ford, "1,8 л",
                "передний", 180000, 125),
            Car("KIA", "RioX", R.drawable.kia, "1,6 л",
                "передний", 14500, 123),
            Car("LADA", "2114", R.drawable.lada, "1,6 л",
                "передний", 100000, 81)
        )
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val carRecycleView: RecyclerView = view.findViewById(R.id.cars_recycle_view)
        carRecycleView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,false)
        carRecycleView.addItemDecoration(DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL))
        carRecycleView.adapter = CarAdapter(carList)

        return view
    }


}