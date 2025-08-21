package za.ac.cput.domain;

import com.stripe.model.Application;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Entity
@Table(name = "job_seekers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobSeeker extends User {
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String profileSummary;

    @OneToOne(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
    private Resume resume;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
    private List<Application> applications;
}
