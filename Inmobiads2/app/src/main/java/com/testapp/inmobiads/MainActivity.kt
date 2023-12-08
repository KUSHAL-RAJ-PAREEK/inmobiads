package com.testapp.inmobiads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.inmobi.sdk.InMobiSdk
import com.inmobi.sdk.SdkInitializationListener
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val consentObject = JSONObject()
        try {
            // Provide correct consent value to sdk which is obtained by User
            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true)
            // Provide 0 if GDPR is not applicable and 1 if applicable
            consentObject.put("gdpr", "0")
            // Provide user consent in IAB format

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        InMobiSdk.init(
            this,
            "1e1d03f3f9ce47a3afe48f906e76ad0e",
            consentObject,
            SdkInitializationListener() {
                @Override
                fun onInitializationComplete(error: Error?) {
                    if (null != error) {
                        Log.e("ok", "InMobi Init failed -" + error.message.toString())
                    } else {
                        Log.d("ok", "InMobi Init Successful")
                    }
                }
            })
    }
}