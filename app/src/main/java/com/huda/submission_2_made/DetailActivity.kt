package com.huda.submission_2_made

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FILM = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra(EXTRA_FILM) as? RootData

        tv_item_name_detail.text = data?.name
        tv_item_description_detail.text = data?.description
        Glide.with(this).load(data?.photo).override(1000, 1000).into(img_item_photo_detail)

    }
}
