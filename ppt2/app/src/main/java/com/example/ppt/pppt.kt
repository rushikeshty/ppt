package com.example.ppt

import com.google.api.client.auth.oauth2.Credential
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.googleapis.json.GoogleJsonResponseException
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.gson.GsonFactory
import com.google.api.client.util.store.FileDataStoreFactory
import com.google.api.services.slides.v1.Slides
import com.google.api.services.slides.v1.SlidesScopes
import com.google.api.services.slides.v1.model.AffineTransform
import com.google.api.services.slides.v1.model.BatchUpdatePresentationRequest
import com.google.api.services.slides.v1.model.BatchUpdatePresentationResponse
import com.google.api.services.slides.v1.model.CreateShapeRequest
import com.google.api.services.slides.v1.model.CreateSlideRequest
import com.google.api.services.slides.v1.model.Dimension
import com.google.api.services.slides.v1.model.InsertTextRequest
import com.google.api.services.slides.v1.model.LayoutReference
import com.google.api.services.slides.v1.model.PageElementProperties
import com.google.api.services.slides.v1.model.Presentation
import com.google.api.services.slides.v1.model.Request
import com.google.api.services.slides.v1.model.Size
import java.io.File
import java.io.IOException
import java.io.InputStreamReader


private const val APPLICATION_NAME = "Google Slides API Java Quickstart"
private val JSON_FACTORY: JsonFactory = GsonFactory.getDefaultInstance()
private const val TOKENS_DIRECTORY_PATH = "C:\\Users\\Rushikesh\\AndroidStudioProjects\\ppt2\\app\\src\\main\\assets\\tokens"

/**
 * Global instance of the scopes required by this quickstart.
 * If modifying these scopes, delete your previously saved tokens/ folder.
 */
private val SCOPES = listOf<String>(SlidesScopes.PRESENTATIONS,SlidesScopes.DRIVE)
private const val CREDENTIALS_FILE_PATH = "/credentials.json"


class pppt {
}

@Throws(IOException::class)
private fun getCredentials(HTTP_TRANSPORT: NetHttpTransport): Credential? {
     // Load client secrets.
     val file: File = File("C:\\Users\\Rushikesh\\AndroidStudioProjects\\ppt2\\app\\src\\main\\assets\\credentials.json")
     val inputStream = file.inputStream()
     val clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, InputStreamReader(inputStream))

     // Build flow and trigger user authorization request.
     val flow = GoogleAuthorizationCodeFlow.Builder(
          HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES
     )
          .setDataStoreFactory(FileDataStoreFactory(File(TOKENS_DIRECTORY_PATH)))
          .setAccessType("offline")
          .build()
     val receiver = LocalServerReceiver.Builder().setPort(8888).build()
     return AuthorizationCodeInstalledApp(flow, receiver).authorize("salunkherushi2020@gmail.com")
}

fun main() {


//     System.setProperty("https.protocols", "TLSv1.1");
//
//     val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()
//     val service = Slides.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
//          .setApplicationName(APPLICATION_NAME)
//          .build()
//
//     // Prints the number of slides and elements in a sample presentation:
//     // https://docs.google.com/presentation/d/1EAYk18WDjIG-zp_0vLm3CsfQh_i8eXc67Jo2O9C6Vuc/edit
//
//     // Prints the number of slides and elements in a sample presentation:
//     // https://docs.google.com/presentation/d/1EAYk18WDjIG-zp_0vLm3CsfQh_i8eXc67Jo2O9C6Vuc/edit
//     val presentationId = "1ojc-KAjP0s79DIUVo1U2pVCrgQS35DZpSI_SXvXLyPg"
//     val response: Presentation = service.presentations()[presentationId].execute()
//     val slides: List<Page> = response.getSlides()
//
//      System.out.printf("The presentation contains %s slides:\n", slides.size)
//     for (i in slides.indices) {
//          System.out.printf(
//               "- Slide #%s contains %s elements.\n", i + 1,
//               slides[i].getPageElements().size
//
//          )
//
//          val str = slides[i].pageElements.get(0).setTitle("ugytfytfyf")
//          println("ppt "+str)
//     }
    // createSlide(presentationId)
     //createTextBoxWithText(presentationId,"MyNewSlide_002","iegierhgi")
    // createPresentation("hcuwcwucv")


}

@Throws(IOException::class)
fun createPresentation(title: String?): String? {
     /* Load pre-authorized user credentials from the environment.
           TODO(developer) - See https://developers.google.com/identity for
            guides on implementing OAuth2 for your application. */
     System.setProperty("https.protocols", "TLSv1.1");

     val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()

     val credentials = getCredentials(HTTP_TRANSPORT)



     // Create the slides API client
     val service = Slides.Builder(
          NetHttpTransport(),
          GsonFactory.getDefaultInstance(),
          getCredentials(HTTP_TRANSPORT)
     )
          .setApplicationName("Slides samples")
          .build()

     // Creates a blank presentation with a specified title.
     var presentation = Presentation()
          .setTitle(title)
     presentation = service.presentations().create(presentation)
          .setFields("presentationId")
          .execute()
     // Prints the newly created presentation id.
     println("Created presentation with ID: " + presentation.presentationId)

     return presentation.presentationId
}

