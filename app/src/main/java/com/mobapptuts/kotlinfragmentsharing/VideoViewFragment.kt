package com.mobapptuts.kotlinfragmentsharing


import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_video_view.*


/**
 * A simple [Fragment] subclass.
 * Use the [VideoViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VideoViewFragment : Fragment() {

    private var videoUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            videoUri = arguments.getParcelable(VID_URI)
        }
    }

    override fun onStart() {
        super.onStart()

        videoView.setVideoURI(videoUri)
        videoView.start()
    }

    override fun onPause() {
        super.onPause()

        videoView.pause()
    }

    override fun onStop() {
        videoView.stopPlayback()

        super.onStop()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_video_view, container, false)
    }

    companion object {
        private val TAG = VideoIntentFragment::class.qualifiedName
        private val VID_URI = "videoUri"

        fun newInstance(uri: Uri): VideoViewFragment {
            val fragment = VideoViewFragment()
            val args = Bundle()
            args.putParcelable(VID_URI, uri)
            fragment.arguments = args
            return fragment
        }
    }

}
