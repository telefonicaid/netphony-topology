/*
 * Copyright 2004-2005 Daniel F. Savarese
 * Copyright 2009 Savarese Software Research Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.savarese.com/software/ApacheLicense-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 /*
 * The original rocksow library has been modified to support multicast.
*/
#ifndef __ROCKSAW_RAW_SOCKET_H
#define __ROCKSAW_RAW_SOCKET_H

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1getErrorMessage
(JNIEnv *, jclass, jobject);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1RockSawStartup
(JNIEnv *, jclass);

JNIEXPORT void JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1RockSawShutdown
(JNIEnv *, jclass);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1PF_1INET
(JNIEnv *, jclass);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1PF_1INET6
(JNIEnv *, jclass);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1select
(JNIEnv *env, jclass cls, jint, jboolean, jint, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1socket
(JNIEnv *, jclass, jint, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1bind
(JNIEnv *, jclass, jint, jint, jbyteArray);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1bindDevice
(JNIEnv *, jclass, jint, jstring);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket_getProtocolByName
(JNIEnv *, jclass, jstring);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1query_1routing_1interface
(JNIEnv *, jclass, jint, jint, jbyteArray, jbyteArray);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1close
(JNIEnv *, jclass, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1recvfrom1
(JNIEnv *, jclass, jint, jbyteArray, jint, jint, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1recvfrom2
(JNIEnv *, jclass, jint, jbyteArray, jint, jint, jint, jbyteArray);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1sendto
(JNIEnv *, jclass, jint, jbyteArray, jint, jint, jint, jbyteArray);

JNIEXPORT jboolean JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1isErrorEAGAIN
(JNIEnv *, jclass);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1setIPHeaderInclude
(JNIEnv *, jclass, jint, jboolean);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1getIPHeaderInclude
(JNIEnv *env, jclass cls, jint socket);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1setSendBufferSize
(JNIEnv *, jclass, jint, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1getSendBufferSize
(JNIEnv *, jclass, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1setReceiveBufferSize
(JNIEnv *, jclass, jint, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1getReceiveBufferSize
(JNIEnv *, jclass, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1setSendTimeout
(JNIEnv *, jclass, jint, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1getSendTimeout
(JNIEnv *, jclass, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1setReceiveTimeout
(JNIEnv *, jclass, jint, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1getReceiveTimeout
(JNIEnv *, jclass, jint);

JNIEXPORT jint JNICALL
Java_es_tid_rocksaw_net_RawSocket__1_1joinGroup
(JNIEnv *, jclass, jint,jbyteArray, jbyteArray );

#ifdef __cplusplus
}
#endif

#endif
