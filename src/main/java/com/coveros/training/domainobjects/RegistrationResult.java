package com.coveros.training.domainobjects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;


public final class RegistrationResult {

    public final boolean wasSuccessfullyRegistered;
    public final RegistrationStatusEnums status;
    private final String message;

    public RegistrationResult(boolean wasSuccessfullyRegistered, RegistrationStatusEnums status, String message) {
        this.wasSuccessfullyRegistered = wasSuccessfullyRegistered;
        this.status = status;
        this.message = message;
    }

    public RegistrationResult(boolean wasSuccessfullyRegistered, RegistrationStatusEnums status) {
        this(wasSuccessfullyRegistered, status, "");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        RegistrationResult rhs = (RegistrationResult) obj;
        return new EqualsBuilder()
                .append(wasSuccessfullyRegistered, rhs.wasSuccessfullyRegistered)
                .append(status, rhs.status)
                .append(message, rhs.message)
                .isEquals();
    }

    public final int hashCode() {
        // you pick a hard-coded, randomly chosen, non-zero, odd number
        // ideally different for each class
        return new HashCodeBuilder(15, 33).
                append(wasSuccessfullyRegistered).
                append(status).
                append(message).
                toHashCode();
    }

    public final String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public final String toPrettyString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("successfully registered: %s%n", wasSuccessfullyRegistered));
        sb.append(String.format("status: %s%n", status));
        sb.append(String.format("message: %n%n%s%n", message));
        return sb.toString();
    }

    public static RegistrationResult createEmpty() {
        return new RegistrationResult(false, RegistrationStatusEnums.EMPTY);
    }

    public boolean isEmpty() {
        return this.equals(createEmpty());
    }
}
