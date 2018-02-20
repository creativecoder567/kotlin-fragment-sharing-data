package com.mobapptuts.kotlinfragmentsharing

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_video_intent.*


class VideoIntentFragment : Fragment() {

    private var videoUri: Uri? = null
    private val VIDEO_APP_REQUEST_CODE = 1000

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_video_intent, container, false)
    }

    private fun callVideoApp() {
        val videoCaptureIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        if (videoCaptureIntent.resolveActivity(activity.packageManager) != null) {
            startActivityForResult(videoCaptureIntent, VIDEO_APP_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            VIDEO_APP_REQUEST_CODE -> {
                if (resultCode == RESULT_OK)
                    videoUri = data?.data
            }
            else -> Log.e(TAG, "Unrecognized request code $requestCode")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recordButton.setOnClickListener {
            callVideoApp()
        }

        playButton.setOnClickListener {
            // Using the ViewModel to pass the videoUri
        }
    }

    companion object {
        val TAG = VideoIntentFragment::class.qualifiedName
        @JvmStatic fun newInstance() = VideoIntentFragment()
    }
}
