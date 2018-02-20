package com.mobapptuts.kotlinfragmentsharing

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [VideoIntentFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [VideoIntentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoIntentFragment : Fragment() {

    private var videoUriListener: OnFragmentVideoUriListener? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_video_intent, container, false)
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
