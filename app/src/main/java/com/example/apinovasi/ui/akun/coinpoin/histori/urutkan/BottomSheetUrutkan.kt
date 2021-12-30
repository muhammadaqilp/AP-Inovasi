package com.example.apinovasi.ui.akun.coinpoin.histori.urutkan

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.LinearLayout
import android.widget.Spinner
import com.example.apinovasi.R
import com.example.apinovasi.databinding.BottomsheetUrutkanBinding
import com.example.apinovasi.utils.DataDummy
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetUrutkan : BottomSheetDialogFragment(), CustomSpinner.OnSpinnerEventsListener {

    private lateinit var binding: BottomsheetUrutkanBinding
//    private lateinit var popupWindow: PopupWindow

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomsheetUrutkanBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

//    dialog.setOnShowListener(new DialogInterface.OnShowListener() {
//        @Override
//        public void onShow(DialogInterface dialog) {
//
//            // In a previous life I used this method to get handles to the positive and negative buttons
//            // of a dialog in order to change their Typeface. Good ol' days.
//
//            BottomSheetDialog d = (BottomSheetDialog) dialog;
//
//            // This is gotten directly from the source of BottomSheetDialog
//            // in the wrapInBottomSheet() method
//            FrameLayout bottomSheet = (FrameLayout) d.findViewById(android.support.design.R.id.design_bottom_sheet);
//
//            // Right here!
//            BottomSheetBehavior.from(bottomSheet)
//                .setState(BottomSheetBehavior.STATE_EXPANDED);
//        }
//    });

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
//        val height = this.resources.displayMetrics.heightPixels
//        dialog.behavior.peekHeight = (height / 3)
//        return dialog
//    }

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        val dialog = super.onCreateDialog(savedInstanceState)
//
//        dialog.setOnShowListener {
//            val displayMetrics = requireActivity().resources.displayMetrics
//            val height = displayMetrics.heightPixels
//            val maxHeight = (height * 0.8).toInt()
//            BottomSheetBehavior.from(dialog.findViewById(com.google.android.material.R.id.linear))
//                .setPeekHeight(maxHeight)
//        }
//
//        return dialog
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        BottomSheetBehavior.from(binding.linear).peekHeight = ViewGroup.LayoutParams.MATCH_PARENT

        val adpt = FiltAdapter(requireContext())
        adpt.setList(DataDummy.generateFilterUrutkan())

        binding.spinnerUrutkan.setSpinnerEventsListener(this)
        binding.spinnerUrutkan.adapter = adpt
//        binding.ly1.setOnClickListener {
//            binding.ivArrow.animate().rotationBy(180F).setDuration(500).start()
//            expand(binding.btnTerlama)
//            binding.btnTerkecil.visibility = View.VISIBLE
//        }

//        binding.spinnerUrutkan.setOnClickListener{
//            popupWindow?.dismiss()
//
//            if (popupWindow == null) {
//                provideCountryPopupWindow(it)
//            }
//            popupWindow!!.showAsDropDown(it, 0, -it.height)
//        }

        binding.btnTerapkan.setOnClickListener { dismiss() }
    }

//    private fun provideCountryPopupWindow(it: View) {
//        popupWindow = PopupWindow(it.width, ViewGroup.LayoutParams.WRAP_CONTENT)
//            .apply {
//                val backgroundDrawable = requireActivity().getDrawable(
//                    R.drawable.bg_blueradius_white)
//                    .apply {  }
//                setBackgroundDrawable(backgroundDrawable)
//                isOutsideTouchable = true
//                val listView = layoutInflater.inflate(
//                    R.layout.layout_country_dropdown,
//                    null,
//                    false) as ListView
//                listView.adapter = countryAdapter
//                listView.setOnItemClickListener { _, _, position, _ ->
//                    val selectedCountry = countryAdapter.getItem(position)!!
//                    viewModel.setLegalCountry(selectedCountry)
//                    popupWindow?.dismiss()
//                }
//                contentView = listView
//            }
//    }

    private fun expand(v: View) {
        if (v.visibility == View.VISIBLE) return
        val durations: Long
        val matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(
            (v.parent as View).width,
            View.MeasureSpec.EXACTLY
        )
        val wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(
            0,
            View.MeasureSpec.UNSPECIFIED
        )
        v.measure(matchParentMeasureSpec, wrapContentMeasureSpec)
        val targetHeight = v.measuredHeight

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.layoutParams.height = 1
        v.visibility = View.VISIBLE
        durations = ((targetHeight / v.context.resources
            .displayMetrics.density)).toLong()

        v.alpha = 0.0F
        v.visibility = View.VISIBLE
        v.animate().alpha(1.0F).setDuration(durations).setListener(null)

        val a: Animation = object : Animation() {
            override fun applyTransformation(
                interpolatedTime: Float,
                t: Transformation
            ) {
                v.layoutParams.height =
                    if (interpolatedTime == 1f) LinearLayout.LayoutParams.WRAP_CONTENT else (targetHeight * interpolatedTime).toInt()
                v.requestLayout()
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        // Expansion speed of 1dp/ms
        a.duration = durations
        v.startAnimation(a)
    }

    fun collapse(v: View) {
        if (v.visibility == View.GONE) return
        val durations: Long
        val initialHeight = v.measuredHeight
        val a: Animation = object : Animation() {
            override fun applyTransformation(
                interpolatedTime: Float,
                t: Transformation
            ) {
                if (interpolatedTime == 1f) {
                    v.visibility = View.GONE
                } else {
                    v.layoutParams.height =
                        initialHeight - (initialHeight * interpolatedTime).toInt()
                    v.requestLayout()
                }
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        durations = (initialHeight / v.context.resources
            .displayMetrics.density).toLong()

        v.alpha = 1.0F
        v.animate().alpha(0.0F).setDuration(durations)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    v.visibility = View.GONE
                    v.alpha = 1.0F
                }
            })

        // Collapse speed of 1dp/ms
        a.duration = durations
        v.startAnimation(a)
    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    override fun onPopupWindowOpened(spinner: Spinner?) {
        binding.ivArrow.animate().rotationBy(180F).setDuration(500).start()
    }

    override fun onPopupWindowClosed(spinner: Spinner?) {
        binding.ivArrow.animate().rotationBy(180F).setDuration(500).start()
    }
}