// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/ai/generativelanguage/v1beta3/tuned_model.proto

package com.google.ai.generativelanguage.v1beta3;

public interface HyperparametersOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.ai.generativelanguage.v1beta3.Hyperparameters)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Immutable. The number of training epochs. An epoch is one pass through the
   * training data. If not set, a default of 10 will be used.
   * </pre>
   *
   * <code>optional int32 epoch_count = 14 [(.google.api.field_behavior) = IMMUTABLE];</code>
   * @return Whether the epochCount field is set.
   */
  boolean hasEpochCount();
  /**
   * <pre>
   * Immutable. The number of training epochs. An epoch is one pass through the
   * training data. If not set, a default of 10 will be used.
   * </pre>
   *
   * <code>optional int32 epoch_count = 14 [(.google.api.field_behavior) = IMMUTABLE];</code>
   * @return The epochCount.
   */
  int getEpochCount();

  /**
   * <pre>
   * Immutable. The batch size hyperparameter for tuning.
   * If not set, a default of 16 or 64 will be used based on the number of
   * training examples.
   * </pre>
   *
   * <code>optional int32 batch_size = 15 [(.google.api.field_behavior) = IMMUTABLE];</code>
   * @return Whether the batchSize field is set.
   */
  boolean hasBatchSize();
  /**
   * <pre>
   * Immutable. The batch size hyperparameter for tuning.
   * If not set, a default of 16 or 64 will be used based on the number of
   * training examples.
   * </pre>
   *
   * <code>optional int32 batch_size = 15 [(.google.api.field_behavior) = IMMUTABLE];</code>
   * @return The batchSize.
   */
  int getBatchSize();

  /**
   * <pre>
   * Immutable. The learning rate hyperparameter for tuning.
   * If not set, a default of 0.0002 or 0.002 will be calculated based on the
   * number of training examples.
   * </pre>
   *
   * <code>optional float learning_rate = 16 [(.google.api.field_behavior) = IMMUTABLE];</code>
   * @return Whether the learningRate field is set.
   */
  boolean hasLearningRate();
  /**
   * <pre>
   * Immutable. The learning rate hyperparameter for tuning.
   * If not set, a default of 0.0002 or 0.002 will be calculated based on the
   * number of training examples.
   * </pre>
   *
   * <code>optional float learning_rate = 16 [(.google.api.field_behavior) = IMMUTABLE];</code>
   * @return The learningRate.
   */
  float getLearningRate();
}
