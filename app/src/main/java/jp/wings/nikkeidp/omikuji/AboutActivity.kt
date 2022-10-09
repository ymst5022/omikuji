package jp.wings.nikkeidp.omikuji

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jp.wings.nikkeidp.omikuji.databinding.AboutBinding

class AboutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val aboutBinding = AboutBinding.inflate(layoutInflater)
        setContentView(aboutBinding.root)

        val info = packageManager.getPackageInfo(packageName,0)
        aboutBinding.textView2.text = "Version " + info.versionName
    }
}