package com.root14.chucknorrisjokes.utils

import android.content.Context
import android.util.Log
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class AdHelper {

    companion object {
        private var rewardedAd: RewardedAd? = null
        fun awardedAd(context: Context): RewardedAd? {
            val adRequest = AdRequest.Builder().build()
            RewardedAd.load(
                context,
                "ca-app-pub-3760820713270793/6226953885",
                adRequest,
                object : RewardedAdLoadCallback() {
                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        Log.d("norris award ad", adError.toString())
                        rewardedAd = null
                    }

                    override fun onAdLoaded(ad: RewardedAd) {
                        Log.d("norris award ad", "Ad was loaded.")
                        rewardedAd = ad
                    }
                })
            return rewardedAd
        }
    }
}