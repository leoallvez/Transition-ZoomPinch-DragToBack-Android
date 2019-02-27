package example.com.zoompinch.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.content.Intent
import android.os.Build
import android.view.View
import android.widget.ImageView
import example.com.zoompinch.R
import example.com.zoompinch.R.layout.*
import example.com.zoompinch.R.string.*
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        loadImage(photoOne)
        photoOne.setOnClickListener{ view ->
            onClick(view)
        }

        loadImage(photoTwo)
        photoTwo.setOnClickListener{ view ->
            onClick(view)
        }
    }

    private fun loadImage(imageView: ImageView) {
        Glide.with(this)
            .load(getString(R.string.img_url))
            .into(imageView);
    }

    private fun transition(view: View, url: String, id: String) {
        val intent = Intent(this, ZoomPichActivity::class.java)
        intent.putExtra("url", url)
        intent.putExtra("id", id)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ViewCompat.setTransitionName(view, id)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, id)
            startActivity(intent, options.toBundle())
        } else {
            startActivity(intent)
        }
    }

    private fun onClick(view: View) {
        transition(view, getString(example.com.zoompinch.R.string.img_url), getString(example.com.zoompinch.R.string.transition))
    }
}
