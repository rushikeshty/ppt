// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta3/tuned_model.proto

package com.google.ai.generativelanguage.v1beta3;

/**
 * <pre>
 * A set of tuning examples. Can be training or validatation data.
 * </pre>
 *
 * Protobuf type {@code google.ai.generativelanguage.v1beta3.TuningExamples}
 */
public final class TuningExamples extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.ai.generativelanguage.v1beta3.TuningExamples)
    TuningExamplesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TuningExamples.newBuilder() to construct.
  private TuningExamples(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TuningExamples() {
    examples_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TuningExamples();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningExamples_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningExamples_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.ai.generativelanguage.v1beta3.TuningExamples.class, com.google.ai.generativelanguage.v1beta3.TuningExamples.Builder.class);
  }

  public static final int EXAMPLES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.google.ai.generativelanguage.v1beta3.TuningExample> examples_;
  /**
   * <pre>
   * Required. The examples. Example input can be for text or discuss, but all
   * examples in a set must be of the same type.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  @java.lang.Override
  public java.util.List<com.google.ai.generativelanguage.v1beta3.TuningExample> getExamplesList() {
    return examples_;
  }
  /**
   * <pre>
   * Required. The examples. Example input can be for text or discuss, but all
   * examples in a set must be of the same type.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.google.ai.generativelanguage.v1beta3.TuningExampleOrBuilder> 
      getExamplesOrBuilderList() {
    return examples_;
  }
  /**
   * <pre>
   * Required. The examples. Example input can be for text or discuss, but all
   * examples in a set must be of the same type.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  @java.lang.Override
  public int getExamplesCount() {
    return examples_.size();
  }
  /**
   * <pre>
   * Required. The examples. Example input can be for text or discuss, but all
   * examples in a set must be of the same type.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  @java.lang.Override
  public com.google.ai.generativelanguage.v1beta3.TuningExample getExamples(int index) {
    return examples_.get(index);
  }
  /**
   * <pre>
   * Required. The examples. Example input can be for text or discuss, but all
   * examples in a set must be of the same type.
   * </pre>
   *
   * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   */
  @java.lang.Override
  public com.google.ai.generativelanguage.v1beta3.TuningExampleOrBuilder getExamplesOrBuilder(
      int index) {
    return examples_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < examples_.size(); i++) {
      output.writeMessage(1, examples_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < examples_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, examples_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.ai.generativelanguage.v1beta3.TuningExamples)) {
      return super.equals(obj);
    }
    com.google.ai.generativelanguage.v1beta3.TuningExamples other = (com.google.ai.generativelanguage.v1beta3.TuningExamples) obj;

    if (!getExamplesList()
        .equals(other.getExamplesList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getExamplesCount() > 0) {
      hash = (37 * hash) + EXAMPLES_FIELD_NUMBER;
      hash = (53 * hash) + getExamplesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningExamples parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.ai.generativelanguage.v1beta3.TuningExamples prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * A set of tuning examples. Can be training or validatation data.
   * </pre>
   *
   * Protobuf type {@code google.ai.generativelanguage.v1beta3.TuningExamples}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.ai.generativelanguage.v1beta3.TuningExamples)
      com.google.ai.generativelanguage.v1beta3.TuningExamplesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningExamples_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningExamples_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.ai.generativelanguage.v1beta3.TuningExamples.class, com.google.ai.generativelanguage.v1beta3.TuningExamples.Builder.class);
    }

    // Construct using com.google.ai.generativelanguage.v1beta3.TuningExamples.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (examplesBuilder_ == null) {
        examples_ = java.util.Collections.emptyList();
      } else {
        examples_ = null;
        examplesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningExamples_descriptor;
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.TuningExamples getDefaultInstanceForType() {
      return com.google.ai.generativelanguage.v1beta3.TuningExamples.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.TuningExamples build() {
      com.google.ai.generativelanguage.v1beta3.TuningExamples result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.TuningExamples buildPartial() {
      com.google.ai.generativelanguage.v1beta3.TuningExamples result = new com.google.ai.generativelanguage.v1beta3.TuningExamples(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.google.ai.generativelanguage.v1beta3.TuningExamples result) {
      if (examplesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          examples_ = java.util.Collections.unmodifiableList(examples_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.examples_ = examples_;
      } else {
        result.examples_ = examplesBuilder_.build();
      }
    }

    private void buildPartial0(com.google.ai.generativelanguage.v1beta3.TuningExamples result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.ai.generativelanguage.v1beta3.TuningExamples) {
        return mergeFrom((com.google.ai.generativelanguage.v1beta3.TuningExamples)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.ai.generativelanguage.v1beta3.TuningExamples other) {
      if (other == com.google.ai.generativelanguage.v1beta3.TuningExamples.getDefaultInstance()) return this;
      if (examplesBuilder_ == null) {
        if (!other.examples_.isEmpty()) {
          if (examples_.isEmpty()) {
            examples_ = other.examples_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureExamplesIsMutable();
            examples_.addAll(other.examples_);
          }
          onChanged();
        }
      } else {
        if (!other.examples_.isEmpty()) {
          if (examplesBuilder_.isEmpty()) {
            examplesBuilder_.dispose();
            examplesBuilder_ = null;
            examples_ = other.examples_;
            bitField0_ = (bitField0_ & ~0x00000001);
            examplesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getExamplesFieldBuilder() : null;
          } else {
            examplesBuilder_.addAllMessages(other.examples_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              com.google.ai.generativelanguage.v1beta3.TuningExample m =
                  input.readMessage(
                      com.google.ai.generativelanguage.v1beta3.TuningExample.parser(),
                      extensionRegistry);
              if (examplesBuilder_ == null) {
                ensureExamplesIsMutable();
                examples_.add(m);
              } else {
                examplesBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<com.google.ai.generativelanguage.v1beta3.TuningExample> examples_ =
      java.util.Collections.emptyList();
    private void ensureExamplesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        examples_ = new java.util.ArrayList<com.google.ai.generativelanguage.v1beta3.TuningExample>(examples_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.google.ai.generativelanguage.v1beta3.TuningExample, com.google.ai.generativelanguage.v1beta3.TuningExample.Builder, com.google.ai.generativelanguage.v1beta3.TuningExampleOrBuilder> examplesBuilder_;

    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public java.util.List<com.google.ai.generativelanguage.v1beta3.TuningExample> getExamplesList() {
      if (examplesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(examples_);
      } else {
        return examplesBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public int getExamplesCount() {
      if (examplesBuilder_ == null) {
        return examples_.size();
      } else {
        return examplesBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public com.google.ai.generativelanguage.v1beta3.TuningExample getExamples(int index) {
      if (examplesBuilder_ == null) {
        return examples_.get(index);
      } else {
        return examplesBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder setExamples(
        int index, com.google.ai.generativelanguage.v1beta3.TuningExample value) {
      if (examplesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExamplesIsMutable();
        examples_.set(index, value);
        onChanged();
      } else {
        examplesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder setExamples(
        int index, com.google.ai.generativelanguage.v1beta3.TuningExample.Builder builderForValue) {
      if (examplesBuilder_ == null) {
        ensureExamplesIsMutable();
        examples_.set(index, builderForValue.build());
        onChanged();
      } else {
        examplesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder addExamples(com.google.ai.generativelanguage.v1beta3.TuningExample value) {
      if (examplesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExamplesIsMutable();
        examples_.add(value);
        onChanged();
      } else {
        examplesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder addExamples(
        int index, com.google.ai.generativelanguage.v1beta3.TuningExample value) {
      if (examplesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureExamplesIsMutable();
        examples_.add(index, value);
        onChanged();
      } else {
        examplesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder addExamples(
        com.google.ai.generativelanguage.v1beta3.TuningExample.Builder builderForValue) {
      if (examplesBuilder_ == null) {
        ensureExamplesIsMutable();
        examples_.add(builderForValue.build());
        onChanged();
      } else {
        examplesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder addExamples(
        int index, com.google.ai.generativelanguage.v1beta3.TuningExample.Builder builderForValue) {
      if (examplesBuilder_ == null) {
        ensureExamplesIsMutable();
        examples_.add(index, builderForValue.build());
        onChanged();
      } else {
        examplesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder addAllExamples(
        java.lang.Iterable<? extends com.google.ai.generativelanguage.v1beta3.TuningExample> values) {
      if (examplesBuilder_ == null) {
        ensureExamplesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, examples_);
        onChanged();
      } else {
        examplesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder clearExamples() {
      if (examplesBuilder_ == null) {
        examples_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        examplesBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public Builder removeExamples(int index) {
      if (examplesBuilder_ == null) {
        ensureExamplesIsMutable();
        examples_.remove(index);
        onChanged();
      } else {
        examplesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public com.google.ai.generativelanguage.v1beta3.TuningExample.Builder getExamplesBuilder(
        int index) {
      return getExamplesFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public com.google.ai.generativelanguage.v1beta3.TuningExampleOrBuilder getExamplesOrBuilder(
        int index) {
      if (examplesBuilder_ == null) {
        return examples_.get(index);  } else {
        return examplesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public java.util.List<? extends com.google.ai.generativelanguage.v1beta3.TuningExampleOrBuilder> 
         getExamplesOrBuilderList() {
      if (examplesBuilder_ != null) {
        return examplesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(examples_);
      }
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public com.google.ai.generativelanguage.v1beta3.TuningExample.Builder addExamplesBuilder() {
      return getExamplesFieldBuilder().addBuilder(
          com.google.ai.generativelanguage.v1beta3.TuningExample.getDefaultInstance());
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public com.google.ai.generativelanguage.v1beta3.TuningExample.Builder addExamplesBuilder(
        int index) {
      return getExamplesFieldBuilder().addBuilder(
          index, com.google.ai.generativelanguage.v1beta3.TuningExample.getDefaultInstance());
    }
    /**
     * <pre>
     * Required. The examples. Example input can be for text or discuss, but all
     * examples in a set must be of the same type.
     * </pre>
     *
     * <code>repeated .google.ai.generativelanguage.v1beta3.TuningExample examples = 1 [(.google.api.field_behavior) = REQUIRED];</code>
     */
    public java.util.List<com.google.ai.generativelanguage.v1beta3.TuningExample.Builder> 
         getExamplesBuilderList() {
      return getExamplesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.google.ai.generativelanguage.v1beta3.TuningExample, com.google.ai.generativelanguage.v1beta3.TuningExample.Builder, com.google.ai.generativelanguage.v1beta3.TuningExampleOrBuilder> 
        getExamplesFieldBuilder() {
      if (examplesBuilder_ == null) {
        examplesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.google.ai.generativelanguage.v1beta3.TuningExample, com.google.ai.generativelanguage.v1beta3.TuningExample.Builder, com.google.ai.generativelanguage.v1beta3.TuningExampleOrBuilder>(
                examples_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        examples_ = null;
      }
      return examplesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.ai.generativelanguage.v1beta3.TuningExamples)
  }

  // @@protoc_insertion_point(class_scope:google.ai.generativelanguage.v1beta3.TuningExamples)
  private static final com.google.ai.generativelanguage.v1beta3.TuningExamples DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.ai.generativelanguage.v1beta3.TuningExamples();
  }

  public static com.google.ai.generativelanguage.v1beta3.TuningExamples getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TuningExamples>
      PARSER = new com.google.protobuf.AbstractParser<TuningExamples>() {
    @java.lang.Override
    public TuningExamples parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<TuningExamples> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TuningExamples> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.ai.generativelanguage.v1beta3.TuningExamples getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

