package com.kotlinrecyclerview.retrofit

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Amit Agnihotri on 8/28/2018.
 */
class MainActivity : AppCompatActivity() {
    lateinit var pDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClick.setOnClickListener(View.OnClickListener {
            DisplayProgressDialog()
            callWebService()
        })
    }

    fun callWebService() {
        val apiService = ApiInterface.create()
        val call = apiService.getCategoryDetails()
        Log.d("REQUEST", call.toString() + "")
        call.enqueue(object : Callback<CategoryResponse> {
            override fun onResponse(call: Call<CategoryResponse>, response: retrofit2.Response<CategoryResponse>?) {
                if (response != null) {
                    if (pDialog != null && pDialog!!.isShowing()) {
                        pDialog.dismiss()
                    }
                    var list: List<Category> = response.body().categories!!
                    Log.d("MainActivity", "" + list.size)
                    var msg: String = ""
                    for (item: Category in list.iterator()) {
                        msg = msg + item.title + "\n"
                    }
                    Toast.makeText(this@MainActivity, "List of Category  \n  " + msg, Toast.LENGTH_LONG).show()
                    txtDisplay.setText(msg + "")
                }

            }

            override fun onFailure(call: Call<CategoryResponse>, t: Throwable) {
                //                Log.e(TAG, t.toString());
                if (pDialog != null && pDialog.isShowing()) {
                    pDialog.dismiss()
                }
            }
        })
    }

    fun DisplayProgressDialog() {
        pDialog = ProgressDialog(this@MainActivity)
        pDialog!!.setMessage("Loading..")
        pDialog!!.setCancelable(false)
        pDialog!!.isIndeterminate = false
        pDialog!!.show()
    }
}
