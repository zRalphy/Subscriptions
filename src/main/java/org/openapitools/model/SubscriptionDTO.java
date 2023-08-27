package org.openapitools.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Subscription
 */

public class SubscriptionDTO {

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private OffsetDateTime startDateTime;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private OffsetDateTime endDateTime;

	/**
	 * Constructor with only required parameters
	 */
	public SubscriptionDTO(OffsetDateTime startDateTime, OffsetDateTime endDateTime) {
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}

	public SubscriptionDTO startDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
		return this;
	}

	/**
	 * Get startDateTime
	 *
	 * @return startDateTime
	 */
	@NotNull
	@Valid
	@Schema(name = "startDateTime", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("startDateTime")
	public OffsetDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(OffsetDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public SubscriptionDTO endDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
		return this;
	}

	/**
	 * Get endDateTime
	 *
	 * @return endDateTime
	 */
	@NotNull
	@Valid
	@Schema(name = "endDateTime", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("endDateTime")
	public OffsetDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(OffsetDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		SubscriptionDTO subscriptionDTO = (SubscriptionDTO) o;
		return Objects.equals(this.startDateTime, subscriptionDTO.startDateTime) &&
				Objects.equals(this.endDateTime, subscriptionDTO.endDateTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(startDateTime, endDateTime);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Subscription {\n");
		sb.append("    startDateTime: ").append(toIndentedString(startDateTime)).append("\n");
		sb.append("    endDateTime: ").append(toIndentedString(endDateTime)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

