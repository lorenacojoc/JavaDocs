package ro.teamnet.zth.appl.domain;

/**
 * Created by Lorena on 7/7/2016.
 */

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;


@Table(name = "jobs")
public class Job {

    @Id(name = "JOB_ID")
    private Integer id;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Column(name = "MIN_SALARY")
    private Integer minSalary;

    @Column(name = "MAX_SALARY")
    private Integer maxSalary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Job job = (Job) o;

        if (id != null ? !id.equals(job.id) : job.id != null) {
            return false;
        }
        if (jobTitle != null ? !jobTitle.equals(job.jobTitle) : job.jobTitle != null) {
            return false;
        }
        if (maxSalary != null ? !maxSalary.equals(job.maxSalary) : job.maxSalary != null) {
            return false;
        }
        if (minSalary != null ? !minSalary.equals(job.minSalary) : job.minSalary != null) {
            return false;
        }

        return true;
    }

}