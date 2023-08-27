package org.openapitools.api;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.openapitools.model.SubscriptionDTO;
import org.openapitools.service.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("${openapi.subscription.base-path:}")
public class ApiApiController implements ApiApi {
	private final SubscriptionService subscriptionService;
	private final NativeWebRequest request;

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<SubscriptionDTO> createSubscription(String userId, SubscriptionDTO subscriptionDTO) {
		return new ResponseEntity<>(subscriptionService.createSubscription(userId, subscriptionDTO), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<SubscriptionDTO> getSubscription(String userId) throws ApiException {
		return new ResponseEntity<>(subscriptionService.getSubscription(userId), HttpStatus.OK);
	}
}