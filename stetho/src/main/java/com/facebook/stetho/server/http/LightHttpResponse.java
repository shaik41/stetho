/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.stetho.server.http;

public class LightHttpResponse extends LightHttpMessage {
  public int code;
  public String reasonPhrase;
  public LightHttpBody body;

  public void prepare() {
    if (body != null) {
      addHeader(HttpHeaders.CONTENT_TYPE, body.contentType());
      addHeader(HttpHeaders.CONTENT_LENGTH, String.valueOf(body.contentLength()));
    }
  }

  @Override
  public void reset() {
    super.reset();
    this.code = -1;
    this.reasonPhrase = null;
    this.body = null;
  }
}
