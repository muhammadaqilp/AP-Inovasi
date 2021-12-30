package com.example.apinovasi.utils

import com.example.apinovasi.R
import com.example.apinovasi.data.*
import com.example.apinovasi.ui.akun.coinpoin.histori.urutkan.ItemUrutkanEnt

object DataDummy {
    fun generateAksesPremiumData(): List<AksesPremiumEntity> {
        val aksesPremium = ArrayList<AksesPremiumEntity>()

        aksesPremium.add(
            AksesPremiumEntity(
                "1",
                "Try Out Premium 1x",
                "Aku Pintar",
                "500 AP Coin",
                R.drawable.dummy_aksespremium_1
            )
        )
        aksesPremium.add(
            AksesPremiumEntity(
                "2",
                "AP Konseling 1x",
                "Aku Pintar",
                "1500 AP Coin",
                R.drawable.dummy_aksespremium_2
            )
        )
        aksesPremium.add(
            AksesPremiumEntity(
                "3",
                "AP Konseling 3x",
                "Aku Pintar",
                "2500 AP Coin",
                R.drawable.dummy_aksespremium_3
            )
        )

        return aksesPremium
    }

    fun generateVoucherData(): List<VoucherEntity> {
        val voucher = ArrayList<VoucherEntity>()

        voucher.add(
            VoucherEntity(
                "1",
                "Gramedia Rp10.000 Voucher",
                "Gramedia",
                "1000 AP Poin",
                "1000 AP Coin",
                R.drawable.dummy_voucher_1
            )
        )
        voucher.add(
            VoucherEntity(
                "2",
                "Gramedia Rp25.000 Voucher",
                "Gramedia",
                "2500 AP Poin",
                "2500 AP Coin",
                R.drawable.dummy_voucher_2
            )
        )
        voucher.add(
            VoucherEntity(
                "3",
                "Gramedia Rp50.000 Voucher",
                "Gramedia",
                "5000 AP Poin",
                "5000 AP Coin",
                R.drawable.dummy_voucher_3
            )
        )
        voucher.add(
            VoucherEntity(
                "4",
                "25% OFF For All Programs",
                "Lembaga Bahasa LIA",
                "5000 AP Poin",
                "1000 AP Coin",
                R.drawable.dummy_voucher_4
            )
        )

        return voucher
    }

    fun generateFilterUrutkan(): List<ItemUrutkanEnt> {
        val urut = ArrayList<ItemUrutkanEnt>()

        urut.add(
            ItemUrutkanEnt(
                "1",
                "Terbaru"
            )
        )

        urut.add(
            ItemUrutkanEnt(
                "2",
                "Terlama"
            )
        )

        urut.add(
            ItemUrutkanEnt(
                "3",
                "Jumlah Terbesar"
            )
        )

        urut.add(
            ItemUrutkanEnt(
                "4",
                "Jumlah Terkecil"
            )
        )

        return urut
    }

    fun generateBenefitSiswa(): BenefitEntity {
        return BenefitEntity(
            "Jelajah Fitur Gratis",
            "Kamu bisa jelajahi Aku Pintar dan nikmati banyak fitur gratisnya",
            R.drawable.ic_jelajahi
        )
    }

    fun generateBenefitBintang(): List<BenefitEntity> {
        val benefit = ArrayList<BenefitEntity>()

        benefit.add(
            BenefitEntity(
                "AP Poin",
                "Dapatkan 1000 AP Poin",
                R.drawable.ic_ap_poin_2
            )
        )

        benefit.add(
            BenefitEntity(
                "Akses Konten Premium",
                "Nikmati juga konten premium pilihan untukmu",
                R.drawable.ic_konten
            )
        )

        benefit.add(
            BenefitEntity(
                "Akses Webinar Gratis",
                "Akses satu kali webinar secara gratis",
                R.drawable.ic_webinar
            )
        )

        benefit.add(
            BenefitEntity(
                "Diskon Konseling Pintar",
                "Dapatkan diskon 10% untuk fitur Konseling Pintar ",
                R.drawable.ic_konseling
            )
        )

        return benefit
    }

    fun generateBenefitBerprestasi(): List<BenefitEntity> {
        val benefit = ArrayList<BenefitEntity>()

        benefit.add(
            BenefitEntity(
                "AP Poin",
                "Dapatkan 2500 AP Poin",
                R.drawable.ic_ap_poin_2
            )
        )

        benefit.add(
            BenefitEntity(
                "Akses Konten Premium",
                "Nikmati juga konten premium pilihan untukmu",
                R.drawable.ic_konten
            )
        )

        benefit.add(
            BenefitEntity(
                "Akses Webinar Gratis",
                "Akses dua kali webinar secara gratis",
                R.drawable.ic_webinar
            )
        )

        benefit.add(
            BenefitEntity(
                "Diskon Konseling Pintar",
                "Dapatkan potongan 20% untuk satu kali transaksi Konseling Pintar",
                R.drawable.ic_konseling
            )
        )

        benefit.add(
            BenefitEntity(
                "Voucher Kursus Pintar",
                "Nikmati Kursus Pintar dengan voucher diskon senilai Rp10.000",
                R.drawable.ic_kursus
            )
        )

        benefit.add(
            BenefitEntity(
                "Akses Tryout Premium Gratis",
                "Akses dua kali Tryout secara gratis",
                R.drawable.ic_try_out
            )
        )

        return benefit
    }

