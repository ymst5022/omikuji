package jp.wings.nikkeidp.omikuji

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OmikujiPreferenceActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(android.R.id.content, OmikujiPreferenceFragment())
        fragmentTransaction.commit()
    }
}