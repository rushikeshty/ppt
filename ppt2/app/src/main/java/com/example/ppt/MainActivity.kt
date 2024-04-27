//package com.example.ppt
//
//import android.annotation.SuppressLint
//import android.content.Intent
//import android.content.pm.PackageManager
//import android.net.Uri
//import android.os.Bundle
//import android.os.Environment
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ProgressBar
//import android.widget.Toast
//import androidx.annotation.NonNull
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import androidx.core.content.ContextCompat
//import androidx.core.content.FileProvider
//import com.google.api.client.auth.oauth2.Credential
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
//import com.google.api.client.googleapis.json.GoogleJsonResponseException
//import com.google.api.client.http.javanet.NetHttpTransport
//import com.google.api.client.json.JsonFactory
//import com.google.api.client.json.gson.GsonFactory
//import com.google.api.client.util.store.FileDataStoreFactory
//import com.google.api.services.slides.v1.Slides
//import com.google.api.services.slides.v1.SlidesScopes
//import com.google.api.services.slides.v1.model.AffineTransform
//import com.google.api.services.slides.v1.model.BatchUpdatePresentationRequest
//import com.google.api.services.slides.v1.model.BatchUpdatePresentationResponse
//import com.google.api.services.slides.v1.model.CreateImageRequest
//import com.google.api.services.slides.v1.model.CreateShapeRequest
//import com.google.api.services.slides.v1.model.CreateSlideRequest
//import com.google.api.services.slides.v1.model.Dimension
//import com.google.api.services.slides.v1.model.InsertTextRequest
//import com.google.api.services.slides.v1.model.LayoutReference
//import com.google.api.services.slides.v1.model.OpaqueColor
//import com.google.api.services.slides.v1.model.OptionalColor
//import com.google.api.services.slides.v1.model.Page
//import com.google.api.services.slides.v1.model.PageElementProperties
//import com.google.api.services.slides.v1.model.Presentation
//import com.google.api.services.slides.v1.model.Request
//import com.google.api.services.slides.v1.model.RgbColor
//import com.google.api.services.slides.v1.model.Size
//import com.google.api.services.slides.v1.model.TextStyle
//import com.google.api.services.slides.v1.model.UpdateTextStyleRequest
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//import org.apache.poi.xslf.usermodel.SlideLayout
//import org.apache.poi.xslf.usermodel.XMLSlideShow
//import org.apache.poi.xslf.usermodel.XSLFPictureData
//import org.apache.poi.xslf.usermodel.XSLFSlide
//import org.apache.poi.xslf.usermodel.XSLFTextShape
//import java.io.ByteArrayOutputStream
//import java.io.File
//import java.io.FileInputStream
//import java.io.FileOutputStream
//import java.io.IOException
//import java.io.InputStream
//import java.io.InputStreamReader
//import kotlin.random.Random
//
//
//class MainActivity : AppCompatActivity() {
//    companion object {
//        private const val APPLICATION_NAME = "Google Slides API Java Quickstart"
//
//        //private const val TOKENS_DIRECTORY_PATH = "C:\\Users\\Rushikesh\\AndroidStudioProjects\\ppt2\\app\\src\\main\\assets\\tokens"
//        private const val CREDENTIALS_FILE_PATH = "/credentials.json"
//
//    }
//    private var presentationId = ""
//
//    private var downloadId: Long = 0
//
//    private lateinit var progressBar: ProgressBar
//    private val WRITE_EXTERNAL_STORAGE_REQUEST_CODE: Int = 0
//    private val JSON_FACTORY: JsonFactory = GsonFactory.getDefaultInstance()
//    private val SCOPES = listOf<String>(SlidesScopes.PRESENTATIONS, SlidesScopes.DRIVE)
//    private lateinit var pptEditText: EditText
//
//     @SuppressLint("MissingInflatedId")
//     override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val button = findViewById<Button>(R.id.button1)
//        progressBar = findViewById<ProgressBar>(R.id.progressBar)
//        pptEditText = findViewById(R.id.pptEditText)
//        showPermissionDialog()
//        System.setProperty("https.protocols", "TLSv1.1");
//        button.setOnClickListener {
//            val textBoxId = generateRandomString()
//            if (pptEditText.text.toString().isNotEmpty()) {
//                progressBar.visibility = View.VISIBLE
//                val text = pptEditText.text.toString()
//
//                GlobalScope.launch(Dispatchers.IO) {
//
//                    createTextBoxWithText(
//                        presentationId,
//                        text,
//                        textBoxId,
//                        text
//                    )
//                    // downloadPPT()
//                }
//            } else {
//                Toast.makeText(applicationContext, "please enter some text", Toast.LENGTH_SHORT)
//                    .show()
//            }
//        }
//           val createppt = findViewById<Button>(R.id.create)
//            createppt.setOnClickListener {
//                progressBar.visibility = View.VISIBLE
//                val text = pptEditText.text.toString()
//                Toast.makeText(applicationContext, "create ppt", Toast.LENGTH_SHORT).show()
//                if(text!=""){
//                    GlobalScope.launch(Dispatchers.IO) {
//                       presentationId = createPresentation(text)
//                        //createSlide(presentationId,"abc1")
//                    }
//                }
//
//            }
//         val addslide = findViewById<Button>(R.id.addslide)
//         addslide.setOnClickListener {
//             progressBar.visibility = View.VISIBLE
//             val text = pptEditText.text.toString()
//             if(text!=""){
//                 GlobalScope.launch(Dispatchers.IO) {
//                     createSlide("1_fjHrEq2c5R9pMQtlzGl8a2U1183wKpKwqQylhspiqc",text)
//                  }
//             }
//         }
//           val addimage = findViewById<Button>(R.id.addimage)
//            addimage.setOnClickListener{
//                progressBar.visibility = View.VISIBLE
//                val text = pptEditText.text.toString()
//                if(text!=""){
//                    GlobalScope.launch(Dispatchers.IO) {
//                        createImage(presentationId,text,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5R8lyr_k3Jaz2t35u3FIwOgXif_a2JI4AyDxOhKPGXudJQyaYvCCbFtB9lg&s")
//                    }
//                }
//
//            }
//            val downloadppt = findViewById<Button>(R.id.downloadppt)
//            downloadppt.setOnClickListener {
//                progressBar.visibility = View.VISIBLE
//                GlobalScope.launch(Dispatchers.IO) {
//                   downloadPPT()
//                }
//            }
//
//
//
//
//        // Inside your Activity or Fragment
//
//// Check if the permission is not granted
//
//
//        //  pptMake()
//
//
//    }
//
//
//    fun createDir() {
//        val directory = File(Environment.getExternalStorageDirectory().toString() + "/tokens")
//        if (!directory.exists()) {
//            directory.mkdirs()
//        }
//        val assetManager = applicationContext.assets
//        val sourceFileName = "tokens/StoredCredential"  // replace with your asset file name
//        val destinationFile = File(directory, "StoredCredential")
//
//        try {
//            // Open the asset file
//            val inputStream = assetManager.open(sourceFileName)
//
//            // Create a FileOutputStream to write the file to the destination
//            val outputStream = FileOutputStream(destinationFile)
//
//            // Transfer bytes from the input file to the output file
//            inputStream.copyTo(outputStream)
//
//            // Close the streams
//            inputStream.close()
//            outputStream.close()
//
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }
//    @Throws(IOException::class)
//    fun createSlide(presentationId: String?,slideId: String?): BatchUpdatePresentationResponse? {
//        /* Load pre-authorized user credentials from the environment.
//              TODO(developer) - See https://developers.google.com/identity for
//               guides on implementing OAuth2 for your application. */
//        System.setProperty("https.protocols", "TLSv1.1");
//
//        val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
//
//
//        // Create the slides API client
//        val service = Slides.Builder(
//            NetHttpTransport(),
//            GsonFactory.getDefaultInstance(),
//            getCredentials(HTTP_TRANSPORT)
//        )
//            .setApplicationName("Slides samples")
//            .build()
//
//        // Add a slide at index 1 using the predefined "TITLE_AND_TWO_COLUMNS" layout
//        val requests: MutableList<Request> = ArrayList<Request>()
//         var response: BatchUpdatePresentationResponse? = null
//        try {
//            requests.add(
//                Request()
//                    .setCreateSlide(
//                        CreateSlideRequest()
//                            .setObjectId(slideId)
//                            .setInsertionIndex(1)
//                            .setSlideLayoutReference(
//                                LayoutReference()
//                                    .setPredefinedLayout("BLANK")
//                            )
//                    )
//            )
//
//            // If you wish to populate the slide with elements, add create requests here,
//            // using the slide ID specified above.
//
//            // Execute the request.
//            val body = BatchUpdatePresentationRequest().setRequests(requests)
//            response = service.presentations().batchUpdate(presentationId, body).execute()
//            val createSlideResponse = response.replies[0].createSlide
//            progressBar.visibility = View.INVISIBLE
//            // Prints the slide id.
//            println("Created slide with ID: " + createSlideResponse.objectId)
//
//
//        } catch (e: GoogleJsonResponseException) {
//            // TODO(developer) - handle error appropriately
//            val error = e.details
//            if (error.code == 400) {
//                System.out.printf(
//                    " Id '%s' should be unique among all pages and page elements.\n",
//                    presentationId
//                )
//            } else if (error.code == 404) {
//                System.out.printf("Presentation not found with id '%s'.\n", presentationId)
//            } else {
//                throw e
//            }
//        }
//        return response
//    }
//
//    private fun pptMake() {
//        System.setProperty("https.protocols", "TLSv1.1");
//        GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
//                val service =
//                    Slides.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
//                        .setApplicationName(APPLICATION_NAME)
//                        .build()
//                val presentationId = "1ojc-KAjP0s79DIUVo1U2pVCrgQS35DZpSI_SXvXLyPg"
//                val response: Presentation = service.presentations()[presentationId].execute()
//                val slides: List<Page> = response.slides
//                Log.d("ppppppp", "The presentation contains %s slides:\n $slides.size")
//
//                for (i in slides.indices) {
//                    System.out.printf(
//                        "- Slide #%s contains %s elements.\n", i + 1,
//                        slides[i].pageElements.size
//                    )
//
//                    val str = slides[i].pageElements[0].title
//
//                    Log.d("ppppppppppp", str)
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//    @Throws(IOException::class)
//    fun createPresentation(title: String?): String {
//
//        System.setProperty("https.protocols", "TLSv1.1");
//
//        val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
//
////        val credentials = getCredentials(HTTP_TRANSPORT)
//
//
//        // Create the slides API client
//        val service = Slides.Builder(
//            NetHttpTransport(),
//            GsonFactory.getDefaultInstance(),
//            getCredentials(HTTP_TRANSPORT)
//        )
//            .setApplicationName("Slides samples")
//            .build()
//
//        // Creates a blank presentation with a specified title.
//        var presentation = Presentation()
//            .setTitle(title)
//        presentation = service.presentations().create(presentation)
//            .setFields("presentationId")
//            .execute()
//        // Prints the newly created presentation id.
//        runOnUiThread{
//            Toast.makeText(
//                applicationContext,
//                "Created presentation with ID: + ${presentation.presentationId}",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//
//        progressBar.visibility = View.INVISIBLE
//        println("Created presentation with ID: " + presentation.presentationId)
//
//        return presentation.presentationId
//    }
//
//    fun generateRandomString(): String {
//        val length = Random.nextInt(6, 11) // Generates a random length between 6 and 10 (inclusive)
//        val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9') // Define the character set
//
//        return (1..length)
//            .map { charset.random() }
//            .joinToString("")
//    }
//
//    @SuppressLint("UseCompatLoadingForDrawables")
//    fun editPPT() {
//        val file2 = File(
//
//            Environment.getExternalStorageDirectory()
//                .toString() + "/" + File.separator + "test.pptx"
//        )
//
//        val inputstream = FileInputStream(file2)
//        val ppt = XMLSlideShow(inputstream)
//
//        //getting the slide master object
//        //getting the slide master object
//        val slideMaster = ppt.slideMasters[0]
//
//        //get the desired slide layout
//
//        //get the desired slide layout
//        val titleLayout = slideMaster.getLayout(SlideLayout.TITLE)
//        val basicLayout = slideMaster.getLayout(SlideLayout.BLANK)
//
//        //creating a slide with title layout
//
//        //creating a slide with title layout
//        val slide1 = ppt.createSlide(titleLayout)
//        val slide2 = ppt.createSlide(titleLayout)
//
//
//        //selecting the place holder in it
//
//        //selecting the place holder in it
//        val title1: XSLFTextShape = slide1.getPlaceholder(0)
//        //setting the title init
//
//        //setting the title init
//        title1.text = "jvuuhfjvhrj rviuhviruuhviug"
//       // addImageToSlide(ppt, slide2, "Picture3.png")
//
//        //saving the changes
//        val out2 = FileOutputStream(file2)
//        ppt.write(out2)
//        Toast.makeText(
//            applicationContext,
//            "Presentation edited successfully",
//            Toast.LENGTH_SHORT
//        ).show()
//
//        println("Presentation edited successfully")
//        out2.close()
//
//
//    }
//
//    private fun showPermissionDialog() {
//        if (ContextCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
//            )
//            != PackageManager.PERMISSION_GRANTED
//        ) {
//
//            // Request permission
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
//                WRITE_EXTERNAL_STORAGE_REQUEST_CODE
//            );
//        } else {
//            createDir()
//        }
//
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
//            // Check if the permission is granted
//            if (grantResults.isNotEmpty() &&
//                grantResults[0] == PackageManager.PERMISSION_GRANTED
//            ) {
//
//                createDir()
//            } else {
//                Toast.makeText(applicationContext, "permission denied", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//    }
//
//
////    @Throws(IOException::class)
////    private fun addImageToSlide(ppt: XMLSlideShow, slide: XSLFSlide, imageName: String) {
////        val imageStream = assets.open(imageName)
////
////        // Add the image to the slide
////        val pictureData: Int = ppt.addPicture(
////            convertInputStreamToByteArray(imageStream),
////            XSLFPictureData.PICTURE_TYPE_PNG
////        )
////
////        // Create a picture shape
////
////        slide.createPicture(pictureData)
////
////        // Close the input stream
////        imageStream.close()
////
////
////    }
////
//
//    private fun convertInputStreamToByteArray(inputStream: InputStream): ByteArray {
//        val buffer = ByteArrayOutputStream()
//        var nRead: Int
//        val data = ByteArray(16384)
//        try {
//            while (inputStream.read(data, 0, data.size).also { nRead = it } != -1) {
//                buffer.write(data, 0, nRead)
//            }
//            buffer.flush()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        } finally {
//            try {
//                inputStream.close()
//            } catch (e: IOException) {
//                e.printStackTrace()
//            }
//        }
//        return buffer.toByteArray()
//    }
//
//    @Throws(IOException::class)
//    private fun getCredentials(HTTP_TRANSPORT: NetHttpTransport): Credential? {
//        // Load client secrets.
//        val file = applicationContext.assets.open("credentials.json")
//        val clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, InputStreamReader(file))
//
//        // Build flow and trigger user authorization request.
//        val flow = GoogleAuthorizationCodeFlow.Builder(
//            HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES
//        )
//            .setDataStoreFactory(
//                FileDataStoreFactory(
//                    File(
//                        Environment.getExternalStorageDirectory().toString() + "/tokens/"
//                    )
//                )
//            )
//            .setAccessType("offline")
//            .build()
//        val receiver = LocalServerReceiver.Builder().setPort(8888).build()
//        return AuthorizationCodeInstalledApp(
//            flow,
//            receiver
//        ).authorize("salunkherushi2020@gmail.com")
//    }
//
//    @Throws(IOException::class)
//    fun createTextBoxWithText(
//        presentationId: String?,
//        slideId: String?,
//        textBoxId: String?,
//        text: String
//    ): BatchUpdatePresentationResponse? {
//        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
//
//        /* Load pre-authorized user credentials from the environment.
//              TODO(developer) - See https://developers.google.com/identity for
//               guides on implementing OAuth2 for your application. */
//
//        val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
//
//        // Create the slides API client
//        val service = Slides.Builder(
//            NetHttpTransport(),
//            GsonFactory.getDefaultInstance(),
//            getCredentials(HTTP_TRANSPORT)
//        )
//            .setApplicationName("Slides samples")
//            .build()
//
//        // Create a new square text box, using a supplied object ID.
//        val requests: MutableList<Request> = ArrayList()
//        val pt350 = Dimension().setMagnitude(350.0).setUnit("PT")
//        requests.add(
//            Request()
//                .setCreateShape(
//                    CreateShapeRequest()
//                        .setObjectId(textBoxId)
//                        .setShapeType("TEXT_BOX")
//                        .setElementProperties(
//                            PageElementProperties()
//                                .setPageObjectId(slideId)
//                                .setSize(
//                                    Size()
//                                        .setHeight(pt350)
//                                        .setWidth(pt350)
//                                )
//                                .setTransform(
//                                    AffineTransform()
//                                        .setScaleX(1.0)
//                                        .setScaleY(1.0)
//                                        .setTranslateX(350.0)
//                                        .setTranslateY(100.0)
//                                        .setUnit("PT")
//                                )
//                        )
//                )
//        )
//
//        // Insert text into the box, using the object ID given to it.
//        requests.add(
//            Request()
//                .setInsertText(
//                    InsertTextRequest()
//                        .setObjectId(textBoxId)
//                        .setInsertionIndex(0)
//                        .setText(text)
//
//
//                )
//
//        )
//        requests.add(
//            Request()
//
//                .setUpdateTextStyle(
//                    UpdateTextStyleRequest()
//                        .setObjectId(textBoxId)
//                        .setStyle(
//                            TextStyle().setFontFamily("Roboto")
//                                .setForegroundColor(
//                                    OptionalColor().setOpaqueColor(
//                                        OpaqueColor()
//                                            .setRgbColor(
//                                                RgbColor().setBlue(0f)
//                                                    .setGreen(0f)
//                                                    .setRed(0f)
//                                            )
//                                    )
//                                )
//                        ).setFields("*")
//                )
//
//        )
//
//        var response: BatchUpdatePresentationResponse? = null
//        try {
//            // Execute the requests.
//            val body = BatchUpdatePresentationRequest().setRequests(requests)
//            response = service.presentations().batchUpdate(presentationId, body).execute()
//            val createShapeResponse = response.replies[0].createShape
//            println("Created textbox with ID: " + createShapeResponse.objectId)
//
//            progressBar.visibility = View.INVISIBLE
//        } catch (e: GoogleJsonResponseException) {
//            // TODO(developer) - handle error appropriately
//            progressBar.visibility = View.INVISIBLE
//            val error = e.details
//            if (error.code == 404) {
//                System.out.printf("Presentation not found with id '%s'.\n", presentationId)
//            } else {
//                throw e
//            }
//        }
//        return response
//    }
//
//    @Throws(IOException::class)
//    fun createImage(
//        presentationId: String?,
//        slideId: String?,
//        imageUrl: String?
//    ): BatchUpdatePresentationResponse? {
//
//        val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
//
//
//        // Create the slides API client
//        val service = Slides.Builder(
//            NetHttpTransport(),
//            GsonFactory.getDefaultInstance(),
//            getCredentials(HTTP_TRANSPORT)
//        )
//            .setApplicationName("Slides samples")
//            .build()
//
//        // Create a new image, using the supplied object ID, with content downloaded from imageUrl.
//        val requests: MutableList<Request> = ArrayList()
//        val imageId = "MyImageId_01"
//        val emu4M = Dimension().setMagnitude(4000000.0).setUnit("EMU")
//        requests.add(
//            Request()
//                .setCreateImage(
//                    CreateImageRequest()
//                        .setObjectId(imageId)
//                        .setUrl(imageUrl)
//                        .setElementProperties(
//                            PageElementProperties()
//                                .setPageObjectId(slideId)
//                                .setSize(
//                                    Size()
//                                        .setHeight(emu4M)
//                                        .setWidth(emu4M)
//                                )
//                                .setTransform(
//                                    AffineTransform()
//                                        .setScaleX(1.0)
//                                        .setScaleY(1.0)
//                                        .setTranslateX(100000.0)
//                                        .setTranslateY(100000.0)
//                                        .setUnit("EMU")
//                                )
//                        )
//                )
//        )
//        var response: BatchUpdatePresentationResponse? = null
//        try {
//            // Execute the request.
//            val body = BatchUpdatePresentationRequest().setRequests(requests)
//
//            response = service.presentations().batchUpdate(presentationId, body)
//
//                .execute()
//            val createImageResponse = response.replies[0].createImage
//            // Prints the created image id.
//            progressBar.visibility = View.INVISIBLE
//            println("Created image with ID: " + createImageResponse.objectId)
//        } catch (e: GoogleJsonResponseException) {
//            // TODO(developer) - handle error appropriately
//            val error = e.details
//            if (error.code == 404) {
//                System.out.printf("Presentation not found with id '%s'.\n", presentationId)
//            } else {
//                throw e
//            }
//        }
//        return response
//    }
//
//
//    @SuppressLint("UnspecifiedRegisterReceiverFlag")
//    private fun downloadPPT() {
//
//        val presentationId = "1ojc-KAjP0s79DIUVo1U2pVCrgQS35DZpSI_SXvXLyPg"
//        val url = "https://docs.google.com/presentation/d/$presentationId/export/pptx"
//        // Set up a BroadcastReceiver to listen for the download completion
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.data = Uri.parse(url)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        startActivity(intent)
//        progressBar.visibility = View.INVISIBLE
//
//    }
//
//    private fun openDownloadedFile() {
//        // Replace "YourFileName.pptx" with the actual file name you used during download
//        val file = File(
//            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
//            "YourFileName.pptx"
//        )
//
//        val contentUri = FileProvider.getUriForFile(this, "com.example.ppt.fileprovider", file)
//
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.setDataAndType(contentUri, "application/vnd.ms-powerpoint")
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
//
//        try {
//            startActivity(intent)
//        } catch (e: Exception) {
//            // Handle exceptions
//            Toast.makeText(this, "Error opening file", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//}
//
//
