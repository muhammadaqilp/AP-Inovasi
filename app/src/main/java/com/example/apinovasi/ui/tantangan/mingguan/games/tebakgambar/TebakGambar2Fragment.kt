package com.example.apinovasi.ui.tantangan.mingguan.games.tebakgambar

import android.app.Dialog
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.apinovasi.R
import com.example.apinovasi.databinding.DialogConfirmationClueBinding
import com.example.apinovasi.databinding.FragmentTebakGambar2Binding
import com.example.apinovasi.ui.tantangan.mingguan.games.CheckButton
import com.example.apinovasi.utils.showCustomToast

class TebakGambar2Fragment : Fragment() {

    private var _binding: FragmentTebakGambar2Binding? = null
    private val binding get() = _binding!!
    private lateinit var timer: CountDownTimer
    private lateinit var listener: CheckButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTebakGambar2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener = activity as CheckButton

        startTimer(20000)

        binding.btnClue.setOnClickListener { showDialog() }
        with(binding) {
            edtJawaban.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    if (p0 != null) {
                        if (p0.isNotEmpty()) {
                            listener.onButtonActive(true, p0.toString())
                        } else {
                            listener.onButtonActive(false, p0.toString())
                        }
                    }
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }
            })
        }
    }

    private fun startTimer(time: Long) {
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(time: Long) {
                val secondsInMilli: Long = 1000
                val elapsedSeconds = time / secondsInMilli

                binding.tvTimer.text =
                    resources.getString(R.string.txt_timer, elapsedSeconds)
                if (elapsedSeconds <= 5) {
                    binding.tvTimer.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.red
                        )
                    )
                }
            }

            override fun onFinish() {
                binding.tvTimer.text = resources.getString(R.string.txt_waktu_habis)
            }
        }
        timer.start()
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        val binding1 = DialogConfirmationClueBinding.inflate(layoutInflater)
        val window = dialog.window
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding1.root)
        dialog.setCancelable(false)

        binding1.btnTutup.setOnClickListener { dialog.dismiss() }
        binding1.btnYakin.setOnClickListener {
            timer.cancel()
            startTimer(20000)
            Toast(context).showCustomToast(
                "Waktu telah ditambahkan dan hint telah muncul", requireActivity()
            )
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        if (::timer.isInitialized) {
            timer.cancel()
        }
    }
}