package za.ac.cput.factory;

import za.ac.cput.domain.JobListing;
import za.ac.cput.domain.Employer;
import za.ac.cput.domain.Application;
import za.ac.cput.domain.Skill;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobListingFactory {

    public static JobListing createJobListing(
            String title,
            String description,
            String location,
            String salary,
            String employmentType,
            LocalDateTime postedDate,
            boolean isActive,
            Employer employer,
            List<Application> applications,
            List<Skill> skills
    ) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Job title is required");
        }
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Job description is required");
        }

        return JobListing.builder()
                .title(title)
                .description(description)
                .location(location)
                .salary(salary)
                .employmentType(employmentType)
                .postedDate(postedDate != null ? postedDate : LocalDateTime.now())
                .isActive(isActive)
                .employer(employer)
                .applications(applications != null ? applications : new ArrayList<>())
                .skills(skills != null ? skills : new ArrayList<>())
                .build();
    }

    // Optional: default JobListing for testing
    public static JobListing createDefaultJobListing() {
        return createJobListing(
                "Software Developer",
                "Develop and maintain web applications",
                "Cape Town",
                "R25,000",
                "Full-Time",
                LocalDateTime.now(),
                true,
                null, // default employer can be set if needed
                new ArrayList<>(),
                new ArrayList<>()
        );
    }
}
