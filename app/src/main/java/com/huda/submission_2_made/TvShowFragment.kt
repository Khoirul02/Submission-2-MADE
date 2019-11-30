package com.huda.submission_2_made


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tv_show.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {

    private val list = ArrayList<RootData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_tv_show.setHasFixedSize(true)
        list.addAll(getListTvShow())
        rv_tv_show.layoutManager = LinearLayoutManager(activity)
        val listTvShowAdapter = ListTvShowAdapter(list)
        rv_tv_show.adapter = listTvShowAdapter

        listTvShowAdapter.setOnItemClickCallback(object : ListTvShowAdapter.OnItemClickCallback{
            override fun onItemClicked(data: RootData) {
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_FILM, data)
                startActivity(intent)            }
        })
    }

    fun getListTvShow(): ArrayList<RootData> {
        val dataName = resources.getStringArray(R.array.data_name_tv_show)
        val dataDescription = resources.getStringArray(R.array.data_description_tv_show)
        val dataPhoto = resources.getStringArray(R.array.data_photo_tv_show)
        val listTvShow = ArrayList<RootData>()
        for (position in dataName.indices) {
            val tvShow = RootData(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listTvShow.add(tvShow)
        }
        return listTvShow
    }

}
