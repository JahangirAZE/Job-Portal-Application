package az.jobportal.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id) {
        Job job = jobService.findById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job created successfully!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted) {
            return new ResponseEntity<>("Job deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,
                                                @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJob(id, updatedJob);
        if (updated) {
            return new ResponseEntity<>("Job updated successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}