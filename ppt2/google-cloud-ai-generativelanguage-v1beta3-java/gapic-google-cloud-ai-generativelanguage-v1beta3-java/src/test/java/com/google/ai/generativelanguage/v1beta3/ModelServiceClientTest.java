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

package com.google.ai.generativelanguage.v1beta3;

import static com.google.ai.generativelanguage.v1beta3.ModelServiceClient.ListModelsPagedResponse;
import static com.google.ai.generativelanguage.v1beta3.ModelServiceClient.ListTunedModelsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ModelServiceClientTest {
  private static MockModelService mockModelService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ModelServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockModelService = new MockModelService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockModelService));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    ModelServiceSettings settings =
        ModelServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ModelServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getModelTest() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[MODEL]").toString())
            .setBaseModelId("baseModelId-766553581")
            .setVersion("version351608024")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setInputTokenLimit(907518208)
            .setOutputTokenLimit(-2101721161)
            .addAllSupportedGenerationMethods(new ArrayList<String>())
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .build();
    mockModelService.addResponse(expectedResponse);

    ModelName name = ModelName.of("[MODEL]");

    Model actualResponse = client.getModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelRequest actualRequest = ((GetModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      ModelName name = ModelName.of("[MODEL]");
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getModelTest2() throws Exception {
    Model expectedResponse =
        Model.newBuilder()
            .setName(ModelName.of("[MODEL]").toString())
            .setBaseModelId("baseModelId-766553581")
            .setVersion("version351608024")
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setInputTokenLimit(907518208)
            .setOutputTokenLimit(-2101721161)
            .addAllSupportedGenerationMethods(new ArrayList<String>())
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .build();
    mockModelService.addResponse(expectedResponse);

    String name = "name3373707";

    Model actualResponse = client.getModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetModelRequest actualRequest = ((GetModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.getModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listModelsTest() throws Exception {
    Model responsesElement = Model.newBuilder().build();
    ListModelsResponse expectedResponse =
        ListModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllModels(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    int pageSize = 883849137;
    String pageToken = "pageToken873572522";

    ListModelsPagedResponse pagedListResponse = client.listModels(pageSize, pageToken);

    List<Model> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListModelsRequest actualRequest = ((ListModelsRequest) actualRequests.get(0));

    Assert.assertEquals(pageSize, actualRequest.getPageSize());
    Assert.assertEquals(pageToken, actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listModelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      int pageSize = 883849137;
      String pageToken = "pageToken873572522";
      client.listModels(pageSize, pageToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTunedModelTest() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    mockModelService.addResponse(expectedResponse);

    TunedModelName name = TunedModelName.of("[TUNED_MODEL]");

    TunedModel actualResponse = client.getTunedModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTunedModelRequest actualRequest = ((GetTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTunedModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      TunedModelName name = TunedModelName.of("[TUNED_MODEL]");
      client.getTunedModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTunedModelTest2() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    mockModelService.addResponse(expectedResponse);

    String name = "name3373707";

    TunedModel actualResponse = client.getTunedModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTunedModelRequest actualRequest = ((GetTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTunedModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.getTunedModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTunedModelsTest() throws Exception {
    TunedModel responsesElement = TunedModel.newBuilder().build();
    ListTunedModelsResponse expectedResponse =
        ListTunedModelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTunedModels(Arrays.asList(responsesElement))
            .build();
    mockModelService.addResponse(expectedResponse);

    int pageSize = 883849137;
    String pageToken = "pageToken873572522";

    ListTunedModelsPagedResponse pagedListResponse = client.listTunedModels(pageSize, pageToken);

    List<TunedModel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTunedModelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTunedModelsRequest actualRequest = ((ListTunedModelsRequest) actualRequests.get(0));

    Assert.assertEquals(pageSize, actualRequest.getPageSize());
    Assert.assertEquals(pageToken, actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTunedModelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      int pageSize = 883849137;
      String pageToken = "pageToken873572522";
      client.listTunedModels(pageSize, pageToken);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTunedModelTest() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTunedModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    TunedModel tunedModel = TunedModel.newBuilder().build();

    TunedModel actualResponse = client.createTunedModelAsync(tunedModel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTunedModelRequest actualRequest = ((CreateTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(tunedModel, actualRequest.getTunedModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTunedModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      TunedModel tunedModel = TunedModel.newBuilder().build();
      client.createTunedModelAsync(tunedModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTunedModelTest2() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTunedModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockModelService.addResponse(resultOperation);

    String tunedModelId = "tunedModelId1071842584";
    TunedModel tunedModel = TunedModel.newBuilder().build();

    TunedModel actualResponse = client.createTunedModelAsync(tunedModelId, tunedModel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTunedModelRequest actualRequest = ((CreateTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(tunedModelId, actualRequest.getTunedModelId());
    Assert.assertEquals(tunedModel, actualRequest.getTunedModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTunedModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String tunedModelId = "tunedModelId1071842584";
      TunedModel tunedModel = TunedModel.newBuilder().build();
      client.createTunedModelAsync(tunedModelId, tunedModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateTunedModelTest() throws Exception {
    TunedModel expectedResponse =
        TunedModel.newBuilder()
            .setName(TunedModelName.of("[TUNED_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setTemperature(321701236)
            .setTopP(110545926)
            .setTopK(110545921)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setTuningTask(TuningTask.newBuilder().build())
            .build();
    mockModelService.addResponse(expectedResponse);

    TunedModel tunedModel = TunedModel.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TunedModel actualResponse = client.updateTunedModel(tunedModel, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTunedModelRequest actualRequest = ((UpdateTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(tunedModel, actualRequest.getTunedModel());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTunedModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      TunedModel tunedModel = TunedModel.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTunedModel(tunedModel, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTunedModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockModelService.addResponse(expectedResponse);

    TunedModelName name = TunedModelName.of("[TUNED_MODEL]");

    client.deleteTunedModel(name);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTunedModelRequest actualRequest = ((DeleteTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTunedModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      TunedModelName name = TunedModelName.of("[TUNED_MODEL]");
      client.deleteTunedModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTunedModelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockModelService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTunedModel(name);

    List<AbstractMessage> actualRequests = mockModelService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTunedModelRequest actualRequest = ((DeleteTunedModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTunedModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockModelService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTunedModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
