package com.preetika.ussample.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import com.google.gson.Gson
import com.preetika.ussample.R
import com.preetika.ussample.model.Data
import com.preetika.ussample.response.GithubResp
import com.preetika.ussample.retrofit.GitHubCVService
import com.preetika.ussample.retrofit.GithubApiCall
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * @author Preetika KAur
 * MainActivity to call api and show data on ui
 */
class MainActivity : AppCompatActivity() {

    private var mGitHubApiCall: GithubApiCall? = null
    var result: String?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mGitHubApiCall = GitHubCVService.gitHubService
        checkPermission()

        Thread(Runnable {
            this@MainActivity.runOnUiThread(Runnable {
                getData()
            })
        }).start()

    }



    fun checkPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                    Manifest.permission.INTERNET)) {

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.INTERNET),
                    1)


            }
        } else {
            // Permission has already been granted
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }
    }



    fun getData(){
        mGitHubApiCall!!.getData().enqueue(object : Callback<GithubResp> {
            override fun onResponse(call: Call<GithubResp>, response: Response<GithubResp>) {
                if (response.isSuccessful) {
                    val msg = response.body()?.files?.cvDummyJson?.content
                    result= msg+""
                    Log.e("data", result)
                    val data= Gson().fromJson(result, Data::class.java)
                    tv_username.text= HtmlCompat.fromHtml("<u><b>"+data.data.name+"</b></u>", 0)
                    tv_summary_desc.text= data.data.summary
                    tv_username.visibility= View.VISIBLE
                    tv_summary.visibility= View.VISIBLE
                    tv_summary_desc.visibility= View.VISIBLE
                    tv_educational_bg.visibility= View.VISIBLE
                    tv_skills.visibility= View.VISIBLE
                    for (i in 0..data.data.skills.size-1) {
                        val tv_skill = TextView(this@MainActivity)
                        tv_skill.textSize =
                            this@MainActivity.resources.getDimension(R.dimen.dynamic_textsmall)

                        tv_skill.setPadding(5,5,5,5)
                        tv_skill.setTextColor(this@MainActivity.resources.getColor(R.color.black))
                        val list= listOf(data.data.skills.get(i).languages)
                        val languageData=  list.joinToString (prefix = "", separator = ",", limit = 5, postfix = "")
                        val datatext = "<b>"+data.data.skills.get(i).type+ ": </b> "+languageData.removePrefix("[").removeSuffix("]")
                        tv_skill.text = HtmlCompat.fromHtml(datatext,0)
                        lv_skills.addView(tv_skill)
                    }
                    for(i in 0..data.data.educationBg.size-1){
                        val tv_skill = TextView(this@MainActivity)
                        tv_skill.textSize =
                            this@MainActivity.resources.getDimension(R.dimen.dynamic_textsmall)

                        tv_skill.setPadding(5,5,5,5)
                        tv_skill.setTextColor(this@MainActivity.resources.getColor(R.color.black))
                        val skillset= "<b>"+data.data.educationBg.get(i).position+ "</b>"+
                                "<br><b> Majors in: </b>"+data.data.educationBg.get(i).major+
                                "<br><b>From: </b>"+
                                data.data.educationBg.get(i).from+
                                "\t\t\t\t" +
                                "<b>To: </b>" +
                                data.data.educationBg.get(i).to+
                                "<br><b>Institute Name:</b> "+
                                data.data.educationBg.get(i).instituteName
                        tv_skill.text=HtmlCompat.fromHtml(skillset,0)
                        lv_education.addView(tv_skill)
                    }
                    lv_education.visibility=View.VISIBLE
                    lv_skills.visibility= View.VISIBLE
                } else {
                    Log.e("data", "error")
                }
            }

            override fun onFailure(call: Call<GithubResp>, t: Throwable) {
                Log.e("data", "Fail to call")
                tv_username.visibility= View.GONE
                tv_summary.visibility= View.GONE
                tv_summary_desc.visibility= View.GONE
                tv_skills.visibility= View.GONE
                tv_educational_bg.visibility= View.GONE
                lv_education.visibility=View.GONE
                lv_skills.visibility= View.GONE
                tv_errormsg.visibility= View.VISIBLE
            }

        })

    }

}
