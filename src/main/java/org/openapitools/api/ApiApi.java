package org.openapitools.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.Optional;

import org.openapitools.model.SubscriptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.NativeWebRequest;

@Validated
@Tag(name = "subscriptions", description = "the subscriptions API")
public interface ApiApi {

	default Optional<NativeWebRequest> getRequest() {
		return Optional.empty();
	}

	/**
	 * POST /api/user/{userId}/subscriptions : Creates user subscription
	 *
	 * @param userId
	 * 		(required)
	 * @return Tasks list (status code 200)
	 */
	@Operation(
			operationId = "createSubscription",
			summary = "Creates user subscription",
			tags = {"subscriptions"},
			responses = {
					@ApiResponse(responseCode = "200", description = "Tasks list", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = SubscriptionDTO.class))
					})
			},
			security = {
					@SecurityRequirement(name = "bearerAuth")
			}
	)
	@PostMapping(path = "/api/user/{userId}/subscriptions")
	default ResponseEntity<SubscriptionDTO> createSubscription(
			@Parameter(name = "userId", required = true, in = ParameterIn.PATH) @PathVariable("userId") String userId,
			@Parameter(name = "SubscriptionDTO", required = true) @Valid @RequestBody SubscriptionDTO subscriptionDTO) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					String exampleString = "{ \"userId\" : \"google-oauth2|107572411600055728921\", \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\", \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\" }";
					ApiUtil.setExampleResponse(request, "application/json", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * GET /api/user/{userId}/subscriptions : Returns user subscription
	 *
	 * @param userId
	 * 		(required)
	 * @return subscription (status code 200)
	 */
	@Operation(
			operationId = "getSubscription",
			summary = "Returns user subscription",
			tags = {"subscriptions"},
			responses = {
					@ApiResponse(responseCode = "200", description = "Subscription", content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = SubscriptionDTO.class))
					})
			},
			security = {
					@SecurityRequirement(name = "bearerAuth")
			}
	)
	@GetMapping(path = "/api/user/{userId}/subscriptions")
	default ResponseEntity<SubscriptionDTO> getSubscription(
			@Parameter(name = "userId", required = true, in = ParameterIn.PATH) @PathVariable("userId") String userId) throws ApiException {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					String exampleString = "{\"userId\" : \"google-oauth2|107572411600055728921\"}";
					ApiUtil.setExampleResponse(request, "application/json", exampleString);
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
