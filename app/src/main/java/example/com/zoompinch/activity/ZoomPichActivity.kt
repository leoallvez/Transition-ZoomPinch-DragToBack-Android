package example.com.zoompinch.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import example.com.zoompinch.R.layout.*
import example.com.zoompinch.R.anim.*
import example.com.zoompinch.widget.FrameTouch
import kotlinx.android.synthetic.main.activity_zoom_pich.*
import android.content.Intent
import android.support.v4.view.ViewCompat
import uk.co.senab.photoview.PhotoViewAttacher

class ZoomPichActivity : AppCompatActivity(), FrameTouch.FrameOnTouch {

    //https://medium.com/android-dev-br/transi%C3%A7%C3%A3o-zoom-pinch-e-drag-to-back-de-imageview-f359556a1671
    var mAttacher: PhotoViewAttacher? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_zoom_pich)
        overridePendingTransition(enter_anim, enter_anim)

        val intent = intent
        val imgUrl = intent.getStringExtra("url")
        val id = intent.getStringExtra("id")

        ViewCompat.setTransitionName(photo, id)

    }

    override fun onFrameTouchUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onScrollMovie(x: Float, y: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
