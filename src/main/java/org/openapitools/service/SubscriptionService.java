package org.openapitools.service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.openapitools.api.ApiException;
import org.openapitools.model.Subscription;
import org.openapitools.model.SubscriptionDTO;
import org.openapitools.repository.SubscriptionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
	private final SubscriptionRepository subscriptionRepository;

	public SubscriptionDTO createSubscription(String userId, SubscriptionDTO subscriptionDTO) {
		Subscription subscription = new Subscription();
		subscription.setStartDateTime(subscriptionDTO.getStartDateTime());
		subscription.setEndDateTime(subscriptionDTO.getEndDateTime());
		subscription.setUserId(userId);
		subscriptionRepository.save(subscription);
		return subscriptionDTO;
	}

	public SubscriptionDTO getSubscription(String userId) throws ApiException {
		Optional<Subscription> subscriptionFromDb = subscriptionRepository.findByUserId(userId);
		if (subscriptionFromDb.isEmpty()) {
			throw new ApiException(HttpStatus.NOT_FOUND.value());
		} else {
			return new SubscriptionDTO(
					subscriptionFromDb.get().getStartDateTime(),
					subscriptionFromDb.get().getEndDateTime());
		}
	}
}
