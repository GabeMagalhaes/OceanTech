package com.example.oceantech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.oceantech.databinding.ActivityMainBinding
import com.example.oceantech.models.Report
import com.example.oceantech.webservices.ReportConnection
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        binding.btMembers.setOnClickListener {
            val intent = Intent(this@MainActivity, MembersActivity::class.java)
            startActivity(intent)
        }

        auth = Firebase.auth



        /* private fun searchReport(id: String){

            val callback = object : Callback<Report> {
                override fun onResponse(call: Call<Report>, response: Response<Report>) {
                    val report = response.body()!!


                }

                override fun onFailure(call: Call<Report>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Error on finding the Report", Toast.LENGTH_SHORT).show()
                }

            }

            ReportConnection().reportService.getReport(id).enqueue(callback)

        }
        */
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload();
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }

    private fun sendEmailVerification() {
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
            }
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    private fun reload() {
        
    }

    companion object {
        private const val TAG = "EmailPassword"
    }

}