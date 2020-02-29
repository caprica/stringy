/*
 * Copyright 2020 Caprica Software Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.caprica.stringy.strings;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

import static org.slf4j.LoggerFactory.getLogger;

@Api(
    tags = {"Strings"}
)
@RestController
public class StringsController {

    private static final Logger log = getLogger(StringsController.class);

    @ApiOperation(value = "Echo the given message")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The echoed message"),
    })
    @GetMapping(value = "/echo", produces = "text/plain")
    public String echo(
        @ApiParam(name = "message", value = "Message to echo", example = "Hello!") @RequestParam String message) {
        log.info("echo(message={})", message);
        return message;
    }

    @ApiOperation(value = "Reverse the given message")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The reversed message"),
    })
    @GetMapping(value = "/reverse", produces = "text/plain")
    public String reverse(
        @ApiParam(name = "message", value = "Message to reverse", example = "Hello!") @RequestParam String message) {
        log.info("echo(message={})", message);
        return new StringBuilder(message).reverse().toString();
    }

    @ApiOperation(value = "Base64 encode the given message")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The Base64 encoded message"),
    })
    @GetMapping(value = "/encode-base64", produces = "text/plain")
    public String encodeBase64(
        @ApiParam(name = "message", value = "Message to Base64 encode", example = "Hello!") @RequestParam String message) {
        log.info("echo(message={})", message);
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
