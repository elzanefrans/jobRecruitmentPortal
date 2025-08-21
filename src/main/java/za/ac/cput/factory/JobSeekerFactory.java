package za.ac.cput.factory;

import za.ac.cput.domain.JobSeeker;
import za.ac.cput.domain.Resume;
import com.stripe.model.Application;

import java.util.ArrayList;
import java.util.List;

public class JobSeekerFactory {

    public static JobSeeker createJobSeeker(
            String firstName,
            String lastName,
            String phone,
            String address,
            String profileSummary,
            Resume resume,
            List<Application> applications
    ) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name is required");
        }

        return JobSeeker.builder()
                .firstName(firstName)
                .lastName(lastName)
                .phone(phone)
                .address(address)
                .profileSummary(profileSummary)
                .resume(resume)
                .applications(applications != null ? applications : new ArrayList<>())
                .build();
    }

    // Optional: create a default JobSeeker for testing
    public static JobSeeker createDefaultJobSeeker() {
        return createJobSeeker(
                "John",
                "Doe",
                "0123456789",
                "123 Main St, Cape Town",
                "Motivated software developer seeking opportunities",
                null,
                new ArrayList<>()
        );
    }
}