    fun generateBenefitJuara(): List<BenefitEntity> {
        val benefit = ArrayList<BenefitEntity>()

        benefit.add(
            BenefitEntity(
                "AP Poin",
                "Dapatkan 4000 AP Poin",
                R.drawable.ic_ap_poin_2
            )
        )

        benefit.add(
            BenefitEntity(
                "Akses Konten Premium",
                "Nikmati juga konten premium pilihan untukmu",
                R.drawable.ic_konten
            )
        )

        benefit.add(
            BenefitEntity(
                "Akses Webinar Gratis",
                "Akses tiga kali webinar secara gratis",
                R.drawable.ic_webinar
            )
        )

        benefit.add(
            BenefitEntity(
                "Diskon Konseling Pintar",
                "Dapatkan potongan 35% untuk satu kali transaksi Konseling Pintar",
                R.drawable.ic_konseling
            )
        )

        benefit.add(
            BenefitEntity(
                "Voucher Kursus Pintar",
                "Nikmati Kursus Pintar dengan voucher diskon senilai Rp15.000",
                R.drawable.ic_kursus
            )
        )

        benefit.add(
            BenefitEntity(
                "Akses Tryout Premium Gratis",
                "Akses tiga kali Tryout secara gratis",
                R.drawable.ic_try_out
            )
        )

        return benefit
    }

    fun generateListChallenge(): List<ChallengeEntity> {
        val challenge = ArrayList<ChallengeEntity>()

        challenge.add(
            ChallengeEntity(
                "Tonton AP Live",
                "Minimal 2 Video AP Live",
                "1/2",
                "20",
                "10",
                R.drawable.ic_play
            )
        )

        challenge.add(
            ChallengeEntity(
                "Ikuti Ruang Pintar",
                "Mengikuti 2 Kali Ruang Pintar",
                "1/2",
                "50",
                "30",
                R.drawable.ic_watch
            )
        )

        challenge.add(
            ChallengeEntity(
                "Ikuti Acara / Webinar",
                "Mengikuti 3 kali Webinar / Event",
                "1/3",
                "150",
                "140",
                R.drawable.ic_watch
            )
        )

        challenge.add(
            ChallengeEntity(
                "Belajar Pintar",
                "Mempelajarai 3 Modul",
                "0/3",
                "70",
                "40",
                R.drawable.ic_tuntas
            )
        )

        challenge.add(
            ChallengeEntity(
                "Selesaikan Tes Pintar",
                "Menyelesaikan 1 Tes Pintar",
                "0/1",
                "90",
                "50",
                R.drawable.ic_tes
            )
        )

        challenge.add(
            ChallengeEntity(
                "Cek Minat Bakat",
                "Menyelesaikan Minimal 1 Minat Bakat",
                "0/1",
                "100",
                "100",
                R.drawable.ic_minatbakat
            )
        )

        challenge.add(
            ChallengeEntity(
                "Daftar Kursus Pintar",
                "Mendaftar 1 Kursus Pintar",
                "0/1",
                "200",
                "160",
                R.drawable.ic_watch
            )
        )

        challenge.add(
            ChallengeEntity(
                "Pelajari Mata Pelajaran",
                "Mempelajari 2 Bab Mata Pelajaran",
                "0/2",
                "260",
                "180",
                R.drawable.ic_tuntas
            )
        )

        return challenge
    }

    fun generateWordTranslate(): List<GamesWordEntity>{
        val word = ArrayList<GamesWordEntity>()

        word.add(
            GamesWordEntity("1","algebra")
        )

        word.add(
            GamesWordEntity("2","can be")
        )

        word.add(
            GamesWordEntity("3","useful")
        )

        word.add(
            GamesWordEntity("4","way")
        )

        word.add(
            GamesWordEntity("5","about")
        )

        word.add(
            GamesWordEntity("6","things")
        )

        word.add(
            GamesWordEntity("7","of thinking")
        )

        word.add(
            GamesWordEntity("8","benefical")
        )

        word.add(
            GamesWordEntity("9","easy")
        )

        word.add(
            GamesWordEntity("10","can")
        )

        word.add(
            GamesWordEntity("11","anythings")
        )

        word.add(
            GamesWordEntity("12","how")
        )

        word.add(
            GamesWordEntity("13","implification")
        )

        word.add(
            GamesWordEntity("14","of")
        )

        return word
    }
}