@Throws(IOException::class)
fun createSlide(presentationId: String?): BatchUpdatePresentationResponse? {
     /* Load pre-authorized user credentials from the environment.
           TODO(developer) - See https://developers.google.com/identity for
            guides on implementing OAuth2 for your application. */
     System.setProperty("https.protocols", "TLSv1.1");

     val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()


     // Create the slides API client
     val service = Slides.Builder(
          NetHttpTransport(),
          GsonFactory.getDefaultInstance(),
          getCredentials(HTTP_TRANSPORT)
     )
          .setApplicationName("Slides samples")
          .build()

     // Add a slide at index 1 using the predefined "TITLE_AND_TWO_COLUMNS" layout
     val requests: MutableList<Request> = ArrayList<Request>()
     val slideId = "MyNewSlide_004"
     var response: BatchUpdatePresentationResponse? = null
     try {
          requests.add(
               Request()
                    .setCreateSlide(
                         CreateSlideRequest()
                              .setObjectId(slideId)
                              .setInsertionIndex(1)
                              .setSlideLayoutReference(
                                   LayoutReference()
                                        .setPredefinedLayout("TITLE")
                              )
                    )
          )

          // If you wish to populate the slide with elements, add create requests here,
          // using the slide ID specified above.

          // Execute the request.
          val body = BatchUpdatePresentationRequest().setRequests(requests)
          response = service.presentations().batchUpdate(presentationId, body).execute()
          val createSlideResponse = response.replies[0].createSlide

          // Prints the slide id.
          println("Created slide with ID: " + createSlideResponse.objectId)
     } catch (e: GoogleJsonResponseException) {
          // TODO(developer) - handle error appropriately
          val error = e.details
          if (error.code == 400) {
               System.out.printf(
                    " Id '%s' should be unique among all pages and page elements.\n",
                    presentationId
               )
          } else if (error.code == 404) {
               System.out.printf("Presentation not found with id '%s'.\n", presentationId)
          } else {
               throw e
          }
     }
     return response
}

@Throws(IOException::class)
fun createTextBoxWithText(presentationId: String?, slideId: String?, textBoxId: String?,text:String): BatchUpdatePresentationResponse? {
     System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

     /* Load pre-authorized user credentials from the environment.
           TODO(developer) - See https://developers.google.com/identity for
            guides on implementing OAuth2 for your application. */

     val HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()

     // Create the slides API client
     val service = Slides.Builder(
          NetHttpTransport(),
          GsonFactory.getDefaultInstance(),
          getCredentials(HTTP_TRANSPORT)
     )
          .setApplicationName("Slides samples")
          .build()

     // Create a new square text box, using a supplied object ID.
     val requests: MutableList<Request> = ArrayList()
     val pt350 = Dimension().setMagnitude(350.0).setUnit("PT")
     requests.add(
          Request()
               .setCreateShape(
                    CreateShapeRequest()
                         .setObjectId(textBoxId)
                         .setShapeType("TEXT_BOX")
                         .setElementProperties(
                              PageElementProperties()
                                   .setPageObjectId(slideId)
                                   .setSize(
                                        Size()
                                             .setHeight(pt350)
                                             .setWidth(pt350)
                                   )
                                   .setTransform(
                                        AffineTransform()
                                             .setScaleX(1.0)
                                             .setScaleY(1.0)
                                             .setTranslateX(350.0)
                                             .setTranslateY(100.0)
                                             .setUnit("PT")
                                   )
                         )
               )
     )

     // Insert text into the box, using the object ID given to it.
     requests.add(
          Request()
               .setInsertText(
                    InsertTextRequest()
                         .setObjectId(textBoxId)
                         .setInsertionIndex(0)
                         .setText("rushikesh ppt")

               )

     )
     var response: BatchUpdatePresentationResponse? = null
     try {
          // Execute the requests.
          val body = BatchUpdatePresentationRequest().setRequests(requests)
          response = service.presentations().batchUpdate(presentationId, body).execute()
          val createShapeResponse = response.replies[0].createShape
          println("Created textbox with ID: " + createShapeResponse.objectId)
     } catch (e: GoogleJsonResponseException) {
          // TODO(developer) - handle error appropriately
          val error = e.details
          if (error.code == 404) {
               System.out.printf("Presentation not found with id '%s'.\n", presentationId)
          } else {
               throw e
          }
     }
     return response
}