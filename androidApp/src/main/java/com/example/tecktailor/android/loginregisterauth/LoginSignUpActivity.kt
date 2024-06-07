package com.example.tecktailor.android.loginregisterauth


import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.tecktailor.android.R
import com.example.tecktailor.android.databinding.ActivityLoginSignUpBinding
import com.example.tecktailor.android.onboarding.PlaceHolderAdapter
import com.example.tecktailor.android.onboarding.SectionsPagerAdapter
import com.example.tecktailor.utils.Common
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.io.IOException

class LoginSignUpActivity : AppCompatActivity() {
//    private val firebaseConfigViewModel: FirebaseConfigViewModel by viewModel()
    private lateinit var binding: ActivityLoginSignUpBinding
    private lateinit var viewAdapter: PlaceHolderAdapter
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
//    private val sharedPrefs: SharedPrefs by inject()
//    private val stateViewModel: StateViewModel by viewModel()
    private var selectedAudioUrl: String? = null
    var mp: MediaPlayer? = null
    var mute = false
    private var activityRunning = false

    private val autoScrollHandler = Handler()
    private val autoScrollRunnable = object : Runnable {
        override fun run() {
            val currentItem = binding.viewPager.currentItem
            val totalItems = binding.viewPager.adapter?.count ?: 0
            val nextItem = (currentItem + 1) % totalItems
            binding.viewPager.currentItem = nextItem
            autoScrollHandler.postDelayed(this, AUTO_SCROLL_DELAY)
        }
    }

    companion object {
        private const val AUTO_SCROLL_DELAY = 3000L

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        FirebaseApp.initializeApp(this)
//        auth = FirebaseAuth.getInstance()
        binding = ActivityLoginSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize viewAdapter and viewPager here
        viewAdapter = PlaceHolderAdapter(this, supportFragmentManager, Common.getIntroImages().size)
        binding.viewPager.adapter = viewAdapter
        initUI()

//        if (sharedPrefs.getLanguageCode().isEmpty()) launchLanguageSelection()
//        InstallReferralHelper(this, object : CallbackListener<InstallReferral> {
//            override fun setObject(value: InstallReferral) {
//                stateViewModel.installReferral = value
//            }
//        })

//        fetchLandingConfig()

        binding.tvSignUp.setOnClickListener {
//            showBottomSheet(shouldShowSignUp = true)
        }

        binding.btnSignInWithGmail.setOnClickListener {
//            showBottomSheet(shouldShowSignUp = false)
        }

        binding.imglanguage.setOnClickListener {
//            launchLanguageSelection()
        }

//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.web_client_id)).requestEmail().build()
//        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.btnSignInWithGoogle.setOnClickListener {
//            val signInIntent = googleSignInClient.signInIntent
//            launcher.launch(signInIntent)
        }

        binding.volumeButton.setOnClickListener {
            if (mute) {
                binding.mute.setImageResource(R.drawable.ic_volume_up)
                mp?.start()
            } else {
                binding.mute.setImageResource(R.drawable.ic_volume_off)
                mp?.pause()
            }
            mute = !mute
        }

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.main_navigation) as? NavHostFragment
//        navHostFragment?.let {
//            val navController = it.navController
//            navController.addOnDestinationChangedListener { _, destination, _ ->
//                if (destination.id == R.id.btn_sign_In_with_google) {
//                    val signInIntent = googleSignInClient.signInIntent
//                    launcher.launch(signInIntent)
//                }
//            }
//        }
    }

//    private fun launchLanguageSelection() {
//        val bottomSheetFragment = SelectLanguageFragment()
//        bottomSheetFragment.setClickEvent(object : LanguageClick {
//            override fun onLanguageClick(languageSel: LanguageSel) {
//                if (stateViewModel.landingConfig.isNullOrEmpty().not()) {
//                    val audioConfig =
//                        stateViewModel.landingConfig?.find { it.languageCode.equals(languageSel.code) }
//                    selectedAudioUrl = if (audioConfig == null) {
//                        stateViewModel.landingConfig?.first()?.welcome_audio
//                    } else {
//                        audioConfig.welcome_audio
//                    }
//                    playAudio()
//                }
//                relaunchActivity()
//            }
//
//        })
//        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
//    }

//    private fun fetchLandingConfig() {
//        lifecycle.coroutineScope.launch {
//            firebaseConfigViewModel.landingConfig.collect { data ->
//                if (data.data.isNullOrEmpty().not()) {
//                    Log.d(
//                        "DebuggingCode: ",
//                        "firebaseConfigViewModel.landingConfig: " + Gson().toJson(data.data)
//                    )
////                    stateViewModel.landingConfig = data.data
//                    selectedAudioUrl =
//                        data.data?.find { it.languageCode.equals("en") }?.welcome_audio
//                    playAudio()
//                }
//            }
//        }
//    }

    private fun relaunchActivity() {
        val intent = Intent(this, LoginSignUpActivity::class.java)
        finish()
        startActivity(intent)
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                if (task.isSuccessful) {
                    val account = task.result
                    val idToken = account.idToken
                    updateUI(account)
//                googleSignInViewModel.signInWithGoogle(Intent().apply { putExtra("idToken", idToken,)
//                }.toString())
                } else {
                    Toast.makeText(this, "Google Sign-In Failed", Toast.LENGTH_SHORT).show()
                }
            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Google Sign-In Canceled", Toast.LENGTH_SHORT).show()
            }
        }


    private fun updateUI(account: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "Google Sign-In Successful", Toast.LENGTH_SHORT).show()
//                navigateToHomeScreen()
            } else {
                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }


//    private fun navigateToHomeScreen() {
//        if (activityRunning) {
//            val intent = Intent(this, BusinessActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }

//    private fun handleResults(task: Task<GoogleSignInAccount>) {
//        if (task.isSuccessful){
//            val account : GoogleSignInAccount? = task.result
//            if (account != null){
//                updateUI(account)
//            }
//        }else{
//            Toast.makeText(this, task.exception.toString() , Toast.LENGTH_SHORT).show()
//        }
//        val intent = Intent(this, LoginSignUpActivity::class.java)
//        startActivity(intent)
//        finish()
//    }

//    private fun showBottomSheet(shouldShowSignUp: Boolean = false) {
//        val bottomSheetFragment = LoginSignupBottomSheetFragment()
//        bottomSheetFragment.setVisibilityState(shouldShowSignUp)
//        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
//    }

    private fun initUI() {
        val sectionsPagerAdapter = SectionsPagerAdapter(
            applicationContext,
            supportFragmentManager,
            Common.getIntroImages().size
        )
        binding.viewPager.adapter = sectionsPagerAdapter

        mp = MediaPlayer()
    }

    private fun playAudio() {
        mp?.stop()
        try {
            mp?.setDataSource(selectedAudioUrl)
            mp?.prepareAsync()
            mp?.setOnPreparedListener {
                mp?.start()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun onResume() {
        super.onResume()
        activityRunning = true
        startAutoScroll()
    }

    override fun onPause() {
        super.onPause()
        activityRunning = false
        stopAutoScroll()
        mp?.pause()
    }

    private fun startAutoScroll() =
        autoScrollHandler.postDelayed(autoScrollRunnable, AUTO_SCROLL_DELAY)

    private fun stopAutoScroll() =
        autoScrollHandler.removeCallbacks(autoScrollRunnable)

}