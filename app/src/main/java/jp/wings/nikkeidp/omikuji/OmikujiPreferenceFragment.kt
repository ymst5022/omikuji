package jp.wings.nikkeidp.omikuji

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class OmikujiPreferenceFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preference)
    }
}