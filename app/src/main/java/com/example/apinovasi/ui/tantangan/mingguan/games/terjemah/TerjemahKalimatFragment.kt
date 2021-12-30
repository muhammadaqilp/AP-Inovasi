package com.example.apinovasi.ui.tantangan.mingguan.games.terjemah

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.apinovasi.R
import com.example.apinovasi.data.GamesWordEntity
import com.example.apinovasi.databinding.FragmentTerjemahKalimatBinding
import com.example.apinovasi.ui.tantangan.mingguan.games.CheckButton
import com.example.apinovasi.utils.DataDummy
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class TerjemahKalimatFragment : Fragment() {

    private var _binding: FragmentTerjemahKalimatBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: CheckButton

    //    private lateinit var chip: Chip
    private var listSelected = ArrayList<GamesWordEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTerjemahKalimatBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener = context as CheckButton

        val data = DataDummy.generateWordTranslate()
        val itemData = ArrayList<GamesWordEntity>()
        itemData.addAll(data)

        for (item in itemData) chipMaker(item, binding.wordChips)

        binding.btnClue.setOnClickListener {
            listener.onButtonActive(true, "LOREM IPSUM")
        }
    }

    private fun chipMaker(word: GamesWordEntity, group: ChipGroup) {
        val chip = layoutInflater.inflate(R.layout.item_chip, group, false) as Chip
        chip.text = word.word
        group.addView(chip)

        chip.setOnClickListener {
            listener.onButtonActive(true, "LOREM IPSUM")
            generateChipSelected(word, binding.selectedChips)
            binding.wordChips.removeView(it)
        }
    }

    private fun generateChipSelected(word: GamesWordEntity, group: ChipGroup) {
        val chip = layoutInflater.inflate(R.layout.item_chip, group, false) as Chip
        chip.text = word.word
        group.addView(chip)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}