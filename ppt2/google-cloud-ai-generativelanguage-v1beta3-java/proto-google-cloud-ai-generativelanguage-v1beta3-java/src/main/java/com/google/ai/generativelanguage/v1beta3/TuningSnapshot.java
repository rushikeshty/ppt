// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta3/tuned_model.proto

package com.google.ai.generativelanguage.v1beta3;

/**
 * <pre>
 * Record for a single tuning step.
 * </pre>
 *
 * Protobuf type {@code google.ai.generativelanguage.v1beta3.TuningSnapshot}
 */
public final class TuningSnapshot extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.ai.generativelanguage.v1beta3.TuningSnapshot)
    TuningSnapshotOrBuilder {
private static final long serialVersionUID = 0L;
  // Use TuningSnapshot.newBuilder() to construct.
  private TuningSnapshot(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private TuningSnapshot() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new TuningSnapshot();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningSnapshot_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningSnapshot_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.ai.generativelanguage.v1beta3.TuningSnapshot.class, com.google.ai.generativelanguage.v1beta3.TuningSnapshot.Builder.class);
  }

  public static final int STEP_FIELD_NUMBER = 1;
  private int step_ = 0;
  /**
   * <pre>
   * Output only. The tuning step.
   * </pre>
   *
   * <code>int32 step = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The step.
   */
  @java.lang.Override
  public int getStep() {
    return step_;
  }

  public static final int EPOCH_FIELD_NUMBER = 2;
  private int epoch_ = 0;
  /**
   * <pre>
   * Output only. The epoch this step was part of.
   * </pre>
   *
   * <code>int32 epoch = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The epoch.
   */
  @java.lang.Override
  public int getEpoch() {
    return epoch_;
  }

  public static final int MEAN_LOSS_FIELD_NUMBER = 3;
  private float meanLoss_ = 0F;
  /**
   * <pre>
   * Output only. The mean loss of the training examples for this step.
   * </pre>
   *
   * <code>float mean_loss = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The meanLoss.
   */
  @java.lang.Override
  public float getMeanLoss() {
    return meanLoss_;
  }

  public static final int COMPUTE_TIME_FIELD_NUMBER = 4;
  private com.google.protobuf.Timestamp computeTime_;
  /**
   * <pre>
   * Output only. The timestamp when this metric was computed.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return Whether the computeTime field is set.
   */
  @java.lang.Override
  public boolean hasComputeTime() {
    return computeTime_ != null;
  }
  /**
   * <pre>
   * Output only. The timestamp when this metric was computed.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   * @return The computeTime.
   */
  @java.lang.Override
  public com.google.protobuf.Timestamp getComputeTime() {
    return computeTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : computeTime_;
  }
  /**
   * <pre>
   * Output only. The timestamp when this metric was computed.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   */
  @java.lang.Override
  public com.google.protobuf.TimestampOrBuilder getComputeTimeOrBuilder() {
    return computeTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : computeTime_;
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
    if (step_ != 0) {
      output.writeInt32(1, step_);
    }
    if (epoch_ != 0) {
      output.writeInt32(2, epoch_);
    }
    if (java.lang.Float.floatToRawIntBits(meanLoss_) != 0) {
      output.writeFloat(3, meanLoss_);
    }
    if (computeTime_ != null) {
      output.writeMessage(4, getComputeTime());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (step_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, step_);
    }
    if (epoch_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, epoch_);
    }
    if (java.lang.Float.floatToRawIntBits(meanLoss_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeFloatSize(3, meanLoss_);
    }
    if (computeTime_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getComputeTime());
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
    if (!(obj instanceof com.google.ai.generativelanguage.v1beta3.TuningSnapshot)) {
      return super.equals(obj);
    }
    com.google.ai.generativelanguage.v1beta3.TuningSnapshot other = (com.google.ai.generativelanguage.v1beta3.TuningSnapshot) obj;

    if (getStep()
        != other.getStep()) return false;
    if (getEpoch()
        != other.getEpoch()) return false;
    if (java.lang.Float.floatToIntBits(getMeanLoss())
        != java.lang.Float.floatToIntBits(
            other.getMeanLoss())) return false;
    if (hasComputeTime() != other.hasComputeTime()) return false;
    if (hasComputeTime()) {
      if (!getComputeTime()
          .equals(other.getComputeTime())) return false;
    }
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
    hash = (37 * hash) + STEP_FIELD_NUMBER;
    hash = (53 * hash) + getStep();
    hash = (37 * hash) + EPOCH_FIELD_NUMBER;
    hash = (53 * hash) + getEpoch();
    hash = (37 * hash) + MEAN_LOSS_FIELD_NUMBER;
    hash = (53 * hash) + java.lang.Float.floatToIntBits(
        getMeanLoss());
    if (hasComputeTime()) {
      hash = (37 * hash) + COMPUTE_TIME_FIELD_NUMBER;
      hash = (53 * hash) + getComputeTime().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot parseFrom(
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
  public static Builder newBuilder(com.google.ai.generativelanguage.v1beta3.TuningSnapshot prototype) {
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
   * Record for a single tuning step.
   * </pre>
   *
   * Protobuf type {@code google.ai.generativelanguage.v1beta3.TuningSnapshot}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.ai.generativelanguage.v1beta3.TuningSnapshot)
      com.google.ai.generativelanguage.v1beta3.TuningSnapshotOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningSnapshot_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningSnapshot_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.ai.generativelanguage.v1beta3.TuningSnapshot.class, com.google.ai.generativelanguage.v1beta3.TuningSnapshot.Builder.class);
    }

    // Construct using com.google.ai.generativelanguage.v1beta3.TuningSnapshot.newBuilder()
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
      step_ = 0;
      epoch_ = 0;
      meanLoss_ = 0F;
      computeTime_ = null;
      if (computeTimeBuilder_ != null) {
        computeTimeBuilder_.dispose();
        computeTimeBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.ai.generativelanguage.v1beta3.TunedModelProto.internal_static_google_ai_generativelanguage_v1beta3_TuningSnapshot_descriptor;
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.TuningSnapshot getDefaultInstanceForType() {
      return com.google.ai.generativelanguage.v1beta3.TuningSnapshot.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.TuningSnapshot build() {
      com.google.ai.generativelanguage.v1beta3.TuningSnapshot result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.ai.generativelanguage.v1beta3.TuningSnapshot buildPartial() {
      com.google.ai.generativelanguage.v1beta3.TuningSnapshot result = new com.google.ai.generativelanguage.v1beta3.TuningSnapshot(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.ai.generativelanguage.v1beta3.TuningSnapshot result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.step_ = step_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.epoch_ = epoch_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.meanLoss_ = meanLoss_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.computeTime_ = computeTimeBuilder_ == null
            ? computeTime_
            : computeTimeBuilder_.build();
      }
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
      if (other instanceof com.google.ai.generativelanguage.v1beta3.TuningSnapshot) {
        return mergeFrom((com.google.ai.generativelanguage.v1beta3.TuningSnapshot)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.ai.generativelanguage.v1beta3.TuningSnapshot other) {
      if (other == com.google.ai.generativelanguage.v1beta3.TuningSnapshot.getDefaultInstance()) return this;
      if (other.getStep() != 0) {
        setStep(other.getStep());
      }
      if (other.getEpoch() != 0) {
        setEpoch(other.getEpoch());
      }
      if (other.getMeanLoss() != 0F) {
        setMeanLoss(other.getMeanLoss());
      }
      if (other.hasComputeTime()) {
        mergeComputeTime(other.getComputeTime());
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
            case 8: {
              step_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              epoch_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 29: {
              meanLoss_ = input.readFloat();
              bitField0_ |= 0x00000004;
              break;
            } // case 29
            case 34: {
              input.readMessage(
                  getComputeTimeFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000008;
              break;
            } // case 34
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

    private int step_ ;
    /**
     * <pre>
     * Output only. The tuning step.
     * </pre>
     *
     * <code>int32 step = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return The step.
     */
    @java.lang.Override
    public int getStep() {
      return step_;
    }
    /**
     * <pre>
     * Output only. The tuning step.
     * </pre>
     *
     * <code>int32 step = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @param value The step to set.
     * @return This builder for chaining.
     */
    public Builder setStep(int value) {

      step_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The tuning step.
     * </pre>
     *
     * <code>int32 step = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return This builder for chaining.
     */
    public Builder clearStep() {
      bitField0_ = (bitField0_ & ~0x00000001);
      step_ = 0;
      onChanged();
      return this;
    }

    private int epoch_ ;
    /**
     * <pre>
     * Output only. The epoch this step was part of.
     * </pre>
     *
     * <code>int32 epoch = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return The epoch.
     */
    @java.lang.Override
    public int getEpoch() {
      return epoch_;
    }
    /**
     * <pre>
     * Output only. The epoch this step was part of.
     * </pre>
     *
     * <code>int32 epoch = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @param value The epoch to set.
     * @return This builder for chaining.
     */
    public Builder setEpoch(int value) {

      epoch_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The epoch this step was part of.
     * </pre>
     *
     * <code>int32 epoch = 2 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return This builder for chaining.
     */
    public Builder clearEpoch() {
      bitField0_ = (bitField0_ & ~0x00000002);
      epoch_ = 0;
      onChanged();
      return this;
    }

    private float meanLoss_ ;
    /**
     * <pre>
     * Output only. The mean loss of the training examples for this step.
     * </pre>
     *
     * <code>float mean_loss = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return The meanLoss.
     */
    @java.lang.Override
    public float getMeanLoss() {
      return meanLoss_;
    }
    /**
     * <pre>
     * Output only. The mean loss of the training examples for this step.
     * </pre>
     *
     * <code>float mean_loss = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @param value The meanLoss to set.
     * @return This builder for chaining.
     */
    public Builder setMeanLoss(float value) {

      meanLoss_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The mean loss of the training examples for this step.
     * </pre>
     *
     * <code>float mean_loss = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return This builder for chaining.
     */
    public Builder clearMeanLoss() {
      bitField0_ = (bitField0_ & ~0x00000004);
      meanLoss_ = 0F;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp computeTime_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> computeTimeBuilder_;
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return Whether the computeTime field is set.
     */
    public boolean hasComputeTime() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     * @return The computeTime.
     */
    public com.google.protobuf.Timestamp getComputeTime() {
      if (computeTimeBuilder_ == null) {
        return computeTime_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : computeTime_;
      } else {
        return computeTimeBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public Builder setComputeTime(com.google.protobuf.Timestamp value) {
      if (computeTimeBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        computeTime_ = value;
      } else {
        computeTimeBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public Builder setComputeTime(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (computeTimeBuilder_ == null) {
        computeTime_ = builderForValue.build();
      } else {
        computeTimeBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public Builder mergeComputeTime(com.google.protobuf.Timestamp value) {
      if (computeTimeBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0) &&
          computeTime_ != null &&
          computeTime_ != com.google.protobuf.Timestamp.getDefaultInstance()) {
          getComputeTimeBuilder().mergeFrom(value);
        } else {
          computeTime_ = value;
        }
      } else {
        computeTimeBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public Builder clearComputeTime() {
      bitField0_ = (bitField0_ & ~0x00000008);
      computeTime_ = null;
      if (computeTimeBuilder_ != null) {
        computeTimeBuilder_.dispose();
        computeTimeBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public com.google.protobuf.Timestamp.Builder getComputeTimeBuilder() {
      bitField0_ |= 0x00000008;
      onChanged();
      return getComputeTimeFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    public com.google.protobuf.TimestampOrBuilder getComputeTimeOrBuilder() {
      if (computeTimeBuilder_ != null) {
        return computeTimeBuilder_.getMessageOrBuilder();
      } else {
        return computeTime_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : computeTime_;
      }
    }
    /**
     * <pre>
     * Output only. The timestamp when this metric was computed.
     * </pre>
     *
     * <code>.google.protobuf.Timestamp compute_time = 4 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getComputeTimeFieldBuilder() {
      if (computeTimeBuilder_ == null) {
        computeTimeBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getComputeTime(),
                getParentForChildren(),
                isClean());
        computeTime_ = null;
      }
      return computeTimeBuilder_;
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


    // @@protoc_insertion_point(builder_scope:google.ai.generativelanguage.v1beta3.TuningSnapshot)
  }

  // @@protoc_insertion_point(class_scope:google.ai.generativelanguage.v1beta3.TuningSnapshot)
  private static final com.google.ai.generativelanguage.v1beta3.TuningSnapshot DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.ai.generativelanguage.v1beta3.TuningSnapshot();
  }

  public static com.google.ai.generativelanguage.v1beta3.TuningSnapshot getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<TuningSnapshot>
      PARSER = new com.google.protobuf.AbstractParser<TuningSnapshot>() {
    @java.lang.Override
    public TuningSnapshot parsePartialFrom(
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

  public static com.google.protobuf.Parser<TuningSnapshot> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<TuningSnapshot> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.ai.generativelanguage.v1beta3.TuningSnapshot getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
