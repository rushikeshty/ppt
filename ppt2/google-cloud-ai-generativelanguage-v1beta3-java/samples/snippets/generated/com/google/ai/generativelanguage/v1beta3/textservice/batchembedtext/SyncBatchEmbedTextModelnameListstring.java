/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ai.generativelanguage.v1beta3.samples;

// [START generativelanguage_v1beta3_generated_TextService_BatchEmbedText_ModelnameListstring_sync]
import com.google.ai.generativelanguage.v1beta3.BatchEmbedTextResponse;
import com.google.ai.generativelanguage.v1beta3.ModelName;
import com.google.ai.generativelanguage.v1beta3.TextServiceClient;
import java.util.ArrayList;
import java.util.List;

public class SyncBatchEmbedTextModelnameListstring {

  public static void main(String[] args) throws Exception {
    syncBatchEmbedTextModelnameListstring();
  }

  public static void syncBatchEmbedTextModelnameListstring() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (TextServiceClient textServiceClient = TextServiceClient.create()) {
      ModelName model = ModelName.of("[MODEL]");
      List<String> texts = new ArrayList<>();
      BatchEmbedTextResponse response = textServiceClient.batchEmbedText(model, texts);
    }
  }
}
// [END generativelanguage_v1beta3_generated_TextService_BatchEmbedText_ModelnameListstring_sync]
