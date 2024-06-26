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

package com.google.ai.generativelanguage.v1beta3.stub;

import static com.google.ai.generativelanguage.v1beta3.PermissionServiceClient.ListPermissionsPagedResponse;

import com.google.ai.generativelanguage.v1beta3.CreatePermissionRequest;
import com.google.ai.generativelanguage.v1beta3.DeletePermissionRequest;
import com.google.ai.generativelanguage.v1beta3.GetPermissionRequest;
import com.google.ai.generativelanguage.v1beta3.ListPermissionsRequest;
import com.google.ai.generativelanguage.v1beta3.ListPermissionsResponse;
import com.google.ai.generativelanguage.v1beta3.Permission;
import com.google.ai.generativelanguage.v1beta3.TransferOwnershipRequest;
import com.google.ai.generativelanguage.v1beta3.TransferOwnershipResponse;
import com.google.ai.generativelanguage.v1beta3.UpdatePermissionRequest;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PermissionServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (generativelanguage.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createPermission to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PermissionServiceStubSettings.Builder permissionServiceSettingsBuilder =
 *     PermissionServiceStubSettings.newBuilder();
 * permissionServiceSettingsBuilder
 *     .createPermissionSettings()
 *     .setRetrySettings(
 *         permissionServiceSettingsBuilder
 *             .createPermissionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PermissionServiceStubSettings permissionServiceSettings =
 *     permissionServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PermissionServiceStubSettings extends StubSettings<PermissionServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<CreatePermissionRequest, Permission> createPermissionSettings;
  private final UnaryCallSettings<GetPermissionRequest, Permission> getPermissionSettings;
  private final PagedCallSettings<
          ListPermissionsRequest, ListPermissionsResponse, ListPermissionsPagedResponse>
      listPermissionsSettings;
  private final UnaryCallSettings<UpdatePermissionRequest, Permission> updatePermissionSettings;
  private final UnaryCallSettings<DeletePermissionRequest, Empty> deletePermissionSettings;
  private final UnaryCallSettings<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipSettings;

  private static final PagedListDescriptor<
          ListPermissionsRequest, ListPermissionsResponse, Permission>
      LIST_PERMISSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListPermissionsRequest, ListPermissionsResponse, Permission>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPermissionsRequest injectToken(
                ListPermissionsRequest payload, String token) {
              return ListPermissionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPermissionsRequest injectPageSize(
                ListPermissionsRequest payload, int pageSize) {
              return ListPermissionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPermissionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPermissionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Permission> extractResources(ListPermissionsResponse payload) {
              return payload.getPermissionsList() == null
                  ? ImmutableList.<Permission>of()
                  : payload.getPermissionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPermissionsRequest, ListPermissionsResponse, ListPermissionsPagedResponse>
      LIST_PERMISSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPermissionsRequest, ListPermissionsResponse, ListPermissionsPagedResponse>() {
            @Override
            public ApiFuture<ListPermissionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPermissionsRequest, ListPermissionsResponse> callable,
                ListPermissionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPermissionsResponse> futureResponse) {
              PageContext<ListPermissionsRequest, ListPermissionsResponse, Permission> pageContext =
                  PageContext.create(callable, LIST_PERMISSIONS_PAGE_STR_DESC, request, context);
              return ListPermissionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createPermission. */
  public UnaryCallSettings<CreatePermissionRequest, Permission> createPermissionSettings() {
    return createPermissionSettings;
  }

  /** Returns the object with the settings used for calls to getPermission. */
  public UnaryCallSettings<GetPermissionRequest, Permission> getPermissionSettings() {
    return getPermissionSettings;
  }

  /** Returns the object with the settings used for calls to listPermissions. */
  public PagedCallSettings<
          ListPermissionsRequest, ListPermissionsResponse, ListPermissionsPagedResponse>
      listPermissionsSettings() {
    return listPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to updatePermission. */
  public UnaryCallSettings<UpdatePermissionRequest, Permission> updatePermissionSettings() {
    return updatePermissionSettings;
  }

  /** Returns the object with the settings used for calls to deletePermission. */
  public UnaryCallSettings<DeletePermissionRequest, Empty> deletePermissionSettings() {
    return deletePermissionSettings;
  }

  /** Returns the object with the settings used for calls to transferOwnership. */
  public UnaryCallSettings<TransferOwnershipRequest, TransferOwnershipResponse>
      transferOwnershipSettings() {
    return transferOwnershipSettings;
  }

  public PermissionServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPermissionServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPermissionServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "generativelanguage.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "generativelanguage.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PermissionServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PermissionServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PermissionServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected PermissionServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createPermissionSettings = settingsBuilder.createPermissionSettings().build();
    getPermissionSettings = settingsBuilder.getPermissionSettings().build();
    listPermissionsSettings = settingsBuilder.listPermissionsSettings().build();
    updatePermissionSettings = settingsBuilder.updatePermissionSettings().build();
    deletePermissionSettings = settingsBuilder.deletePermissionSettings().build();
    transferOwnershipSettings = settingsBuilder.transferOwnershipSettings().build();
  }

  /** Builder for PermissionServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<PermissionServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreatePermissionRequest, Permission>
        createPermissionSettings;
    private final UnaryCallSettings.Builder<GetPermissionRequest, Permission> getPermissionSettings;
    private final PagedCallSettings.Builder<
            ListPermissionsRequest, ListPermissionsResponse, ListPermissionsPagedResponse>
        listPermissionsSettings;
    private final UnaryCallSettings.Builder<UpdatePermissionRequest, Permission>
        updatePermissionSettings;
    private final UnaryCallSettings.Builder<DeletePermissionRequest, Empty>
        deletePermissionSettings;
    private final UnaryCallSettings.Builder<TransferOwnershipRequest, TransferOwnershipResponse>
        transferOwnershipSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createPermissionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPermissionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPermissionsSettings = PagedCallSettings.newBuilder(LIST_PERMISSIONS_PAGE_STR_FACT);
      updatePermissionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePermissionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      transferOwnershipSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPermissionSettings,
              getPermissionSettings,
              listPermissionsSettings,
              updatePermissionSettings,
              deletePermissionSettings,
              transferOwnershipSettings);
      initDefaults(this);
    }

    protected Builder(PermissionServiceStubSettings settings) {
      super(settings);

      createPermissionSettings = settings.createPermissionSettings.toBuilder();
      getPermissionSettings = settings.getPermissionSettings.toBuilder();
      listPermissionsSettings = settings.listPermissionsSettings.toBuilder();
      updatePermissionSettings = settings.updatePermissionSettings.toBuilder();
      deletePermissionSettings = settings.deletePermissionSettings.toBuilder();
      transferOwnershipSettings = settings.transferOwnershipSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createPermissionSettings,
              getPermissionSettings,
              listPermissionsSettings,
              updatePermissionSettings,
              deletePermissionSettings,
              transferOwnershipSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createPermissionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getPermissionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updatePermissionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deletePermissionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .transferOwnershipSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createPermission. */
    public UnaryCallSettings.Builder<CreatePermissionRequest, Permission>
        createPermissionSettings() {
      return createPermissionSettings;
    }

    /** Returns the builder for the settings used for calls to getPermission. */
    public UnaryCallSettings.Builder<GetPermissionRequest, Permission> getPermissionSettings() {
      return getPermissionSettings;
    }

    /** Returns the builder for the settings used for calls to listPermissions. */
    public PagedCallSettings.Builder<
            ListPermissionsRequest, ListPermissionsResponse, ListPermissionsPagedResponse>
        listPermissionsSettings() {
      return listPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to updatePermission. */
    public UnaryCallSettings.Builder<UpdatePermissionRequest, Permission>
        updatePermissionSettings() {
      return updatePermissionSettings;
    }

    /** Returns the builder for the settings used for calls to deletePermission. */
    public UnaryCallSettings.Builder<DeletePermissionRequest, Empty> deletePermissionSettings() {
      return deletePermissionSettings;
    }

    /** Returns the builder for the settings used for calls to transferOwnership. */
    public UnaryCallSettings.Builder<TransferOwnershipRequest, TransferOwnershipResponse>
        transferOwnershipSettings() {
      return transferOwnershipSettings;
    }

    @Override
    public PermissionServiceStubSettings build() throws IOException {
      return new PermissionServiceStubSettings(this);
    }
  }
}
