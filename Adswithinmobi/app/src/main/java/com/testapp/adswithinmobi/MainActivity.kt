package com.testapp.adswithinmobi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inmobi.sdk.InMobiSdk
import com.inmobi.sdk.SdkInitializationListener
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private val TAG = "InMobiIntegration"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeInMobiSDK()
    }

    private fun initializeInMobiSDK() {
        try {
            // Create a consent object if GDPR applies
            val consentObject = JSONObject()
            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true)
            consentObject.put("gdpr", "0")
            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_IAB, "<< consent in IAB format >>")
            InMobiSdk.setIsAgeRestricted(false)

            // Set demographic signals
            InMobiSdk.setGender(InMobiSdk.Gender.MALE)
            InMobiSdk.setAge(25) // Replace with the actual age of the user
            InMobiSdk.setAgeGroup(InMobiSdk.AgeGroup.BETWEEN_18_AND_24) // Choose the appropriate age group

            // Initialize InMobi SDK
            InMobiSdk.init(this, "1e1d03f3f9ce47a3afe48f906e76ad0e", consentObject, object :
                SdkInitializationListener {
                override fun onInitializationComplete(error: Error?) {
                    if (error != null) {
                        Log.e(TAG, "InMobi Init failed - ${error.message}")
                    } else {
                        Log.d(TAG, "InMobi Init Successful")
                        // SDK initialization successful, proceed with other setup
                        // e.g., loading ads, setting up listeners, etc.
                    }
                }
            })
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}
