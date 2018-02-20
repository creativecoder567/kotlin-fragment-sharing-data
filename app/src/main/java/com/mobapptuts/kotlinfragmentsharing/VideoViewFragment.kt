package com.mobapptuts.kotlinfragmentsharing


import android.arch.lifecycle.ViewModelProviders
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

    private val videoUriViewModel by lazy {
        ViewModelProviders.of(activity).get(VideoUriViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        if (videoUriViewModel.videoUri != null) {
            videoView.setVideoURI(videoUriViewModel.videoUri)
            videoView.start()
        }
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
        @JvmStatic fun newInstance() = VideoViewFragment()
    }

}
