package com.mobapptuts.kotlinfragmentsharing

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class VideoIntentFragment : Fragment() {

    private var videoUri: Uri? = null
    private val VIDEO_APP_REQUEST_CODE = 1000

    private var videoUriListener: OnFragmentVideoUriListener? = null

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

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentVideoUriListener) {
            videoUriListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        videoUriListener = null
    }

    interface OnFragmentVideoUriListener {
        fun onFragmentVideoUri(uri: Uri)
    }

    companion object {
        val TAG = VideoIntentFragment::class.qualifiedName
        @JvmStatic fun newInstance() = VideoIntentFragment()
    }
}
