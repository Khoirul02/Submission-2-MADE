package com.huda.submission_2_made


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movies.*

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

    private val list = ArrayList<RootData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_movies.setHasFixedSize(true)
        list.addAll(getListMovies())
        rv_movies.layoutManager = LinearLayoutManager(activity)
        val listMovieAdapter = ListMoviesAdapter(list)
        rv_movies.adapter = listMovieAdapter

        listMovieAdapter.setOnItemClickCallback(object : ListMoviesAdapter.OnItemClickCallback {
            override fun onItemClicked(data: RootData) {
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_FILM, data)
                startActivity(intent)
            }
        })
    }

    fun getListMovies(): ArrayList<RootData> {
        val dataName = resources.getStringArray(R.array.data_name_movies)
        val dataDescription = resources.getStringArray(R.array.data_description_movies)
        val dataPhoto = resources.getStringArray(R.array.data_photo_movies)
        val listMovies = ArrayList<RootData>()
        for (position in dataName.indices) {
            val movies = RootData(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listMovies.add(movies)
        }
        return listMovies
    }
}
