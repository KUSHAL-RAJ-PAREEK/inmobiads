package com.testapp.adsintegration

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import com.inmobi.ads.InMobiBanner
import com.inmobi.sdk.InMobiSdk
import com.inmobi.sdk.SdkInitializationListener
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InMobiSdk.init(this, "1e1d03f3f9ce47a3afe48f906e76ad0e")
//        InMobiSdk.init(this, "1e1d03f3f9ce47a3afe48f906e76ad0e")
//
//        // Assuming you have a LinearLayout in your activity's layout with ID "adContainer"
//        val adContainer: LinearLayout = findViewById(R.id.adcontainer)
//        val banner = InMobiBanner(this, 1703867233627)
//
//        adContainer.addView(banner)
//
//        // Load the ad
//        banner.load()
//sdk initilize

        val consentObject = JSONObject()
        try {
            // Provide correct consent value to sdk which is obtained by User
            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true)
            // Provide 0 if GDPR is not applicable and 1 if applicable
            consentObject.put("gdpr", "0")
            // Provide user consent in IAB format
//            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_IAB, “ << consent in IAB format >> ”)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        InMobiSdk.init(this, "1e1d03f3f9ce47a3afe48f906e76ad0e", consentObject,  SdkInitializationListener() {
            @Override
            fun onInitializationComplete(error : Error?) {
                if (null != error) {
                    Log.e("okayfine123", "InMobi Init failed -" + error.message.toString())
                } else {
                    Log.d("okayfine123", "InMobi Init Successful")
                }
            }
        })
    }
}